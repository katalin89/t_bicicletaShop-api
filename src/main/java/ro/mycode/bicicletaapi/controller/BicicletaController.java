package ro.mycode.bicicletaapi.controller;

import org.springframework.web.bind.annotation.*;
import ro.mycode.bicicletaapi.dtos.BicicletaDTO;
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

        return  bicicleta;
    }

    @DeleteMapping("api/v1/deleteByMarca/{marca}")
    public String deleteBicicleta(@PathVariable String marca){
        this.bicicletaRepo.deleteBicicletaByMarca(marca);

        return marca;
    }

    @DeleteMapping("api/v1/delete/{id}")
    public  long deleteById(@PathVariable long id){
        this.bicicletaRepo.deleteById((id));

        return id;
    }

    @PutMapping("api/v1/update")
    public Bicicleta updateBicicleta(@RequestBody BicicletaDTO bicicleta){
        Bicicleta b=bicicletaRepo.findByModel((bicicleta.getModel()));

        if(bicicleta.getPret()!=0){
            b.setPret(bicicleta.getPret());
        }else System.out.println("Nu are valoare");
        if(bicicleta.getCuloare().equals("")==false){
            b.setCuloare(bicicleta.getCuloare());
        }else System.out.println("Nu are valoare");

        if(bicicleta.getModel().equals("")==false){
            b.setModel(bicicleta.getModel());
        }else System.out.println("Nu are valoare");

        if (bicicleta.getMarca().equals("")==false){
            b.setMarca(bicicleta.getMarca());
        }else System.out.println("Nu are valoare");

        return b;

    }

    @GetMapping("api/v1/get/bicicleta/{id}")
    public Bicicleta getBicicletaById(@PathVariable int id){
        return bicicletaRepo.findById(Long.valueOf(id)).get();
    }

    @GetMapping("api/v1/sortByColor")
    public List<Bicicleta>sortByColor(){
        return bicicletaRepo.sortByColor();
    }
    @GetMapping("api/v1/sortByMarca")
    public List<Bicicleta>sortByMarca(){
        return bicicletaRepo.sortByMarca();
    }

   @GetMapping("api/v1/sortByModel")
    public List<Bicicleta>sortByModel(){
        return bicicletaRepo.sortByModel();
   }

   @GetMapping("api/v1/sortByPrice")
    public List<Bicicleta>sortByPrice(){
        return bicicletaRepo.sortByPret();
   }

}

