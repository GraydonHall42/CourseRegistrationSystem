package registrationSystem;

public class Course {
    private String courseName;
    private String courseNumber;

    private Course[] prereqs;

    public Course(String courseName, String courseNumber) {
        this.setCourseName(courseName);
        this.setCourseNumber(courseNumber);
    }

    // constructor for if you want to include prereqs.
    public Course(String courseName, String courseNumber, Course[] prereqs) {
        this.setCourseName(courseName);
        this.setCourseNumber(courseNumber);
        this.setPrereqs(prereqs);
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

    public Course[] getPrereqs() {
        return prereqs;
    }

    public void setPrereqs(Course[] prereqs) {
        this.prereqs = prereqs;
    }



    @Override
    public String toString() {
        return this.courseName + " " + this.courseNumber;
    }
}
