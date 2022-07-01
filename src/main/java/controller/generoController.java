package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.genero.generoDao;
import model.genero.generoVo;

public class generoController extends HttpServlet {

    generoVo r=new generoVo();
    generoDao rd=new generoDao();
    

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
            case "estadoGenero":
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
            List genero=rd.listar();
            req.setAttribute("genero", genero);
            req.getRequestDispatcher("VIEW/genero/listgenero.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch (Exception e){
            System.out.println("El formulario NO ha sido abierto" +e.getMessage().toString());
        }
    }
    //REGISTRAR
    private void registrar(HttpServletRequest req, HttpServletResponse resp){
        try{
            req.getRequestDispatcher("VIEW/genero/addgenero.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch (Exception e){
            System.out.println("El formulario NO ha sido abierto" +e.getMessage().toString());
        }
    }
    //ELIMINAR
    private void eliminar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idGenero")!=null){
            r.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        try {
            rd.eliminar(r.getIdGenero());
            System.out.println("El estado se elimino correctamente");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error al eliminar el estado "+e.getMessage().toString());
        }
    }
    //ESTADO
    private void estado(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idGenero")!=null){
            r.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        if(req.getParameter("estadoGenero")!=null){
            r.setEstadoGenero(Boolean.parseBoolean(req.getParameter("estadoGenero")));
        }
        try{
            rd.estado(r.getEstadoGenero(), r.getIdGenero());
            System.out.println("Es estado se cambio correctamente");
            visualizar(req, resp);        
        }catch (Exception e){
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
    //EDITAR
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            r.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        try {
            List genero=rd.Listargenero(r.getIdGenero());
            req.setAttribute("genero", genero);
            req.getRequestDispatcher("VIEW/genero/editgenero.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edicionc 'GENERO'");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    //--------------------------------------------------------------------------------------------//
    //METODOS DEL DOPOST
    //--------------------------------------------------------------------------------------------//
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("nombreGenero")!=null){
            r.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("estadoGenero")!=null){
            r.setEstadoGenero(true);
        }
        else{
            r.setEstadoGenero(false);
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
        
        if(req.getParameter("idGenero")!=null){
            r.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        if(req.getParameter("nombreGenero")!=null){
            r.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("estadoGenero")!=null){
            r.setEstadoGenero(true);
        }
        else{
            r.setEstadoGenero(false);
        }
        try{
            rd.actualizar(r);
            System.out.println("Editar el registro de genero");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error al editar el registro "+e.getMessage().toString());
        }
    }
} 

