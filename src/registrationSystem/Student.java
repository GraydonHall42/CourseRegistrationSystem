package registrationSystem;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Registration> registrations;

    // dictionary holding all the courses and their listing
    private CourseCatalogue courseList;

    // later: could add method so CourseCatalogue gets used.
    // specify Course Full Name (key in Course Catalogue) and instructor
    // use this to get specific course offering
    // and then create registration using this.
    // add registration to registrations ArrayList

    public void addRegistration(Registration registration) {
        this.registrations.add(registration);
    }
}
