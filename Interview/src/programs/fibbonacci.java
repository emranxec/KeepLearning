package programs;

import java.util.stream.Stream;

public class fibbonacci {
    static int counter=0;
    public static void main(String[] args) {
        printFibbonacci(10);
        printFibbonacciUsingIterator(10);
        System.out.println("");
        printFibbonacciUsingJavaEight(10);
    }

    private static void printFibbonacciUsingJavaEight(int i) {
        System.out.println("---printFibbonacciUsingJavaEight--");
        Stream.iterate(new int[]{0,1},t->new int[]{t[1],t[0]+t[1]})
                .limit(10)
                .map(t->t[0])
                .forEach(System.out::print);
    }

    private static void printFibbonacciUsingIterator(int n) {
        int i=0,a=-1,b=1;
        int c;
        System.out.print("----using iterator: ------");
        while (i < n) {
            c = a + b;
            System.out.print(c + ",");

            a = b;
            b = c;
            i++;
        }
    }

    static void printFibbonacci(int n){
        //0,1,1,2,3,5,8,13
        System.out.println(0);
        System.out.println(1);
        findFibbonci(0,1,n);
    }

    private static void findFibbonci(int i, int j,int n) {
        int k=i+j;
        if(counter<n) {
            System.out.println(k);
            counter++;
            i = j;
            j = k;
            findFibbonci(i, j, n);
        }
    }
}
