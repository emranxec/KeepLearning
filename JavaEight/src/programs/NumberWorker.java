package programs;

@FunctionalInterface
public interface NumberWorker<T> {

    T compute(T t);
}
