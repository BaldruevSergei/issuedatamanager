package com.example.plugins.ao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book extends Media {
    private String isbn;
    private List<String> genres = new ArrayList<>();

    public Book() {}

    public Book(String isbn, String title, String author, Date publicationDate) {
        this.isbn = isbn;
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublicationDate(publicationDate);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN не может быть пустым!");
        }
        this.isbn = isbn;
    }

    public List<String> getGenres() {
        return genres;
    }

    // Добавление метода setGenres
    public void setGenres(List<String> genres) {
        if (genres == null) {
            throw new IllegalArgumentException("Список жанров не может быть null!");
        }
        this.genres = new ArrayList<>(genres); // Создаём копию списка для предотвращения изменений извне
    }

    public void addGenre(String genre) {
        if (genre != null && !genre.isEmpty()) {
            genres.add(genre);
        }
    }

    public void removeGenre(String genre) {
        genres.remove(genre);
    }

    public boolean hasGenre(String genre) {
        return genres.contains(genre);
    }

    @Override
    public String getMediaType() {
        return "Book";
    }

    public boolean isAvailable(List<Copy> copies) {
        for (Copy copy : copies) {
            if (copy.getBook().equals(this) && copy.isAvailable()) {
                return true;
            }
        }
        return false;
    }
}
