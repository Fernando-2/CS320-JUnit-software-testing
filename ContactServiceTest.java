/*
 * CS 320 Project One - Contact Service Tests
 * Author: Fernando Rivas
 * Verifies add, find, update, delete, and unique-ID handling.
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private Contact contact(String id) {
        return new Contact(id, "Maria", "Rivera", "2155550123", "123 Main Street");
    }

    @Test
    void testAddAndFindContact() {
        ContactService service = new ContactService();
        Contact added = contact("C1");
        service.addContact(added);
        assertSame(added, service.getContact("C1"));
    }

    @Test
    void testAddMultipleContacts() {
        ContactService service = new ContactService();
        service.addContact(contact("C1"));
        service.addContact(contact("C2"));
        assertEquals("C1", service.getContact("C1").getContactId());
        assertEquals("C2", service.getContact("C2").getContactId());
    }

    @Test
    void testDuplicateIdsCannotBeAdded() {
        ContactService service = new ContactService();
        service.addContact(contact("C1"));
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact("C1")));
        assertEquals("Maria", service.getContact("C1").getFirstName());
    }

    @Test
    void testNullContactCannotBeAdded() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    void testMissingContactCannotBeFound() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.getContact("missing"));
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        service.addContact(contact("C1"));
        service.addContact(contact("C2"));
        service.deleteContact("C1");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("C1"));
        assertNotNull(service.getContact("C2"));
    }

    @Test
    void testDeletingMissingContactThrowsException() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("missing"));
    }

    @Test
    void testUpdateAllFieldsWithoutChangingId() {
        ContactService service = new ContactService();
        service.addContact(contact("C1"));
        service.updateContact("C1", "Ana", "Lopez", "2675559876", "456 Market St");
        Contact result = service.getContact("C1");
        assertEquals("C1", result.getContactId());
        assertEquals("Ana", result.getFirstName());
        assertEquals("Lopez", result.getLastName());
        assertEquals("2675559876", result.getPhone());
        assertEquals("456 Market St", result.getAddress());
    }

    @Test
    void testUpdatingMissingContactThrowsException() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class,
                () -> service.updateContact("missing", "Ana", "Lopez", "2675559876", "Street"));
    }

    @Test
    void testInvalidUpdateDoesNotPartiallyChangeContact() {
        ContactService service = new ContactService();
        service.addContact(contact("C1"));
        assertThrows(IllegalArgumentException.class,
                () -> service.updateContact("C1", "Ana", "Lopez", "bad phone", "Street"));
        Contact result = service.getContact("C1");
        assertEquals("Maria", result.getFirstName());
        assertEquals("Rivera", result.getLastName());
        assertEquals("2155550123", result.getPhone());
        assertEquals("123 Main Street", result.getAddress());
    }

    @Test
    void testDeletedIdCanBeReused() {
        ContactService service = new ContactService();
        service.addContact(contact("C1"));
        service.deleteContact("C1");
        service.addContact(new Contact("C1", "New", "User", "2155550000", "Street"));
        assertEquals("New", service.getContact("C1").getFirstName());
    }
}
