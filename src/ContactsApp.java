import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactsApp {

    // starting menu
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
            case 4 -> deleteContact();
            case 5 -> closeMenu();
            default -> openMenu();
        }


    }

    // view contacts
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

        Contacts newUserContact = new Contacts(userName, userNumber);

        HashMap<String, String> newerUserContact = new HashMap<>();
        try{
            BufferedWriter bf = new BufferedWriter(new FileWriter(String.valueOf(contactsTxtPath)));
//        bf.close();
            newerUserContact.put(userName, userNumber);
            for (Map.Entry<String, String> entry : newerUserContact.entrySet()) {
                System.out.println("entry.getKey() = " + entry.getKey());
                System.out.println("entry.getValue() = " + entry.getValue());
                bf.write(entry.getKey() + " | " + entry.getValue());
                bf.newLine();

            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        Files.write(contactsTxtPath, (Iterable<? extends CharSequence>) newerUserContact, StandardOpenOption.APPEND);

//        List<String> newContactList = List.of(userContact);
//        Files.write(contactsTxtPath, newContactList, StandardOpenOption.APPEND);

        openMenu();

    }

    // method to search contacts by name
    public static void searchContact() throws IOException {

        // scanner set up
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name to search for:");
        String inputtedName = scanner.nextLine();

        // getting our filepath and setting up list that contains data
        String directory = "./src/data";
        String filename = "contacts.txt";
        Path contactsTxtPath = Paths.get(directory, filename);
        List<String> printList = Files.readAllLines(contactsTxtPath);

        // looping through our list to check data to the user input
        for (String s : printList) {
            // if our list contains user input, print user inputted name and number
            if(s.toLowerCase(Locale.ROOT).contains(inputtedName.toLowerCase(Locale.ROOT))) {
                System.out.println(s);
            }
        }

        // return to the open menu
        openMenu();
    }

    // method to delete a contact
    public static void deleteContact() throws IOException {

        // setting up a scasnner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name to delete:");
        String inputtedName = scanner.nextLine();

        // getting our file path
        String directory = "./src/data";
        String filename = "contacts.txt";
        Path contactsTxtPath = Paths.get(directory, filename);

        // getting a list of our stored data
        List<String> printList = Files.readAllLines(contactsTxtPath);

        // removing an item based on the user input
        printList.removeIf(s -> s.toLowerCase(Locale.ROOT).contains(inputtedName.toLowerCase(Locale.ROOT)));

        // rewriting our new list without the deleted user inputted data
        Files.write(contactsTxtPath, printList);
        System.out.println("Deleting contact " + inputtedName + " from records.");

        openMenu();

    }

    // end application
    public static void closeMenu() throws IOException {

        System.out.println("Thanks for using Contact Manager, here is a list of your contacts:");
        System.out.println();
        printContacts();

    }

    // print contacts
    private static void printContacts() throws IOException {
        String directory = "./src/data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        Path contactsTxtPath = Paths.get(directory, filename);

//        ArrayList<Contacts> printList = new ArrayList<>();


        List<String> printList = Files.readAllLines(contactsTxtPath);
        String nameAndNumber = "Name | Phone Number";


        System.out.printf("%32s\n", nameAndNumber);
        System.out.println("            ---------------------");
        for (String contacts : printList) {
            System.out.printf("%30s\n", contacts);
        }
//        for (String contact : printList) {
//            System.out.println(contact);
//        }
    }

    public static void HashMapFromTextFile() {
        String directory = "./src/data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        Path contactsTxtPath = Paths.get(directory, filename);

        Map<String, String> contactFile = new HashMap<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(String.valueOf(contactsTxtPath)));
            String line = null;
            while((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String name = parts[0].trim();
                String number = parts[1].trim();

                if (!name.equals("") && !number.equals("")) {
                    contactFile.put(name, number);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Contact Manager CLI");
        System.out.println();
        openMenu();

    }
}