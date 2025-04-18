package ir.maktabsharif127.jpa.domains;

import ir.maktabsharif127.jpa.domains.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = Address.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Address extends BaseEntity<Long> {

    public static final String TABLE_NAME = "address";

    public static final String ADDRESS = "address";
    public static final String POSTAL_CODE = "postal_code";

    @Column(name = ADDRESS, columnDefinition = "VARCHAR")
    private String address;

    @Column(name = POSTAL_CODE, length = 10)
    private String postalCode;
}
