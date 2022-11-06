package PhoneBook;

import java.io.*;
import java.util.*;

public class ContactList {
    List<Contact> contacts;

    // Constructor of contact list
    public ContactList() {
        this.contacts = new ArrayList<>();
    }

    // add new contact to the phonebook
    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    // remove contact from phone book
    public void removeContact(String contact) {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i).name);
            if (contacts.get(i).name.contains(contact)) {
                contacts.remove(i);
                System.out.println("Name removed");
            } else System.out.println("Name not exist");
        }

    }

    // print the contacts from phonebook
    public void printContacts() {
        if (this.contacts.size() != 0) {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println("Contact: " + contacts.get(i).name + " Phone: " + contacts.get(i).phone);
            }
        } else System.out.println("Phonebook is empty.");
    }

    // search contact by given name
    public void searchByName(String name) {
        int count = 0;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).name.contains(name)) {
                count++;
                System.out.println("Contact: " + contacts.get(i).name + " Phone: " + contacts.get(i).phone);
            }
        }
        if (count == 0)
            System.out.println("Name not exist");

    }

    // sort the contacts names in the phonebook by ascending order
    public void sortNameByAscendingOrder() {
        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.name.toLowerCase().compareTo(o2.name.toLowerCase());
            }
        });
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.name + " Phone: " + contact.phone);
        }
    }

    // sort the contacts phones in the phonebook by ascending order
    public void sortPhoneByAscendingOrder() {
        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.phone.compareTo(o2.phone);
            }

        });
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.name + " Phone: " + contact.phone);
        }
    }

    // print reserved phonebook
    public void printReversed() {
        System.out.println("Phone book: ");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("Name: " + contacts.get(i).name + " Phone: " + contacts.get(i).phone);
        }
        System.out.println("Reversed phone book: \n");
        for (int i = contacts.size() - 1; i >= 0; i--) {
            System.out.println("Name: " + contacts.get(i).name + " Phone: " + contacts.get(i).phone);
        }
    }

//remove duplicates from the phonebook
    public void removeDuplicates() {
        Set<Contact> noDuplicate = new HashSet<>();
        System.out.println();
        System.out.println("Duplicates contacts: ");
        for (Contact contact : contacts) {
            if (!noDuplicate.contains(contact)) {
                noDuplicate.add(contact);
            } else
                System.out.println("Contact: " + contact.name + "Phone: " + contact.phone);
        }
        contacts.clear();
        contacts.addAll(noDuplicate);
        System.out.println("Phone book after removing duplicates: ");
        for (Contact contact : contacts) {
            System.out.println("Contact: " + contact.name + "Phone: " + contact.phone);
        }
    }

    // save phone book to file
    public void saveToFile(String fileName)  {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {

            for (Contact contact : contacts) {
                try {
                    FileWriter writer = new FileWriter(fileName + ".txt", true);
                    writer.write(contact.getName());
                    writer.write("\r\n");
                    writer.write(contact.getPhone());
                    writer.write("\r\n");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //extract phonebook from file
    public void readFromFile(String fileName) {
        contacts = new ArrayList<>();
        File file = new File(fileName + ".txt");
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String name;
            String phone;
            while ((name = bufferedReader.readLine()) != null && (phone = bufferedReader.readLine()) != null) {
                contacts.add(new Contact(name, phone));
            }
            System.out.println("The phone book that is currently being use now is: " + fileName);
        } catch (Exception e) {
            System.out.println("the phone book is not found!!!");
        }
    }


}






//        try {
//            FileOutputStream file = new FileOutputStream(new File("src/PhoneBook/phonebook.txt"));
//            ObjectOutputStream oos = new ObjectOutputStream(file);
//
//
//            // Write objects to file
//            oos.writeObject(contacts);
//
//            oos.close();
//            file.close();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        } catch (IOException e) {
//            System.out.println("Error initializing stream");
//            e.printStackTrace();
//        }














