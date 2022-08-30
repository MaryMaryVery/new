package org.itstep.helloworldspring;


import org.aspectj.apache.bcel.classfile.InnerClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {
    @Autowired
    DogRepository DogRepository;

    public List<Dog> findAll(){
        return DogRepository.findAll();
    }

    public Optional<Dog> findById(Integer Dog_Id){
        return  DogRepository.findById(Integer.valueOf(Dog_Id));
    }

    public Dog save(Dog Dog){return DogRepository.save(Dog);}

    public void deleteById(Integer Dog_Id){
        DogRepository.deleteById(Integer.valueOf(Dog_Id));
    }
}
