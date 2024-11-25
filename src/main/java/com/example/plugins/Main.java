package com.example.plugins;
import com.example.plugins.issuedatamanager.LibraryService;
import com.atlassian.activeobjects.external.ActiveObjects;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Создаем мок для ActiveObjects
        ActiveObjects ao = Mockito.mock(ActiveObjects.class);

        // Передаем мок в LibraryService
        LibraryService libraryService = new LibraryService(ao);

        // Добавляем книгу
        libraryService.addBook(
                "978-3-16-148410-0",
                "1984",
                "George Orwell",
                new Date(),
                Arrays.asList("Dystopian")
        );

        System.out.println("Книга успешно добавлена!");
    }
}
