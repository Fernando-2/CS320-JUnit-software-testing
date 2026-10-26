/*
 * CS 320 Project One - Contact Tests
 * Author: Fernando Rivas
 * Tests normal inputs, nulls, character limits, and invalid phone numbers.
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
    private Contact validContact() {
        return new Contact("C1", "Maria", "Rivera", "2155550123", "123 Main Street");
    }

    @Test
    void testCreateValidContactAndGetters() {
        Contact contact = validContact();
        assertEquals("C1", contact.getContactId());
        assertEquals("Maria", contact.getFirstName());
        assertEquals("Rivera", contact.getLastName());
        assertEquals("2155550123", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void testAllMaximumLengthsAreAccepted() {
        Contact contact = new Contact("1234567890", "ABCDEFGHIJ", "KLMNOPQRST",
                "0123456789", "123456789012345678901234567890");
        assertEquals(10, contact.getContactId().length());
        assertEquals(10, contact.getFirstName().length());
        assertEquals(10, contact.getLastName().length());
        assertEquals(30, contact.getAddress().length());
    }

    @Test
    void testNullContactIdRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "Maria", "Rivera", "2155550123", "Street"));
    }

    @Test
    void testContactIdOverTenCharactersRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "Maria", "Rivera", "2155550123", "Street"));
    }

    @Test
    void testNullFirstNameRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", null, "Rivera", "2155550123", "Street"));
    }

    @Test
    void testFirstNameOverTenCharactersRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "ElevenChars", "Rivera", "2155550123", "Street"));
    }

    @Test
    void testNullLastNameRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Maria", null, "2155550123", "Street"));
    }

    @Test
    void testLastNameOverTenCharactersRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Maria", "LastNameTooLong", "2155550123", "Street"));
    }

    @Test
    void testNullPhoneRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Maria", "Rivera", null, "Street"));
    }

    @Test
    void testPhoneWithNineDigitsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Maria", "Rivera", "215555012", "Street"));
    }

    @Test
    void testPhoneWithElevenDigitsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Maria", "Rivera", "12155550123", "Street"));
    }

    @Test
    void testPhoneWithNonDigitsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Maria", "Rivera", "215-555123", "Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Maria", "Rivera", "215555A123", "Street"));
    }

    @Test
    void testNullAddressRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Maria", "Rivera", "2155550123", null));
    }

    @Test
    void testAddressOverThirtyCharactersRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Maria", "Rivera", "2155550123",
                        "1234567890123456789012345678901"));
    }

    @Test
    void testUpdateEachPermittedField() {
        Contact contact = validContact();
        contact.setFirstName("Ana");
        contact.setLastName("Lopez");
        contact.setPhone("2675559876");
        contact.setAddress("456 Market St");
        assertEquals("C1", contact.getContactId()); // ID remains unchanged.
        assertEquals("Ana", contact.getFirstName());
        assertEquals("Lopez", contact.getLastName());
        assertEquals("2675559876", contact.getPhone());
        assertEquals("456 Market St", contact.getAddress());
    }

    @Test
    void testInvalidFirstNameUpdatesRejected() {
        Contact contact = validContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("FirstNameTooLong"));
        assertEquals("Maria", contact.getFirstName());
    }

    @Test
    void testInvalidLastNameUpdatesRejected() {
        Contact contact = validContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("LastNameIsTooLong"));
        assertEquals("Rivera", contact.getLastName());
    }

    @Test
    void testInvalidPhoneUpdatesRejected() {
        Contact contact = validContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("215555012"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("21555501234"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("215555X123"));
        assertEquals("2155550123", contact.getPhone());
    }

    @Test
    void testInvalidAddressUpdatesRejected() {
        Contact contact = validContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setAddress("1234567890123456789012345678901"));
        assertEquals("123 Main Street", contact.getAddress());
    }
}
