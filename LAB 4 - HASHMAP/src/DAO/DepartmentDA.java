package DAO;
import domain.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class DepartmentDA {

    private HashMap<String, Employee> employeeMap;
    public DepartmentDA() throws FileNotFoundException {

        Scanner departmentFile = new Scanner (new FileReader("C:\\Users\\User\\IdeaProjects\\OOP - LAB 4 - HASHMAP\\src\\dep.csv"));

        departmentFile.nextLine();

        while(departmentFile.hasNext()){

            employeeMap = new HashMap<>();

            String rowDeptInfo = departmentFile.nextLine();

            String[] rowDeptInfoSpecific = new String [3];
            rowDeptInfoSpecific = rowDeptInfo.split(",");

            Department department = new Department();
            department.setDepCode(rowDeptInfoSpecific[0].trim());
            department.setDepName(rowDeptInfoSpecific[1].trim());

            readDepEmp(department);
            printDepartment(department);
        }
    }

    public void printDepartment(Department department){
        System.out.println("Department code: " + department.getDepCode());
        System.out.println("Department name: " + department.getDepName());
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        System.out.println("Department total salary: " + decimalFormat.format(department.getDepTotalSalary()));
        System.out.println("---------------------Details -------------------------");
        System.out.println("EmpNo\t\t Employee Name\t\t\t\t\t Salary");

        for (Map.Entry<String, Employee> entry : department.getEmployeeMap().entrySet()) {
            String empNo = entry.getValue().getEmpNo();
            String fullName = entry.getValue().getLastName() + ", " + entry.getValue().getFirstName();

            System.out.printf("%-8s\t %-30s\t %-8s\n", empNo, fullName, decimalFormat.format(entry.getValue().getSalary()));
        }
        System.out.println();
        System.out.println();
    }

    public void readDepEmp(Department department) throws FileNotFoundException {

        Scanner departmentEmpFile = new Scanner(new FileReader("C:\\Users\\User\\IdeaProjects\\OOP - LAB 4 - HASHMAP\\src\\deptemp.csv"));
        departmentEmpFile.nextLine();

        Double totalSalary = 0.0;
        Integer key = 0;

        while(departmentEmpFile.hasNext()) {

            String rowDeptEmpInfo = departmentEmpFile.nextLine();

            String[] rowDeptEmpInfoSpecific = new String[3];
            rowDeptEmpInfoSpecific = rowDeptEmpInfo.split(",");

            if(department.getDepCode().equals(rowDeptEmpInfoSpecific[0].trim())) {

                String empNo = rowDeptEmpInfoSpecific[1].trim();

                EmployeeDA employeeDA = new EmployeeDA(empNo);

                employeeMap.put(empNo+key, employeeDA.getEmployee());

                Employee employee = new Employee();
                employee = employeeDA.getEmployee();

                employee.setSalary(Double.parseDouble(rowDeptEmpInfoSpecific[2].trim()));

                totalSalary = totalSalary + employee.getSalary();
                key++;
            }
        }
            department.setEmployeeMap(employeeMap);
            department.setDepTotalSalary(totalSalary);
    }
}
