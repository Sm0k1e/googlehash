package ro.msgjr.hash.inout;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private List<String> rows;
    private String path;

    public FileReader(String fileName) {
        this.rows = new ArrayList<>();
        this.path = "src/main/resources/" + fileName + ".in";
        readFile();
    }

    private void readFile() {
        try {
            Files.lines(Paths.get(path)).forEach(e -> rows.add(e));
        } catch (IOException e) {
            System.out.println("\n\nWrong Path");
        }
    }

    public List<String> getRows() {
        return rows;
    }
}
