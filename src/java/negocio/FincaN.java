/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Finca;
import java.sql.Connection;
import java.util.List;
import persistencia.Daos;
import utilidades.Conexion;

/**
 *
 * @author Aux Software
 */
public class FincaN {
    Daos dao;
    
    public FincaN() {
        dao = new Daos();
    }
    
    public List<Finca> ListadoFincas() {
        return dao.ListadoFincas();

    }
    
    public Finca getFinca(String idfinca) throws Exception {
        return dao.getFincaBYID(idfinca);
    }
    
    public void getInsertarFinca(Finca finca) throws Exception {

        String mensajeError = "";
        String idfinca = finca.getIdfinca();
        String nombre = finca.getNombre();
        String direccion = finca.getDireccion();
        String iddepartamento = finca.getIddepartamento();
        String idmunicipio = finca.getIdmunicipio();
        String propietario = finca.getPropietario();
        String hectareas = finca.getHectareas();
        String terreno = finca.getTipoterreno();
        

        if ("".equals(nombre) || null == nombre) {
            mensajeError += "<br>Ingrese el nombre de la finca";
        }

        if ("".equals(direccion) || null == direccion) {
            mensajeError += "<br>Ingrese dirección";
        }

        if ("".equals(iddepartamento) || null == iddepartamento) {
            mensajeError += "<br>Ingrese Departamento";
        }

        if ("".equals(idmunicipio) || null == idmunicipio) {
            mensajeError += "<br>Ingrese Municipio";
        }
        
        if ("".equals(propietario) || null == propietario) {
            mensajeError += "<br>Ingrese nombre del Propietario";
        }

        if ("".equals(hectareas) || null == hectareas) {
            mensajeError += "<br>Ingrese número de hectáreas";
        }
        
        if ("".equals(terreno) || null == terreno) {
            mensajeError += "<br>Ingrese tipos de terreno";
        }

      
        if (!"".equals(mensajeError)) {

            throw new Exception(mensajeError);
        }

        dao.insertarFinca(finca);

    } 
    
    public void getActualizarFinca(Finca finca) throws Exception {

        Conexion con = new Conexion();
        String mensajeError = "";
        String idfinca = finca.getIdfinca();
        String nombre = finca.getNombre();
        String direccion = finca.getDireccion();
        String iddepartamento = finca.getIddepartamento();
        String idmunicipio = finca.getIdmunicipio();
        String propietario = finca.getPropietario();
        String hectareas = finca.getHectareas();
        String terreno = finca.getTipoterreno();
        

        if ("".equals(nombre) || null == nombre) {
            mensajeError += "<br>Ingrese el de la finca";
        }

        if ("".equals(direccion) || null == direccion) {
            mensajeError += "<br>Ingrese dirección";
        }

        if ("".equals(iddepartamento) || null == iddepartamento) {
            mensajeError += "<br>Ingrese Departamento";
        }

        if ("".equals(idmunicipio) || null == idmunicipio) {
            mensajeError += "<br>Ingrese Municipio";
        }
        
        if ("".equals(propietario) || null == propietario) {
            mensajeError += "<br>Ingrese nombre del Propietario";
        }

        if ("".equals(hectareas) || null == hectareas) {
            mensajeError += "<br>Ingrese número de hectáreas";
        }
        
        if ("".equals(terreno) || null == terreno) {
            mensajeError += "<br>Ingrese tipos de terreno";
        }

      
        if (!"".equals(mensajeError)) {

            throw new Exception(mensajeError);
        }

        dao.actualizarFinca(finca);

        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }

    } 
    
    public void getEliminarFinca(Finca finca) throws Exception {
 
        String mensajeError = "";
        String idfinca = finca.getIdfinca();

        dao.eliminarFinca(finca);

        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }

    }
}
