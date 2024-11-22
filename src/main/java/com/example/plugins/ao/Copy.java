package com.example.plugins.ao;
public class Copy {
    private String copyId; // Уникальный ID экземпляра
    private Book book;
    private boolean available; // Статус доступности

    public String getCopyId() {
        return copyId;
    }

    public void setCopyId(String copyId) {
        this.copyId = copyId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
