package ir.maktabsharif127.jpa.designpatters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Prototype<User> {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String mobileNumber;
    private String email;
    private String nationalCode;

    public User(User user) {
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.username = user.username;
        this.password = user.password;
        this.mobileNumber = user.mobileNumber;
        this.email = user.email;
        this.nationalCode = user.nationalCode;
    }

    @Override
    public User clone() {
        return new User(this);
    }
}
