package com.xec.spring.autowired;

import org.springframework.stereotype.Service;

@Service
public class Dog implements Animal{

    @Override
    public String charateristics() {
        return "Bow bow";
    }
}
