/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Student;
import model.studentTable;
/**
 *
 * @author Theerakan
 */
public class UpdateStudentController extends HttpServlet {
static LinkedList<Integer> idChecker = new LinkedList<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.InterruptedException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        synchronized(getServletContext()){
            for(int i = 0; i < idChecker.size(); i++) System.out.println( idChecker.get(i) );
            
            if(searchId(id)){
                request.getRequestDispatcher("handleError.jsp").forward(request, response);
            }else{
                
                
                
                Student std = studentTable.findStudentById(id);
                // session.setAttribute("student", std);
                getServletContext().setAttribute("student", std);
                request.getRequestDispatcher("confirm_update.jsp").forward(request, response); 
            }
        }
        idChecker.add(id);
        
        
  	
        
    }
    
    public static boolean searchId(int id){
        int ans = -1;
        for(int i = 0; i < idChecker.size(); i++){
            int llid = idChecker.get(i);
            
            if(llid == id){
                ans = i;
                break;
            }
        }
        
        if(ans == -1){
            return false;
        }
        return true;
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (InterruptedException ex) {
        Logger.getLogger(UpdateStudentController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (InterruptedException ex) {
        Logger.getLogger(UpdateStudentController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
