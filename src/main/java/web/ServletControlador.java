package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "editar":

                    this.editarCliente(request, response);

                    break;

                case "eliminar":

                    this.eliminarCliente(request, response);

                    break;

                default:
                    this.accionDefault(request, response);
                    break;
            }
        } else {
            this.accionDefault(request, response);
        }

    }

    //Lo metemos en un metodo para ahorrar lineas de codigo
    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();

        HttpSession sesion = request.getSession();

        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", calcularSaldoTotal(clientes));
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {

        double saldoTotal = 0;

        for (Cliente cliente : clientes) {

            saldoTotal += cliente.getSaldo();

        }

        return saldoTotal;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "insertar":

                    this.insertarCliente(request, response);

                    break;

                case "modificar":

                    this.modificarCliente(request, response);

                    break;

                default:
                    this.accionDefault(request, response);
                    break;
            }
        } else {
            this.accionDefault(request, response);
        }

    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1. Recuperamos los valores del formulario agregarClioente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }
        //Creamos el objeto cliente con los nuevos datos recibidos
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);

        //Insertamos en la base de datos
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);

        System.out.println(registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);

    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recuperamos el idCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));

        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1. Recuperamos los valores del formulario editarClioente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }
        //Creamos el objeto cliente con los nuevos datos recibidos
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);

        //modificar el objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);

        System.out.println(registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);

    }
    
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1. Recuperamos los valores del formulario editarClioente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        
        //Creamos el objeto cliente con los nuevos datos recibidos
        Cliente cliente = new Cliente(idCliente);

        //Eliminamos el objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().elimiar(cliente);

        System.out.println(registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);

    }

}
