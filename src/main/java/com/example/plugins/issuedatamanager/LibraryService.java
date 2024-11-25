package com.example.plugins.issuedatamanager;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.example.plugins.ao.Book;
import com.example.plugins.ao.Copy;
import com.example.plugins.ao.Member;
import com.example.plugins.ao.BorrowingTransaction;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryService {
    private final ActiveObjects ao;

    @Inject
    public LibraryService(ActiveObjects ao) {
        this.ao = ao; // Инжектируем ActiveObjects
    }

    public BorrowingTransaction borrowBook(Member member, Copy copy) {
        if (!copy.isAvailable()) {
            System.out.println("Книга уже занята!");
            return null;
        }

        BorrowingTransaction transaction = ao.create(BorrowingTransaction.class);
        transaction.setTransactionId(generateTransactionId());
        transaction.setMember(member);
        transaction.setCopy(copy);
        transaction.setBorrowDate(new Date());
        transaction.setDueDate(calculateDueDate(14)); // Срок возврата — 14 дней
        transaction.setReturned(false);
        transaction.save();

        copy.setAvailable(false); // Сделать экземпляр недоступным
        copy.save();

        return transaction;
    }

    public void returnBook(BorrowingTransaction transaction) {
        transaction.markAsReturned();
        transaction.getCopy().setAvailable(true);
        transaction.save();
    }

    public void addBook(String isbn, String title, String author, Date publicationDate, List<String> genres) {
        Book book = ao.create(Book.class); // Создание записи в Active Objects
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublicationDate(publicationDate);
        book.setGenres(genres.toArray(new String[0])); // Сохранение списка жанров
        book.save();

        System.out.println("Книга добавлена в базу данных: " + title);
    }

    public void addCopy(Book book, String copyId) {
        Copy copy = ao.create(Copy.class); // Создание экземпляра через Active Objects
        copy.setCopyId(copyId);
        copy.setBook(book);
        copy.setAvailable(true);
        copy.save();

        System.out.println("Экземпляр добавлен в базу данных: " + copyId + " для книги " + book.getTitle());
    }

    private String generateTransactionId() {
        return "TX-" + System.currentTimeMillis();
    }

    private Date calculateDueDate(int days) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.add(java.util.Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    public List<BorrowingTransaction> getOverdueTransactions() {
        Date now = new Date();
        BorrowingTransaction[] allTransactions = ao.find(BorrowingTransaction.class);
        return Arrays.stream(allTransactions)
                .filter(transaction -> !transaction.isReturned() && transaction.getDueDate().before(now))
                .collect(Collectors.toList());
    }

    public List<Book> getBooks() {
        return Arrays.asList(ao.find(Book.class)); // Получение всех записей книг из базы данных
    }
}
