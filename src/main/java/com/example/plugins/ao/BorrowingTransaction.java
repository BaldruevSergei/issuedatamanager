package com.example.plugins.ao;

import java.util.Date;

public class BorrowingTransaction {
    private String transactionId; // Уникальный идентификатор транзакции
    private Date borrowDate;      // Дата заимствования
    private Date dueDate;         // Дата возврата
    private boolean returned;     // Статус возврата
    private Member member;        // Член, который взял книгу
    private Copy copy;            // Конкретный экземпляр книги

    // Геттеры и сеттеры
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    // Отметить возврат книги
    public void markAsReturned() {
        this.returned = true;
    }

    // Проверить, просрочена ли транзакция
    public boolean isOverdue() {
        return !returned && new Date().after(dueDate);
    }
}
