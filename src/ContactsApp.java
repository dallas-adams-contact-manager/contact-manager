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





    public static void addContacts() throws IOException {
        Scanner scanner = new Scanner(System.in);

        String directory = "./src/data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
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

    public static void main(String[] args) throws IOException {
        addContacts();





//


    }
}