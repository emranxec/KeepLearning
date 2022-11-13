package programs;

public class program24 {

    public static void main(String[] args) {


        new Thread(() -> System.out.println("New thread created")).start();

        int a = 5;

        // lambda expression to define the calculate method
        Square s = (int x) -> x * x;
        String firstN = "imran";
        String secondN = "khan";
        FindSomerandomName findSomerandomName = (String first, String concat) -> first = first.concat(concat);
        FindSomerandomName.danceAgain();
        findSomerandomName.dance();
        String ans1 = findSomerandomName.find(firstN, secondN);
        System.out.println(ans1);

    }
}

@FunctionalInterface
interface Square {
    int calculate(int x);
}


@FunctionalInterface
interface FindSomerandomName {
    String find(String firstName, String concat);

    static void danceAgain() {
        System.out.println("dancing");
    }

    default void dance() {
        FindSomerandomName.danceAgain();
        System.out.println("dancing again");
    }
}
