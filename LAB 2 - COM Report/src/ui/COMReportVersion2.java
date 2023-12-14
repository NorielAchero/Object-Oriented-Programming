package ui;

import dao.BlockSectionDA;
import domain.BlockSection;

import java.io.FileNotFoundException;

public class COMReportVersion2 {

    public COMReportVersion2() throws FileNotFoundException {

        BlockSectionDA blockSectionDA = new BlockSectionDA();

    }
    public static void main (String [] args) throws FileNotFoundException {

        new COMReportVersion2();

    }
}
