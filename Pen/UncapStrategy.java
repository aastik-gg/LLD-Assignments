public class UncapStrategy implements OpenCloseStrategy {
    @Override
    public void open() {
        System.out.println("Twist and remove the cap");
    }

    @Override
    public void close() {
        System.out.println("Align and secure the cap");
    }
}