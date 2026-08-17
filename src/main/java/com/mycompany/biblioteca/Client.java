package com.mycompany.biblioteca;

public class Client extends Person {
    private String membershipType; // Ejemplo de atributo propio de Client

    // Constructor vacío
    public Client() {
        super();
    }

    // Constructor con parámetros (incluyendo los de Person mediante super)
    public Client(String id, String name, String phone, String email, String membershipType) {
        super(id, name, phone, email);
        this.membershipType = membershipType;
    }

    // Getter y Setter para el nuevo atributo
    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}