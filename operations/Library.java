package operations;

import books.books;

public class Library {

    public void issueBook(books book) {
        if (book.available) {
            book.available = false;
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is already issued.");
        }
    }

    public void returnBook(books book) {
        if (!book.available) {
            book.available = true;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not issued.");
        }
    }
}