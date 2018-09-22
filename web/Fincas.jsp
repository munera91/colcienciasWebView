<%-- 
    Document   : Fincas
    Created on : 10/06/2018, 11:56:28 AM
    Author     : Juliana. Maldonado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entidades.Finca"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<% 
    String idfinca = request.getParameter("txtid");
    String nombre = request.getParameter("txtnombre");
    String direccion = request.getParameter("txtdireccion");
    String nombreprop = request.getParameter("txtnombreprop");
    String hectareas = request.getParameter("txthectareas");
    String iddepartamento = request.getParameter("cbdepartamento");
    String departamento = request.getParameter("cbdepartamento");
    String idmunicipio = request.getParameter("cbmunicipio");
    String municipio = request.getParameter("cbmunicipio");
    String idterreno = request.getParameter("cbterreno");
    String terreno = request.getParameter("cbterreno");
    
    String men =(String) request.getAttribute("mensajes");
String dat =(String) request.getAttribute("datos");
List<Finca>LU=(List<Finca>) request.getAttribute("listado")!=null?
        (List<Finca>) request.getAttribute("listado"):null;
Finca usu=(Finca) request.getAttribute("datousuario") !=null?
        (Finca) request.getAttribute("datousuario"):null;

                if(usu!=null){
                
                nombre= usu.getNombre();
                direccion= usu.getDireccion();
                nombreprop= usu.getPropietario();
                hectareas= usu.getHectareas();
                idfinca= usu.getIdfinca();
                iddepartamento = usu.getIddepartamento();
                departamento= usu.getDepartamento();
                idmunicipio= usu.getIdmunicipio();
                municipio= usu.getMunicipio();
                terreno= usu.getTipoterreno();
}
    
%>

<html>
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Colciencias</title>       
        <link href="css/plugins/chosen/chosen.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">


    <link href="css/plugins/chosen/chosen.css" rel="stylesheet">
    <link href="css/plugins/toastr/toastr.min.css" rel="stylesheet" type="text/css"/>
   
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

        <link href="css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
        <script type="text/javascript" src="js/validar.js"> </script>

    </head>

    <body>

<div id="wrapper">

<nav class="navbar-default navbar-static-side" role="navigation">
<div class="sidebar-collapse">
<ul class="nav metismenu" id="side-menu">
<li class="nav-header">
    <div class="dropdown profile-element"> <span>
            <img alt="image" class="img-circle" src="img/logo.jpg" />
        </span>
        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
          <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">Karen Maldonado</strong>
         </span> <span class="text-muted text-xs block">Administrador<b class="caret"></b></span> </span> </a>
        <ul class="dropdown-menu animated fadeInRight m-t-xs">
            <li><a href="index1.jsp">Salir</a></li>
        </ul> 
    </div>
</li>
<li>
    <a href="index1.jsp"><span class="nav-label">Inicio</span></a>
</li>

<li>
    <a href="#"><span class="nav-label">Registro</span></a>
    <ul class="nav nav-second-level collapse">
        <li><a href="Fincas.jsp">Fincas</a></li>
         <li><a href="vacunos.jsp">Vacunos</a></li>
    </ul>
</li>


</nav>

<div id="page-wrapper" class="gray-bg">
    <div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
            </div>
            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <a href="index1.jsp">
                        <i class="fa fa-sign-out"></i>Salir
                    </a>
                </li>
            </ul>

        </nav>
    </div>

    <div class="wrapper wrapper-content animated fadeInRight">

<div class="row">
<div class="col-lg-12">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>Registro de Fincas</h5>

        </div>
        <div class="ibox-content">
            <form method="POST" class="form-horizontal" action="./Fincas" id="frm">
               <td><input type="password" name="txtid" class="texto" id="txtid" value="<%=idfinca!=null?idfinca:""%>"  readonly="readonly"
id="" size="1" maxlength="1">
                <div class="form-group"><label class="col-sm-2 control-label">Nombre Finca*</label>
                    <div class="col-sm-3"><input type="text" class="form-control" name="txtnombre" value="<%=nombre!=null?nombre:""%>" id ="txtnombre"></div>
                    
                    <div class="form-group"><label class="col-sm-2 control-label">Dirección*</label>
                        <div class="col-sm-3"><input type="text" class="form-control" name="txtdireccion" value="<%=direccion!=null?direccion:""%>" id="txtdireccion"></div>

                    </div>
                        
               </div>
                
               <div class="form-group"><label class="col-sm-2 control-label">Departamento*</label>
                    <div class="col-sm-3">
                        <jsp:useBean id ="cn" class="persistencia.Daos" scope="page"></jsp:useBean>
                            <%
                                ResultSet rs = cn.mostrarDepartamentos();
                            %>
                         <select class="form-control m-b" name="cbdepartamento" id="cbdepartamento">
                             <option value="">Escoge una opción</option>
                             <%
                                 while(rs.next()) {
                                 
                                 
                             %>    
                             <option value="<%=rs.getString("idDepartamento")%>"<%= iddepartamento != null && iddepartamento.equals(rs.getString("idDepartamento")) ? "selected" : ""%>><%=rs.getString("nombre") %></option>
                             <%
                              }
                             %>

                            </select>

                        </div>

                    <div class="form-group"><label class="col-sm-2 control-label">Municipio*</label>
                        <div class="col-sm-3">
                            <jsp:useBean id ="cn2" class="persistencia.Daos" scope="page"></jsp:useBean>
                            <%
                                ResultSet rs2 = cn2.mostrarMunicipios();
                            %>
                            
                         <select class="form-control m-b" name="cbmunicipio" id="cbmunicipio">
                             <option value="">Escoge una opción</option>
                             <%
                                 while(rs2.next()) {
                                 
                                 
                             %>    
                                                         <option value="<%=rs2.getString("idMUNICIPIO")%>"<%= municipio != null && municipio.equals(rs2.getString("idMUNICIPIO")) ? "selected" : ""%>><%=rs2.getString("nombre") %></option>
                                                         
                             <%
                              }
                             %>
                         </select>

                        </div>

                    </div>
               </div>                
                                            
                <div class="form-group"><label class="col-sm-2 control-label">Nombre Propietario*</label>
                    <div class="col-sm-3"><input type="text" class="form-control" name="txtnombreprop" id="txtnombreprop" value="<%=nombreprop!=null?nombreprop:""%>"></div>

                   <div class="form-group"><label class="col-sm-2 control-label">Numero Hectáreas*</label>
                        <div class="col-sm-3"><input type="text" class="form-control" name="txthectareas" id="txthectareas" value="<%=hectareas!=null?hectareas:""%>" onkeypress="return numeros(event); "></div>

                    </div>
                    
                </div>

                <div class="form-group"><label class="col-sm-2 control-label">Tipo Terreno*</label>

                        <div class="col-sm-3">
                            
                         <div class="ibox float-e-margins">

                <div class="input-group">
                    <jsp:useBean id ="cn3" class="persistencia.Daos" scope="page"></jsp:useBean>
                            <%
                                ResultSet rs3 = cn3.mostrarTerrenos();
                            %>
                            
                <select data-placeholder="Seleccione Tipo Terreno" class="chosen-select" multiple style="width:240px;" tabindex="4" name="cbterreno" id="cbterreno" >
                  <option value="">Escoge una opción</option>
                             <%
                                 while(rs3.next()) {
                                 
                                 
                             %>    

                         <option value="<%=rs3.getString("DESCRIPCION")%>"><%=rs3.getString("DESCRIPCION")%></option>
                             <%
                              }
                             %>

                </select>
                </div>
                </div>

                    </div>

                </div>
                    <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <center>
                            <div class="col-sm-5 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit" name="action" value="nuevo" id="">Limpiar</button>
                                <a class="button btn btn-primary" name="action" id="btnguardar">Crear</a>
                                <button class="btn btn-primary" type="submit" name="action" value="mostrar" id="btnlistar">Listar</button>
                                <a class="button btn btn-primary" name="action" id="btnActualizar">Actualizar</a>
                                <a class="button btn btn-primary" name="action" id="btnEliminar">Eliminar</a>
                            </div>
                            </center>
                        </div>


                </div>
        </div>
                </div>
            </div>
        </div>

            <p><%=men!=null? men:""%></p>
              <%if(LU!= null ){%>
              
              <table width="100%" height="200" border="1" cellspacing="3" cellpading=5"" class ="table table-bordered table-striped" id="tableFinca">


                  <tr>
                       <td>Nombre Finca</td>       
                       <td>Dirección</td>
                       <td>Departamento</td>
                       <td>Municipio</td>    
                       <td>Nombre Propietario</td>      
                       <td>Hectáreas</td>
                       <td>Tipo Terreno</td>
                       <td>Opciones</td>
                   
                      
                  </tr>

                  <%for(Finca fin:LU){%>
                  <tr>
                      <td><%=fin.getNombre()%></td>
                      <td><%=fin.getDireccion()%></td>
                      <td><%=fin.getDepartamento()%></td>
                      <td><%=fin.getMunicipio()%></td>
                      <td><%=fin.getPropietario()%></td>
                      <td><%=fin.getHectareas()%></td>
                      <td><%=fin.getTipoterreno()%></td>
                      
                      <td><a href="./Fincas?action=buscar&txtid=<%=fin.getIdfinca()%>"><img src="img/ver_mas_info.png" border="0" ></a></td>

                  </tr>
                  <%}%>
                  
              </table>
              <%}%>
    </div>


    <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>

    <!-- Chosen -->
    <script src="js/plugins/chosen/chosen.jquery.js"></script>

    <!-- MENU -->
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

    <script src="js/plugins/toastr/toastr.min.js" type="text/javascript"></script>
    <script>
        $(document).ready(function(){

            $('#txtid').hide()
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });


        });
        var config = {
                '.chosen-select'           : {},
                '.chosen-select-deselect'  : {allow_single_deselect:true},
                '.chosen-select-no-single' : {disable_search_threshold:10},
                '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
                '.chosen-select-width'     : {width:"95%"}
            }
            for (var selector in config) {
                $(selector).chosen(config[selector]);
            }
  


        $("#btnguardar").click(function () {
            
            if ($("#txtnombre").val() === "" && $("#txthectareas").val()=== "" && $("#txtdireccion").val()==="" && $("#txtnombreprop").val()==="" && $("#cbmunicipio").val() ==="" && $("#cbterreno").val()=== null) {
                 toastr.warning('Todos los campos son obligatorios');
                 return true;
           }else if ($("#txtnombre").val() === "") {
               toastr.warning('El campo nombre finca es obligatorio');
               return true;
           }else if ($("#txtdireccion").val()=== "" ) {
                toastr.warning('El campo dirección es obligatorio');
                return true;
            }  else if ($("#cbdepartamento").val()=== "" ) {
                toastr.warning('El campo departamento es obligatorio');
                return true;
            }else if ($("#cbmunicipio").val()=== "" ) {
                toastr.warning('El campo municipio es obligatorio');
                return true;
            } else if ($("#txtnombreprop").val()=== "" ) {
                toastr.warning('El campo nombre propietario es obligatorio');
                return true;
            } else if ($("#txthectareas").val()=== "" ) {
                toastr.warning('El campo número de hectáreas es obligatorio');
                return true;
            } else if ( $("#cbterreno").val()=== null ) {
                toastr.warning('El campo tipo terreno es obligatorio');
                return true;
            }     
            
            var cadena = { "id": "100", "nombre": $("#txtnombre").val(), "hectareas": $("#txthectareas").val(),
                "direccion": $("#txtdireccion").val(), "nombrePropietario": $("#txtnombreprop").val(),
                "municipio": $("#cbmunicipio").val(), "tipoTerreno": $("#cbterreno").val().join(",")};
            var json =JSON.stringify(cadena);
            $.ajax({
                url: "http://localhost:9533/colciencias/finca/",
                method: 'POST',
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: json,
                cache: false,
                success: function (res) {
                    if (res.success.name === "add") {
                       toastr.success('Error');
                    }
                },error:function(res){
                    toastr.success(res.responseText);    
                    setTimeout(function(){
                       window.location.assign("Fincas.jsp");
                      }, 1000);                      
                    return false;
                }
            });
        });       
                
        $("#btnEliminar").click(function(){
            
            if ($("#txtid").val() === "") {
                 toastr.warning('Debe cargar el registro a eliminar');
                 return true;
            } 
            
            var cadena = { "id": $('#txtid').val(), "nombre": $("#txtnombre").val(), "hectareas": $("#txthectareas").val(),
                "direccion": $("#txtdireccion").val(), "nombrePropietario": $("#txtnombreprop").val(),
                "municipio": $("#cbmunicipio").val(), "tipoTerreno": "convexo"};
            
            var json =JSON.stringify(cadena);
            $.ajax({
                url: "http://localhost:9533/colciencias/finca/",
                method: 'DELETE',
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: json,
                cache: false,
                success: function (res) {
                    if (res.success.name === "add") {
                       toastr.success('Error');
                    }
                },error:function(res){
                    toastr.success(res.responseText);
                    setTimeout(function(){
                       window.location.assign("Fincas.jsp");
                      }, 1000);
                      
                    return false;
                }
            });
        });
        
        $("#btnActualizar").click(function(){
            
             if ($("#txtnombre").val() === "" && $("#txthectareas").val()=== "" && $("#txtdireccion").val()==="" && $("#txtnombreprop").val()==="" && $("#cbmunicipio").val() ==="" && $("#cbterreno").val()=== null) {
                 toastr.warning('Todos los campos son obligatorios');
                 return true;
           }else if ($("#txtnombre").val() === "") {
               toastr.warning('El campo nombre finca es obligatorio');
               return true;
           }else if ($("#txtdireccion").val()=== "" ) {
                toastr.warning('El campo dirección es obligatorio');
                return true;
            }  else if ($("#cbdepartamento").val()=== "" ) {
                toastr.warning('El campo departamento es obligatorio');
                return true;
            }else if ($("#cbmunicipio").val()=== "" ) {
                toastr.warning('El campo municipio es obligatorio');
                return true;
            } else if ($("#txtnombreprop").val()=== "" ) {
                toastr.warning('El campo nombre propietario es obligatorio');
                return true;
            } else if ($("#txthectareas").val()=== "" ) {
                toastr.warning('El campo número de hectáreas es obligatorio');
                return true;
            } else if ( $("#cbterreno").val()=== null ) {
                toastr.warning('El campo tipo terreno es obligatorio');
                return true;
            } 
            
            var cadena = { "id": $('#txtid').val(), "nombre": $("#txtnombre").val(), "hectareas": $("#txthectareas").val(),
                "direccion": $("#txtdireccion").val(), "nombrePropietario": $("#txtnombreprop").val(),
                "municipio": $("#cbmunicipio").val(), "tipoTerreno": $("#cbterreno").val().join(",")};
            
            var json =JSON.stringify(cadena);
            $.ajax({
                url: "http://localhost:9533/colciencias/finca/",
                method: 'PUT',
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: json,
                cache: false,
                success: function (res) {
                    if (res.success.name === "add") {
                       toastr.success('Error');
                    }
                },error:function(res){
                    toastr.success(res.responseText);
                    setTimeout(function(){
                       window.location.assign("Fincas.jsp");
                      }, 1000); 
                    return false;
                }
            });
        });
        
    </script>
    </form>
    </body>
    </html>