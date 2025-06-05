package ir.maktabsharif127.jpa;

import java.io.File;
import java.io.IOException;

public class JpaApplication {
    public static void main(String[] args) throws IOException {

        useFileClass();

    }

    private static void useFileClass() throws IOException {
        File file = new File("note.txt");
        System.out.println("exists(): " + file.exists());
        System.out.println("getPath(): " + file.getPath());
        System.out.println("getAbsolutePath(): " + file.getAbsolutePath());
        System.out.println("createNewFile(): " + file.createNewFile());
        System.out.println("exists(): " + file.exists());
    }
}
