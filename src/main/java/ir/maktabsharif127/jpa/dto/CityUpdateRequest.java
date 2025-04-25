package ir.maktabsharif127.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CityUpdateRequest extends CityCreationRequest {

    private Long id;
}
