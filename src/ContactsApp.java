import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsApp {

    public static void openMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("""
            1. View Contacts
            2. Add a new contact
            3. Search a contact by name
            4. Delete an existing contact
            5. Exit
            """);
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1 -> viewContacts();
            case 2 -> addContacts();
            case 3 -> searchContact();
//            case 4 -> deleteContact();
            case 5 -> closeMenu();
            default -> openMenu();
        }


    }

    public static void viewContacts() throws IOException {
        printContacts();


        openMenu();
    }

    // method to add a contact
    public static void addContacts() throws IOException {
        Scanner scanner = new Scanner(System.in);

        String directory = "./src/data";
        String filename = "contacts.txt";
        Path contactsTxtPath = Paths.get(directory, filename);


        System.out.println("What is your name?");
        String userName = scanner.nextLine();

        System.out.println("What is your number?");
        String userNumber = scanner.nextLine();
        String userContact = userName + " | " + userNumber;

        List<String> newContactList = List.of(userContact);
        Files.write(contactsTxtPath, newContactList, StandardOpenOption.APPEND);

        openMenu();

    }


    public static void searchContact() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name to search for:");
        String inputtedName = scanner.nextLine();

        String directory = "./src/data";
        String filename = "contacts.txt";
        Path contactsTxtPath = Paths.get(directory, filename);
        List<String> printList = Files.readAllLines(contactsTxtPath);

        for (String s : printList) {
            //System.out.println(s);
            if(s.toLowerCase(Locale.ROOT).contains(inputtedName.toLowerCase(Locale.ROOT))) {
                System.out.println(s);
            }
        }

        openMenu();
    }

    // method to delete a contact
    public static void deleteContact() {

        System.out.println("Delete contact...");
    }


    public static void closeMenu() throws IOException {

        System.out.println("Thanks for using Contact Manager, here is a list of your contacts:");
        System.out.println();
        printContacts();

    }

    private static void printContacts() throws IOException {
        String directory = "./src/data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        Path contactsTxtPath = Paths.get(directory, filename);

        List<String> printList = Files.readAllLines(contactsTxtPath);


        System.out.format("Name | Phone number |\n");
        System.out.println("--------------------");
        for (String contacts : printList) {
            System.out.printf("%s\n", contacts);
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Contact Manager CLI");
        System.out.println();
        openMenu();


    }
}