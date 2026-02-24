package src;
public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { super(audit); }

    @Override
    protected SendStatus doSend(Notification n) {
        if (n.body.length() > 40) {
            return SendStatus.error("body length exceeds limit");
        }
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + n.body);
        audit.add("email sent");
        return SendStatus.ok();
    }
}