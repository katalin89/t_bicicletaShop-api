package ro.mycode.bicicletaapi.controller;

import org.springframework.web.bind.annotation.*;
import ro.mycode.bicicletaapi.model.Bicicleta;
import ro.mycode.bicicletaapi.repository.BicicletaRepo;

import java.util.List;

@RestController
@CrossOrigin
public class BicicletaController {
    private BicicletaRepo bicicletaRepo;

    public BicicletaController(BicicletaRepo bicicletaRepo) {

        this.bicicletaRepo = bicicletaRepo;
    }
    @GetMapping("api/v1/biciclete")
    public List<Bicicleta>getAllBiciclete(){
        return  bicicletaRepo.findAll();
    }

    @GetMapping("api/v1/biciclete/marci")
    public List<String>getAllMarci(){
        return bicicletaRepo.getAllMarci();
    }

    @GetMapping("api/v1/biciclete/{marca}")

    List<Bicicleta>getAllBicicleteByMarca(@PathVariable String marca) {
        return bicicletaRepo.getAllBicicletaByMarca(marca);
    }

    @PostMapping("api/v1/add")
        public Bicicleta addBicicleta(@RequestBody Bicicleta bicicleta){
            this.bicicletaRepo.save(bicicleta);
            return bicicleta;
        }



}

/*    @PostMapping("api/v1/add")// asa vom face add in baza de date
    public  Masina  addCar(@RequestBody Masina masina){

        this.masinaRepo.save(masina);


        return  masina;
    }*/

