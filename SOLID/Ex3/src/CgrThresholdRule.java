package src;
public class CgrThresholdRule implements EligibilityRule {
    private final RuleInput config;

    public CgrThresholdRule(RuleInput config) {
        this.config = config;
    }

    @Override
    public String evaluate(StudentProfile profile) {
        if (profile.cgr < config.minCgr) {
            return "CGR below " + config.minCgr;
        }
        return null;
    }
}
