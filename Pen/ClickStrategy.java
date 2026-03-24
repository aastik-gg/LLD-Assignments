public class ClickStrategy implements OpenCloseStrategy {
    @Override
    public void open() {
        System.out.println("Soft click engages the tip");
    }

    @Override
    public void close() {
        System.out.println("Another click retracts the tip");
    }
}