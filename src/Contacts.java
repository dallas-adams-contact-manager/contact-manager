import java.util.HashMap;

public class Contacts {

    public HashMap<String, Long> contact;

    public Contacts() {
        this.contact = new HashMap<>();
    }

    public HashMap<String, Long> getContacts() {
        return this.contact;
    }

    public void addContacts(String name, Long number) {
        this.contact.put(name, number);
    }


}
