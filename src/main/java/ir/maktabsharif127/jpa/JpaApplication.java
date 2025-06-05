package ir.maktabsharif127.jpa;

import lombok.*;

import java.io.*;

public class JpaApplication {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        writePersonObjectToFile();
        readPersonObjectFromFile();

    }

    private static void writePersonObjectToFile() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("note.txt")) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {
                outputStream.writeObject(
                        Person.builder()
                                .firstName("mohsen")
                                .lastName("asgari")
                                .build()
                );
            }
        }
    }

    private static void readPersonObjectFromFile() throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream("note.txt")) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                Person person = (Person) objectInputStream.readObject();
                System.out.println("FirstName: " + person.getFirstName());
                System.out.println("LastName: " + person.getLastName());
                System.out.println(person);
            }
        }
    }
}


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
class Person implements Serializable {

    private static final long serialVersionUID = -1L;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String mobileNumber;
}
