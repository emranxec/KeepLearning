package programs.utilClasses;


public class interviewQuestions {

    public static void main(String[] args) {

        //1. how to create a immutable class
        immmutableClass immmutableClass = new immmutableClass("imran");

    }
}
final class immmutableClass{
    final private String name;

    immmutableClass(String name){
        this.name=name;
    }
    String getName(){
        return name;
    }
}
