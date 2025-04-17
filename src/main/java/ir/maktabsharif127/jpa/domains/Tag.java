package ir.maktabsharif127.jpa.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Tag.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
public class Tag {

    public static final String TABLE_NAME = "tb_tag";

    public static final String NAME = "name";
    public static final String IS_ACTIVE = "is_active";

    @Id
    private Long id;

    //    alter table tb_tab add column name varchar
    @Column(name = NAME, columnDefinition = "VARCHAR", nullable = false, unique = true)
    private String name;

    @Column(name = IS_ACTIVE)
    private Boolean isActive;

}
