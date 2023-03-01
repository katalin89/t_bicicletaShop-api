package ro.mycode.bicicletaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.bicicletaapi.model.Bicicleta;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BicicletaRepo  extends JpaRepository<Bicicleta,Long> {
    @Query("select  distinct  p.marca from Bicicleta  p")
    List<String>getAllMarci();

    @Query("select  b  from Bicicleta  b where b.marca=?1")
    List<Bicicleta>getAllBicicletaByMarca(String marca);

    @Transactional
    @Modifying
    @Query("delete from Bicicleta b  where  b.marca like ?1")
    void deleteBicicletaByMarca(String marca);

    @Transactional
    @Modifying
    @Query("delete  from Bicicleta b where b.id=?1")
    void deleteById(int id);

    Bicicleta findByModel(String model);

    @Transactional
    @Modifying
    @Query("select distinct b from Bicicleta  b order by b.pret")
    List<Bicicleta>sortByPret();

    @Transactional
    @Modifying
    @Query("select distinct b from Bicicleta b order by b.culoare")
    List<Bicicleta>sortByColor();

    @Transactional
    @Modifying
    @Query("select  distinct  b from Bicicleta  b order by  b.marca")
    List<Bicicleta>sortByMarca();

    @Transactional
    @Modifying
    @Query("select distinct  b from Bicicleta b order by b.model")
    List<Bicicleta>sortByModel();

}


