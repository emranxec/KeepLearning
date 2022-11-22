package dataStructure.selfWorked;

import java.util.Arrays;

public class ArrayList {
    private Object[] myStore;
    private int actSize=0;

    public int size(){
        return actSize;
    }
    ArrayList(){
        myStore= new Object[10];
    }
    public void add(Object obj){
        if(myStore.length-actSize<=5){
            increaseListSize();
        }
        myStore[actSize++]=obj;
    }

    public Integer remove(Object obj){
        Integer index=null;
        for(int i=0;i<actSize;i++){
            if(myStore[i].equals(obj)){
                index=i;
                break;
            }
        }
        if(index!=null) {
            return removeFromIndex(index);
        }
        return -1;
    }

    private Integer removeFromIndex(Integer index) {
        if(index!=null && index<actSize){
            for(int i=index;i<size();i++){
                if(myStore[i+1]!=null) {
                    myStore[i] = myStore[i + 1];
                }
            }
            actSize--;
        }
        return index;
    }

    public Object get(int index){
        if(index<actSize){
            return myStore[index];
        }
        return new ArrayIndexOutOfBoundsException();
    }

    private void increaseListSize() {
        myStore= Arrays.copyOf(myStore,myStore.length*2);
        System.out.println("new length =" + myStore.length);
    }

    public void printAll(){
        for(int i=0;i<size();i++){
            System.out.print(get(i)+" ");
        }
    }
    public static void main(String[] args) {
        ArrayList mal = new ArrayList();
        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
        mal.printAll();
        mal.add(new Integer(29));
        System.out.println("----Element at Index 5:"+mal.get(5));
        System.out.println("---List size: "+mal.size());
        System.out.println("---Removing element at index 2: "+ mal.remove(new Integer(2)));
        mal.printAll();
    }
}
