import java.util.function.Consumer;

public class Mailer{
    public Mailer(){}

    Mailer from(String Add){
        System.out.println("from");
        return this;
    }

    Mailer to(String Add){
        System.out.println("to");
        return this;
    }

    Mailer subject(String Add){
        System.out.println("subject");
        return this;
    }
    Mailer body(String Add){
        System.out.println("body");
        return this;
    }

    static void send(Consumer<Mailer> block){
        Mailer mailer=new Mailer();
        block.accept(mailer);
        System.out.println("sending");

    }
}

class testMailer{
    public static void main(String[] args) {
        //composed pattern
        Mailer.send(mailer ->
                mailer.from("Imran")
                        .to("salman")
                        .subject("hello")
                        .body("Hii")
        );
    }
}
