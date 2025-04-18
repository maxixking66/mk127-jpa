package ir.maktabsharif127.jpa.domains;

import ir.maktabsharif127.jpa.domains.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = City.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@ToString
public class City extends BaseEntity<Long> {

    public static final String TABLE_NAME = "city";

    public static final String NAME = "name";

    @Column(name = NAME)
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Province province;
}
