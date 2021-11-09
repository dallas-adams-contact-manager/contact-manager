import java.util.HashMap;

public class Contacts {

    // properties
    public HashMap<String, Integer> contact;

    // constructor
    public Contacts() {
        this.contact = new HashMap<>();
    }

    // getter
    public HashMap<String, Integer> getContacts() {
        return this.contact;
    }

    // setter
    public void addContact(String name, int number) {
        this.contact.put(name, number);
    }


}
