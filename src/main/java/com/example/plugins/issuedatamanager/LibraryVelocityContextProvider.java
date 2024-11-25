package com.example.plugins.issuedatamanager;

import com.example.plugins.ao.Book;
import com.atlassian.plugin.webresource.WebResourceManager;
import com.atlassian.templaterenderer.RenderingException;
import com.atlassian.templaterenderer.TemplateRenderer;

import javax.inject.Inject;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryVelocityContextProvider {

    private final LibraryService libraryService;
    private final WebResourceManager webResourceManager;
    private final TemplateRenderer templateRenderer;

    @Inject
    public LibraryVelocityContextProvider(LibraryService libraryService, WebResourceManager webResourceManager, TemplateRenderer templateRenderer) {
        this.libraryService = libraryService;
        this.webResourceManager = webResourceManager;
        this.templateRenderer = templateRenderer;
    }

    public String renderBooksDropdown() {
        // Подключение необходимых ресурсов для AUI
        webResourceManager.requireResource("com.atlassian.auiplugin:ajs");
        webResourceManager.requireResource("com.example.plugins:library-resources");

        // Получение данных из LibraryService
        List<Book> books = libraryService.getBooks();

        // Контекст для передачи данных в шаблон
        Map<String, Object> context = new HashMap<>();
        context.put("books", books);

        StringWriter writer = new StringWriter();

        try {
            // Рендеринг шаблона dropdown.vm
            templateRenderer.render("templates/dropdown.vm", context, writer);
        } catch (RenderingException | IOException e) {
            e.printStackTrace();
            return "Ошибка рендеринга шаблона";
        }

        // Возврат отрендеренного HTML
        return writer.toString();
    }
}

