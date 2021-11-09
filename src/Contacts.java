import java.util.HashMap;

public class Contacts {




    // properties
    public HashMap<String, String> contact;


    // constructor
    public Contacts() {
        this.contact = new HashMap<>();
    }



    // getter
//    public HashMap<String, Integer> getContacts() {
//        return this.contact;
//    }

    // setter
    public void addContact(String name, String number) {
        this.contact.put(name, number);
    }

}
