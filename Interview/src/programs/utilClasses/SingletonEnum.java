package programs.utilClasses;

/**
 * To overcome above issue we can use enum also, as this guarantees singleton-ness of the object and return the same instance always.
 */
enum SingletonEnum {
    INSTANCE;
}
