package com.example.plugins.controller;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.sal.api.transaction.TransactionCallback;
import com.example.plugins.ao.Book;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookController extends HttpServlet {
    private final ActiveObjects activeObjects;

    public AddBookController(ActiveObjects activeObjects) {
        this.activeObjects = activeObjects;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String isbn = req.getParameter("isbn");
        String title = req.getParameter("title");
        String author = req.getParameter("author");

        activeObjects.executeInTransaction((TransactionCallback<Void>) () -> {
            Book book = activeObjects.create(Book.class);
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setAuthor(author);
            book.save();
            return null;
        });

        resp.sendRedirect("/books");
    }
}