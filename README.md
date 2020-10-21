# Bienvenidos a controlClientes

1. [Estructura de archivos](#archivos)
2. [Tecnologías](#tecnologias)

Proyecto hecho por un curso de Java de cero a Expero de la plataforma Udemy. Contiene Java Class,  JSPs, Servlets, JDBC y Expression Language

Basicamente es un panel de administracion básico donde se lista todon los trabajadores, el sueldo total y la cantidad de trabajadores que hay.
Se pueden añadir, editar y borrar trabajadores.

# Archivos

Estructura de archivos principales hechos por mi: 

<b>JAVA</b>

Java > Datos > [ClienteDaoJDBC.java] para hacer los metodos de listar, actualizar, insertar...
Java > Datos > [Conexion.java] para hacer la conexión con la base de datos.

Java > Dominio > [Cliente.java] clase principal donde introducimos todas las variables y constructores.

Java > Web > [ServletControlador.java] para controlar todas las peticiones tanto Get como Post.

<b>WEBAPP</b>

WebApp > [WEB-INF] carpeta privada para no poder acceder por URL en el navegador.

WebApp > WEB-INF > cliente > [agregarCliente.jsp] formulario para agregar clientes.

WebApp > WEB-INF > cliente > [editarCliente.jsp] formulario para editar clientes.

WebApp > WEB-INF > cliente > [listadoClientes.jsp] tabla para listar los clientes correctamente.

WebApp > WEB-INF > comunes > [botonesNavegacion.jsp] optimización de código en un fichero a parte.

WebApp > WEB-INF > comunes > [botonesNavegacionEdicion.jsp] optimización de código en un fichero a parte.

WebApp > WEB-INF > comunes > [cabecero.jsp] optimización de código en un fichero a parte.

WebApp > WEB-INF > comunes > [piePagina.jsp] optimización de código en un fichero a parte.


## Tecnologias

Tecnologías utilizadas en el proyecto:

* [Java EE]
* [JSP]
* [Servlets]
* [JDBC]
* [Expression Language]
* [MySql] - Gestor de base de datos
* [Glassfish Server 5.0] - Como servidor web
* [NetBeans] - IDE usado para el proyecto


