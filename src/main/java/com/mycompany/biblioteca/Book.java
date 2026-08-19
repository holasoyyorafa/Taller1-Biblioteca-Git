package com.mycompany.biblioteca;

public class Book extends Material {
    private String editorial; // Atributo propio del libro

    public Book() {
        super();
    }

    public Book(String code, String title, String author, int year, String editorial) {
        // super() llama al constructor de la clase padre (Material)
        super(code, title, author, year);
        this.editorial = editorial;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}