package model.cancion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;

public class cancionDao {

    Connection con; 
    PreparedStatement ps;
    ResultSet rs; 
    String sql = null;
    int c;
    int cfilas;

    // REGISTRAR
    public int registrar(cancionVo cancion) throws SQLException {
        sql = "INSERT INTO cancion (nombreCancion, fechaGrabacion, duracionCancion, estadoCancion) values(?,?,?,?)";

        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, cancion.getNombreCancion());
            ps.setString(2, cancion.getFechaGrabacion());
            ps.setString(3, cancion.getDuracionCancion());
            ps.setBoolean(4, cancion.getEstadoCancion());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registró la cancion correctamente");

        } catch (Exception e) {
            System.out.println("Error en el registro " + e.getMessage().toString());
        }

        finally {
            con.close();
        }
        return c;
    }

    // -------------------------------------------------------------------------//
    // LISTAR
    public List<cancionVo> listar() throws SQLException {
        List<cancionVo> cancion = new ArrayList<>();
        sql = "SELECT * FROM cancion";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                cancionVo c=new cancionVo();

                c.setIdCancion(rs.getInt("idCancion"));
                c.setNombreCancion(rs.getString("nombreCancion"));
                c.setFechaGrabacion(rs.getString("fechaGrabacion"));
                c.setDuracionCancion(rs.getString("duracionCancion"));
                c.setEstadoCancion(rs.getBoolean("estadoCancion"));
                cancion.add(c);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());
        } finally {
            con.close();
        }
        return cancion;
    }

    // ----------------------------------------------------------------//
    // ELIMINAR
    public void eliminar(int idCancion) throws SQLException {
        sql = "DELETE FROM cancion WHERE idCancion=" +idCancion;

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
    public void estado(Boolean estadoCancion, int idCancion) throws SQLException {
        sql = "UPDATE cancion SET estadoCancion=" +estadoCancion+ "WHERE idCancion=" +idCancion;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se cambio el estado a " +estadoCancion+ " correctamente");
        }catch (Exception e){
            System.out.println("Error en el cambio de estadop "+e.getMessage().toString());
        }finally {
            con.close();
        }
    }
    // ----------------------------------------------------------------//
    // EDITAR
    public List<cancionVo> Listarcancion(int idCancion) throws SQLException {
        List<cancionVo> cancion = new ArrayList<>();
        sql = "SELECT * FROM cancion WHERE idCancion=" +idCancion;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while (rs.next()) {
                cancionVo cfilas = new cancionVo();
                cfilas.setIdCancion(rs.getInt("idCancion"));
                cfilas.setNombreCancion(rs.getString("nombreCancion"));
                cfilas.setFechaGrabacion(rs.getString("fechaGrabacion"));
                cfilas.setDuracionCancion(rs.getString("duracionCancion"));
                cfilas.setEstadoCancion(rs.getBoolean("estadoCancion"));
                cancion.add(cfilas);
            }
            ps.close();
            System.out.println("consulta exitosa a cancion");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());// Error
        } finally {
            con.close();
        }

        return cancion;
    }


    // ----------------------------------------------------------------//
    // ACTUALIZAR
    public int actualizar(cancionVo cancion) throws SQLException {
        sql = "UPDATE cancion SET nombreCancion=?, fechaGrabacion=?, duracionCancion=?, estadoCancion=? WHERE idCancion=?";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, cancion.getNombreCancion());
            ps.setString(2, cancion.getFechaGrabacion());
            ps.setString(3, cancion.getDuracionCancion());
            ps.setBoolean(4, cancion.getEstadoCancion());
            ps.setInt(5, cancion.getIdCancion());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se edito el cancion correctamente");
        } catch (Exception e) {
            System.out.println("Error al editar " + e.getMessage().toString());
        } finally {
            con.close();
        }
        return cfilas;

    }
}