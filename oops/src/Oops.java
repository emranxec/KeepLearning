public class Oops {
    public static void main(String[] args) {
        Base base = new Child();
        base.display(new ChildService());// in child

        Child child = new Child();
        child.display(new BaseService());// in
    }
}

class BaseService {}
class ChildService extends BaseService {}

class Base {
    public void display(BaseService service) {
        System.out.println("In Base");
    }
}

class Child extends Base {
    public void display(ChildService service) {
        System.out.println("In Child");
    }
}