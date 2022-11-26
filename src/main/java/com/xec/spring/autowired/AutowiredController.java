package com.xec.spring.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autowire")
public class AutowiredController {


    public Animal animal;
    @Autowired
    AutowiredController(@Qualifier("cat") Animal animal){
        this.animal=animal;
    }
   @Autowired(required = false)
    public void setAnimal(@Qualifier("dog") Animal animal) {
        this.animal = animal;
    }

    @GetMapping
    public String fetchCharacteristics(){
        return animal.charateristics();
    }
}
