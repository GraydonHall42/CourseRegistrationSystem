package registrationSystem;

import java.util.Objects;

public class Registration {
    private Student student;
    private CourseOffering courseOffering;
    private String grade;


    public Registration(Student student, CourseOffering courseOffering, boolean deleteReg) {
        this.student = student;
        this.courseOffering = courseOffering;
        if (deleteReg==true)
            removeRegistration();
        else
            addRegistration();
    }

    private boolean removeRegistration() {
        boolean success = student.removeRegistration(this);
        if (success) {
            courseOffering.removeRegistration(this);
            return true;
        } else
            return false;
    }

    private boolean addRegistration() {
        // adds the registration to the registrations list in
        // the student, and in the courseOffering
        boolean success = student.addRegistration(this);
        if (success) {
            courseOffering.addRegistration(this);
            return true;
        } else
            return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Registration)) return false;
        Registration that = (Registration) o;
        return Objects.equals(student, that.student)
                && Objects.equals(courseOffering, that.courseOffering);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public CourseOffering getCourseOffering() {
        return courseOffering;
    }

    public void setCourseOffering(CourseOffering courseOffering) {
        this.courseOffering = courseOffering;
    }


}
