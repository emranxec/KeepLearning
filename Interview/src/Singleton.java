import java.io.Serializable;

class SomeSuperClass implements Cloneable{}
public class Singleton extends SomeSuperClass implements Serializable {
    private static Singleton INSTANCE=null;

    private Singleton() throws IllegalAccessException {
        if(INSTANCE!=null){
            throw new IllegalAccessException("Do not try to break the Singleton class");
        }
    }

    protected Object readResolve(){
        return INSTANCE;
    }

    //only if parent class is clonable
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
        //Or we can return instance of singleton class
	/*
		return singleton;
	*/
    }

    public static Singleton getInstance() throws IllegalAccessException {
        if(INSTANCE==null){
            synchronized (INSTANCE){
                if(INSTANCE==null){
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}


/**
 * To overcome above issue we can use enum also, as this guarantees singleton-ness of the object and return the same instance always.
 */
enum SingletonEnum
{
    INSTANCE;
}