/**
 * @author Helmi Mustakoski
 */
import java.io.Console;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * The class ContactsApp method contains a simple Contacts Application
 * It allows users to manage basic information about people, e.g.:
 * personal identification number,
 * first name,
 * last name,
 * phone number,
 * address,
 * and e-mail
 *
 * The user can create, read, update and delete contacts there
 * All information are stored in a CSV format text file
 */
public class ContactsApp {
    private static Console c = System.console();

    private static ArrayList<String[]> contacts = new ArrayList<String[]>();
    private static final Path filePath = Paths.get("./", "ContactsApplication.csv");

    /**
     * the main method of the ContactsApp class where the execution of the program begins
     * It initializes the application, displays menu and receives and controls user input
     */
    public static void main(String [] args) {
        downloadFromFile();

        boolean programRun = true;

        do {
            showMenu();
            int choice = askChoice();

            if (choice == 1){
                showContacts();
            }
            else if(choice == 2){
                addContacts();
            }
            else if(choice == 3){
                deleteContacts();
            }
            else if(choice == 4){
                editContacts();
            }
            else if(choice == 0){
                programRun = false;
            }
        } while (programRun);

        saveToFile();
    }

    /**
     * Asks the user's choice from the menu and returns it
     *
     * @return the user's choice
     */
    private static int askChoice() {
        System.out.println("Enter choice: ");
        int choice = Integer.parseInt(c.readLine());
        return choice;
    }

    /**
     * print the menu of the program
     */
    private static void showMenu() {
        System.out.println("\n1 - Show list of contacts");
        System.out.println("2 - Add contacts details");
        System.out.println("3 - Delete contacts");
        System.out.println("4 - Edit contacts");
        System.out.println("0 - Close program\n");
    }
    /**
     * Displays a list of contacts stored in the application
     */
    private static void showContacts() {
        System.out.println("\nList of Contacts: "+"\n");

        for(int i=0; i<contacts.size(); i++){
            String[] person = contacts.get(i);

            System.out.println("Personal ID: "+person[0]);
            System.out.println("First name: "+ person[1]);
            System.out.println("Last name: "+ person[2]);
            System.out.println("Phone number: "+ person[3]);
            System.out.println("Address: "+ person[4]);
            System.out.println("e-mail: "+ person[5] + "\n");
        }
    }

    /**
     * Add new contacts to the appluication based on user input
     */
    private static void addContacts() {
        System.out.print("Enter personal ID: ");
        String personalID = c.readLine();
        System.out.print("Enter first name: ");
        String firstName = c.readLine();
        System.out.print("Enter last name: ");
        String lastName = c.readLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = c.readLine();
        System.out.print("Enter address: ");
        String address = c.readLine();
        System.out.print("Enter e-mail address: ");
        String email = c.readLine();

        String[]person = new String[6];
        person[0] = personalID;
        person[1] = firstName;
        person[2] = lastName;
        person[3] = phoneNumber;
        person[4] = address;
        person[5] = email;

        contacts.add(person);
        System.out.println(contacts.size());

        for(int i=0; i<contacts.size(); i++){
            String [] p = contacts.get(i);
            System.out.println(p[0]);
            System.out.println(p[1]);
            System.out.println(p[2]);
            System.out.println(p[3]);
            System.out.println(p[4]);
            System.out.println(p[5] + "\n");
        }
    }

    /**
     * Edit the contact of the index selected by the user, according to the user's input
     */
    private static void editContacts() {
        if (contacts.size() > 0){
            showContacts();
            int index;

            try {
                index = Integer.parseInt(c.readLine("Select index of the contact to be edit (0->): "));
            } catch (NumberFormatException e){
                System.out.println("Enter a valid number");
                return;
            }
            if (index >= 0 && index < contacts.size()){
                String [] person = contacts.get(index);

                person[1] = c.readLine("Enter a replacement first name: ");
                person[2] = c.readLine("Enter a replacement last name: ");
                person[3] = c.readLine("Enter a replacement phone number: ");
                person[4] = c.readLine("Enter a replacement address: ");
                person[5] = c.readLine("Enter a replacement email: ");

                contacts.set(index, person);
                System.out.println("contacts edit successfully");
            } else{
                System.out.println("invalid index, cannot edit");
            }
        } else {
            System.out.println("No contact details to edit");
        }
    }

    /**
     * Deletes the user-selected index contact
     */
    private static void deleteContacts() {
        if (contacts.size() > 0){
            showContacts();
            int index;

            try{
                index = Integer.parseInt(c.readLine("Select the index of the contact to be deleted (0->): "));
            } catch (NumberFormatException e){
                System.out.println("Enter a valid number");
                return;
            }
            if(index >= 0 && index < contacts.size()){
                contacts.remove(index);
                System.out.println("contacts delete successfully");
            } else {
            System.out.println("invalid index");
            }
        } else {
            System.out.println("No contact details to remove");
        }
    }

    /**
     * Save contacts to a CSV format text file
     */
    private static void saveToFile() {
        try {
            Files.writeString(filePath,
                "",
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);

            for (int i = 0; i < contacts.size(); i++){
                String contactsString = "";

                String[] person = contacts.get(i);
                contactsString += person[0] +",";
                contactsString += person[1] +",";
                contactsString += person[2] +",";
                contactsString += person[3] +",";
                contactsString += person[4] +",";
                contactsString += person[5] +"\n";

                Files.writeString(filePath,
                contactsString,
                StandardOpenOption.APPEND);
                }

            String content = Files.readString(filePath);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads contacts from the text file to the application
     */
    private static void downloadFromFile() {
        try {
            if (Files.exists(filePath)) {
                List<String>lines = Files.readAllLines(filePath);

                for(String line : lines){
                    String[] person = line.split(",");
                    contacts.add(person);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
