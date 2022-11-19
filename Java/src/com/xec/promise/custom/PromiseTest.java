package com.xec.promise.custom;

import java.util.concurrent.CompletableFuture;

public class PromiseTest {

    public static void main(String[] args) {
        Promise<String> stringPromise = new PromiseImpl<>(new CompletableFuture<>());
        Promise<Long> longPromise = stringPromise.thenApply(str -> Long.valueOf(str.length()));
        Promise<Void> voidPromise = stringPromise.thenAccept(System.out::println);
    }
}
