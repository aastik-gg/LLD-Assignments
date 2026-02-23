import java.util.ArrayList;
import java.util.List;

public class StudentValidator {
    public List<String> validate(StudentForm form){
        List<String> errors = new ArrayList<>();
        if (form.name().isBlank()) errors.add("name is required");
        if (form.email().isBlank() || !form.email().contains("@")) errors.add("email is invalid");
        if (form.phone().isBlank() || !form.phone().chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(form.program().equals("CSE") || form.program().equals("AI") || form.program().equals("SWE"))) errors.add("program is invalid");
        return errors;
    }
}
