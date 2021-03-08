package endtermprojectArucorn;

import java.util.Vector;

public interface CanSendMessage {
    Vector<Mail> mails = new Vector<>();
    boolean sendMail(String heading, String message, String receiver);
    void receiveMail(Mail mail);
    void viewMails();
}
