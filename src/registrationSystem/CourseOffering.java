package registrationSystem;

import java.util.ArrayList;
import java.util.Iterator;

// course offering specifies the instructor for a given course
// can add other details like term, etc if required
public class CourseOffering {

    private Course course;    // course associated with this course offering
    private int sectionNum;
    private int sectionCap;
    private ArrayList<Registration> registrations;
    private int studentsRegistered;
    private boolean courseActive;  // tracks if course is active (>=8 people enrolled)
    private boolean courseFull;  // true if course is at capacity

    public CourseOffering(Course course, int sectionNum, int sectionCap) {
        this.course = course;
        this.sectionNum = sectionNum;
        this.sectionCap = sectionCap;
        registrations = new ArrayList<Registration>();
        studentsRegistered=0;
        courseActive=false;
    }

    // Add registration to registrations list
    // returns true if registration is successfully added
    public boolean addRegistration(Registration reg){
        // checks if an identical registration already exists in registrations
        if(checkDuplicateReg(reg))
            return false;

        registrations.add(reg);
        studentsRegistered +=1;
        checkFull();
        checkActive();
        return true;  // registration was successfully added
    }
    // returns true if a duplicate registration already exists in registrations
    private boolean checkDuplicateReg(Registration reg){
        for(Registration r: registrations){
            if (r.equals(reg)){
                System.out.println("Registration Failure: Student already registered in this course.");
                return true;
            }
        }
        return false;
    }
    // returns true if registration is successfully removed
    public boolean removeRegistration(Registration registration) {
        var success = false;
        Iterator itr = registrations.iterator();
        while (itr.hasNext())
        {
            var x = itr.next();
            if (x.equals(registration)){
                itr.remove();
                success = true;
                studentsRegistered -=1;
            }

        }
        if(!success){
            System.out.println("unable to remove registration. Please check information and try again");
        }
        checkFull();
        checkActive();
        return success;
    }

    // course has active status if >= 8 students are enrolled in it.
    private void checkActive(){
        if(studentsRegistered >= 8){
            courseActive = true;
        }
        else
            courseActive = false;
    }

    // checks if course is full
    // sets courseFull field to True if studentsRegistered is >= the section capacity
    private void checkFull(){
        courseFull = (studentsRegistered >= sectionCap);
    }

    // string representation of coure offering... give course name, section number, and section capacity
    @Override
    public String toString() {
        return "Course: " + course.toString()
                + ", Section Num: " + sectionNum
                + ", Section Capacity: " + sectionCap
                + ", Section Active: " + courseActive;
    }
    // return String with all students enrolled in the course
    public String studentListAsString(){
        if(registrations.isEmpty()){
            return "Student not enrolled in any courses";
        }
        var courseString="";
        for(Registration r: registrations){
            courseString += r.getStudent().toString() + "\n";
        }
        return courseString;
    }
    // check equality between two course offerings based on sectionNum, sectionCap, and course all being equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseOffering)) return false;
        CourseOffering that = (CourseOffering) o;
        return sectionNum == that.sectionNum
                && sectionCap == that.sectionCap
                && getCourse().equals(that.getCourse());
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

    public int getSectionNum() {
        return sectionNum;
    }

    public void setSectionNum(int sectionNum) {
        this.sectionNum = sectionNum;
    }

    public int getSectionCap() {
        return sectionCap;
    }

    public void setSectionCap(int sectionCap) {
        this.sectionCap = sectionCap;
    }

    public boolean isCourseActive() {
        return courseActive;
    }

    public boolean isCourseFull() {
        return courseFull;
    }
}
