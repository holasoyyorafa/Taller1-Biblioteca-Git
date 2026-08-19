package com.mycompany.biblioteca;

public class Loan {
    private Client client;
    private Book book;
    private String loanDate;
    private boolean isActive; // true = prestado, false = ya devuelto

    // Constructor vacío
    public Loan() {
    }

    // Constructor con parámetros
    public Loan(Client client, Book book, String loanDate) {
        this.client = client;
        this.book = book;
        this.loanDate = loanDate;
        this.isActive = true; // Cuando se crea un préstamo, por defecto está activo
    }

    // Getters y Setters
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}