package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.album.albumDao;
import model.album.albumVo;



public class albumController extends HttpServlet {

    albumVo r=new albumVo();
    albumDao rd=new albumDao();
    

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
            case "estadoAlbum":
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
            List album=rd.listar();
            req.setAttribute("album", album);
            req.getRequestDispatcher("VIEW/album/listalbum.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch (Exception e){
            System.out.println("El formulario NO ha sido abierto" +e.getMessage().toString());
        }
    }
    //REGISTRAR
    private void registrar(HttpServletRequest req, HttpServletResponse resp){
        try{
            req.getRequestDispatcher("VIEW/album/addalbum.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch (Exception e){
            System.out.println("El formulario NO ha sido abierto" +e.getMessage().toString());
        }
    }
    //ELIMINAR
    private void eliminar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idAlbum")!=null){
            r.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }
        try {
            rd.eliminar(r.getIdAlbum());
            System.out.println("El estado se elimino correctamente");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error al eliminar el estado "+e.getMessage().toString());
        }
    }
    //ESTADO
    private void estado(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idAlbum")!=null){
            r.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }
        if(req.getParameter("estadoAlbum")!=null){
            r.setEstadoAlbum(Boolean.parseBoolean(req.getParameter("estadoAlbum")));
        }
        try{
            rd.estado(r.getEstadoAlbum(), r.getIdAlbum());
            System.out.println("Es estado se cambio correctamente");
            visualizar(req, resp);        
        }catch (Exception e){
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
    //EDITAR
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            r.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }
        try {
            List album=rd.Listaralbum(r.getIdAlbum());
            req.setAttribute("album", album);
            req.getRequestDispatcher("VIEW/album/editalbum.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edicionc 'ALBUM'");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    //--------------------------------------------------------------------------------------------//
    //METODOS DEL DOPOST
    //--------------------------------------------------------------------------------------------//
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("nombreAlbum")!=null){
            r.setNombreAlbum(req.getParameter("nombreAlbum"));
        }
        if(req.getParameter("estadoAlbum")!=null){
            r.setEstadoAlbum(true);
        }
        else{
            r.setEstadoAlbum(false);
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error en la insercion del registro "+e.getMessage().toString());
        }
    }
    //--------------------------------------------------------------------------------------------//
    private void edit(HttpServletRequest req, HttpServletResponse resp){
        
        if(req.getParameter("idAlbum")!=null){
            r.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }
        if(req.getParameter("nombreAlbum")!=null){
            r.setNombreAlbum(req.getParameter("nombreAlbum"));
        }
        if(req.getParameter("estadoAlbum")!=null){
            r.setEstadoAlbum(true);
        }
        else{
            r.setEstadoAlbum(false);
        }
        try{
            rd.actualizar(r);
            System.out.println("Editar el registro de album");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error al editar el registro "+e.getMessage().toString());
        }
    }
} 


