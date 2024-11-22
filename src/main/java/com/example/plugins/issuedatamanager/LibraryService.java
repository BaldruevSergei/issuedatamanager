package com.example.plugins.issuedatamanager;
import com.example.plugins.ao.Book;
import com.example.plugins.ao.Copy;
import com.example.plugins.ao.Member;
import com.example.plugins.ao.BorrowingTransaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibraryService {
    private List<BorrowingTransaction> transactions = new ArrayList<>();

    public BorrowingTransaction borrowBook(Member member, Copy copy) {
        if (!copy.isAvailable()) {
            System.out.println("Книга уже занята!");
            return null;
        }

        BorrowingTransaction transaction = new BorrowingTransaction();
        transaction.setTransactionId(generateTransactionId());
        transaction.setMember(member);
        transaction.setCopy(copy);
        transaction.setBorrowDate(new Date());
        transaction.setDueDate(calculateDueDate(14)); // Срок возврата — 14 дней
        transaction.setReturned(false);

        transactions.add(transaction);
        copy.setAvailable(false); // Сделать экземпляр недоступным

        return transaction;
    }

    public void returnBook(BorrowingTransaction transaction) {
        transaction.markAsReturned();
        transaction.getCopy().setAvailable(true);
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
        List<BorrowingTransaction> overdueTransactions = new ArrayList<>();
        for (BorrowingTransaction transaction : transactions) {
            if (!transaction.isReturned() && transaction.getDueDate().before(now)) {
                overdueTransactions.add(transaction);
            }
        }
        return overdueTransactions;
    }
}
