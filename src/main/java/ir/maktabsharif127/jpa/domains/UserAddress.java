package ir.maktabsharif127.jpa.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Embeddable
@Setter
@Getter
@NoArgsConstructor
public class UserAddress implements Serializable {

    public static final String POSTAL_CODE = "postal_code";

    @Column
    private String address;

    @Column(name = POSTAL_CODE)
    private String postalCode;

}
