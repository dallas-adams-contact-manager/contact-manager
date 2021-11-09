import java.util.HashMap;

public class Contacts {

    public HashMap<String, String> contact;

    public Contacts() {
        this.contact = new HashMap<>();
    }

    public HashMap<String, String> getContacts() {
        return this.contact;
    }

    public void addContacts(String name, String number) {
        this.contact.put(name, number);
    }

}
