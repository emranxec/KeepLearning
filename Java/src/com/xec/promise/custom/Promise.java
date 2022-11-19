package com.xec.promise.custom;

import java.util.function.Consumer;
import java.util.function.Function;

public interface Promise<T>{
   /* Promise<T> then(Consumer<T> handler);

    <U> Promise<U> thenApply(Function<T, U> handler);*/

    <U> Promise<U> thenApply(Function<T, U> handler);

    Promise<Void> thenAccept(Consumer<T> consumer);

}
