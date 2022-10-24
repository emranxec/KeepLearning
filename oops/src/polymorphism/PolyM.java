package polymorphism;

class topClass{
    public topClass foo(int a) { return this; }
}
class base extends topClass{

    @Override
    public base foo(int a) { return this; }

   // public  char foo(int a) { return 'a'; }

    public char foo(int a,int b) { return 'a'; }

}
public class PolyM extends topClass{


    public static void main(String args[])
    {
        /*System.out.println(foo(1));
        System.out.println(foo(1, 2));*/
    }
}
