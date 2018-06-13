/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Vacuno;
import java.util.List;
import persistencia.Daos;

/**
 *
 * @author Aux Software
 */
public class VacunoN {
    Daos dao;
    
    public VacunoN() {
        dao = new Daos();
    }
    
    public List<Vacuno> ListadoVacunos() {
        return dao.ListadoVacunos();

    }
    
     public Vacuno getVacuno(String idvacuno) throws Exception {
        return dao.getVacunoBYID(idvacuno);
    }
     
    public void getInsertarVacuno(Vacuno vacuno) throws Exception {

        String mensajeError = "";
        String idvacuno = vacuno.getIdvacuno();
        String idfinca = vacuno.getFinca();
        String numeropartos = vacuno.getNumeroPartos();
        String peso = vacuno.getPeso();

        if ("".equals(idfinca) || null == idfinca) {
            mensajeError += "<br>Seleccione la finca";
        }

        if ("".equals(numeropartos) || null == numeropartos) {
            mensajeError += "<br>Ingrese número de partos";
        }

        if ("".equals(peso) || null == peso) {
            mensajeError += "<br>Ingrese Peso";
        }
      
        if (!"".equals(mensajeError)) {

            throw new Exception(mensajeError);
        }

        dao.insertarVacuno(vacuno);

    } 
    
    public void getEliminarVacuno(Vacuno vacuno) throws Exception {
 
        String mensajeError = "";
        String idvacuno = vacuno.getIdvacuno();

        dao.eliminarVacuno(vacuno);

        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }

    }
}
