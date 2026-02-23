public interface EligibilityRule {
    /**
     * @return null when the rule passes; otherwise, the failure reason.
     */
    String evaluate(StudentProfile profile);
}
