package ir.maktabsharif127.jpa;

import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class JpaApplication {

    @SneakyThrows
    public static void main(String[] args) {

//        writeDataToChannel();
        readDataFromChannel();

    }

    @SneakyThrows
    private static void readDataFromChannel() {
        try (FileChannel fileChannel = FileChannel.open(
                Path.of("note-nio.txt"),
                StandardOpenOption.READ
        )) {

            ByteBuffer byteBuffer = ByteBuffer.allocate((int) fileChannel.size());
            fileChannel.read(byteBuffer);

            byteBuffer.flip();

            byte[] fileData = new byte[byteBuffer.remaining()];
            byteBuffer.get(fileData);
            System.out.println(
                    new String(fileData, StandardCharsets.UTF_8)
            );

        }
    }

    private static void writeDataToChannel() throws IOException {
        try (FileChannel fileChannel = FileChannel.open(
                Path.of("note-nio.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE)) {

            ByteBuffer byteBuffer = ByteBuffer.wrap(
                    "Mohsen Asgari".getBytes(StandardCharsets.UTF_8)
            );

            fileChannel.write(byteBuffer);

        }
    }
}
