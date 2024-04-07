
package prog2.spring2024.exercise2;

import java.time.LocalDate;
import java.util.Scanner;

import prog2.spring2024.exercise2.BookStore.BookDetails;

public class Main {
    public static void printBookList() {
        System.out.println("Book List:");
        System.out.println("------------");

        for (BookDetails book : BookDetails.values()) {
            System.out.println("BookID: " + book.getBookID());
            System.out.println("BookName: " + book.getBookName());
            System.out.println("BookAuthor: " + book.getBookAuthor());
            System.out.println("BookPages: " + book.getBookPages());
            System.out.println("BookGenre: " + book.getBookGenre());
            System.out.println("BookRating: " + book.getBookRating());
            System.out.println("BookPublished Year: " + book.getBookPublishedYear());
            System.out.println("BookPublisher: " + book.getBookPublisher());
            System.out.println("BookPrice: " + book.getBookPrice());
            System.out.println("-");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your email address: ");
        String emailAddress = scanner.nextLine();

        BookStore bookStore = new BookStore(firstName, lastName, emailAddress);
        bookStore.setUserID();

        Main.printBookList();
        BookDetails book = null;
        while (book == null) {
            System.out.print("Enter the ID of the book you want: ");
            String bookID = scanner.nextLine();

            book = bookStore.searchBook(bookID);

        }
        
        System.out.println(book.getBookName());
        int choice = 0;

        while (choice < 1 || choice > 3) {
            System.out.println("Please select the service you need:");
            System.out.println("1.Rent a book");
            System.out.println("2.Purchase the book");
            System.out.println("3.Exit");
            choice = scanner.nextInt();
        }
        scanner.close();

        if (choice == 3) {
            return;
        } else {
            bookStore.orderBook(choice);
            bookStore.setOrderDate(LocalDate.now()); 
            bookStore.generateOrderID();
            bookStore.orderConfirmation();
        }

    }
}
