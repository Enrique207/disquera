package model.genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;

public class generoDao {

    Connection con; 
    PreparedStatement ps;
    ResultSet rs; 
    String sql = null;
    int a;
    int gfilas;

    // REGISTRAR
    public int registrar(generoVo genero) throws SQLException {
        sql = "INSERT INTO genero(nombreGenero, estadoGenero) values(?,?)";

        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, genero.getNombreGenero());
            ps.setBoolean(2, genero.getEstadoGenero());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registró el genero correctamente");

        } catch (Exception e) {
            System.out.println("Error en el registro " + e.getMessage().toString());
        }

        finally {
            con.close();
        }
        return a;
    }

    // -------------------------------------------------------------------------//
    // LISTAR
    public List<generoVo> listar() throws SQLException {
        List<generoVo> genero = new ArrayList<>();
        sql = "SELECT * FROM genero";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                generoVo a=new generoVo();

                a.setIdGenero(rs.getInt("idGenero"));
                a.setNombreGenero(rs.getString("nombreGenero"));
                a.setEstadoGenero(rs.getBoolean("estadoGenero"));
                
                genero.add(a);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());// Error
        } finally {
            con.close();
        }

        return genero;
    }

    // ----------------------------------------------------------------//
    // ELIMINAR
    public void eliminar(int idGenero) throws SQLException {
        sql = "DELETE FROM genero WHERE idGenero=" +idGenero;

        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close(); 
            System.out.println("Se elimino correctamente");

        } catch (Exception e) {
            System.out.println("Error en la eliminacion " + e.getMessage().toString());
        }

        finally {
            con.close();
        }
    }

    // ----------------------------------------------------------------//
    // ESTADO
    public void estado(Boolean estadoGenero, int idGenero) throws SQLException {
        sql = "UPDATE genero SET estadoGenero=" +estadoGenero+ " WHERE idGenero=" +idGenero;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se cambio el estado a " +estadoGenero+ " correctamente");
        } catch (Exception e) {
            System.out.println("Error en el cambio de estadop " + e.getMessage().toString());
        } finally {
            con.close();
        }
    }

    // ----------------------------------------------------------------//
    // EDITAR
    public List<generoVo> Listargenero(int idGenero) throws SQLException {
        List<generoVo> genero = new ArrayList<>();
        sql = "SELECT * FROM genero WHERE idGenero=" + idGenero;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while (rs.next()) {
                generoVo gfilas = new generoVo();
                gfilas.setIdGenero(rs.getInt("idGenero"));
                gfilas.setNombreGenero(rs.getString("nombreGenero"));
                gfilas.setEstadoGenero(rs.getBoolean("estadoGenero"));
                genero.add(gfilas);
            }
            ps.close();
            System.out.println("consulta exitosa a genero");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());// Error
        } finally {
            con.close();
        }

        return genero;
    }


    // ----------------------------------------------------------------//
    // ACTUALIZAR
    public int actualizar(generoVo genero) throws SQLException {
        sql = "UPDATE genero SET nombreGenero=?,estadoGenero=? WHERE idGenero=?";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, genero.getNombreGenero());
            ps.setBoolean(2, genero.getEstadoGenero());
            ps.setInt(3, genero.getIdGenero());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se edito el genero correctamente");
        } catch (Exception e) {
            System.out.println("Error al editar " + e.getMessage().toString());
        } finally {
            con.close();
        }
        return gfilas;

    }
}