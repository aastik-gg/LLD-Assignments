package src;
public class AttendanceRule implements EligibilityRule {
    private final RuleInput config;

    public AttendanceRule(RuleInput config) {
        this.config = config;
    }

    @Override
    public String evaluate(StudentProfile profile) {
        if (profile.attendancePct < config.minAttendance) {
            return "attendance below " + config.minAttendance;
        }
        return null;
    }
}
