package com.example.plugins;
import com.example.plugins.ao.Book;
import com.example.plugins.issuedatamanager.LibraryService;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Создаём экземпляр LibraryService
        LibraryService libraryService = new LibraryService();

        // Добавляем книги
        libraryService.addBook(
                "978-3-16-148410-0",
                "1984",
                "George Orwell",
                new Date(),
                Arrays.asList("Dystopian", "Political Fiction")
        );

        libraryService.addBook(
                "978-0-7432-7356-5",
                "Angels and Demons",
                "Dan Brown",
                new Date(),
                Arrays.asList("Thriller", "Mystery")
        );

        // Получаем и выводим список книг
        System.out.println("Добавленные книги:");
        for (Book book : libraryService.getBooks()) {
            System.out.println("ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Genres: " + book.getGenres());
        }
    }
}
