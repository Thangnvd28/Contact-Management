
package model;

import java.util.ArrayList;
import java.util.List;

public class ContactList {

    private List<Contact> contactList = new ArrayList<>();

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public ContactList() {
    }

    public boolean addContact(Contact ct) {
        for (Contact contact : contactList) {
            if (contact.getPhone().equalsIgnoreCase(ct.getPhone())) {
                return false;
            }
        }
        contactList.add(ct);
        return true;
    }

    public boolean remove(int id) {
        for (Contact contact : contactList) {
            if (contact.getId() == id) {
                contactList.remove(contact);
                return true;
            }
        }
        return false;

    }

    public int getListSize() {
        return contactList.size();
    }

    public String displayList() {
        System.out.printf("%-7s | %-25s | %-10s | %-10s | %-10s | %-20s | %-20s\n\n", "ID", "Name", "First Name", "Last Name", "Group", "Adress", "Phone");
        for (Contact ct : contactList) {
            ct.toString();
        }
        return "";
    }

}
