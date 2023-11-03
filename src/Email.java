import java.util.ArrayList;

/**
 * This class creates the strings and array lists that will store the different pieces fo the email and creates functions to get the pieces from different parts of the code.
 */
public class Email {
    private ArrayList<String> recipients;
    private String subject;
    private String body;
    private boolean sent;

    public Email(ArrayList<String> recipients, String subject, String body) {
        this.recipients = recipients;
        this.subject = subject;
        this.body = body;
        this.sent = false;
    }

    public ArrayList<String> getRecipients() {
        return recipients;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }
}
