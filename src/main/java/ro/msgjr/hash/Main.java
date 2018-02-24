package ro.msgjr.hash;

import ro.msgjr.hash.inout.FileReader;
import ro.msgjr.hash.inout.FileWriter;

import java.util.List;

public class Main {
    private static final String fileName = "example";

    public static void main(String... args){
        // Read file
        FileReader fileReader = new FileReader(fileName);
        List<String> rows = fileReader.getRows();
        //////////////////////////////////////////////////////////
        ////////////////////  CODE  //////////////////////////////
        //////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////////
        // Write result
        new FileWriter(fileName,rows.toString());
    }
}
