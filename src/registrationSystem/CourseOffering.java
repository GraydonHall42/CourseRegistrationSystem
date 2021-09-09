package registrationSystem;

import java.util.ArrayList;

// course offering specifies the instructor for a given course
// can add other details like term, etc if required
public class CourseOffering {

    // course associated with this course offering
    private Course course;

    private String instructor;
    private ArrayList<Registration> registrations;
    public CourseOffering(Course course, String instructor) {
        this.course = course;
        this.instructor = instructor;
    }

    public ArrayList<Registration> getRegistrations() {
        return registrations;
    }

    // add Registration to Registration ArrayList.
    public void addRegistration(Registration registration) {
        this.registrations.add(registration);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
