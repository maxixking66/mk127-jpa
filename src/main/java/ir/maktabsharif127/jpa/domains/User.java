package ir.maktabsharif127.jpa.domains;

import ir.maktabsharif127.jpa.domains.base.BaseEntity;
import ir.maktabsharif127.jpa.domains.enumerations.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = User.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@ToString
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends BaseEntity<Long> {

    public static final String TABLE_NAME = "users";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String USER_TYPE = "user_type";

    @Column(name = FIRST_NAME)
    private String firstName;

    @Column(name = LAST_NAME)
    private String lastName;

    @Column(name = USERNAME)
    private String username;

    @Column(name = PASSWORD)
    private String password;

    @Column(name = USER_TYPE)
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
