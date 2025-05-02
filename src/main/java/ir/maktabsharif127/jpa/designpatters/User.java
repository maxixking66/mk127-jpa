package ir.maktabsharif127.jpa.designpatters;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Builder
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String username;
        private String password;
        private String mobileNumber;
        private String email;
        private String nationalCode;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder nationalCode(String nationalCode) {
            this.nationalCode = nationalCode;
            return this;
        }

        public User build() {
            return new User(
                    this.firstName, this.lastName, this.username,
                    this.password, this.mobileNumber,
                    this.email, this.nationalCode
            );
        }

    }
}

