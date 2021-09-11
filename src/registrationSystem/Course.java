package registrationSystem;

import java.util.ArrayList;
import java.util.Objects;

public class Course {
    private String courseName;
    private String courseNumber;
    private ArrayList<CourseOffering> courseOfferings;
    private ArrayList<Course> prereqs;

    // constructor: provide coures name and number to build object
    public Course(String courseName, String courseNumber) {
        this.setCourseName(courseName);
        this.setCourseNumber(courseNumber);
        this.courseOfferings = new ArrayList<CourseOffering>();
        this.prereqs = new ArrayList<Course>();
    }

    // return all course offerings
    public ArrayList<CourseOffering> getCourseOfferings() {
        return courseOfferings;
    }

    // add a course offering to this course
    public void addCourseOffering(int sectionNum, int sectionCap) {
        var newOffering = new CourseOffering(this,sectionNum, sectionCap);
        this.courseOfferings.add(newOffering);
    }

    public CourseOffering getCourseOffering(int secNum){
        for(CourseOffering c:courseOfferings){
            if(c.getSectionNum()==secNum)
                return c;
        }
        return null;
    }


    public ArrayList<Course> getPrereqs() {
        return prereqs;
    }

    // add a pre-requisite class to the course
    public void addPrereq(Course course) {
        this.prereqs.add(course);
    }

    @Override
    public String toString() {
        return this.courseName + " " + this.courseNumber;
    }

    public String preReqsAsString(){
        var prereqString = "";
        for(Course c: prereqs){
            prereqString+= c.toString() + ", ";
        }
        return prereqString;
    }

    public String allOfferingsAsString(){
        var offeringString = "";
        for(CourseOffering c: courseOfferings){
            offeringString += c.toString() + '\n';
        }
        return offeringString;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(getCourseName(), course.getCourseName())
                && Objects.equals(getCourseNumber(), course.getCourseNumber());
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


}
