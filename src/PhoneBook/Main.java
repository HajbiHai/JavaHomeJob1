package PhoneBook;

import java.io.File;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static ContactList contactList = new ContactList();

    public static void main(String[] args) {
        Contact c1 = new Contact("hai" , "0502288522");
        Contact c2 = new Contact("hai" , "0502288522");
        Contact c3 = new Contact("Kohav" , "0505769926");
        Contact c4 = new Contact("home" , "08689821");
        Contact c5 = new Contact("Aba" , "0505280722");
        Contact c6 = new Contact("aaa" , "111");
        Contact c7 = new Contact("bb" , "22");
        Contact c8 = new Contact("aaa" , "111");
        Contact c9 = new Contact("Aba" , "0505280722");

        contactList.addContact(c1);
        contactList.addContact(c2);
        contactList.addContact(c3);
        contactList.addContact(c4);
        contactList.addContact(c5);
        contactList.addContact(c6);
        contactList.addContact(c7);
        contactList.addContact(c8);
        contactList.addContact(c9);
        chooseCommand();

    }
// phone book load menu
    public static void loadMenu(){
        System.out.println("Phone Book commands");
        System.out.println(" 1 - Add contact");
        System.out.println(" 2 - Remove contact");
        System.out.println(" 3 - Print all contacts");
        System.out.println(" 4 - Search by contact name and print");
        System.out.println(" 5 - Sort by contact name (small to big)");
        System.out.println(" 6 - Sort by phone (small to big)");
        System.out.println(" 7 - Print reversed phone book");
        System.out.println(" 8 - Remove duplicates names or phones and print them");
        System.out.println(" 9 - Save phone book in file");
        System.out.println(" 10 - Load phone book from file");
        System.out.println(" 11 - Quit");
        System.out.print("Command: ");


    }
    // Methods menu
    public static void chooseCommand(){

        Scanner scanner = new Scanner(System.in);
        loadMenu();
        int commandNumber = scanner.nextInt();
        scanner.nextLine();
        if(commandNumber<1 || commandNumber >11){
            for (int i = 2 ; i > 0 ; i--){
                System.out.println("Please insert number between 1 & 11: \n you have more " + i + " attempts" );
                loadMenu();
                commandNumber = scanner.nextInt();
            }
            System.out.println("Application terminated after 3 attempts BYE BYE! ");
        }

        // paths to any method from the menu after choosing a command
        while (commandNumber>=1 && commandNumber <= 11){
            switch (commandNumber){
                case 1:
                        scanner.nextLine();
                        System.out.println("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter phone: ");
                        String phone = scanner.nextLine();
                        Contact contact = new Contact(name , phone);
                        contactList.addContact(contact);
                        System.out.println("Add contact successful!");
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException e) {}
                    break;
                case 2:
                    System.out.println("Name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    contactList.removeContact(nameToRemove);
                    try
                    {
                        Thread.sleep(1500);
                    }
                    catch(InterruptedException e) {}
                    break;
                case 3:
                    contactList.printContacts();
                    try
                    {
                        Thread.sleep(1500);
                    }
                    catch(InterruptedException e) {}
                    break;
                case 4:
                    System.out.println("Name for search: ");
                    String searchedName = scanner.nextLine();
                    contactList.searchByName(searchedName);
                    try
                    {
                        Thread.sleep(1500);
                    }
                    catch(InterruptedException e){}
                    break;
                case 5:
                    contactList.sortNameByAscendingOrder();
                    try
                    {
                        Thread.sleep(1500);
                    }
                    catch(InterruptedException e){}
                    break;
                case 6:
                    contactList.sortPhoneByAscendingOrder();
                    try
                    {
                        Thread.sleep(1500);
                    }
                    catch(InterruptedException e){}
                    break;
                case 7:
                    contactList.printReversed();
                    try
                    {
                        Thread.sleep(1500);
                    }
                    catch(InterruptedException e){}
                    break;
                case 8:
                    contactList.removeDuplicates();;
                    try
                    {
                        Thread.sleep(1500);
                    }
                    catch(InterruptedException e){}
                    break;
                case 9:
                    System.out.print("Please enter phone book's name that you want to save: ");
                    String chosenFileName = scanner.nextLine();
                    contactList.saveToFile(chosenFileName);
                    break;
                case 10:
                    System.out.println("Please insert phonebook's name:" );
                    String fileName = scanner.nextLine();
                    contactList.readFromFile(fileName);
                    break;
                case 11:
                    System.out.println("Closing phonebook");
                    exit(0);
                    break;
                default:
                    break;

            }
            loadMenu();
            commandNumber = scanner.nextInt();
            scanner.nextLine();
            if(commandNumber<1 || commandNumber >11){
                for (int i = 2 ; i > 0 ; i--){
                    System.out.println("Please insert number between 1 & 11: \n you have more " + i + " attempts" );
                    loadMenu();
                    commandNumber = scanner.nextInt();
                }
                System.out.println("Application terminated after 3 attempts BYE BYE! ");
            }
    }
    }

//    public static void chooseCommand1(int commandNumber){
////        Scanner scanner = new Scanner(System.in);
    //        commandNumber = scanner.nextInt();
//        scanner.nextLine();
//        chooseCommand1(commandNumber);
////        if (commandNumber == 1){
////            System.out.println("Enter name: ");
////            String name = scanner.nextLine();
////            System.out.println("Enter phone: ");
////            String phone = scanner.nextLine();
////            Contact contact = new Contact(name , phone);
////            contactList.addContact(contact);
////            System.out.println("Add contact successful!");
////            try
////            {
////                Thread.sleep(1000);
////            }
////            catch(InterruptedException e) {}
////            loadMenu();
////        }
////        if(commandNumber == 2){
////            System.out.println("Name to remove: ");
////            String nameToRemove = scanner.nextLine();
////            contactList.removeContact(nameToRemove);
////            try
////            {
////                Thread.sleep(1500);
////            }
////            catch(InterruptedException e) {}
////            loadMenu();
////        }
//
////        if (commandNumber == 3){
////            contactList.printContacts();
////            try
////            {
////                Thread.sleep(1500);
////            }
////            catch(InterruptedException e) {}
////            loadMenu();
////        }
//
////        if (commandNumber == 4){
////            System.out.println("Name for search: ");
////            String name = scanner.nextLine();
////            contactList.searchByName(name);
////            try
////            {
////                Thread.sleep(1500);
////            }
////            catch(InterruptedException e){}
////            loadMenu();
////        }
//
////        if(commandNumber == 5){
////            contactList.sortNameByAscendingOrder();
////            try
////            {
////                Thread.sleep(1500);
////            }
////            catch(InterruptedException e){}
////            loadMenu();
////        }
//
////        if(commandNumber == 6){
////            contactList.sortPhoneByAscendingOrder();
////            try
////            {
////                Thread.sleep(1500);
////            }
////            catch(InterruptedException e){}
////            loadMenu();
////        }
//
////        if (commandNumber == 7){
////            contactList.printReversed();
////            try
////            {
////                Thread.sleep(1500);
////            }
////            catch(InterruptedException e){}
////            loadMenu();
////        }
////
////        if (commandNumber == 8){
////            contactList.removeDuplicates();;
////            try
////            {
////                Thread.sleep(1500);
////            }
////            catch(InterruptedException e){}
////            loadMenu();
////        }
//
//        if (commandNumber == 9){
//            contactList.saveToFile();
//            // save the phonebook on file
//        }
//        if(commandNumber == 10){
//            // load phonebook from file
//        }
//        if(commandNumber == 11) {
//            System.exit(0);
//        }


    }


