package com.example.plugins.issuedatamanager;

import com.example.plugins.ao.Book;
import com.example.plugins.ao.Copy;
import com.example.plugins.ao.Member;
import com.example.plugins.ao.BorrowingTransaction;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Copy> copies = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<BorrowingTransaction> transactions = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addCopy(Copy copy) {
        copies.add(copy);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public Book findBookByISBN(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public Copy findAvailableCopy(Book book) {
        return copies.stream()
                .filter(copy -> copy.getBook().equals(book) && copy.isAvailable())
                .findFirst()
                .orElse(null);
    }
}
