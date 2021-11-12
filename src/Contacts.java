public class Contacts {

    protected String name;
    protected String number;

    // constructor

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

     // getter
    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

     //setter

    public void addName(String name) {
        this.name = name;
    }

    public void addNumber(String number) {
        this.number = number;
    }

}
