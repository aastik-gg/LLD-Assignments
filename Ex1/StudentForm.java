public class StudentForm {
    private final String name;
    private final String email;
    private final String phone;
    private final String program;

    public StudentForm(String name, String email, String phone, String program) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.program = program;
    }

    public String name() { return name; }
    public String email() { return email; }
    public String phone() { return phone; }
    public String program() { return program; }
}
