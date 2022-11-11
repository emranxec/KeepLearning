package com.xec;

import com.xec.fruitShop.FruitBuilder;

import java.util.function.Supplier;

class LazyProxy<T> {
    private T instance;
    private Supplier<T> supplier;

    public LazyProxy(Supplier<T> theSupplier) {
        supplier = theSupplier;
    }


    public T get() {
        System.out.println("get method called");
        if (instance == null) {
            instance = supplier.get();
            supplier = null;
        }
        return instance;
    }
}

public class testLazyProxy{
    public static void main(String[] args) {
        FruitBuilder fruitBuilder = new FruitBuilder();
        proxyPatternJava8(fruitBuilder);
    }


    public static void proxyPatternJava8(FruitBuilder fruitBuilder) {
        var isAvailable = new LazyProxy<>(() -> {
            boolean isFruitsAvailable = false;
            try {
                System.out.println("Lazy called");
                isFruitsAvailable = fruitBuilder.displayAvailableFruits(a -> true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return isFruitsAvailable;
        });

        boolean isFruitsInit= fruitBuilder!=null && fruitBuilder.getFruits()!=null && !fruitBuilder.getFruits().isEmpty();
         System.out.println("proxyPattern is triggered");
        if (isFruitsInit && isAvailable.get()) {
            System.out.println(" is fine" + isAvailable.get());
        } else {

            System.out.println("something is missing check proxyPattern ");
        }
    }
}
