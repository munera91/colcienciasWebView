<%-- 
    Document   : Fincas
    Created on : 10/06/2018, 11:56:28 AM
    Author     : Juliana. Maldonado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="entidades.Vacuno"%>

<% 
    String idvacuno = request.getParameter("txtid");
    String raza = request.getParameter("txtraza");
    String idfinca = request.getParameter("cbfinca");
    String finca = request.getParameter("cbfinca");
    String numpartos = request.getParameter("txtpartos");
    String peso = request.getParameter("txtpeso");
    
    String men =(String) request.getAttribute("mensajes");
String dat =(String) request.getAttribute("datos");
List<Vacuno>LU=(List<Vacuno>) request.getAttribute("listado")!=null?
        (List<Vacuno>) request.getAttribute("listado"):null;
Vacuno usu=(Vacuno) request.getAttribute("datousuario") !=null?
        (Vacuno) request.getAttribute("datousuario"):null;

                if(usu!=null){
                
                idvacuno= usu.getIdvacuno();
                raza= usu.getRaza();
                idfinca= usu.getIdfinca();
                finca= usu.getFinca();
                numpartos= usu.getNumeroPartos();
                peso = usu.getPeso();

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
        <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">

    <link href="css/plugins/chosen/chosen.css" rel="stylesheet">

    <link href="css/plugins/colorpicker/bootstrap-colorpicker.min.css" rel="stylesheet">

    <link href="css/plugins/cropper/cropper.min.css" rel="stylesheet">

    <link href="css/plugins/switchery/switchery.css" rel="stylesheet">

    <link href="css/plugins/jasny/jasny-bootstrap.min.css" rel="stylesheet">

    <link href="css/plugins/nouslider/jquery.nouislider.css" rel="stylesheet">

    <link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet">

    <link href="css/plugins/ionRangeSlider/ion.rangeSlider.css" rel="stylesheet">
    <link href="css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css" rel="stylesheet">

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
            <img alt="image" class="img-circle" src="img/profile_small.jpg" />
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
    <a href="index.jsp"><span class="nav-label">Inicio</span></a>
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
            <h5>Registro de Vacunos</h5>

        </div>
        <div class="ibox-content">
            <form method="POST" class="form-horizontal" action="./Vacunos">
               <td><input type="password" name="txtid" class="texto" id="txtid" value="<%=idvacuno!=null?idvacuno:""%>"  readonly="readonly"
id="" size="1" maxlength="1">
                <div class="form-group"><label class="col-sm-2 control-label">Finca*</label>
                     <div class="col-sm-3">
                         <jsp:useBean id ="cn" class="persistencia.Daos" scope="page"></jsp:useBean>
                            <%
                                ResultSet rs = cn.mostrarFincas();
                            %>
                         <select class="form-control m-b" name="cbfinca">
                             <option value="">Escoge una opción</option>
                             <%
                                 while(rs.next()) {
                                 
                                 
                             %>    
                             <option value="<%=rs.getString("ID_FINCA")%>"><%=rs.getString("NOMBRE")%></option>
                             <%
                              }
                             %>

                            </select>

                        </div>
                    
                    <div class="form-group"><label class="col-sm-2 control-label">Raza</label>
                        <div class="col-sm-3"><input type="text" class="form-control" Value="Holstein Friesian" name="txtraza" disabled="True"></div>

                    </div>
                        
               </div>
                
                <div class="form-group"><label class="col-sm-2 control-label">Número Partos*</label>
                     <div class="col-sm-3"><input type="text" class="form-control" name="txtpartos" value="<%=numpartos!=null?numpartos:""%>" onkeypress="return numeros(event); "></div>
                    
                    <div class="form-group"><label class="col-sm-2 control-label">Peso*</label>
                        <div class="col-sm-3"><input type="text" class="form-control" name="txtpeso" value="<%=peso!=null?peso:""%>" onkeypress="return numeros(event); "></div>

                    </div>
                        
                      <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <center>
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit" name="action" value="nuevo" id="">Limpiar</button>
                                <button class="btn btn-primary" type="submit" name="action" value="guardar" id="">Crear</button>
                                <button class="btn btn-primary" type="submit" name="action" value="mostrar" id="">Listar</button>
                                <button class="btn btn-primary" type="submit" name="action" value="actualizar" id="">Actualizar</button>
                            </div>
                            </center>
                        </div>
               </div>
                                          
                </div>

                </div>
        </div>
                </div>
            </div>
                                       <p><%=men!=null? men:""%></p>
              <%if(LU!= null ){%>
              
                <table width="100%" height="200" border="1" cellspacing="3" cellpading=5"" class ="table table-bordered table-striped">

 
                  <tr>
                       <td>Nombre Finca</td>       
                       <td>Raza</td>
                       <td>Peso</td>
                       <td>Número de Partos</td>    

                  </tr>

                  <%for(Vacuno van:LU){%>
                  <tr>
                      
                      <td><%=van.getFinca()%></td>
                      <td><%=van.getRaza()%></td>
                      <td><%=van.getPeso()%></td>
                      <td><%=van.getNumeroPartos()%></td>

                      
                      <td><a href="./Vacunos?action=buscar&txtid=<%=van.getIdvacuno()%>"><img src="img/ver_mas_info.png" border="0" ></a></td>
                      <td><a href="./Vacunos?action=eliminar&txtid=<%=van.getIdvacuno()%>"><img src="img/checkno.png" border="0" ></a></td>

                  </tr>
                  <%}%>
                  
              </table>
              <%}%>
        </div>

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
     <script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Chosen -->
    <script src="js/plugins/chosen/chosen.jquery.js"></script>

   <!-- JSKnob -->
   <script src="js/plugins/jsKnob/jquery.knob.js"></script>

   <!-- Input Mask-->
    <script src="js/plugins/jasny/jasny-bootstrap.min.js"></script>

   <!-- Data picker -->
   <script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>

   <!-- NouSlider -->
   <script src="js/plugins/nouslider/jquery.nouislider.min.js"></script>

   <!-- Switchery -->
   <script src="js/plugins/switchery/switchery.js"></script>

    <!-- IonRangeSlider -->
    <script src="js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>

    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>

    <!-- MENU -->
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

    <!-- Color picker -->
    <script src="js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>

    <!-- Image cropper -->
    <script src="js/plugins/cropper/cropper.min.js"></script>

    <script>
        $(document).ready(function(){
            $('#txtid').hide()
        })


    </script>
    </form>
    </body>
    </html>