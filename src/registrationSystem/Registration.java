package registrationSystem;

public class Registration {
    private Student student;
    private CourseOffering courseOffering;
    private String grade;

    public Registration(Student student, CourseOffering courseOffering, String grade) {
        this.student = student;
        this.courseOffering = courseOffering;
        this.grade = grade;
    }


}
