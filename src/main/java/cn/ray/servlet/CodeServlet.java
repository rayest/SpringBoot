package cn.ray.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Rayest on 2016/10/15 0015.
 */
public class CodeServlet extends HttpServlet{
    private static final long SerialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("======== DoPost ========");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("======== DoPost ========");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Code Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>这是：Code Servlet</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
