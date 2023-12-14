package DAO;
import domain.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EmployeeDA {
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDA(String empNo) throws FileNotFoundException {

        Scanner employeeFile = new Scanner(new FileReader("C:\\Users\\User\\IdeaProjects\\OOP - LAB 4 - HASHMAP\\src\\emp.csv"));
        employeeFile.nextLine();

        employee = new Employee();

       while(employeeFile.hasNext()){

           String rowEmployeeInfo = employeeFile.nextLine();

           String[] rowEmployeeInfoSpecific = new String[4];
           rowEmployeeInfoSpecific = rowEmployeeInfo.split(",");

           if(empNo.equals(rowEmployeeInfoSpecific[0])){
               employee.setEmpNo(rowEmployeeInfoSpecific[0].trim());
               employee.setLastName(rowEmployeeInfoSpecific[1].trim());
               employee.setFirstName(rowEmployeeInfoSpecific[2].trim());
           }
       }
    }
}
