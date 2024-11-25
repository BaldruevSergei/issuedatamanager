package com.example.plugins.controller;

import com.atlassian.templaterenderer.TemplateRenderer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookFormController extends HttpServlet {
    private final TemplateRenderer templateRenderer;

    public AddBookFormController(TemplateRenderer templateRenderer) {
        this.templateRenderer = templateRenderer;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        templateRenderer.render("templates/add-book.vm", resp.getWriter());
    }
}
