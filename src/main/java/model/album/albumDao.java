package model.album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;

public class albumDao {

    Connection con; 
    PreparedStatement ps;
    ResultSet rs; 
    String sql = null;
    int a;
    int gfilas;

    // REGISTRAR
    public int registrar(albumVo album) throws SQLException {
        sql = "INSERT INTO album(nombreAlbum, estadoAlbum) values(?,?)";

        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, album.getNombreAlbum());
            ps.setBoolean(2, album.getEstadoAlbum());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registró el album correctamente");

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
    public List<albumVo> listar() throws SQLException {
        List<albumVo> album = new ArrayList<>();
        sql = "SELECT * FROM album";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                albumVo a=new albumVo();

                a.setIdAlbum(rs.getInt("idAlbum"));
                a.setNombreAlbum(rs.getString("nombreAlbum"));
                a.setEstadoAlbum(rs.getBoolean("estadoAlbum"));
                
                album.add(a);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());// Error
        } finally {
            con.close();
        }

        return album;
    }

    // ----------------------------------------------------------------//
    // ELIMINAR
    public void eliminar(int idAlbum) throws SQLException {
        sql = "DELETE FROM album WHERE idAlbum=" +idAlbum;

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
    public void estado(Boolean estadoAlbum, int idAlbum) throws SQLException {
        sql = "UPDATE album SET estadoAlbum=" +estadoAlbum+ " WHERE idAlbum=" +idAlbum;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se cambio el estado a " +estadoAlbum+ " correctamente");
        } catch (Exception e) {
            System.out.println("Error en el cambio de estadop " + e.getMessage().toString());
        } finally {
            con.close();
        }
    }

    // ----------------------------------------------------------------//
    // EDITAR
    public List<albumVo> Listaralbum(int idAlbum) throws SQLException {
        List<albumVo> album = new ArrayList<>();
        sql = "SELECT * FROM album WHERE idAlbum=" + idAlbum;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while (rs.next()) {
                albumVo gfilas = new albumVo();
                gfilas.setIdAlbum(rs.getInt("idAlbum"));
                gfilas.setNombreAlbum(rs.getString("nombreAlbum"));
                gfilas.setEstadoAlbum(rs.getBoolean("estadoAlbum"));
                album.add(gfilas);
            }
            ps.close();
            System.out.println("consulta exitosa a album");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());// Error
        } finally {
            con.close();
        }

        return album;
    }


    // ----------------------------------------------------------------//
    // ACTUALIZAR
    public int actualizar(albumVo album) throws SQLException {
        sql = "UPDATE album SET nombreAlbum=?,estadoAlbum=? WHERE idAlbum=?";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, album.getNombreAlbum());
            ps.setBoolean(2, album.getEstadoAlbum());
            ps.setInt(3, album.getIdAlbum());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se edito el album correctamente");
        } catch (Exception e) {
            System.out.println("Error al editar " + e.getMessage().toString());
        } finally {
            con.close();
        }
        return gfilas;

    }
}
