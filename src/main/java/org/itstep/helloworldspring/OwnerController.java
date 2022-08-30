package org.itstep.helloworldspring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("api")
public class OwnerController {
    @Autowired
    OwnerService OwnerService;

    @GetMapping(value="/Owner")
    public List<Owner> findAll(){
        return OwnerService.findAll();
    }

    @GetMapping(value="/Owner/{id}")
    public Optional<Owner> findById(@PathVariable Long id){
        return OwnerService.findById(id);
    }

    @PostMapping(value="/Owner")
    Owner createOrSave(@RequestBody Owner Owner) {
        return
                OwnerService.save
                        (Owner);
    }

    @PutMapping(value="/Owner/{id}")
    Owner update(@RequestBody Owner newOwner, @PathVariable Long id) {
        return OwnerService.findById(id).map(Owner -> {
            Owner.setOwner_name(newOwner.getOwner_name());
            Owner.setPhone(newOwner.getPhone());
            Owner.setCity(newOwner.getCity());
            Owner.setPK_Owner(newOwner.getPK_Owner());
            return OwnerService.save (Owner);}).orElse(null);
    }

    @DeleteMapping(value="/Owner/{id}")
    void deleteById(@PathVariable Long id) {
        OwnerService.deleteById(id);
        System.out.println("delete");
    }
}

