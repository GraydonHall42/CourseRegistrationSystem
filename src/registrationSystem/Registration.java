package registrationSystem;

import java.util.Objects;

public class Registration {
    private Student student;
    private CourseOffering courseOffering;
    private String grade;

    // creates Registration object
    // if deleteReg = True, this registraion is REMOVED from the student and the course Offering
    // if deleteReg = False, this registration is ADDED to the student and the course offering
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
        boolean success = student.removeRegistration(this);  // true if addition is successful
        if (success) {
            courseOffering.removeRegistration(this);
            return true;
        } else
            return false;
    }

    // add registration to student and course offering
    private boolean addRegistration() {
        boolean success = student.addRegistration(this);  // true if addition is successful
        if (success) {
            courseOffering.addRegistration(this);
            return true;
        } else
            return false;
    }

    // check for equality between two registrations, based on student and course offering both being identical
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
