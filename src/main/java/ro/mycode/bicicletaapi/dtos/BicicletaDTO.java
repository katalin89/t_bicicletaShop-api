package ro.mycode.bicicletaapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BicicletaDTO {
    private String marca="";
    private String model="";
    private String culoare="";
    private int pret=0;

}
