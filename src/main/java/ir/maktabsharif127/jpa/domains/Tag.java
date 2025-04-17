package ir.maktabsharif127.jpa.domains;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = Tag.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Tag {

    public static final String TABLE_NAME = "tb_tag";

    public static final String NAME = "name";
    public static final String IS_ACTIVE = "is_active";

    @Id
    @SequenceGenerator(
            name = "my_tag_seq_gen",
            allocationSize = 5
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_tag_seq_gen")
    private Long id;

    //    alter table tb_tab add column name varchar
    @Column(name = NAME, columnDefinition = "VARCHAR", nullable = false, unique = true)
    private String name;

    @Column(name = IS_ACTIVE)
    private Boolean isActive;

    @OneToOne
    private Tag tag;

    @ManyToOne
    private Tag sTag;

    @OneToMany
    private Set<Tag> tags;

    @ManyToMany
    private Set<Tag> manyTags;
}
