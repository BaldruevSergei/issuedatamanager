package com.example.plugins.issuedatamanager;

import com.atlassian.plugin.webresource.WebResourceManager;
import com.atlassian.templaterenderer.RenderingException;
import com.atlassian.templaterenderer.TemplateRenderer;

import javax.inject.Inject;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class MyEntityVelocityContextProvider {

    private final MyEntityService service;
    private final WebResourceManager webResourceManager;
    private final TemplateRenderer templateRenderer;

    @Inject
    public MyEntityVelocityContextProvider(MyEntityService service, WebResourceManager webResourceManager, TemplateRenderer templateRenderer) {
        this.service = service;
        this.webResourceManager = webResourceManager;
        this.templateRenderer = templateRenderer;
    }

    public String renderEntitiesDropdown() {
        // Загружаем AUI и ресурсы плагина
        webResourceManager.requireResource("com.atlassian.auiplugin:ajs");
        webResourceManager.requireResource("com.example.plugins:dialog-resources"); // Подключаем ресурсы, описанные в atlassian-plugin.xml

        // Контекст для шаблона
        Map<String, Object> context = new HashMap<>();
        context.put("entities", service.getAllEntities());

        StringWriter writer = new StringWriter();

        try {
            // Рендеринг шаблона
            templateRenderer.render("templates/dropdown.vm", context, writer);
        } catch (RenderingException e) {
            e.printStackTrace(); // Обработка RenderingException
            return "Error rendering template (RenderingException)";
        } catch (IOException e) {
            e.printStackTrace(); // Обработка IOException
            return "Error rendering template (IOException)";
        }

        // Возврат результата
        return writer.toString();
    }
}
