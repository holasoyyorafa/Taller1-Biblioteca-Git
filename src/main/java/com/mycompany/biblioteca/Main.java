

package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Declaramos el ArrayList estático para guardar los clientes en memoria
    private static ArrayList<Client> clientList = new ArrayList<>();
        // NUEVA: Lista para guardar los libros
    private static ArrayList<Book> bookList = new ArrayList<>();
        // NUEVA: Lista para guardar los préstamos
    private static ArrayList<Loan> loanList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

do {
            System.out.println("=====================================");
            System.out.println("      LIBRARY MANAGEMENT SYSTEM      ");
            System.out.println("=====================================");
            System.out.println("--- CLIENTS ---");
            System.out.println("1. Add Client");
            System.out.println("2. List Clients");
            System.out.println("3. Search Client");
            System.out.println("4. Update Client");
            System.out.println("5. Delete Client");
            System.out.println("--- BOOKS ---");
            System.out.println("6. Add Book");
            System.out.println("7. List Books");
            System.out.println("8. Search Book");
            System.out.println("9. Update Book");
            System.out.println("10. Delete Book");
            System.out.println("11. Register Loan");
            System.out.println("12. Register Return");
            System.out.println("13. List Active Loans");
            System.out.println("14. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (option) {
                // ... (Los case del 1 al 5 déjalos exactamente como los tienes) ...
                case 1: addClient(scanner); break;
                case 2: listClients(); break;
                case 3: searchClient(scanner); break;
                case 4: updateClient(scanner); break;
                case 5: deleteClient(scanner); break;
                
                // NUEVOS CASES PARA LIBROS
                case 6: addBook(scanner); break;
                case 7:listBooks(); break;
                case 8:searchBook(scanner); break;
                case 9:updateBook(scanner);break;
                case 10:deleteBook(scanner); break;
                case 11:registerLoan(scanner);break;
                case 12:registerReturn(scanner);break;
                case 13:listActiveLoans();break;
                case 14:System.out.println("Saliendo del sistema...");break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println();
            
        } while (option != 14); // OJO: Cambia el número de salida a 14
        
        scanner.close();
    }

    // Método para añadir un cliente al ArrayList
    public static void addClient(Scanner scanner) {
        System.out.println("\n--- ADD NEW CLIENT ---");
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter Membership Type: ");
        String membershipType = scanner.nextLine();

        // Creamos el objeto y lo guardamos en la lista
        Client newClient = new Client(id, name, phone, email, membershipType);
        clientList.add(newClient);
        
        System.out.println("¡Client added successfully!");
    }
    // Método para listar los clientes
    public static void listClients() {
        System.out.println("\n--- CLIENT LIST ---");
        
        if (clientList.isEmpty()) {
            System.out.println("No clients registered yet.");
        } else {
            // El ciclo for-each recorre cada cliente guardado en la lista
            for (Client client : clientList) {
                System.out.println("ID: " + client.getId() + 
                                   " | Name: " + client.getName() + 
                                   " | Phone: " + client.getPhone() + 
                                   " | Email: " + client.getEmail() +
                                   " | Membership: " + client.getMembershipType());
            }
        }
    }
    // Método para buscar un cliente por ID
    public static void searchClient(Scanner scanner) {
        System.out.println("\n--- SEARCH CLIENT ---");
        System.out.print("Enter the ID of the client to search: ");
        String searchId = scanner.nextLine();

        boolean found = false; // Variable para saber si lo encontramos

        for (Client client : clientList) {
            // Comparamos el ID que escribió el usuario con el ID del cliente
            if (client.getId().equals(searchId)) {
                System.out.println("¡Client Found!");
                System.out.println("Name: " + client.getName());
                System.out.println("Phone: " + client.getPhone());
                System.out.println("Email: " + client.getEmail());
                System.out.println("Membership: " + client.getMembershipType());
                
                found = true;
                break; // Rompemos el ciclo porque ya lo encontramos
            }
        }

        // Si terminó el ciclo y found sigue siendo false, el cliente no existe
        if (!found) {
            System.out.println("Error: Client with ID '" + searchId + "' not found.");
        }
    }
    // Método para actualizar los datos de un cliente
    public static void updateClient(Scanner scanner) {
        System.out.println("\n--- UPDATE CLIENT ---");
        System.out.print("Enter the ID of the client to update: ");
        String searchId = scanner.nextLine();

        boolean found = false;

        for (Client client : clientList) {
            if (client.getId().equals(searchId)) {
                System.out.println("¡Client Found! Please enter the new details:");
                
                System.out.print("Enter new Name: ");
                String newName = scanner.nextLine();
                client.setName(newName); // Actualizamos el nombre
                
                System.out.print("Enter new Phone: ");
                String newPhone = scanner.nextLine();
                client.setPhone(newPhone); // Actualizamos el teléfono
                
                System.out.print("Enter new Email: ");
                String newEmail = scanner.nextLine();
                client.setEmail(newEmail); // Actualizamos el correo
                
                System.out.print("Enter new Membership Type: ");
                String newMembership = scanner.nextLine();
                client.setMembershipType(newMembership); // Actualizamos la membresía

                System.out.println("¡Client updated successfully!");
                found = true;
                break; // Rompemos el ciclo porque ya actualizamos
            }
        }

        if (!found) {
            System.out.println("Error: Client with ID '" + searchId + "' not found.");
        }
    }
    // Método para eliminar un cliente
    public static void deleteClient(Scanner scanner) {
        System.out.println("\n--- DELETE CLIENT ---");
        System.out.print("Enter the ID of the client to delete: ");
        String searchId = scanner.nextLine();

        Client clientToRemove = null; // Variable para guardar el cliente que vamos a borrar

        // Buscamos el cliente en la lista
        for (Client client : clientList) {
            if (client.getId().equals(searchId)) {
                clientToRemove = client;
                break; // Lo encontramos, rompemos el ciclo
            }
        }

        // Verificamos si lo encontramos para poder eliminarlo
        if (clientToRemove != null) {
            clientList.remove(clientToRemove);
            System.out.println("¡Client deleted successfully!");
        } else {
            System.out.println("Error: Client with ID '" + searchId + "' not found.");
        }
    }
    // Método para añadir un libro al ArrayList
    public static void addBook(Scanner scanner) {
        System.out.println("\n--- ADD NEW BOOK ---");
        System.out.print("Enter Code: ");
        String code = scanner.nextLine();
        
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Importante limpiar el buffer después de un nextInt()
        
        System.out.print("Enter Editorial: ");
        String editorial = scanner.nextLine();

        // Creamos el objeto y lo guardamos en la lista
        Book newBook = new Book(code, title, author, year, editorial);
        bookList.add(newBook);
        
        System.out.println("¡Book added successfully!");
    }
    // Método para listar los libros
    public static void listBooks() {
        System.out.println("\n--- BOOK LIST ---");
        
        if (bookList.isEmpty()) {
            System.out.println("No books registered yet.");
        } else {
            for (Book book : bookList) {
                System.out.println("Code: " + book.getCode() + 
                                   " | Title: " + book.getTitle() + 
                                   " | Author: " + book.getAuthor() + 
                                   " | Year: " + book.getYear() +
                                   " | Editorial: " + book.getEditorial());
            }
        }
    }

    // Método para buscar un libro por código
    public static void searchBook(Scanner scanner) {
        System.out.println("\n--- SEARCH BOOK ---");
        System.out.print("Enter the Code of the book to search: ");
        String searchCode = scanner.nextLine();

        boolean found = false;

        for (Book book : bookList) {
            if (book.getCode().equals(searchCode)) {
                System.out.println("¡Book Found!");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Year: " + book.getYear());
                System.out.println("Editorial: " + book.getEditorial());
                
                found = true;
                break; 
            }
        }

        if (!found) {
            System.out.println("Error: Book with Code '" + searchCode + "' not found.");
        }
    }

    // Método para actualizar un libro
    public static void updateBook(Scanner scanner) {
        System.out.println("\n--- UPDATE BOOK ---");
        System.out.print("Enter the Code of the book to update: ");
        String searchCode = scanner.nextLine();

        boolean found = false;

        for (Book book : bookList) {
            if (book.getCode().equals(searchCode)) {
                System.out.println("¡Book Found! Please enter the new details:");
                
                System.out.print("Enter new Title: ");
                String newTitle = scanner.nextLine();
                book.setTitle(newTitle); 
                
                System.out.print("Enter new Author: ");
                String newAuthor = scanner.nextLine();
                book.setAuthor(newAuthor); 
                
                System.out.print("Enter new Year: ");
                int newYear = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer porque usamos nextInt()
                book.setYear(newYear); 
                
                System.out.print("Enter new Editorial: ");
                String newEditorial = scanner.nextLine();
                book.setEditorial(newEditorial); 

                System.out.println("¡Book updated successfully!");
                found = true;
                break; 
            }
        }

        if (!found) {
            System.out.println("Error: Book with Code '" + searchCode + "' not found.");
        }
    }

    // Método para eliminar un libro
    public static void deleteBook(Scanner scanner) {
        System.out.println("\n--- DELETE BOOK ---");
        System.out.print("Enter the Code of the book to delete: ");
        String searchCode = scanner.nextLine();

        Book bookToRemove = null; 

        for (Book book : bookList) {
            if (book.getCode().equals(searchCode)) {
                bookToRemove = book;
                break; 
            }
        }

        if (bookToRemove != null) {
            bookList.remove(bookToRemove);
            System.out.println("¡Book deleted successfully!");
        } else {
            System.out.println("Error: Book with Code '" + searchCode + "' not found.");
        }
    }
    // Método para registrar un préstamo
    public static void registerLoan(Scanner scanner) {
        System.out.println("\n--- REGISTER LOAN ---");
        
        // 1. Buscar el cliente
        System.out.print("Enter Client ID: ");
        String clientId = scanner.nextLine();
        Client selectedClient = null;
        for (Client c : clientList) {
            if (c.getId().equals(clientId)) {
                selectedClient = c;
                break;
            }
        }
        
        if (selectedClient == null) {
            System.out.println("Error: Client not found. Cannot proceed with loan.");
            return; // Salimos del método si no hay cliente
        }

        // 2. Buscar el libro
        System.out.print("Enter Book Code: ");
        String bookCode = scanner.nextLine();
        Book selectedBook = null;
        for (Book b : bookList) {
            if (b.getCode().equals(bookCode)) {
                selectedBook = b;
                break;
            }
        }
        
        if (selectedBook == null) {
            System.out.println("Error: Book not found. Cannot proceed with loan.");
            return; // Salimos del método si no hay libro
        }

        // 3. Registrar el préstamo si ambos existen
        System.out.print("Enter Loan Date (e.g. 16/08/2026): ");
        String date = scanner.nextLine();

        Loan newLoan = new Loan(selectedClient, selectedBook, date);
        loanList.add(newLoan);
        System.out.println("¡Loan registered successfully!");
    }

    // Método para registrar la devolución
    public static void registerReturn(Scanner scanner) {
        System.out.println("\n--- REGISTER RETURN ---");
        System.out.print("Enter the Book Code to return: ");
        String bookCode = scanner.nextLine();

        boolean found = false;
        for (Loan loan : loanList) {
            // Buscamos un préstamo activo que tenga ese código de libro
            if (loan.getBook().getCode().equals(bookCode) && loan.isActive()) {
                loan.setActive(false); // Lo marcamos como devuelto
                System.out.println("¡Book returned successfully!");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Error: No active loan found for that book code.");
        }
    }

    // Método para listar solo los préstamos activos
    public static void listActiveLoans() {
        System.out.println("\n--- ACTIVE LOANS ---");
        boolean hasActive = false;
        
        for (Loan loan : loanList) {
            if (loan.isActive()) { // Solo mostramos los que no han sido devueltos
                System.out.println("Client: " + loan.getClient().getName() + 
                                   " | Book: " + loan.getBook().getTitle() + 
                                   " | Date: " + loan.getLoanDate());
                hasActive = true;
            }
        }
        
        if (!hasActive) {
            System.out.println("No active loans at the moment.");
        }
    }
}