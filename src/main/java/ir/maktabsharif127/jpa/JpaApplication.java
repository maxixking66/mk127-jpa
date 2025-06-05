package ir.maktabsharif127.jpa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JpaApplication {
    public static void main(String[] args) throws IOException {

        try (FileOutputStream outputStream = new FileOutputStream("note-4.txt")) {
            outputStream.write(
                    "Mohsen Asgari\nMat".getBytes(StandardCharsets.UTF_8)
            );
        }

        try (FileInputStream inputStream = new FileInputStream("note-4.txt")) {
            System.out.println(
                    new String(inputStream.readAllBytes(), StandardCharsets.UTF_8)
            );
        }

    }
}
