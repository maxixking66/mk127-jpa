package ir.maktabsharif127.jpa;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JpaApplication {
    public static void main(String[] args) throws IOException {

//        createFileAndWriteOnToIt();
        readFile();
    }

    private static void readFile() throws IOException {
        File file = createFileIfNotExists("note.txt");
        try (FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8)) {
            int read = fileReader.read();
            while (read != -1) {
                System.out.print((char) read);
                read = fileReader.read();
            }
        }
    }

    private static void createFileAndWriteOnToIt() throws IOException {
        File file = createFileIfNotExists("note.txt");
        try (FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8, false)) {
            fileWriter.write("mohsen asgari\nmohsen asgari");
        }
    }

    private static File createFileIfNotExists(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new RuntimeException();
            }
        }
        return file;
    }
}
