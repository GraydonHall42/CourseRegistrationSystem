package registrationSystem;

import java.util.Map;

public class CourseCatalogue {

    // dictionary to hold courses. Key= course Name+number, value=course object
    private Map<String, Course> courseList;

    public Map<String, Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course course) {
        this.courseList.put(course.toString(), course);
    }

}
