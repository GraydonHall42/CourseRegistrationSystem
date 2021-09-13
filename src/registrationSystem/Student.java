package registrationSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Student {
    private String studentName;
    private int studentID;
    private ArrayList<Registration> registrations;
    private ArrayList<Course> coursesCompleted;  // holds courses completed by the student


    public Student(String studentName, int studentId){
        this.studentName = studentName;
        this.studentID = studentID;
        registrations = new ArrayList<Registration>();
        coursesCompleted = new ArrayList<Course>();
    }

    public void addCompletedCourse(Course c){
        coursesCompleted.add(c);
    }

    // Adds registration to registrations ArrayList
    // return true if registration is sucessfully added
    public boolean addRegistration(Registration reg){
        // checks if an identical registration already exists in registrations
        if(checkDuplicateReg(reg))
            return false;

        // ensure this student has the correct pre-requisite courses
        if(!checkPreReqs(reg))
            return false;

        // check that course offering is not over capacity...
        if(reg.getCourseOffering().isCourseFull()) {
            System.out.println("Registration failure: Course Offering is Full");
            return false;
        }

        // ensure student does not enroll in > 6 courses
        if (registrations.size() < 6) {
            registrations.add(reg);
            return true;
        } else
            System.out.println("Registration failure: Student in 6 classes already.");
            return false;

    }

    // check that the student has the correct pre-requisite courses
    // returns true if all prereqs are satisfied
    private boolean checkPreReqs(Registration reg) {
        // https://stackoverflow.com/questions/13501142/java-arraylist-how-can-i-tell-if-two-lists-are-equal-order-not-mattering
        Course c = reg.getCourseOffering().getCourse();
        ArrayList<Course> prereqs = c.getPrereqs();
        if(prereqs.containsAll(coursesCompleted) && coursesCompleted.containsAll(prereqs)){
            return true;
        } else {
            System.out.println("Registration Falure: Student does not satisfy pre-requiste requirements");
            return false;
        }
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

    // remove registration from registrations list
    // returns true if course is successfully removed
    public boolean removeRegistration(Registration registration) {
        boolean removed = false;  // becomes true if removal successful
        Iterator itr = registrations.iterator();
        while (itr.hasNext())
        {
            var x = itr.next();
            if (x.equals(registration))
                itr.remove();
                removed = true;
        }
        if(!removed){
            System.out.println("unable to remove registration. Please check information and try again");
        }
        return removed;
    }

    // string representation of student: NAME + ID
    @Override
    public String toString() {
        return getStudentName() +"- ID: " + getStudentID();
    }

    // return String of all courses the student is in
    public String courseListAsString(){
        var courseString="";
        if(registrations.isEmpty()){
            return "Student not enrolled in any courses";
        }
        for(Registration r: registrations){
            courseString += r.getCourseOffering().toString() + "\n";
        }
        return courseString;
    }

    // check if two students are equal based on same name and ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getStudentID() == student.getStudentID()
                && Objects.equals(getStudentName(), student.getStudentName());
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
