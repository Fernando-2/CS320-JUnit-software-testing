/*
 * CS 320 Project One - Contact
 * Author: Fernando Rivas
 * Represents an individual contact. Field validation keeps each
 * contact consistent with the customer requirements.
 */
public class Contact {
    // The identifier cannot be modified after the contact is created.
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName,
                   String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must have at most 10 characters and not be null");
        }
        this.contactId = contactId;
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must have at most 10 characters and not be null");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must have at most 10 characters and not be null");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        // The rubric calls for exactly ten digits, with no formatting symbols.
        if (phone == null || !phone.matches("[0-9]{10}")) {
            throw new IllegalArgumentException("Phone number must contain exactly 10 digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must have at most 30 characters and not be null");
        }
        this.address = address;
    }
}
