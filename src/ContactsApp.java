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

        // checking to make sure our seeds are inside the contact object
        System.out.println(contact.getContacts());

        // asking the user if they want to add a new contact
        System.out.println("Do you want to add a new contact[s]?[y/n]");
        String res2 = scanner.nextLine();

        // if the user responds yes or "y" we will run the main body of the code
        if(res2.equalsIgnoreCase("y")) {

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


            } while(confirm);

            // if the user doesn't want to add a new contact
        } else {
            System.out.println("Maybe next time...");
        }

        // showing the user their new contacts list
        System.out.println("Your contacts list: " + contact.getContacts());


    }


}
