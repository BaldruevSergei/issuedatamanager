package com.example.plugins.issuedatamanager;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.event.api.EventListener;
import com.atlassian.plugin.event.events.PluginEnabledEvent;
import com.example.plugins.ao.MyEntity;
import net.java.ao.EntityManager;

import javax.inject.Inject;

public class ActiveObjectsInitializer {

    private final ActiveObjects ao;

    @Inject
    public ActiveObjectsInitializer(ActiveObjects ao) {
        this.ao = ao;
    }

    @EventListener
    public void onPluginEnabled(PluginEnabledEvent event) {
        ao.migrate(MyEntity.class); // Создаёт таблицу в базе данных
    }
}
