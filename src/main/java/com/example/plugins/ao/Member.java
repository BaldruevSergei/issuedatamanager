package com.example.plugins.ao;
public class Member {
    private String memberId;
    private String name;
    private String contactInfo;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void borrowBook(Book book) {
        // Логика заимствования
    }

    public void returnBook(Book book) {
        // Логика возврата
    }
}
