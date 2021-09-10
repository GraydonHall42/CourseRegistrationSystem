package registrationSystem;

import java.util.ArrayList;
import java.util.Map;

public class CourseCatalogue {

    // dictionary to hold courses. Key= course Name+number, value=course object
    private ArrayList<Course> courseList;

    public CourseCatalogue(){
        courseList = loadFromDB();
    }

    public Course searchCat(String courseName, String courseNum ){
        for (Course c: courseList){
            if (c.getCourseName().equals(courseName) && c.getCourseNumber().equals(courseNum)){
                return c;
            }
        }
        return null;
    }

    public void listCourses(){

    }

    @Override
    public String toString() {
        String courseListAsString = "";
        for (Course c: courseList){
            courseListAsString+=c.toString()+"\n";
        }
        return courseListAsString;
    }

    private static ArrayList<Course> loadFromDB(){
        // in real life courses will be loaded from the DB or at least from some file on the disk.
        // for now, we just hard
        ArrayList<Course> imaginaryDB = new ArrayList<Course>();
        imaginaryDB.add(new Course("ENGG", "233"));
        imaginaryDB.add(new Course("PHYS", "259"));
        imaginaryDB.add(new Course("ENSF", "607"));

        return imaginaryDB;
    }

    public static void createOffering(){
        // create a couple of offerings for each course
        // ?? would 3 per course be okay?
    }

    public static void main(String[] args) {
        var x = new CourseCatalogue();
        System.out.println(x);
    }

}
