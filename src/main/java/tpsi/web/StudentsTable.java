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
int counter;
List<Student> Students = new ArrayList<>();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        counter++;
        
        String name = request.getParameter("namePOST");
        String lastName = request.getParameter("lastNamePOST");
        String email = request.getParameter("emailPOST");
        Student tempStudent = new Student(name, lastName, email);
        Students.add(tempStudent);

        session.setAttribute("counter", counter);
        session.setAttribute("studentList", Students);
        
        request.getRequestDispatcher("students.jsp").forward(request, response);

        
    }
    
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            counter++;
            request.getRequestDispatcher("students.jsp").forward(request, response);
        }
}
