/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.preventech.main;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Paola Venuso
 */
public class MapServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://admin:admin@preventechdb-swyud.mongodb.net/test?retryWrites=true&w=majority"));
            MongoDatabase db = mongoClient.getDatabase("maps");
            MongoCollection collection = db.getCollection("prog3");
            List<Document> foundDocument = (List<Document>) collection.find().into(new ArrayList<>());
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Test</title> ");
            out.println("<link rel=\"stylesheet\" href=\"leaflet/leaflet.css\" />");
            out.println("<script src=\"leaflet/leaflet.js\"></script>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Test Servlet</h1>");
            out.println("<div id=\"map\" style=\"height: 1000px;\">");
            out.println("</div>");
            out.println("<script type=\"text/javascript\">\n"
                    + "var map = L.map('map').setView([40.905028, 14.060930], 11);\n");
            for (Document o : foundDocument) {
                List<Document> list = (List<Document>) o.get("pos");
                String list2 = (String) o.get("str");
                //System.out.println(list.get(0) + " " + list.get(1) );
                //System.out.println(list2);
                out.println("L.marker(["+ list.get(0)+","+list.get(1)+ "]).addTo(map).bindPopup(\"{{ "+list2+ "|safe }}\")");
            }        
            out.println("var layer = L.tileLayer('http://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}.png');\n"
                    + " map.addLayer(layer);\n"
                    + "</script>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
