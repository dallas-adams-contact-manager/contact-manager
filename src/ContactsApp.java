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
//            case 3 -> searchContact();
//            case 4 -> deleteContact();
            case 5 -> closeMenu();
            default -> openMenu();
        }

    }

    public static void viewContacts() throws IOException {
        printContacts();

        openMenu();
    }

    public static void addContacts() throws IOException {
        Scanner scanner = new Scanner(System.in);

        String directory = "./src/data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
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



//        InputStreamReader reader = new InputStreamReader(
//                new FileInputStream(filename), StandardCharsets.UTF_16);
//        BufferedReader bufferedReader = new BufferedReader(reader);
//
//        OutputStreamWriter writer = new OutputStreamWriter(
//                new FileOutputStream(filename), StandardCharsets.UTF_8);
//        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        List<String> printList = Files.readAllLines(contactsTxtPath);
//        System.out.println("printList = " + printList);
        System.out.format("Name | Phone number |\n");
        System.out.println("--------------------");
        for (String contacts : printList) {
            System.out.printf("%s\n", contacts);
        }
    }

    public static void main(String[] args) throws IOException {
//        String directory = "./src/data";
//        String filename = "contacts.txt";
//        Path dataDirectory = Paths.get(directory);
//        Path dataFile = Paths.get(directory, filename);
//        Path contactsTxtPath = Paths.get(directory, filename);
//        PrintWriter writer = new PrintWriter(filename);
//        writer.print("");
//        writer.close();
//        new FileWriter(filename, false).close();
        System.out.println("Welcome to Contact Manager CLI");
        System.out.println();
        openMenu();


    }
}