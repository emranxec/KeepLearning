package programs.utilClasses;

@FunctionalInterface
public interface NumberWorker<T> {

    T compute(T t);
}
