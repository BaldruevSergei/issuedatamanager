package com.example.plugins.issuedatamanager;

import com.example.plugins.ao.Book;
import net.java.ao.ActiveObjects;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LibraryServiceTest {

    private LibraryService libraryService;
    private ActiveObjects ao;

    @Before
    public void setUp() {
        // Создаем мок для ActiveObjects
        ao = Mockito.mock(ActiveObjects.class);
        libraryService = new LibraryService(ao);
    }

    @Test
    public void testAddBook() {
        // Подготовка тестовых данных
        String isbn = "978-3-16-148410-0";
        String title = "1984";
        String author = "George Orwell";
        Date publicationDate = new Date();
        List<String> genres = Arrays.asList("Dystopian", "Science Fiction");

        // Вызов метода
        libraryService.addBook(isbn, title, author, publicationDate, genres);

        // Проверка взаимодействия с ActiveObjects
        verify(ao, times(1)).create(Book.class);
    }

    @Test
    public void testGetBooks() {
        // Мокаем возвращаемое значение ActiveObjects
        Book mockBook = Mockito.mock(Book.class);
        when(ao.find(Book.class)).thenReturn(new Book[]{mockBook});

        // Вызываем метод
        List<Book> books = libraryService.getBooks();

        // Проверяем, что вернулся список с одним элементом
        assertEquals(1, books.size());
    }
}
