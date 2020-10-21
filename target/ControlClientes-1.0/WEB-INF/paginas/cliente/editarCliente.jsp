<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <script src="https://kit.fontawesome.com/92c833d72a.js" crossorigin="anonymous"></script>

        <title>Editar cliente</title>
    </head>
    <body>

        <!-- Cabecero -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp" />


        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}" 
              method="POST" class="was-validated">

            <!-- Botones de Navegacion -->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp" />

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Cliente</h4>
                                </div>
                                <div class="card-body">

                                    <div class="form-group">
                                        <label for="nombre">Nombre  </label>   
                                        <input type="text" name="nombre" id="nombre"  class="form-control" required value="${cliente.nombre}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="apellido">Apellidos  </label>   
                                        <input type="text" name="apellido" id="apellido"  class="form-control" required value="${cliente.apellido}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Correo Electrónico  </label>   
                                        <input type="email" name="email" id="email"  class="form-control" required value="${cliente.email}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="telefono">Teléfono  </label>   
                                        <input type="tel" name="telefono" id="telefono"  class="form-control" required value="${cliente.telefono}"/>
                                    </div>

                                    <div class="form-group">
                                        <label for="saldo">Saldo  </label>   
                                        <input type="number" name="saldo" id="saldo"  class="form-control" value="${cliente.saldo}" required step="any"/>
                                    </div>

                                </div>
                                
                            </div>                            
                        </div>
                    </div>
                </div>
            </section>



        </form>


        <!-- Pie de pagina-->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp" />




        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    </body>
</html>
