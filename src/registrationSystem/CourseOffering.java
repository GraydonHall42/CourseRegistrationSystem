package registrationSystem;

import java.util.ArrayList;
import java.util.Iterator;

// course offering specifies the instructor for a given course
// can add other details like term, etc if required
public class CourseOffering {

    // course associated with this course offering
    private Course course;
    private int sectionNum;
    private int sectionCap;
    private ArrayList<Registration> registrations;
    private int studentsRegistered;
    private boolean courseActive;

    public CourseOffering(Course course, int sectionNum, int sectionCap) {
        this.course = course;
        this.sectionNum = sectionNum;
        this.sectionCap = sectionCap;
        registrations = new ArrayList<Registration>();
        studentsRegistered=0;
        courseActive=false;
    }

    public void addRegistration(Registration reg){
        registrations.add(reg);
        studentsRegistered +=1;
        checkActive();
    }

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
        checkActive();
        return success;
    }

    private void checkActive(){
        if(studentsRegistered >= 8){
            courseActive = true;
        }
        else
            courseActive = false;
    }

    @Override
    public String toString() {
        return "Course: " + course.toString()
                + ", SecNum: " + sectionNum
                + ", SecCapacity: " + sectionCap;
    }

    public String studentListAsString(){
        var courseString="";
        for(Registration r: registrations){
            courseString += r.getStudent().toString() + "\n";
        }
        return courseString;
    }

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

}
