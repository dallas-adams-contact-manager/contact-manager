import java.util.Scanner;

public class ContactsApp {


    public static void main(String[] args) {

        // initializing a new scanner
        Scanner scanner = new Scanner(System.in);

        // creating our contacts object to store data in
        Contacts contact = new Contacts();

        // seeding our contacts object
        contact.addContacts("nick", 1231231234L);
        contact.addContacts("jackie", 9169961799L);

        // asking the user if they want to add a new contact
        System.out.println("1. view contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. delete a contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option (1, 2, 3, 4, or 5)");
        String res2 = scanner.nextLine();


            // if the user response is 1 run this
            if (res2.equalsIgnoreCase("1")) {
                System.out.println("Contact list: " + contact.getContacts());
            }

            // if the user response is 2 run this
            if (res2.equalsIgnoreCase("2")) {

                // setting up a boolean so the user has the option to keep adding contacts
                boolean confirm;

                // while the confirm boolean is true, we will run this code
                do {

                    // asking the user for a name
                    System.out.println("enter a name");
                    String res = scanner.nextLine();

                    // aking the user for a phone number without the dashes
                    System.out.println("enter a phone number without dashes please");
                    Long response = scanner.nextLong();

                    // printing out the user input to the console
                    System.out.println("your entered name is: " + res + ", and their phone number is: " + response);
                    contact.addContacts(res, response);

                    // printing out the new contact object with the user inputted info
                    System.out.println(contact.getContacts());

                    // asking the user if they want to add another contact
                    System.out.println("would you like to input another contact?[y/n]");
                    scanner.nextLine();
                    String answer = scanner.nextLine();
                    confirm = answer.equalsIgnoreCase("y");

                    // if the user responds other than y the confirm condition becomes false and the do while loop ends
                } while (confirm);

                // if the user response is 3 run this
            } else if (res2.equalsIgnoreCase("3")) {
                System.out.println("Enter a name to be searched");
            } else if (res2.equalsIgnoreCase("4")) {
                System.out.println("Enter a name to be deleted");
            } else if (res2.equalsIgnoreCase("5")) {
                System.out.println("Tank you for using this app!");
            }

        // showing the user their new contacts list
        System.out.println("Your contacts list: " + contact.getContacts());

    }

}
