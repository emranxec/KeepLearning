package programs.utilClasses;

public class Address implements Cloneable{
    private String streetName;
    private String address1;

    public Address(String streetName, String address1) {
        this.streetName = streetName;
        this.address1 = address1;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
