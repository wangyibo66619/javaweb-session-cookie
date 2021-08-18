package com.wang.servlet;

import com.wang.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        // 创建session
        HttpSession session = req.getSession();
        // 往session里面存东西
        session.setAttribute("name",new Person("王艺博",18));
        // 获得Session的id
        String sessionId = session.getId();
        // 判断Session是不是新建的
        if ( session.isNew() ) {
            resp.getWriter().write("session创建成功，ID：" + sessionId);
        }else {
            resp.getWriter().write("session已经在服务器中存在了，ID：" + sessionId);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
