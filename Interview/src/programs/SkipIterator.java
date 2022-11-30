package programs;

import java.util.*;

public class SkipIterator implements Iterator {
    Set<Integer> skips = new HashSet<>();
    Iterator<Integer> iterator;
    boolean isAlreadySkip=true;

    SkipIterator(Iterator<Integer> iterator){
        this.iterator = iterator;
    }
    @Override
    public boolean hasNext() {
        if(iterator.hasNext() && !isAlreadySkip ){
            skips.add(iterator.next());
            isAlreadySkip=true;
        }
        return iterator.hasNext();
    }

    @Override
    public Object next() {
        if(hasNext()){
            isAlreadySkip=false;
            return iterator.next();
        }
       return null;
    }
}


class testClass{
    public static void main(String[] args) {
        List<Integer> myInt= Arrays.asList(1,2,3,4,5,6,7);


        SkipIterator iterator=new SkipIterator(myInt.iterator());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

    }
}