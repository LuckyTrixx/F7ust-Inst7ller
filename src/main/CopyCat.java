package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyCat {
    public void faustInTheCraddle(String cdDrive, String dest, String lang, PrettyLauncher launch) {

        Path sourceData = Paths.get(cdDrive + "data");
        Path destData = Paths.get(dest + "/data");
        Path destRoot = Paths.get(dest);
        try {
            launch.setProgresstext("Copy Data-folder");
            copyDir(sourceData, destData, launch);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Path sourceDataAmes_ini = Paths.get(cdDrive + "ames.ini");
        try {
            launch.setProgresstext("Copy ames.ini");
            Files.copy(sourceDataAmes_ini, Paths.get(dest + "\\ames.ini"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        launch.fill();
        
        Path sourceaObj_ini = Paths.get(cdDrive + "aObj.ini");
        try {
            launch.setProgresstext("Copy aObj.ini");
            Files.copy(sourceaObj_ini, Paths.get(dest + "\\aObj.ini"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        launch.fill();
        
        Path sourcearxin3_fon = Paths.get(cdDrive + "arxrin3.fon");
        try {
            launch.setProgresstext("Copy arxrin3.font");
            Files.copy(sourcearxin3_fon, Paths.get(dest + "\\arxrin3.fon"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        launch.fill();
        
        Path sourceFaust16_exe = Paths.get(cdDrive + "faust16.exe");
        try {
            launch.setProgresstext("Copy faust16.exe");
            Files.copy(sourceFaust16_exe, Paths.get(dest + "\\faust16.exe"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Path sourceFaust_exe = Paths.get(cdDrive + "faust.exe");
        try {
            launch.setProgresstext("Copy faust.exei");
            Files.copy(sourceFaust_exe, Paths.get(dest + "\\faust.exe"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Path sourceMmxImage_dll = Paths.get(cdDrive + "mmxImage.dll");
        try {
            launch.setProgresstext("Copy mmxImage.dll");
            Files.copy(sourceMmxImage_dll, Paths.get(dest + "\\mmxImage.dll"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        switch (lang) {
        case "English":
            launch.setProgresstext("Copy sy.at3");
            copySysat3(cdDrive + "data\\eng", dest + "\\data\\sy.at3");
            break;
        case "Deutsch":
            launch.setProgresstext("Copy sy.at3");
            copySysat3(cdDrive + "data\\ger", dest + "\\data\\sy.at3");
            break;
        }
    }

    public void copyDir(Path src, Path dest, PrettyLauncher launch) throws IOException {
        Files.walk(src).forEach(source -> {
            try {
                Files.copy(source, dest.resolve(src.relativize(source)), StandardCopyOption.REPLACE_EXISTING);
                launch.fill();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void copySysat3(String source, String dest) {
        Path sys3 = Paths.get(source + "\\sy.at3");
        try {
            Files.copy(sys3, Paths.get(dest));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
