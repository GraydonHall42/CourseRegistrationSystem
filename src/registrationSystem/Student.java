package registrationSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Student {
    private String studentName;
    private int studentID;
    private ArrayList<Registration> registrations;


    public Student(String studentName, int studentId){
        this.studentName = studentName;
        this.studentID = studentID;
        registrations = new ArrayList<Registration>();
    }

    // return true if registration is sucessfully added
    public boolean addRegistration(Registration reg){
        // checks if an identical registration already exists in registrations
        if(checkDuplicateReg(reg))
            return false;

        // ensure student does not enroll in > 6 courses
        if (registrations.size() < 6) {
            registrations.add(reg);
            return true;
        } else
            System.out.println("Student in 6 classes already. Please remove one and try again");
            return false;

    }

    // returns true if a duplicate registration already exists in registrations
    private boolean checkDuplicateReg(Registration reg){
        for(Registration r: registrations){
            if (r.equals(reg)){
                return true;
            }
        }
        return false;
    }

    // returns true if course is successfully removed
    public boolean removeRegistration(Registration registration) {
        boolean removed = false;
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
