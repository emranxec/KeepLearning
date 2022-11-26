package com.xec.spring.autowired;

import org.springframework.stereotype.Service;

@Service
public class Cat implements Animal{
    @Override
    public String charateristics() {
        return "meaw";
    }
}
