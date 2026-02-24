package src;
import java.util.List;

public class OnboardingResult {
    public final boolean ok;
    public final StudentRecord record;
    public final List<String> errors;
    public final int totalStudents;

    public OnboardingResult(boolean ok, StudentRecord record, List<String> errors, int totalStudents) {
        this.ok = ok;
        this.record = record;
        this.errors = errors;
        this.totalStudents = totalStudents;
    }
}
