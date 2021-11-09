import java.util.HashMap;

public class Contacts {

    public HashMap<String, Integer> contact;

    public Contacts() {
        this.contact = new HashMap<>();
    }

    public HashMap<String, Integer> getContacts() {
        return this.contact;
    }

    public void addContact(String name, int number) {
        this.contact.put(name, number);
    }


}
