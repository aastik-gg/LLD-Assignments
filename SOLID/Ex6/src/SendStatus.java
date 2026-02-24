package src;
public class SendStatus {
    public final boolean success;
    public final String message;

    private SendStatus(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static SendStatus ok() { return new SendStatus(true, null); }

    public static SendStatus error(String message) { return new SendStatus(false, message); }
}
