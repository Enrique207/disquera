package model.artista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;

public class artistaDao {

    Connection con; 
    PreparedStatement ps;
    ResultSet rs; 
    String sql = null;
    int a;
    int afilas;

    // REGISTRAR
    public int registrar(artistaVo artista) throws SQLException {
        sql = "INSERT INTO artista (noArtista, tipoDocumento, nombreArtista, apellidoArtista, nombreArtistico, feNacimArtista, emailArtista, estadoArtista) values (?,?,?,?,?,?,?,?)";

        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, artista.getNoArtista());
            ps.setString(2, artista.getTipoDocumento());
            ps.setString(3, artista.getNombreArtista());
            ps.setString(4, artista.getApellidoArtista());
            ps.setString(5, artista.getNombreArtistico());
            ps.setString(6, artista.getFeNacimArtista());
            ps.setString(7, artista.getEmailArtista());
            ps.setBoolean(8, artista.getEstadoArtista());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registró la artista correctamente");

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
    public List<artistaVo> listar() throws SQLException {
        List<artistaVo> artista = new ArrayList<>();
        sql = "SELECT * FROM artista";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                artistaVo a=new artistaVo();

                a.setIdArtista(rs.getInt("idArtista"));
                a.setNoArtista(rs.getString("noArtista"));
                a.setTipoDocumento(rs.getString("tipoDocumento"));
                a.setNombreArtista(rs.getString("nombreArtista"));
                a.setApellidoArtista(rs.getString("apellidoArtista"));
                a.setNombreArtistico(rs.getString("nombreArtistico"));
                a.setFeNacimArtista(rs.getString("feNacimArtista"));
                a.setEmailArtista(rs.getString("emailArtista"));
                a.setEstadoArtista(rs.getBoolean("estadoArtista"));
                
                artista.add(a);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());
        } finally {
            con.close();
        }

        return artista;
    }

    // ----------------------------------------------------------------//
    // ELIMINAR
    public void eliminar(int idArtista) throws SQLException {
        sql = "DELETE FROM artista WHERE idartista=" + idArtista;

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
    public void estado(Boolean estadoArtista, int idArtista) throws SQLException {
        sql = "UPDATE artista SET estadoArtista="+estadoArtista+" WHERE idArtista="+idArtista;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se cambio el estado a "+estadoArtista+" correctamente");
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado " +e.getMessage().toString());
        } finally {
            con.close();
        }
    }

    // ----------------------------------------------------------------//
    // EDITAR
    public List<artistaVo> Listarartista(int idArtista) throws SQLException {
        List<artistaVo> artista = new ArrayList<>();
        sql = "SELECT * FROM artista WHERE idArtista=" +idArtista;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while (rs.next()) {
                artistaVo afilas = new artistaVo();
                afilas.setIdArtista(rs.getInt("idArtista"));
                afilas.setNoArtista(rs.getString("noArtista"));
                afilas.setTipoDocumento(rs.getString("tipoDocumento"));
                afilas.setNombreArtista(rs.getString("nombreArtista"));
                afilas.setApellidoArtista(rs.getString("apellidoArtista"));
                afilas.setNombreArtistico(rs.getString("nombreArtistico"));
                afilas.setFeNacimArtista(rs.getString("feNacimArtista"));
                afilas.setEmailArtista(rs.getString("emailArtista"));
                afilas.setEstadoArtista(rs.getBoolean("estadoArtista"));
                artista.add(afilas);
            }
            ps.close();
            System.out.println("consulta exitosa a artista");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());// Error
        } finally {
            con.close();
        }

        return artista;
    }


    // ----------------------------------------------------------------//
    // ACTUALIZAR
    public int actualizar(artistaVo artista) throws SQLException {
        sql = "UPDATE artista SET noArtista=?, tipoDocumento=?, nombreArtista=?, apellidoArtista=?, nombreArtistico=?, feNacimArtista=?, emailArtista=?, estadoArtista=? WHERE idArtista=?";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, artista.getNoArtista());
            ps.setString(2, artista.getTipoDocumento());
            ps.setString(3, artista.getNombreArtista());
            ps.setString(4, artista.getApellidoArtista());
            ps.setString(5, artista.getNombreArtistico());
            ps.setString(6,artista.getFeNacimArtista());
            ps.setString(7,artista.getEmailArtista());
            ps.setBoolean(8, artista.getEstadoArtista());
            ps.setInt(9, artista.getIdArtista());

            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se edito el artista correctamente");
        } catch (Exception e) {
            System.out.println("Error al editar " + e.getMessage().toString());
        } finally {
            con.close();
        }
        return afilas;
    }
}