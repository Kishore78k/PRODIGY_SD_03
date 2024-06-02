import java.util.Scanner;

public class ContactManagementSystem {
    private static ContactManager contactManager = new ContactManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contactManager.addContact(contact);
        System.out.println("Contact added successfully.");
    }

    private static void viewContacts() {
        System.out.println("\nContact List:");
        for (int i = 0; i < contactManager.getContacts().size(); i++) {
            System.out.println((i + 1) + ". " + contactManager.getContact(i));
        }
    }

    private static void editContact() {
        System.out.print("Enter contact number to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline

        Contact contact = contactManager.getContact(index);
        if (contact != null) {
            System.out.print("Enter new name (leave blank to keep current): ");
            String name = scanner.nextLine();
            System.out.print("Enter new phone number (leave blank to keep current): ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter new email (leave blank to keep current): ");
            String email = scanner.nextLine();

            if (!name.isEmpty()) contact.setName(name);
            if (!phoneNumber.isEmpty()) contact.setPhoneNumber(phoneNumber);
            if (!email.isEmpty()) contact.setEmail(email);

            contactManager.updateContact(index, contact);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    private static void deleteContact() {
        System.out.print("Enter contact number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline

        Contact contact = contactManager.getContact(index);
        if (contact != null) {
            contactManager.deleteContact(index);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Invalid contact number.");
        }
    }
}
