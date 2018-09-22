/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import entidades.Finca;
import entidades.Vacuno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Conexion;
/**
 *
 * @author Usuario
 */
public class Daos extends Conexion{
    
    public ArrayList<Finca> ListadoFincas() {

        ArrayList<Finca> listaFincas = new ArrayList();
        PreparedStatement st;
        ResultSet result;
        try {
            st = this.getConexion().prepareCall("SELECT \"ID_FINCA\", \"NOMBRE\", \"HECTAREAS\", \"DIRECCION\", \"NOMBRE_PROPIETARIO\", \n" +
"D.\"idDepartamento\" as IDDEP, D.nombre as DEPARTAMENTO, M.\"idMUNICIPIO\" as IDMUN, M.nombre as MUNICIPIO,\n" +
"\"TIPO_TERRENO\" FROM public.\"FINCA\" F INNER JOIN public.\"MUNICIPIO\" M ON (M.\"idMUNICIPIO\" = F.\"MUNICIPIO\")\n" +
"INNER JOIN public.\"DEPARTAMENTO\" D ON (D.\"idDepartamento\" = M.\"idDepartamento\")"); 
            ResultSet r = st.executeQuery();
            while (r.next()) {
                Finca u = new Finca();
                u.setIdfinca(r.getString(1));
                u.setNombre(r.getString(2));
                u.setHectareas(r.getString(3));;
                u.setDireccion(r.getString(4));
                u.setPropietario(r.getString(5));
                u.setIddepartamento(r.getString(6));
                u.setDepartamento(r.getString(7));
                u.setIdmunicipio(r.getString(8));
                u.setMunicipio(r.getString(9));
                u.setTipoterreno(r.getString(10));
                
                listaFincas.add(u);

            }

        }
        catch (Exception e1) {
        } finally {
            try {
                this.Cerrar();
            }  
            catch (Exception clo) {
            }

        }

        return listaFincas;
    }
    
    public Finca getFincaBYID(String idfinca) throws Exception {

       Finca f = new Finca();
       try {

           PreparedStatement st;
           ResultSet r;

           st = this.getConexion().prepareCall("SELECT \"ID_FINCA\", \"NOMBRE\", \"HECTAREAS\", \"DIRECCION\", \n"
                   + "\"NOMBRE_PROPIETARIO\", M.\"idMUNICIPIO\" as municipio, \"TIPO_TERRENO\", D.\"idDepartamento\" as departamento\n"
                   + "FROM public.\"FINCA\" F\n"
                   + "INNER JOIN public.\"MUNICIPIO\" M ON (M.\"idMUNICIPIO\" = F.\"MUNICIPIO\")\n"
                   + "INNER JOIN public.\"DEPARTAMENTO\" D ON (D.\"idDepartamento\" = M.\"idDepartamento\")\n"
                   + "WHERE \"ID_FINCA\" = '"+idfinca+"'");
           r = st.executeQuery();
           while (r.next()) {
               f.setIdfinca(r.getString(1));
               f.setNombre(r.getString(2));
               f.setHectareas(r.getString(3));
               f.setDireccion(r.getString(4));
               f.setPropietario(r.getString(5));
               f.setMunicipio(r.getString(6));
               f.setTipoterreno(r.getString(7));
               f.setIddepartamento(r.getString(8));
           }
       } catch (Exception e1) {
       } finally {
       }
       try {
           this.Cerrar();
       } catch (Exception clo) {
       }

       return f;
   }
    
    public void insertarFinca(Finca finca) throws Exception {
        PreparedStatement st, st2;
        ResultSet result2;
        String id = "";
        int idFinca = 1;
        st2 = this.getConexion().prepareStatement("SELECT MAX(\"ID_FINCA\")\n"
                + " FROM public.\"FINCA\" ");
        result2 = st2.executeQuery();
        while (result2.next()) {
            id = result2.getString("max");
            idFinca += Integer.parseInt(id);
            id = Integer.toString(idFinca);
        }
        st = this.getConexion().prepareStatement("INSERT INTO PUBLIC.\"FINCA\"(\"ID_FINCA\",\"NOMBRE\","
                + "\"HECTAREAS\",\"DIRECCION\",\"NOMBRE_PROPIETARIO\",\"MUNICIPIO\",\"TIPO_TERRENO\") \n"
                + "VALUES('" + id + "','" + finca.getNombre() + "'," + finca.getHectareas() + ","
                + "'" + finca.getDireccion() + "','" + finca.getPropietario()+ "','" + finca.getIdmunicipio() + "',"
                + "'" + finca.getTipoterreno() + "')");
        st.executeUpdate();

    }
    
     public void actualizarFinca(Finca finca) throws Exception {
        PreparedStatement st;
        st = this.getConexion().prepareStatement("UPDATE public.\"FINCA\"\n"
                + " SET \"NOMBRE\"='" + finca.getNombre() + "', \"HECTAREAS\"=" + finca.getHectareas() + ","
                + " \"DIRECCION\"='" + finca.getDireccion() + "', \"NOMBRE_PROPIETARIO\"='" + finca.getPropietario() + "', \n"
                + " \"MUNICIPIO\"='" + finca.getIdmunicipio() + "',\"TIPO_TERRENO\"='" + finca.getTipoterreno() + "'\n"
                + "WHERE \"ID_FINCA\" = '" + finca.getIdfinca() + "'");
        st.executeUpdate();
    }
     
     public void eliminarFinca(Finca finca) throws Exception {
        PreparedStatement st;
        st = this.getConexion().prepareStatement("DELETE FROM public.\"FINCA\" "
                + "WHERE \"ID_FINCA\" = '" + finca.getIdfinca() + "'");
        st.executeUpdate();
    }
     
     public ResultSet mostrarMunicipios() throws Exception{
        PreparedStatement st2;
        ResultSet result2;
        String id = "";
        int idFinca = 1;
        st2 = this.getConexion().prepareStatement("SELECT \"idMUNICIPIO\", nombre FROM public.\"MUNICIPIO\" ");
        result2 = st2.executeQuery();
        
        return result2;
     }

     public ResultSet mostrarDepartamentos() throws Exception{
        PreparedStatement st2;
        ResultSet result2;
        String id = "";
        int idFinca = 1;
        st2 = this.getConexion().prepareStatement("SELECT \"idDepartamento\",nombre FROM public.\"DEPARTAMENTO\" ");
        result2 = st2.executeQuery();
        
        return result2;
     }
     
     public ResultSet mostrarTerrenos() throws Exception{
        PreparedStatement st2;
        ResultSet result2;
        String id = "";
        int idFinca = 1;
        st2 = this.getConexion().prepareStatement("SELECT \"ID_TIPO_TERRENO\", \"DESCRIPCION\" FROM public.\"TIPO_TERRENO\"");
        result2 = st2.executeQuery();
        
        return result2;
     }
     
         public ArrayList<Vacuno> ListadoVacunos() {

        ArrayList<Vacuno> listaVacunos = new ArrayList();
        PreparedStatement st;
        ResultSet result;
        try {
            st = this.getConexion().prepareCall("SELECT \"ID_VACUNO\", \"RAZA\", \"NUMERO_PARTOS\", \"PESO\", F.\"ID_FINCA\" as IDFINCA, F.\"NOMBRE\" as NOMBREFINCA\n" +
"FROM public.\"VACUNO\" V\n" +
"INNER JOIN public.\"FINCA\" F ON (F.\"ID_FINCA\" = V.\"FINCA\")"); 
            ResultSet r = st.executeQuery();
            while (r.next()) {
                Vacuno v = new Vacuno();
                v.setIdvacuno(r.getString(1));
                v.setRaza(r.getString(2));
                v.setNumeroPartos(r.getString(3));
                v.setPeso(r.getString(4));
                v.setIdfinca(r.getString(5));
                v.setFinca(r.getString(6));
                
                listaVacunos.add(v);

            }

        }
        catch (Exception e1) {
        } finally {
            try {
                this.Cerrar();
            }  
            catch (Exception clo) {
            }

        }

        return listaVacunos;
    }
         
        public Vacuno getVacunoBYID(String idVacuno) throws Exception {
            
        Vacuno v = new Vacuno();
        try {
            
            PreparedStatement st;
            ResultSet r;

            st = this.getConexion().prepareCall("SELECT \"ID_VACUNO\", \"RAZA\", \"NUMERO_PARTOS\", \"PESO\", \"FINCA\"\n"
                + " FROM public.\"VACUNO\""
                + "WHERE \"ID_VACUNO\" = '" + idVacuno + "'");
            r = st.executeQuery();
            while (r.next()) {
                v.setIdvacuno(r.getString(1));
                v.setRaza(r.getString(2));
                v.setNumeroPartos(r.getString(3));
                v.setPeso(r.getString(4));
                v.setIdfinca(r.getString(5));
                
            }
        }
        catch (Exception e1) {
        } finally {
        }
        try {
            this.Cerrar();
        } catch (Exception clo) {
        }

        return v;
    }
        
   public void insertarVacuno(Vacuno vacuno) throws Exception {
        PreparedStatement st, st2;
        ResultSet result2;
        String id = "";
        int idVacuno = 1;
        st2 = this.getConexion().prepareStatement("SELECT MAX(\"ID_VACUNO\")\n"
                + " FROM public.\"VACUNO\" ");
        result2 = st2.executeQuery();
        while (result2.next()) {
            id = result2.getString("max");
            idVacuno += Integer.parseInt(id);
            id = Integer.toString(idVacuno);
        }
        st = this.getConexion().prepareStatement("INSERT INTO PUBLIC.\"VACUNO\"(\"ID_VACUNO\",\"RAZA\",\"NUMERO_PARTOS\""
                + ",\"PESO\",\"FINCA\")\n"
                + "VALUES('" + id + "','" + vacuno.getRaza() + "'," + vacuno.getNumeroPartos() + "," + vacuno.getPeso() + ","
                + "'" + vacuno.getIdfinca()+ "')");
        st.executeUpdate();
    }
   
   public void actualizarVacuno(Vacuno vacuno) throws Exception {
        PreparedStatement st;

        st = this.getConexion().prepareStatement("UPDATE public.\"VACUNO\"\n"
                + "  SET \"RAZA\"='"+ vacuno.getRaza() +"', \"NUMERO_PARTOS\"="+ vacuno.getNumeroPartos() +","
                        + " \"PESO\"="+ vacuno.getPeso() +", \"FINCA\"='"+ vacuno.getIdfinca()+"'\n"
                + "WHERE \"ID_VACUNO\" = '" + vacuno.getIdvacuno() + "'");
        st.executeUpdate();
    }
   
   public void eliminarVacuno(Vacuno vacuno) throws Exception {
        PreparedStatement st;
        st = this.getConexion().prepareStatement("DELETE FROM public.\"VACUNO\" "
                + "WHERE \"ID_VACUNO\" = '" + vacuno.getIdvacuno() + "'");
        st.executeUpdate();
    }
   
   public ResultSet mostrarFincas() throws Exception{
        PreparedStatement st2;
        ResultSet result2;
        String id = "";
        int idFinca = 1;
        st2 = this.getConexion().prepareStatement("SELECT \"ID_FINCA\", \"NOMBRE\", \"HECTAREAS\", \"DIRECCION\", \"NOMBRE_PROPIETARIO\", \n" +
"D.\"idDepartamento\" as IDDEP, D.nombre as DEPARTAMENTO, M.\"idMUNICIPIO\" as IDMUN, M.nombre as MUNICIPIO,\n" +
"\"TIPO_TERRENO\" FROM public.\"FINCA\" F INNER JOIN public.\"MUNICIPIO\" M ON (M.\"idMUNICIPIO\" = F.\"MUNICIPIO\")\n" +
"INNER JOIN public.\"DEPARTAMENTO\" D ON (D.\"idDepartamento\" = M.\"idMUNICIPIO\")");
        result2 = st2.executeQuery();
        
        return result2;
     }
}
