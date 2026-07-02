import java.util.*;

class Contact implements Comparable<Contact> {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int compareTo(Contact other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

class AddressBook {
    ArrayList<Contact> contacts = new ArrayList<>();
    HashMap<String, Contact> nameMap = new HashMap<>();
    HashSet<String> phoneSet = new HashSet<>();

    void addContact(Contact contact) {
        if (phoneSet.contains(contact.phone)) {
            System.out.println("Duplicate phone number not allowed.");
            return;
        }

        contacts.add(contact);
        nameMap.put(contact.name.toLowerCase(), contact);
        phoneSet.add(contact.phone);

        System.out.println("Contact added successfully.");
    }

    void searchContact(String name) {
        Contact contact = nameMap.get(name.toLowerCase());

        if (contact != null) {
            System.out.println("Contact found:");
            System.out.println(contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    void deleteContact(String name) {
        Contact contact = nameMap.get(name.toLowerCase());

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        contacts.remove(contact);
        nameMap.remove(name.toLowerCase());
        phoneSet.remove(contact.phone);

        System.out.println("Contact deleted successfully.");
    }

    void displaySortedByName() {
        Collections.sort(contacts);

        System.out.println("\nContacts sorted by name:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AddressBook book = new AddressBook();

        book.addContact(new Contact("Lavanya", "9876543210", "lavanya@gmail.com"));
        book.addContact(new Contact("Aman", "9999999999", "aman@gmail.com"));
        book.addContact(new Contact("Riya", "8888888888", "riya@gmail.com"));

        book.addContact(new Contact("Fake", "9876543210", "fake@gmail.com"));

        book.searchContact("Aman");

        book.deleteContact("Riya");

        book.displaySortedByName();
    }
}
