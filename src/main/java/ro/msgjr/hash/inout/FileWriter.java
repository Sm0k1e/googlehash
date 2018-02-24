package ro.msgjr.hash.inout;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileWriter {

    private static String path;

    public FileWriter(String fileName, String out) {
        path = "src/main/resources/" + fileName + ".out";
        writeFile(out);
    }

    private void writeFile(String out){
        try {
            Files.write(Paths.get(path),out.getBytes());
        }catch(IOException e){
            System.out.println("\n\nWrong Path!\n\n");
        }
    }
}
