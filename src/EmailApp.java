import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class creates the whole app for the program and puts all the pieces together from the other classes
 */
public class EmailApp {
    /**
     * This is the main class for the program tha prints the menu and reads the user choices to know what to do next.
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Email> emails = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("********************************************************************************");
            System.out.println("Emailer Version 1.0");
            System.out.println("********************************************************************************");
            System.out.println("Here are your choices:");
            System.out.println("1. Write Email");
            System.out.println("2. List Emails");
            System.out.println("3. Send Emails");
            System.out.println("4. Save Emails to File");
            System.out.println("5. Exit");
            System.out.println("Enter the number of your choice: ");

            if (scanner.hasNextLine()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.print("Enter the recipients' email (comma-separated): ");
                    String recipientsLine = scanner.nextLine();
                    ArrayList<String> recipients = new ArrayList<>();
                    for (String recipient : recipientsLine.split(",")) {
                        recipients.add(recipient.trim());
                    }
                    System.out.print("Enter Subject: ");
                    String subject = scanner.nextLine();
                    System.out.print("Enter Body: ");
                    String body = scanner.nextLine();
                    emails.add(new Email(recipients, subject, body));
                } else if (choice == 2) {
                    EmailPrinter.printEmails(emails);
                } else if (choice == 3) {
                    for (Email email : emails) {
                        email.setSent(true);
                    }
                    System.out.println("All emails have been sent.");
                } else if (choice == 4) {
                    System.out.print("Enter the name of the file to save: ");
                    String fileName;
                    fileName = scanner.nextLine();
                    EmailPrinter.saveEmailsToFile(emails, fileName);
                } else if (choice == 5) {
                    System.out.println("Thank you for using this program.");
                    System.exit(0);
                } else {
                    System.out.println("Invalid choice. PLease enter a number 1-5");
                }
            } else {
                System.out.println("Invalid input. Please enter a correct integer");
                scanner.next();
            }
        }
    }
}
