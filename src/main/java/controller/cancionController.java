package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.cancion.cancionDao;
import model.cancion.cancionVo;

public class cancionController extends HttpServlet {

    cancionVo r=new cancionVo();
    cancionDao rd=new cancionDao();
    

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
            case "estadoCancion":
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
            List cancion=rd.listar();
            req.setAttribute("cancion", cancion);
            req.getRequestDispatcher("VIEW/cancion/listcancion.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch (Exception e){
            System.out.println("El formulario NO ha sido abierto" +e.getMessage().toString());
        }
    }
    //REGISTRAR
    private void registrar(HttpServletRequest req, HttpServletResponse resp){
        try{
            req.getRequestDispatcher("VIEW/cancion/addcancion.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch (Exception e){
            System.out.println("El formulario NO ha sido abierto" +e.getMessage().toString());
        }
    }
    //ELIMINAR
    private void eliminar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idCancion")!=null){
            r.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        try {
            rd.eliminar(r.getIdCancion());
            System.out.println("El estado se elimino correctamente");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error al eliminar el estado "+e.getMessage().toString());
        }
    }
    //ESTADO
    private void estado(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idCancion")!=null){
            r.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        if(req.getParameter("estadoCancion")!=null){
            r.setEstadoCancion(Boolean.parseBoolean(req.getParameter("estadoCancion")));
        }
        try {
            rd.estado(r.getEstadoCancion(), r.getIdCancion());
            System.out.println("El estado se cambio correctamente");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error en el cambio del estado " +e.getMessage().toString());
        }
    }
    //EDITAR
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){
            r.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        try {
            List cancion=rd.Listarcancion (r.getIdCancion());
            req.setAttribute("cancion", cancion);
            req.getRequestDispatcher("VIEW/cancion/editcancion.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    //--------------------------------------------------------------------------------------------//
    //METODOS DEL DOPOST
    //--------------------------------------------------------------------------------------------//
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("nombreCancion")!=null){
            r.setNombreCancion(req.getParameter("nombreCancion"));
        }
        if(req.getParameter("fechaGrabacion")!=null){
                r.setFechaGrabacion(req.getParameter("fechaGrabacion"));
        }
        if(req.getParameter("duracionCancion")!=null){
            r.setDuracionCancion(req.getParameter("duracionCancion"));   
        }
        if(req.getParameter("estadoCancion")!=null){
            r.setEstadoCancion(true);
        }
        else{
            r.setEstadoCancion(false);
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
        if(req.getParameter("idCancion")!=null){
            r.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        if(req.getParameter("nombreCancion")!=null){
            r.setNombreCancion(req.getParameter("nombreCancion"));
        }
        if(req.getParameter("fechaGrabacion")!=null){
            r.setFechaGrabacion(req.getParameter("fechaGrabacion"));
        }
        if(req.getParameter("duracionCancion")!=null){
        r.setDuracionCancion(req.getParameter("duracionCancion"));   
        }
        if(req.getParameter("estadoCancion")!=null){
            r.setEstadoCancion(true);
        }
        else{
            r.setEstadoCancion(false);
        }
        try{
            rd.actualizar(r);
            System.out.println("Editar el registro de cancion");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error al editar el registro "+e.getMessage().toString());
        }
    }
} 
