package com.xec.fruitShop;

@FunctionalInterface
interface FruitCondition<T> {
    public boolean test(T t);
}
