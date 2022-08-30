package org.itstep.helloworldspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    org.itstep.helloworldspring.OwnerRepository OwnerRepository;

    public List<Owner> findAll(){
        return OwnerRepository.findAll();
    }

    public Optional<Owner> findById(Long Owner_id){
        return OwnerRepository.findById(Owner_id);
    }

    public Owner save(Owner Owner){return OwnerRepository.save(Owner);}

    public void deleteById(Long Owner_id){
        OwnerRepository.deleteById(Owner_id);
    }
}
