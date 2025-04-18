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
@Table(name = Province.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Province extends BaseEntity<Long> {

    public static final String TABLE_NAME = "province";

    public static final String NAME = "name";
    public static final String PRE_CODE = "pre_code";

    @Column(name = NAME)
    private String name;

    @Column(name = PRE_CODE)
    private String preCode;
}
