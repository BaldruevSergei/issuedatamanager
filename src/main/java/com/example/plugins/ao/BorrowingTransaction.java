package com.example.plugins.ao;

import net.java.ao.Entity;
import java.util.Date;

public interface BorrowingTransaction extends Entity {
    String getTransactionId();
    void setTransactionId(String transactionId);

    Member getMember();
    void setMember(Member member);

    Copy getCopy();
    void setCopy(Copy copy);

    Date getBorrowDate();
    void setBorrowDate(Date borrowDate);

    Date getDueDate();
    void setDueDate(Date dueDate);

    boolean isReturned();
    void setReturned(boolean returned);

    default void markAsReturned() {
        setReturned(true);
    }
}
