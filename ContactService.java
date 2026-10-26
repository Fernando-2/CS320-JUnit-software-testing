/*
 * CS 320 Project One - Contact Service
 * Author: Fernando Rivas
 * Stores contacts in memory. No database or user interface is needed.
 */
import java.util.ArrayList;

public class ContactService {
    private final ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        for (Contact existing : contacts) {
            if (existing.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID already exists");
            }
        }
        contacts.add(contact);
    }

    public Contact getContact(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        throw new IllegalArgumentException("Contact ID not found");
    }

    public void deleteContact(String contactId) {
        Contact contact = getContact(contactId);
        contacts.remove(contact);
    }

    public void updateContact(String contactId, String firstName, String lastName,
                              String phone, String address) {
        Contact contact = getContact(contactId);
        // Validate all new fields before changing the existing contact.
        Contact validated = new Contact(contactId, firstName, lastName, phone, address);
        contact.setFirstName(validated.getFirstName());
        contact.setLastName(validated.getLastName());
        contact.setPhone(validated.getPhone());
        contact.setAddress(validated.getAddress());
    }
}
