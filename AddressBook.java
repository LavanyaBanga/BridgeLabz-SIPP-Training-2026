import java.util.*;

class Contact {
    String name, phone, email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class AddressBookApp {
    ArrayList<Contact> contacts = new ArrayList<>();
    HashMap<String, Contact> nameMap = new HashMap<>();
    HashSet<String> phoneSet = new HashSet<>();

    void addContact(String name, String phone, String email) {
        if (phoneSet.contains(phone)) {
            System.out.println("Duplicate phone number not allowed!");
            return;
        }

        Contact c = new Contact(name, phone, email);
        contacts.add(c);
        nameMap.put(name, c);
        phoneSet.add(phone);

        System.out.println("Contact added successfully.");
    }

    void searchContact(String name) {
        Contact c = nameMap.get(name);
        if (c != null)
            System.out.println(c);
        else
            System.out.println("Contact not found.");
    }

    void deleteContact(String name) {
        Contact c = nameMap.remove(name);

        if (c != null) {
            contacts.remove(c);
            phoneSet.remove(c.phone);
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    void displaySorted() {
        Collections.sort(contacts, Comparator.comparing(c -> c.name));

        System.out.println("\nContacts Sorted by Name:");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        AddressBookApp app = new AddressBookApp();

        app.addContact("Lavanya", "9876543210", "lavanya@gmail.com");
        app.addContact("Aman", "9999999999", "aman@gmail.com");
        app.addContact("Riya", "8888888888", "riya@gmail.com");
        app.addContact("Duplicate", "9876543210", "dup@gmail.com");

        app.searchContact("Aman");
        app.deleteContact("Riya");
        app.displaySorted();
    }
}
