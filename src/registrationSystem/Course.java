package registrationSystem;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private String courseNumber;
    private ArrayList<CourseOffering> courseOfferings;
    private ArrayList<Course> prereqs;

    public Course(String courseName, String courseNumber) {
        this.setCourseName(courseName);
        this.setCourseNumber(courseNumber);
    }

    public ArrayList<CourseOffering> getCourseOfferings() {
        return courseOfferings;
    }

    // add a course offering.
//    public void addCourseOffering(String instructorName) {
//        var newOffering = new CourseOffering(this,instructorName);
//        this.courseOfferings.add(newOffering);
//    }


    public ArrayList<Course> getPrereqs() {
        return prereqs;
    }

    // add a pre-requisite class
    public void addPrereq(Course course) {
        this.prereqs.add(course);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    @Override
    public String toString() {
        return this.courseName + " " + this.courseNumber;
    }
}
