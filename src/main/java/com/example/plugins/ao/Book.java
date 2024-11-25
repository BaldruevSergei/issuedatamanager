package com.example.plugins.ao;

import net.java.ao.Entity;
import net.java.ao.schema.Table;

import java.util.Date;

@Table("Books")
public interface Book extends Entity {
    String getIsbn();
    void setIsbn(String isbn);

    String getTitle();
    void setTitle(String title);

    String getAuthor();
    void setAuthor(String author);

    Date getPublicationDate();
    void setPublicationDate(Date publicationDate);

    String[] getGenres();
    void setGenres(String[] genres);
}
