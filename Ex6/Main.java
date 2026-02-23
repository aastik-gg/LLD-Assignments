public class Main {
    public static void main(String[] args) {
        System.out.println("=== Notification Demo ===");
        AuditLog audit = new AuditLog();

        Notification n = new Notification("Welcome", "Hello and welcome to SST!", "riya@sst.edu", "9876543210");

        NotificationSender email = new EmailSender(audit);
        NotificationSender sms = new SmsSender(audit);
        NotificationSender wa = new WhatsAppSender(audit);

        email.send(n);
        sms.send(n);
        SendStatus waStatus = wa.send(n);
        if (!waStatus.success) {
            System.out.println("WA ERROR: " + waStatus.message);
            audit.add("WA failed");
        }

        System.out.println("AUDIT entries=" + audit.size());
    }
}