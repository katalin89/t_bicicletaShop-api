package ro.mycode.bicicletaapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
}

