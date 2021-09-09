package registrationSystem;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Registration> registrations;
    private CourseCatalogue courseList;

    public void addRegistration(Registration registration) {
        this.registrations.add(registration);
    }
}
