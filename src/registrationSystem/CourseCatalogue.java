package registrationSystem;

import java.util.Map;

public class CourseCatalogue {
    private Map<String, Course> courseList;

    public Map<String, Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course course) {
        this.courseList.put(course.toString(), course);
    }

}
