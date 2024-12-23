package api;


import dto.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentAPI extends HttpServlet {

    List<StudentDTO> list = new ArrayList<>();

    @java.lang.Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String stud = "";
        for (StudentDTO student : list) {
            if (student.getId() == id) {
                stud = student.toString();
                break;
            }
        }
        stud = stud == "" ? "Not Found" : stud;
        resp.getWriter().println(stud);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");

        StudentDTO student = new StudentDTO(id, name, age, address);

        boolean isAdd = list.add(student);
        resp.getWriter().println("Student added: " + isAdd);
        resp.getWriter().println(student.toString());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String address = req.getParameter("address");

        if (id != null && name != null && age != null && address != null) {
            StudentDTO studentDTO = new StudentDTO(Integer.parseInt(id), name, Integer.parseInt(age), address);
            for (StudentDTO studentDTO1 : list) {
                if (studentDTO1.getId() == studentDTO.getId()) {
                    studentDTO1.setId(studentDTO.getId());
                    studentDTO1.setName(studentDTO.getName());
                    studentDTO1.setAddress(studentDTO.getAddress());
                    studentDTO1.setAge(studentDTO.getAge());
                    resp.getWriter().println(studentDTO1.toString());
                    break;
                }
            }
        } else {
            resp.getWriter().println("Please Fill All Fields");
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if(id !=null){
            for (StudentDTO studentDTO : list) {
                if (studentDTO.getId() == Integer.parseInt(id)) {
                    list.remove(studentDTO);
                    resp.getWriter().println("Student Deleted");
                }
            }
        }
    }
}
