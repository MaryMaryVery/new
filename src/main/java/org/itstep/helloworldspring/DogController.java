package org.itstep.helloworldspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("api")
public class DogController {
    @Autowired
    DogService DogService;

    @GetMapping(value="/Dog")
    public List<Dog> findAll(){
        return DogService.findAll();
    }

    @GetMapping(value="/Dog/{id}")
    public Optional<Dog> findById(@PathVariable Integer Dog_Id){
        return DogService.findById(Dog_Id);
    }

    @PostMapping(value="/Dog")
    Dog createOrSave(@RequestBody Dog Dog) {
        return
                DogService.save
                        (Dog);
    }

    @PutMapping(value="/Dog/{id}")
    Dog update(@RequestBody Dog newDog, @PathVariable Integer Dog_Id) {
        return DogService.findById(Dog_Id).map(Dog -> {
            Dog.setNickname(newDog.getNickname());


            ;return DogService.save (Dog);
        }).orElse(null);
    }

    @DeleteMapping(value="/Dog/{id}")
    void deleteById(@PathVariable Integer id) {
        DogService.deleteById(id);
        System.out.println("delete");
    }
}

