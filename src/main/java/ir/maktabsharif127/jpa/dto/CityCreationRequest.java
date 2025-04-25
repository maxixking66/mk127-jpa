package ir.maktabsharif127.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CityCreationRequest implements Serializable {

    private String name;

    private Long provinceId;
}
