package src;
public class CreditRule implements EligibilityRule {
    private final RuleInput config;

    public CreditRule(RuleInput config) {
        this.config = config;
    }

    @Override
    public String evaluate(StudentProfile profile) {
        if (profile.earnedCredits < config.minCredits) {
            return "credits below " + config.minCredits;
        }
        return null;
    }
}
