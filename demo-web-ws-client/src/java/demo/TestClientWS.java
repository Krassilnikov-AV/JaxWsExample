package demo;

import ejb.DemoEJB;
import ejb.DemoEJB_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.DemoWS;
import ws.DemoWS_Service;
import ws.TestWS;
import ws.TestWS_Service;

@WebServlet(name = "TestClientWS", urlPatterns = {"/TestClientWS"})
public class TestClientWS extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/demo-web-ws/TestWS?wsdl")
    private TestWS_Service srv;

    @WebServiceRef(wsdlLocation = "http://localhost:8080/demo-web-ws/DemoWS?wsdl")
    private DemoWS_Service add;

     @WebServiceRef(wsdlLocation = "http://localhost:8080/DemoEJB/DemoEJB?wsdl")
    private DemoEJB_Service ran;
    
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
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestClientWS</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestClientWS</h1>");
            out.println("<h2>Response: " + getMessage(name) + "</h2>");
            out.println("</body>");
            out.println("</html>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//            throws ServletException, IOException {
//       response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Method not supported yet");

        response.setContentType("text/html;charset=UTF-8");
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String rand = null;
        if (first == null || first.isEmpty() || second == null || second.isEmpty()) {
            rand = request.getParameter("random");
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestClientWS</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestClientWS</h1>");
            if (rand == null) {
                out.println("<h2>Sum: " + getSum(first, second) + "</h2>");
            } else {
                out.println("<h2>Random: " + getRandom() + "</h2>");
            }
            out.println("</body>");
            out.println("</html>");
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

    private String getMessage(String name) {
        if (srv != null) {
            TestWS port = srv.getTestWSPort();
            return port.hello(name);
        }
        return "Service is null";
    }

    private String getSum(String first, String second) {
        try {
            int x = Integer.parseInt(first);
            int y = Integer.parseInt(second);
            DemoWS port = add.getDemoWSPort();
            long s = port.sum(x, y);
            return Long.toString(s);
        } catch (NumberFormatException e) {
            //           return "Bad parameters";
            return getText(first, second);
        }
    }

    private String getText(String first, String second) {
        DemoWS port = add.getDemoWSPort();
        return port.toUpperCase(first) + " + " + port.toUpperCase(second);
    }

    private String getRandom() {
      DemoEJB port = ran.getDemoEJBPort();
              return Integer.toString(port.random());
    }
}
