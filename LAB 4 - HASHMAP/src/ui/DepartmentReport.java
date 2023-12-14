package ui;

import DAO.DepartmentDA;

import java.io.FileNotFoundException;

public class DepartmentReport {

    public static void main(String[] args) throws FileNotFoundException {
        new DepartmentReport();
    }

    public DepartmentReport() throws FileNotFoundException {
        DepartmentDA departmentDA = new DepartmentDA();
    }

}


