package dao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import domain.*;

public class BlockSectionDA {

    public BlockSectionDA() throws FileNotFoundException {

        BlockSection blockSection = new BlockSection();

        Scanner blockSectionCsv = new Scanner(new FileReader("src/blockSection.csv"));

        String outputPrinter = "";

        String rowBlockSection = new String();

        outputPrinter += "\nNoriel Achero | 2 BSCS 1 | OOP Laboratory 2\n";

        outputPrinter += "COM Report Version 2\n\n";


        while(blockSectionCsv.hasNext()) {

            rowBlockSection = blockSectionCsv.nextLine();

            String[] rowBlockSectionSpecific = new String[3];
            rowBlockSectionSpecific = rowBlockSection.split(",");

            blockSection.setBlockCode(rowBlockSectionSpecific[0].trim());
            blockSection.setDescription(rowBlockSectionSpecific[1].trim());
            blockSection.setAdviser(rowBlockSectionSpecific[2].trim());

            outputPrinter += "**************************************************************************************\n";
            outputPrinter += "Block Section Code: " + blockSection.getBlockCode();
            outputPrinter += "\nDescription: " + blockSection.getDescription();
            outputPrinter += "\nAdviser: " + blockSection.getAdviser();

            StudentDA studentDA = new StudentDA();

            blockSection.setStudentList(studentDA.getStudentList());

            Integer counter = 0;
            for(Student student: blockSection.getStudentList()){
                if (Objects.equals(student.getBlockCode(), blockSection.getBlockCode())){
                    counter++;
                    }
                }
            outputPrinter += "\nTotal Students: " + counter + "\n";
            counter = 0;


            for(Student student: blockSection.getStudentList()){
                if (Objects.equals(student.getBlockCode(), blockSection.getBlockCode())){
                    outputPrinter += "\nStudent Number: " + student.getStudentNumber();
                    outputPrinter += "\nName: " + student.getName();
                    outputPrinter += "\nProgram: " + student.getProgram();


                    Integer totalUnits = 0;
                    for(Course course: student.getCourseList()){
                        totalUnits = totalUnits + course.getUnit();
                    }
                    outputPrinter += "\nTotal Units: " + totalUnits + "\n";
                    totalUnits = 0;


                    outputPrinter += "\nCourse Code\t\t\tDescription\t\t\t\t\t\tUnits\tDay\t\tTime\n";

                    for(Course course: student.getCourseList()){
                        outputPrinter += course.getCourseCode() + "\t\t\t";
                        outputPrinter += course.getDescription() + "\t\t\t";
                        outputPrinter += course.getUnit() + "\t\t";
                        outputPrinter += course.getDay() + "\t\t";
                        outputPrinter += course.getTime() + "\n";
                    }
                    outputPrinter += "\n";
                }


            }
            outputPrinter += "\n";
        }

        System.out.println(outputPrinter);

    }

}
