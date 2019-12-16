package Server;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text=req.getParameter("text");
        System.out.println(text);
//        BufferedReader reader=new BufferedReader(new InputStreamReader(req.getInputStream(), StandardCharsets.UTF_8));
//        String s=reader.readLine();
        Student student=new Student();
        student.age=1;
        List<Student> list=new ArrayList<Student>();
        Student student1=new Student();
        student1.age=1;
        Student student2=new Student();
        student2.age=2;
        list.add(student1);
        list.add(student2);
       resp.getWriter().write(JSON.toJSONString(list));

    }
}
