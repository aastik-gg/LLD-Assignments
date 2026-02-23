import java.util.List;

public class OnboardingPrinter {
	public void print(OnboardingResult result) {
		if (result.ok && result.record != null) {
			StudentRecord rec = result.record;
			System.out.println("OK: created student " + rec.id);
			System.out.println("Saved. Total students: " + result.totalStudents);
			System.out.println("CONFIRMATION:");
			System.out.println(rec);
		} else {
			System.out.println("ERROR: cannot register");
			List<String> errs = result.errors;
			for (String err : errs) {
				System.out.println("- " + err);
			}
		}
	}
}
