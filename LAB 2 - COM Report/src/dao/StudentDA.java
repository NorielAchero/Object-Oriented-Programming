package dao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import domain.*;

public class StudentDA {

    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentDA() throws FileNotFoundException {
        Scanner studentInfo = new Scanner(new FileReader("src/studentInfo.csv"));
        String rowStudent = new String();

        studentList = new ArrayList<Student>();

        while(studentInfo.hasNext()){

            Student student = new Student();

            rowStudent = studentInfo.nextLine();

            String[] rowStudentSpecific = new String[4];
            rowStudentSpecific = rowStudent.split(",");

            student.setBlockCode(rowStudentSpecific[0]);
            student.setStudentNumber(rowStudentSpecific[1].trim());
            student.setName(rowStudentSpecific[2].trim());
            student.setProgram(rowStudentSpecific[3].trim());


            CourseDA courseDA = new CourseDA(student.getStudentNumber());

            student.setCourseList(courseDA.getCourseList());

            studentList.add(student);
        }
    }
}
