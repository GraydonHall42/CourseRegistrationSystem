package registrationSystem;

import java.util.ArrayList;
import java.util.Objects;

public class Course {
    private String courseName;
    private String courseNumber;
    private ArrayList<CourseOffering> courseOfferings;
    private ArrayList<Course> prereqs;

    // constructor: provide course name and number to build Course object
    public Course(String courseName, String courseNumber) {
        this.setCourseName(courseName);
        this.setCourseNumber(courseNumber);
        this.courseOfferings = new ArrayList<CourseOffering>();
        this.prereqs = new ArrayList<Course>();
    }

    // add a course offering to this course, based on section number and section capacity
    public void addCourseOffering(int sectionNum, int sectionCap) {
        var newOffering = new CourseOffering(this,sectionNum, sectionCap);

        // could check for duplicates at this spot in future
        this.courseOfferings.add(newOffering);
    }

    // return course offering based on section number
    // returns null if course offering not found
    public CourseOffering getCourseOffering(int secNum){
        for(CourseOffering c:courseOfferings){
            if(c.getSectionNum()==secNum)
                return c;
        }
        return null;
    }

    // add a pre-requisite class to the course
    public void addPrereq(Course course) {
        this.prereqs.add(course);
    }

    // return string of comma separated list of all the prereq classes
    public String preReqsAsString(){
        var prereqString = "";
        for(Course c: prereqs){
            prereqString+= c.toString() + ", ";
        }
        return prereqString;
    }

    // return string of all the sections of the course
    //form: course name, section number, capacity
    public String allOfferingsAsString(){
        var offeringString = "";
        for(CourseOffering c: courseOfferings){
            offeringString += c.toString() + '\n';
        }
        return offeringString;

    }


    // compare equality of two courses based on name and course number
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(getCourseName(), course.getCourseName())
                && Objects.equals(getCourseNumber(), course.getCourseNumber());
    }

    // string representation of course: NAME COURSENUMBER
    @Override
    public String toString() {
        return this.courseName + " " + this.courseNumber;
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

    public ArrayList<CourseOffering> getCourseOfferings() {
        return courseOfferings;
    }

    public ArrayList<Course> getPrereqs() {
        return prereqs;
    }


}
