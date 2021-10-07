package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TaskEntity;
import utils.DBUtil;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        TaskEntity t = em.find(TaskEntity.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("tasks", t);
        request.setAttribute("token", request.getSession().getId());

        request.getSession().setAttribute("tasks_id", t.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/edit.jsp");
        rd.forward(request, response);
    }

}