package com.xec.enums;

public enum Learning {
    COLLECTIONS,REGULAR,EXCEPTION,ANNOTATION,STRING
}

class Demo{

    public static void main(String[] args) {

        Learning learn = Learning.COLLECTIONS;

        switch (learn) {

            case COLLECTIONS -> {
                System.out.println("COLLECTIONS");
            }
            case REGULAR -> {
                System.out.println("REGULAR");

            }
            case EXCEPTION -> {
                System.out.println("EXCEPTION");

            }
            case ANNOTATION -> {
                System.out.println("ANNOTATION");

            }
            case STRING -> {
                System.out.println("STRING");

            }
        }
        }
    }
