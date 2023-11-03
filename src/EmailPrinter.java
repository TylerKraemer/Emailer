import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class created the email and prints it out
 */
public class EmailPrinter {
    /**
     * This function creates what is printed once the email is created
     * @param emails this is the array list that will store all the information about the email.
     */
    public static void printEmails(ArrayList<Email> emails) {
        for (Email email : emails) {
            System.out.println("To: " + String.join(",", email.getRecipients()));
            System.out.println("Subject: " + email.getSubject());
            System.out.println("Status: " + (email.isSent() ? "sent" : "not sent"));
            System.out.println("Body:\n" + email.getBody() + "\n");
        }
    }

    /**
     * This fucntion saves the emails to a file.
     * @param emails This is the array list that stores all the information about the emails
     * @param fileName this is the name of the file being read from the users input
     */
    public static void saveEmailsToFile(ArrayList<Email> emails, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Email email : emails) {
                String recipients = String.join(",", email.getRecipients());
                String line = recipients + "\t" + email.getSubject() + "\t" + (email.isSent() ? "sent" : "not sent") + "\t" + email.getBody() + "\n";
                writer.write(line);
            }
            System.out.println("Emails were saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving emails to file.");
        }
    }
}
