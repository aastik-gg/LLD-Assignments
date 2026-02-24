package src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OnboardingService {
    private final StudentRepository repository;

    public OnboardingService(StudentRepository repository) {
        this.repository = repository;
    }

    public OnboardingResult registerFromRawInput(String raw) {
        StudentInputParser parser = new StudentInputParser();
        StudentForm form = parser.parse(raw);

        StudentValidator validator = new StudentValidator();
        List<String> errors = validator.validate(form);
        if (!errors.isEmpty()) {
            return new OnboardingResult(false, null, new ArrayList<>(errors), repository.count());
        }

        String id = IdUtil.nextStudentId(repository.count());
        StudentRecord rec = new StudentRecord(
                id,
                form.name(),
                form.email(),
                form.phone(),
                form.program());

        repository.save(rec);
        return new OnboardingResult(true, rec, Collections.emptyList(), repository.count());
    }
}