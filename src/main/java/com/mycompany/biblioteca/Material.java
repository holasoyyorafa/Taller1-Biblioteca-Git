package com.mycompany.biblioteca;

public class Material {
    private String code;
    private String title;
    private String author;
    private int year;

    // Constructor vacío
    public Material() {
    }

    // Constructor con parámetros
    public Material(String code, String title, String author, int year) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Aquí debes agregar los Getters y Setters para code, title, author y year
    // (Tip: Puedes generarlos rapidísimo en NetBeans haciendo clic derecho -> Insert Code -> Getter and Setter)
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}
