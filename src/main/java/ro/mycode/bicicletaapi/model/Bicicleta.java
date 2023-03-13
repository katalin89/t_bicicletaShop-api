package ro.mycode.bicicletaapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Bicicleta")
@Table(name = "biciclete")


public class Bicicleta implements Comparable<Bicicleta> {
    @Id
    @SequenceGenerator(name="bicicleta_seqience",sequenceName = "bicicleta_sequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator ="bicicleta_seqience")

    private Long id;

    @Column(name="marca",nullable = false)
    @Size(min=4,message="Marca trebuie sa fie min 4 caractere")
    private String marca;

    @Column(name="model",nullable = false)
    @Size(max=20,message = "Nu poate fi mai lung de 20 de caractere")
    private String model;

    @Column(name="culoare",nullable = false)
    @Size(min=3,message="Trebuie sa fie min3 caractere")
    private  String culoare;

    @Column
    @Min(value = 2000,message = "Pretul este minim 2000 lei")
    private int pret;


    @Override
    public int compareTo(Bicicleta o) {
        if(this.model.compareTo(o.model)>0){
            return  1;
        }
        if(this.model.compareTo(o.model)<0)

            return -1;
        else
        return 0;
    }

    @Override
    public  boolean equals(Object o){
        Bicicleta bicicleta=(Bicicleta) o;
        return  this.model.equals(bicicleta.model);
    }
}
