public class Main {

    public static void main(String[] args) {
        String penType = args.length > 0 ? args[0] : "gel";
        String openMode = args.length > 1 ? args[1] : "cap";

        Pen pen = PenFactory.createPen(penType, openMode);
        runDemo(pen);
    }

    private static void runDemo(Pen pen) {
        pen.start();
        pen.write("nice to meet you");
        pen.refill();
        pen.close();
    }
}