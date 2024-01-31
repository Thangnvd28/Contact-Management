
package controller;


import java.util.Scanner;
import model.Contact;
import model.ContactList;
import util.FormatString;
import util.InputUtils;

public class Controller {
    

    private static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        ContactList ctl = new ContactList();
        int choice;
        while (true) {
            choice = Menu.chooseInputOption();
            switch (choice) {
                case 1 -> {
                    addContact(ctl);
                }
                case 2 -> {
                    displayAll(ctl);
                }
                case 3 -> {
                    deleteContact(ctl);
                }

                case 4 ->
                    System.exit(0);
            }
        }
    }

    public static void addContact(ContactList ctl) {
        System.out.println("------- Add a Contact -------");
        System.out.println("Enter Name: ");
        String name = InputUtils.inputName();
        name = FormatString.formatName(name);
        String fullName[] = name.split(" ");
        String firstName = fullName[0];
        String lastName = fullName[fullName.length - 1];
        int listSize = ctl.getListSize();
        int id;
        if (listSize ==0){
            id = 1;
        }else{
            Contact lastct = ctl.getContactList().get(listSize-1);
            id = lastct.getId() + 1;
        }
        System.out.println("Enter group: ");
        String group = sc.nextLine();
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        address = FormatString.formatName(address);
        System.out.println("Enter phone number: ");
        String phone = InputUtils.inputPhone();
        Contact ct = new Contact(id, name, firstName, lastName, group, address, phone);
        if (ctl.addContact(ct)) {
            System.out.println("Added successfully!");
        } else {
            System.out.println("Failed to add. Phone is already exist!");
        }

    }

    public static void deleteContact(ContactList ctl) {
        System.out.println("------- Delete a Contact -------");
        System.out.println("Enter id to remove.");
        int idToRemove = InputUtils.inputId();
        if (ctl.remove(idToRemove)) {
            System.out.println("Remove successfully.");
        } else {
            System.out.println("Failed to remove. ID is not exist!");
        }
    }

    public static void displayAll(ContactList ctl){
        ctl.displayList();
    }
}
