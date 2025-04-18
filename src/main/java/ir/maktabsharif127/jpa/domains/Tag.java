package ir.maktabsharif127.jpa.domains;

import ir.maktabsharif127.jpa.domains.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = Tag.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Tag extends BaseEntity<Long> {

    public static final String TABLE_NAME = "tb_tag";

    public static final String NAME = "name";
    public static final String IS_ACTIVE = "is_active";

    //    alter table tb_tab add column name varchar
    @Column(name = NAME, columnDefinition = "VARCHAR", nullable = false, unique = true)
    private String name;

    @Column(name = IS_ACTIVE)
    private Boolean isActive;

    @Transient
    private String myField;
}
