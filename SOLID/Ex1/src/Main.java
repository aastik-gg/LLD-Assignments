package src;
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        StudentRepository db = new FakeDb();
        OnboardingService svc = new OnboardingService(db);
        OnboardingPrinter printer = new OnboardingPrinter();

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        System.out.println("INPUT: " + raw);
        OnboardingResult result = svc.registerFromRawInput(raw);
        printer.print(result);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}