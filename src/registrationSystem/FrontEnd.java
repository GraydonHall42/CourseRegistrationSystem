package registrationSystem;


public class FrontEnd {

    private Student s1, s2, s3, s4;  // students we make for this assignment
    private CourseCatalogue cat;  // course catalogue
    private Student[] students;  // array to hold students
    private KeyboardReader reader;  // used to interact with user
    private String studentNamePrompt;
    
    // populate front end with generic students and courses
    public FrontEnd() {

        reader = new KeyboardReader();

        // 4 students that the user can choose from
        s1 = new Student("Jane", 1);
        s2 = new Student("Sam", 2);
        s3 = new Student("Joey", 3);
        s4 = new Student("Alex", 4);
        students = new Student[]{s1, s2, s3, s4};

        // just hardcode in students name to make it more friendly for user, and since we only have 4 students
        // to deal with. This prompt is displayed every time we ask someone to enter a student name.
        studentNamePrompt = "Please Enter Students Name (Jane, Sam, Joey, or Alex): ";

        // course catalogue
        cat = new CourseCatalogue();

    }

    // method to give main menu to user
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
//                    reader.display(cat.coursesAsString());  // if we want just course names, no sections
                    reader.display(cat.allCourseOfferingsAsString());  // if they want all sections to be seen
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

        Course theCourse = cat.searchCatalogue(className, classNum);
        if(theCourse==null){
            System.out.println("Error, course not found. Returning to main menu.");
            return;
        }

        reader.display("\n---The following Sections exist for this course---\n");
        System.out.println(theCourse.allOfferingsAsString());

    }

    // used to either Add or Delete a course based on Student Name, Course Name, Number, and section number
    // if deleteReg=True, the registration is deleted for the student
    // if deleteReg=False, the registration is added for the student
    private void modifyStudentCourses(boolean deleteReg) {
        Student theStudent = null;
        boolean studentFound = false;

        while(!studentFound){
            reader.display(studentNamePrompt);
            String name = reader.getKeyboardInput();
            for(Student s: students){
                if(s.getStudentName().equals(name)){
                    theStudent = s;
                    studentFound = true;
                    break;
                }
            }
            if(!studentFound)
                reader.display("Student Not Found, Please Try Again\n");
        }

        reader.display("Enter Course Name: ");
        String className = reader.getKeyboardInput();
        reader.display("Enter Course Number: ");
        String classNum = reader.getKeyboardInput();


        int secNum = 0;
        while(true){
            try{
                reader.display("Enter Section Number: ");
                secNum = reader.getKeyboardInteger();
                break;  // will get here if no error occurs
            } catch (Exception e){
                System.out.println("Invalid Entry, please enter an integer");
            }
        }


        Course theCourse = cat.searchCatalogue(className, classNum);
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
        Student theStudent = null;
        boolean studentFound = false;
        while(true){
            reader.display(studentNamePrompt);
            String name = reader.getKeyboardInput();
            for(Student s: students){
                if(s.getStudentName().equals(name)){
                    System.out.println("\nCourse List for " + name + ":");
                    System.out.println(s.courseListAsString());
                    studentFound = true;
                    return;
                }
            }
            reader.display("Student Not Found, Please Try Again\n");
        }
    }

    public static void main(String[] args) {
        var x = new FrontEnd();
        x.mainMenu();
    }

    public void testProgram() {

        // 3 courses from catalogue
        Course c1 = cat.searchCatalogue("ENGG", "233");
        Course c2 = cat.searchCatalogue("PHYS", "259");
        Course c3 = cat.searchCatalogue("ENSF", "607");

        // 1 course offerings from each course
        CourseOffering co1 = c1.getCourseOffering(1);
        CourseOffering co2 = c2.getCourseOffering(1);
        CourseOffering co3 = c3.getCourseOffering(1);
        CourseOffering[] courseOfferings = new CourseOffering[]{co1, co2, co3};

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


}
