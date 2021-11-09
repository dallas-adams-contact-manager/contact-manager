import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsApp {


    // method that prompts the user
    public static void initialUserPrompt() {

        System.out.println("1. View contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete a contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option(1, 2, 3, 4, or 5)");

    }


    // method to add a contact
    public static void addContacts() throws IOException {
        Scanner scanner = new Scanner(System.in);

        String directory = "./src/data";
        String filename = "contacts.txt";
        Path contactsTxtPath = Paths.get(directory, filename);
        ArrayList<Contacts> contactsList = new ArrayList<>();

        System.out.println("What is your name?");
        String userName = scanner.nextLine();

        System.out.println("What is your number?");
        String userNumber = scanner.nextLine();
        Contacts userContact = new Contacts(userName, userNumber);
        userContact.addName(userName);
        userContact.addNumber(userNumber);
        contactsList.add(userContact);

        for (Contacts userInfo : contactsList) {
            List<String> newContactList = Arrays.asList(userInfo.getName(), userInfo.getNumber());
            Files.write(contactsTxtPath, newContactList, StandardOpenOption.APPEND);
        }

        List<String> printList = Files.readAllLines(contactsTxtPath);
        System.out.println("printList = " + printList);

    }

    // method to get all contacts
    public static void getAllContacts() throws IOException {
        String directory = "./src/data";
        String filename = "contacts.txt";
        Path contactsTxtPath = Paths.get(directory, filename);
        List<String> printList = Files.readAllLines(contactsTxtPath);

        for(int i = 0; i < printList.size(); i++) {
            System.out.println((i + 1) + ": " + printList.get(i));
        }

    }

    public static void findContactByName() throws IOException {
        String directory = "./src/data";
        String filename = "contacts.txt";
        Path contactsTxtPath = Paths.get(directory, filename);
        List<String> printList = Files.readAllLines(contactsTxtPath);
//        List<String> nameList = Files.readAllLines(contactsTxtPath.getName());

        for(int i = 0; i < printList.size(); i++) {
            System.out.println(printList);
        }
    }

    // method to delete a contact
    public static void deleteAContact() {

        System.out.println("Delete contact...");
    }

    public static void main(String[] args) throws IOException {

        // initializing a scanner in the main method
        Scanner sc = new Scanner(System.in);

        // boolean used to determine if the user wants to continue
        boolean confirm;

        do{
            initialUserPrompt();
            String res = sc.nextLine();
            if(res.equalsIgnoreCase("1")) {
                getAllContacts();
            } else if(res.equalsIgnoreCase("2")) {
                addContacts();
            } else if(res.equalsIgnoreCase("3")) {
                findContactByName();
            } else if(res.equalsIgnoreCase("4")) {
                deleteAContact();
            } else if(res.equalsIgnoreCase("5")) {
                System.out.println("Exiting now, thanks for updating your contacts!");
                break;
            }

            // asking the user if they want to continue
            System.out.println("Want to continue?[y/n]");
            String res2 = sc.nextLine();
            confirm = res2.equalsIgnoreCase("y");

        } while(confirm);




    }
}