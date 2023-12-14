package dao;

import domain.Course;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class CourseDA {

    private List<Course>courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public CourseDA(String studentNumber) throws FileNotFoundException {

        Scanner scheduleInfo = new Scanner(new FileReader("src/scheduleInfo.csv"));

        courseList = new ArrayList<Course>();

        while(scheduleInfo.hasNext()){

            String rowCourse = new String();
            String[] rowCourseSpecific = new String[6];
            Course course = new Course();

            rowCourse = scheduleInfo.nextLine();
            rowCourseSpecific = rowCourse.split(",");


            if(studentNumber.equals(rowCourseSpecific[0])){
                course.setCourseCode(rowCourseSpecific[1]);
                course.setDescription(rowCourseSpecific[2]);

                course.setUnit(Integer.parseInt((rowCourseSpecific[3])));
                course.setDay(rowCourseSpecific[4]);
                course.setTime(rowCourseSpecific[5]);

                courseList.add(course);
            }

        }


    }
}
