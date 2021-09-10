package registrationSystem;

import java.util.ArrayList;

public class Student {
    private String studentName;

    private int studentID;
    private ArrayList<Registration> registrations;
    public Student(String studentName, int studentId){
        this.studentName = studentName;
        this.studentID = studentID;


    }

    // dictionary holding all the courses and their listing

    private CourseCatalogue courseList;

    // later: could add method so CourseCatalogue gets used.
    // specify Course Full Name (key in Course Catalogue) and instructor
    // use this to get specific course offering
    // and then create registration using this.
    // add registration to registrations ArrayList
    public void registerForCourse(CourseCatalogue cat, String courseName,
                                  String courseNumber, int secNumber){
        Course myCourse = cat.searchCat(courseName, courseNumber);
        if (myCourse == null)
            return;
        // if course exists, then we can look at the section
        CourseOffering theOffering = myCourse.getCourseOfferings().get(secNumber-1); // must fix this later?
        Registration reg = new Registration(this, theOffering);
    }

    public void addRegistration(Registration reg){
        registrations.add(reg);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
