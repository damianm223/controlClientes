<%-- 
    Document   : agregarCliente
    Created on : 20 oct. 2020, 22:04:47
    Author     : Damian
--%>

<div class="modal fade" id="agregarClienteModal">
    
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="close" data-dismiss="modal" > <span>&times;</span></button>
            </div>
            
       
        
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="POST" class="was-validated">
            
            <div class="modal-body">
                <div class="form-group">
                    <label for="nombre">Nombre  </label>   
                    <input type="text" name="nombre" id="nombre"  class="form-control" required/>
                </div>
                 <div class="form-group">
                    <label for="apellido">Apellidos  </label>   
                        <input type="text" name="apellido" id="apellido"  class="form-control" required/>
                </div>
                 <div class="form-group">
                    <label for="email">Correo Electr�nico  </label>   
                        <input type="email" name="email" id="email"  class="form-control" required/>
                </div>
                <div class="form-group">
                    <label for="telefono">Tel�fono  </label>   
                        <input type="tel" name="telefono" id="telefono"  class="form-control" required/>
                </div>
                
                <div class="form-group">
                    <label for="saldo">Saldo  </label>   
                        <input type="number" name="saldo" id="saldo"  class="form-control" required step="any" />
                </div>
                                
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
        </form>
         </div>
    </div>    
    
</div>