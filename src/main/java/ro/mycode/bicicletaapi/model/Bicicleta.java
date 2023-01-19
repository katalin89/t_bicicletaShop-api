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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id

    public int id;
    public String marca;
    public String model;
    public String culoare;
    public int pret;

    @Override
    public String toString() {
        String text = "";
        text += id + "," + marca + "," + model + "," + culoare + "," + pret;
        return text;
    }

    public  int compare(Object o){
        Bicicleta bicicleta=(Bicicleta) o;
        if(this.pret>bicicleta.pret){
            return  1;
        }else if(this.pret< bicicleta.pret){
            return 0;

        }
        return  -1;
    }

    @Override
    public int compareTo(Bicicleta o) {
        return 0;
    }
}
