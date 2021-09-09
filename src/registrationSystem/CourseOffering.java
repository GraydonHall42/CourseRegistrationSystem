package registrationSystem;

import java.util.ArrayList;

public class CourseOffering {

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

    public void addRegistration(Registration registration) {
        this.registrations.add(registration);
    }
}
