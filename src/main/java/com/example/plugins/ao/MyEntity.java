package com.example.plugins.ao;

import net.java.ao.Entity;
import net.java.ao.Preload;

@Preload
public interface MyEntity extends Entity {
    String getName();
    void setName(String name);

    String getValue();
    void setValue(String value);
}
