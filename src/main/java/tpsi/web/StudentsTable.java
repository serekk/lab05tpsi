package tpsi.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "StudentsTable", urlPatterns = {"/StudentsTable"})
public class StudentsTable extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        if (session.getAttribute("counter") == null) {
            session.setAttribute("counter", 1);
        } else {
            int licznik = (int) session.getAttribute("counter");
            licznik++;
            session.setAttribute("counter", licznik);
        }
        
         if (session.getAttribute("studentList") == null) {
            List<Student> Students = new ArrayList<>();
            session.setAttribute("studentList", Students);
        }

//        request.getRequestDispatcher("students.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        processRequest(request, response);

            List<Student> Students = (List<Student>) session.getAttribute("studentList");
            String name = request.getParameter("namePOST");
            String lastName = request.getParameter("lastNamePOST");
            String email = request.getParameter("emailPOST");
            Student tempStudent = new Student(name, lastName, email);

            Students.add(tempStudent);
            session.setAttribute("studentList", Students);

        request.getRequestDispatcher("students.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession();
        request.getRequestDispatcher("students.jsp").forward(request, response);
        
        
    }

}
