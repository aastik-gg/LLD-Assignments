package src;
/**
 * Base contract: accepts non-null notifications and reports success/failure via {@link SendStatus}.
 * Subclasses must not throw for invalid channel-specific data; instead return an error status.
 */
public abstract class NotificationSender {
    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) { this.audit = audit; }

    public final SendStatus send(Notification n) {
        if (n == null) throw new IllegalArgumentException("notification cannot be null");
        return doSend(n);
    }

    protected abstract SendStatus doSend(Notification n);
}