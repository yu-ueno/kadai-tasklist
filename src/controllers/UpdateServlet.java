package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TaskEntity;
import utils.DBUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");

        if(token != null && token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            TaskEntity t = em.find(TaskEntity.class, (Integer)(request.getSession().getAttribute("tasks_id")));

            t.setContent(request.getParameter("content"));
            t.setUpdateDate(new Timestamp(System.currentTimeMillis()));

            // DB更新
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();

            request.getSession().removeAttribute("tasks_id");

            // indexページへ
            response.sendRedirect(request.getContextPath() + "/index");

        }
    }

}
