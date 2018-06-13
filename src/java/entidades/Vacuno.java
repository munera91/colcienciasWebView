/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Aux Software
 */
public class Vacuno {
    
    String idvacuno;
    String idfinca;
    String finca;
    String raza;
    String peso;
    String numeroPartos;

    public Vacuno() {
    }

    public Vacuno(String idvacuno, String idfinca, String finca, String raza, String peso, String numeroPartos) {
        this.idvacuno = idvacuno;
        this.idfinca = idfinca;
        this.finca = finca;
        this.raza = raza;
        this.peso = peso;
        this.numeroPartos = numeroPartos;
    }

    public String getIdvacuno() {
        return idvacuno;
    }

    public void setIdvacuno(String idvacuno) {
        this.idvacuno = idvacuno;
    }

    public String getIdfinca() {
        return idfinca;
    }

    public void setIdfinca(String idfinca) {
        this.idfinca = idfinca;
    }

    public String getFinca() {
        return finca;
    }

    public void setFinca(String finca) {
        this.finca = finca;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getNumeroPartos() {
        return numeroPartos;
    }

    public void setNumeroPartos(String numeroPartos) {
        this.numeroPartos = numeroPartos;
    }

    
    
    
}
