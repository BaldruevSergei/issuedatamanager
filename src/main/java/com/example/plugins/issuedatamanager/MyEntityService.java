package com.example.plugins.issuedatamanager;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.example.plugins.ao.MyEntity;
import net.java.ao.Query;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class MyEntityService {

    private final ActiveObjects ao;

    @Inject
    public MyEntityService(ActiveObjects ao) {
        this.ao = ao;
    }

    public List<MyEntity> getAllEntities() {
        return Arrays.asList(ao.find(MyEntity.class, Query.select()));
    }

    public MyEntity createEntity(String name, String value) {
        MyEntity entity = ao.create(MyEntity.class);
        entity.setName(name);
        entity.setValue(value);
        entity.save();
        return entity;
    }
}
