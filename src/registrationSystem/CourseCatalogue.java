package registrationSystem;

import java.util.ArrayList;

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


    public String coursesAsString() {
        String courseListAsString = "";
        for (Course c: courseList){
            courseListAsString+=c.toString()+"\n";
        }
        return courseListAsString;
    }
    public String coursesWithPreReqsAsString() {
        String courseListAsString = "";
        for (Course c: courseList){
            courseListAsString+=c.toString()+"- PreReqs: " + c.preReqsAsString()+"\n";
        }
        return courseListAsString;
    }

    private String allCourseOfferingsAsString() {
        String allCourseListingsString = "";
        for (Course c: courseList){
            allCourseListingsString+=c.allOfferingsAsString();
        }
        return allCourseListingsString;
    }




    private static ArrayList<Course> loadFromDB(){
        // populate CourseCatalogue database by hand
        ArrayList<Course> imaginaryDB = new ArrayList<Course>();

        // add initial courses
        imaginaryDB.add(new Course("ENGG", "233"));
        imaginaryDB.add(new Course("PHYS", "259"));
        imaginaryDB.add(new Course("ENSF", "607"));

        // add 3 prereq's to each course... inspired by our summer courses
        for (Course c: imaginaryDB){
            c.addPrereq(new Course("ENSF", "592"));
            c.addPrereq(new Course("ENSF", "593"));
            c.addPrereq(new Course("ENSF", "594"));
        }


        // add 3 offerings to each course, with capacity of 80 students
        for (Course c: imaginaryDB){
            c.addCourseOffering(1, 80);
            c.addCourseOffering(2, 80);
            c.addCourseOffering(3, 80);
        }

        return imaginaryDB;
    }


    // used to test out contents of course catalogue
    public static void main(String[] args) {
        var x = new CourseCatalogue();

        System.out.println("\n---Courses in catalogue---");
        System.out.println(x.coursesAsString());

        System.out.println("\n---Courses with list of prereqs---");
        System.out.println(x.coursesWithPreReqsAsString());

        System.out.println("\n---Courses and all offerings---");
        System.out.println(x.allCourseOfferingsAsString());

    }

}
