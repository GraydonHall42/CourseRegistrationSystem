package registrationSystem;

import java.util.ArrayList;

// course offering specifies the instructor for a given course
// can add other details like term, etc if required
public class CourseOffering {

    // course associated with this course offering
    private Course course;
    private int sectionNum;
    private int sectionCap;
    private ArrayList<Registration> registrations;

    public CourseOffering(Course course, int sectionNum, int sectionCap) {
        this.course = course;
        this.sectionNum = sectionNum;
        this.sectionCap = sectionCap;
    }

    public ArrayList<Registration> getRegistrations() {
        return registrations;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void addRegistration(Registration reg){
        registrations.add(reg);
    }

}
