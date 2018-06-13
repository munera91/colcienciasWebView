/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Juliana. Maldonado
 */
public class Finca {
    String idfinca;
    String nombre;
    String direccion;
    String idmunicipio;
    String municipio;
    String propietario;
    String hectareas;
    String iddepartamento;
    String departamento;
    String tipoterreno;

    public Finca() {
    }

    public Finca(String idfinca, String nombre, String direccion, String idmunicipio, String municipio, String propietario, String hectareas, String iddepartamento, 
            String departamento, String tipoterreno) {
        this.idfinca = idfinca;
        this.nombre = nombre;
        this.direccion = direccion;
        this.idmunicipio = idmunicipio;
        this.municipio = municipio;
        this.propietario = propietario;
        this.hectareas = hectareas;
        this.iddepartamento = iddepartamento;
        this.departamento = departamento;
        this.tipoterreno = tipoterreno;
    }

    public String getIdfinca() {
        return idfinca;
    }

    public void setIdfinca(String idfinca) {
        this.idfinca = idfinca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(String idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getHectareas() {
        return hectareas;
    }

    public void setHectareas(String hectareas) {
        this.hectareas = hectareas;
    }

    public String getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(String iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTipoterreno() {
        return tipoterreno;
    }

    public void setTipoterreno(String tipoterreno) {
        this.tipoterreno = tipoterreno;
    }


    
}
