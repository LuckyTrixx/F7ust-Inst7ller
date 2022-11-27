package main;

import java.io.FileWriter;
import java.io.IOException;

public class CdDriveFixer {
    public void fix(String drive, String dest, String lang) throws IOException {
        String language = "";
        switch (lang) {
            case "English": language = "ENG";
            break;
            case "Deutsch": language = "GER";
            break;
        }
        FileWriter fw = new FileWriter(dest + "\\fl.ini");
        fw.write("17" + System.lineSeparator());
        fw.write("CDPATH: " + drive + System.lineSeparator());
        fw.write("LANGUAGE: " + language + System.lineSeparator());
        fw.write("CHECKCD:           1" + System.lineSeparator());
        fw.write("SOUNDCHUNCK_BGRMUS:  9" + System.lineSeparator());
        fw.write("LOADFROM_BGRMUS:     2" + System.lineSeparator());
        fw.write("SOUNDCHUNCK_AMBMUS:  9" + System.lineSeparator());
        fw.write("LOADFROM_AMBMUS:     2" + System.lineSeparator());
        fw.write("SOUNDCHUNCK_AMBEFE:  9" + System.lineSeparator());
        fw.write("LOADFROM_AMBEFE:     2" + System.lineSeparator());
        fw.write("SOUNDCHUNCK_EFE:     9" + System.lineSeparator());
        fw.write("LOADFROM_EFE:        2" + System.lineSeparator());
        fw.write("SOUNDCHUNCK_DIA:     9" + System.lineSeparator());
        fw.write("LOADFROM_DIA:        2" + System.lineSeparator());
        fw.write("ART_BAG:             1" + System.lineSeparator());
        fw.write("ART_CURSOR:          1" + System.lineSeparator());
        fw.write("ART_SY:              1" + System.lineSeparator());
        fw.write("CHECKLOADSAVE:             1");
        
        

        fw.close();
    }
}
