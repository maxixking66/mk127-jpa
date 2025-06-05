package ir.maktabsharif127.jpa;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class JpaApplication {
    public static void main(String[] args) throws IOException {

        Files.write(
                Path.of("note-2.txt"), "Mohsen Asgari\nAli alavi".getBytes(StandardCharsets.UTF_8)
        );

        Files.writeString(
                Path.of("note-3.txt"), "Mohsen Asgari\nAli alavi"
        );

    }
}
