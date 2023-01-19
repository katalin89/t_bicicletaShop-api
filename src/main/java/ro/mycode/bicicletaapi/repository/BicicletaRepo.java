package ro.mycode.bicicletaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.bicicletaapi.model.Bicicleta;

import java.util.List;

@Repository
public interface BicicletaRepo  extends JpaRepository<Bicicleta,Long> {
    @Query("select  distinct  p.marca from Bicicleta  p")
    List<String>getAllMarci();

    @Query("select  b  from Bicicleta  b where b.marca=?1")

    List<Bicicleta>getAllBicicletaByMarca(String marca);
}


