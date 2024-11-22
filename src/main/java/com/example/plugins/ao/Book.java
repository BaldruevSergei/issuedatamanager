package com.example.plugins.ao;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private String isbn;
    private List<String> genres = new ArrayList<>();

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void addGenre(String genre) {
        genres.add(genre);
    }

    @Override
    public String getMediaType() {
        return "Book";
    }

    public boolean isAvailable() {
        // Логика проверки доступности
        return true;
    }
}
