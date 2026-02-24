package src;
public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    protected SendStatus doSend(Notification n) {
        if (n.phone == null || !n.phone.startsWith("+")) {
            return SendStatus.error("phone must start with + and country code");
        }
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
        return SendStatus.ok();
    }
}