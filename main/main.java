package main;

import books.books;
import users.Student;
import operations.Library;

public class main {

    public static void main(String[] args) {

        books book1 = new books(101, "Java Programming", "James Gosling");

        Student student1 = new Student(1, "John");

        Library library = new Library();

        System.out.println("Book Details:");
        book1.displayBook();

        System.out.println("\nStudent Details:");
        student1.displayStudent();

        System.out.println("\nIssuing Book...");
        library.issueBook(book1);

        System.out.println("\nBook Status After Issue:");
        book1.displayBook();

        System.out.println("\nReturning Book...");
        library.returnBook(book1);

        System.out.println("\nBook Status After Return:");
        book1.displayBook();
    }
}