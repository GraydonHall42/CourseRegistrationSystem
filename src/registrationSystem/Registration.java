package registrationSystem;

public class Registration {
    private Student student;
    private CourseOffering courseOffering;
    private String grade;

    public Registration(Student student, CourseOffering courseOffering) {
        this.student = student;
        this.courseOffering = courseOffering;
        addRegistration();
    }

    private void addRegistration() {
        student.addRegistration(this);
        courseOffering.addRegistration(this);
    }


}
