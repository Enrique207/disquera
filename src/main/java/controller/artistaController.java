package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.artista.artistaDao;
import model.artista.artistaVo;

public class artistaController extends HttpServlet {

    artistaVo r=new artistaVo();
    artistaDao rd=new artistaDao();
    

    @Override
    // DoGet
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("estas en el DoGet");
        String accion=req.getParameter("accion");
        System.out.println(accion);
        switch(accion){
            case "registrar":
                registrar(req,resp);
            break;
            case "visualizar":
                visualizar(req,resp);
            break;
            case "eliminar":
                eliminar(req,resp);
            break;
            case "estadoArtista":
                estado(req,resp);
            break;
            case "editar":
                editar(req, resp);
        }
    }

    // DoPost
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al DoPost");
        String accion=req.getParameter("accion");
        
        switch(accion){
            case "add":
                add(req, resp);
            break;
            case "edit":
                edit(req, resp);
            break;
        }

    }
    //VISUALIZAR
    private void visualizar(HttpServletRequest req, HttpServletResponse resp){
        
        try{
            List artista=rd.listar();
            req.setAttribute("artista", artista);
            req.getRequestDispatcher("VIEW/artista/listartista.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        }catch (Exception e){
            System.out.println("El formulario NO ha sido abierto" +e.getMessage().toString());
        }
    }
    //REGISTRAR
    private void registrar(HttpServletRequest req, HttpServletResponse resp){
        try{
            req.getRequestDispatcher("VIEW/artista/addartista.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch (Exception e){
            System.out.println("El formulario NO ha sido abierto" +e.getMessage().toString());
        }
    }
    //ELIMINAR
    private void eliminar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idArtista")!=null){
            r.setIdArtista(Integer.parseInt(req.getParameter("idArtista")));
        }
        try {
            rd.eliminar(r.getIdArtista());
            System.out.println("El estado se elimino correctamente");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error al eliminar el estado "+e.getMessage().toString());
        }
    }
    //ESTADO
    private void estado(HttpServletRequest req, HttpServletResponse resp){
        
        if(req.getParameter("idArtista")!=null){
            r.setIdArtista(Integer.parseInt(req.getParameter("idArtista")));
        }
        if(req.getParameter("estadoArtista")!=null){
            r.setEstadoArtista(Boolean.parseBoolean(req.getParameter("estadoArtista")));
        }
        try{
            rd.estado(r.getEstadoArtista(), r.getIdArtista());
            System.out.println("Es estado se cambio correctamente");
            visualizar(req, resp);        
        }catch (Exception e){
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
    //EDITAR
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idArtista")!=null){
            r.setIdArtista(Integer.parseInt(req.getParameter("idArtista")));
        }
        try {
            List artista=rd.Listarartista(r.getIdArtista());
            req.setAttribute("artista", artista);
            req.getRequestDispatcher("VIEW/artista/editartista.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edicion 'ARTISTA'");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    //--------------------------------------------------------------------------------------------//
    //METODOS DEL DOPOST
    //--------------------------------------------------------------------------------------------//
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("noArtista")!=null){
            r.setNoArtista(req.getParameter("noArtista"));
        }
        if(req.getParameter("tipoDocumento")!=null){
            r.setTipoDocumento(req.getParameter("tipoDocumento"));
        }
        if(req.getParameter("nombreArtista")!=null){
            r.setNombreArtista(req.getParameter("nombreArtista"));
        }
        if(req.getParameter("apellidoArtista")!=null){
                r.setApellidoArtista(req.getParameter("apellidoArtista"));
        }
        if(req.getParameter("nombreArtistico")!=null){
            r.setNombreArtistico(req.getParameter("nombreArtistico"));   
        }
        if(req.getParameter("feNacimArtista")!=null){
            r.setFeNacimArtista(req.getParameter("feNacimArtista"));   
        }
        if(req.getParameter("emailArtista")!=null){
            r.setEmailArtista(req.getParameter("emailArtista"));   
        }
        if(req.getParameter("estadoArtista")!=null){
            r.setEstadoArtista(true);
        }
        else{
            r.setEstadoArtista(false);
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");
            visualizar (req, resp);
        }catch (Exception e){
            System.out.println("Error en la insercion del registro "+e.getMessage().toString());
        }
    }
    //--------------------------------------------------------------------------------------------//
    private void edit(HttpServletRequest req, HttpServletResponse resp){
        
        if(req.getParameter("idArtista")!=null){
            r.setIdArtista(Integer.parseInt(req.getParameter("idArtista")));
        }  
        if(req.getParameter("noArtista")!=null){
            r.setNoArtista(req.getParameter("noArtista"));
        }
        if(req.getParameter("tipoDocumento")!=null){
            r.setTipoDocumento(req.getParameter("tipoDocumento"));
        }
        if(req.getParameter("nombreArtista")!=null){
            r.setNombreArtista(req.getParameter("nombreArtista"));
        }
        if(req.getParameter("apellidoArtista")!=null){
                r.setApellidoArtista(req.getParameter("apellidoArtista"));
        }
        if(req.getParameter("nombreArtistico")!=null){
            r.setNombreArtistico(req.getParameter("nombreArtistico"));   
        }
        if(req.getParameter("feNacimArtista")!=null){
            r.setFeNacimArtista(req.getParameter("feNacimArtista"));   
        }
        if(req.getParameter("emailArtista")!=null){
            r.setEmailArtista(req.getParameter("emailArtista"));   
        }
        if(req.getParameter("estadoArtista")!=null){
            r.setEstadoArtista(true);
        }else{
            r.setEstadoArtista(false);
        }try{
            rd.actualizar(r);
            System.out.println("Editar el registro de artista");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error al editar el registro "+e.getMessage().toString());
        }
    }
} 
