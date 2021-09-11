package registrationSystem;

import java.util.Objects;

public class Registration {
    private Student student;
    private CourseOffering courseOffering;
    private String grade;

    // creates Registration object
    // if deleteReg = True, this registraion is REMOVED from the student and the course Offering
    // if deleteReg = False, this registration is ADDED to the studend and the course offering
    public Registration(Student student, CourseOffering courseOffering, boolean deleteReg) {
        this.student = student;
        this.courseOffering = courseOffering;
        if (deleteReg==true)
            removeRegistration();
        else
            addRegistration();
    }

    // remove this registration from student and course offering.
    private boolean removeRegistration() {
        boolean success = student.removeRegistration(this);
        if (success) {
            courseOffering.removeRegistration(this);
            return true;
        } else
            return false;
    }

    // add registration to student and course offering
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
