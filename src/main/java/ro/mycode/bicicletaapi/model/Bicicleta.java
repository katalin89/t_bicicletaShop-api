package ro.mycode.bicicletaapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bicicleta")
@AllArgsConstructor
@NoArgsConstructor

public class Bicicleta implements Comparable<Bicicleta> {

}
