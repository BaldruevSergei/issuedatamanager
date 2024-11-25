package com.example.plugins.ao;

import net.java.ao.Entity;
import net.java.ao.Preload;

@Preload
public interface Copy extends Entity {
    String getCopyId();
    void setCopyId(String copyId);

    Book getBook();
    void setBook(Book book);

    boolean isAvailable();
    void setAvailable(boolean available);
}
