package registrationSystem;

public class FrontEnd {

    private Student s1, s2, s3, s4;
    private CourseCatalogue cat;
    private Course c1, c2, c3;
    private CourseOffering co1, co2, co3;
    private Student[] students;
    private CourseOffering[] courseOfferings;
    private KeyboardReader reader;

    public FrontEnd() {

        reader = new KeyboardReader();

        // 4 students
        s1 = new Student("Jane", 1);
        s2 = new Student("Sam", 2);
        s3 = new Student("Joey", 3);
        s4 = new Student("Alex", 4);
        students = new Student[]{s1, s2, s3, s4};

        // course catalogue
        cat = new CourseCatalogue();

        // 3 courses from catalogue
        c1 = cat.searchCat("ENGG", "233");
        c2 = cat.searchCat("PHYS", "259");
        c3 = cat.searchCat("ENSF", "607");

        // 1 course offerings from each course
        co1 = c1.getCourseOffering(1);
        co2 = c2.getCourseOffering(1);
        co3 = c3.getCourseOffering(1);
        courseOfferings = new CourseOffering[]{co1, co2, co3};



    }

    public void testProgram() {

        // create registrations, for each student in each course offering
        for(Student s:students){
            for(CourseOffering c:courseOfferings){
                Registration r = new Registration(s, c, false);
            }
        }

        // check class list for each student
        System.out.println("---Class List for each student---");
        for(Student s: students){
            System.out.println(s.getStudentName() + "'s Course List");
            System.out.println(s.courseListAsString());
        }


        // check student list for each class
        System.out.println("---Student List for each class---");
        for(CourseOffering c: courseOfferings){
            System.out.println("Student list for " + c);
            System.out.println(c.studentListAsString());
        }

        // create registrations, for each student in each course offering
        for(Student s:students){
            for(CourseOffering c:courseOfferings){
                Registration r = new Registration(s, c, true);
            }
        }

        // check class list for each student
        System.out.println("---Class List for each student (post deletion)---");
        for(Student s: students){
            System.out.println(s.getStudentName() + "'s Course List");
            System.out.println(s.courseListAsString());
        }


        // check student list for each class
        System.out.println("---Student List for each class (post deletion)---");
        for(CourseOffering c: courseOfferings){
            System.out.println("Student list for " + c);
            System.out.println(c.studentListAsString());
        }

    }

    public void mainMenu(){
        while (true) {
            reader.display("\n---Welcome to Graydon Hall's Course Registration System---\n");
            reader.display("Please select one of the following options:\n");
            reader.display("1. Search catalogue courses\n");
            reader.display("2. Add course to student courses\n");
            reader.display("3. Remove course from student courses\n");
            reader.display("4. View All courses in catalogue\n");
            reader.display("5. View all courses taken by student\n");
            reader.display("6. Quit\n");
            reader.display("Enter your option: ");
            String response = reader.getKeyboardInput();
            switch (response) {
                case "1":
                    searchCatalogue();
                    break;
                case "2":
                    modifyStudentCourses(false);
                    break;
                case "3":
                    modifyStudentCourses(true);
                    break;
                case "4":
                    reader.display("\n---All Courses in Catalogue---\n");
                    reader.display(cat.coursesAsString());
                    break;
                case "5":
                    viewCoursesForStudent();
                    break;
                case "6":
                    reader.display("Thanks! Bye for now :)");
                    return;
                default:
                    reader.display("Invalid Entry. Enter integer from 1 to 6\n");
                    break;
            }
        }
    }

    private void searchCatalogue() {
        reader.display("Enter Course Name: ");
        String className = reader.getKeyboardInput();
        reader.display("Enter Course Number: ");
        String classNum = reader.getKeyboardInput();

        Course theCourse = cat.searchCat(className, classNum);
        if(theCourse==null){
            System.out.println("Error, course not found");
            return;
        }

        reader.display("\n---The following Sections exist for this course---\n");
        System.out.println(theCourse.allOfferingsAsString());

    }

    private void modifyStudentCourses(boolean deleteReg) {
        Student theStudent = null;
        boolean studentFound = false;

        reader.display("Please Enter Students Name: ");
        String name = reader.getKeyboardInput();
        for(Student s: students){
            if(s.getStudentName().equals(name)){
                theStudent = s;
                studentFound = true;
            }
        }
        if (studentFound==false){
            reader.display("Student Not Found, Please Try Again\n");
            return;
        }


        reader.display("Enter Course Name: ");
        String className = reader.getKeyboardInput();
        reader.display("Enter Course Number: ");
        String classNum = reader.getKeyboardInput();
        reader.display("Enter Section Number: ");
        int secNum = reader.getKeyboardInteger();

        Course theCourse = cat.searchCat(className, classNum);
        if(theCourse==null){
            System.out.println("Error, course not found");
            return;
        }

        CourseOffering theCourseOffering = theCourse.getCourseOffering(secNum);
        if(theCourseOffering==null){
            System.out.println("Invalid Course Section provided");
            return;
        }

        // will either add or delete, based on deleteReg parameter in method call
        Registration reg = new Registration(theStudent, theCourseOffering, deleteReg);


    }


    private void viewCoursesForStudent() {
        reader.display("Please Enter Students Name:");
        String name = reader.getKeyboardInput();
        for(Student s: students){
            if(s.getStudentName().equals(name)){
                System.out.println(s.courseListAsString());
            }
        }
    }

    public static void main(String[] args) {
        var x = new FrontEnd();
        x.mainMenu();
    }


}
