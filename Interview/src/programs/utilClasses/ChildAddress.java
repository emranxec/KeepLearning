package programs.utilClasses;

class ChildAddress extends Address {
/*    Is there any problem with this approach?

    Well yes. what if some reference variables inside Address class is also Mutable Objects.
    In that case we need to override their  setter methods as well.
    This approch becomes more complex when there are many nested Mutable class references.*/

    public ChildAddress(String address1, String address2) {
        super(address1, address2);
    }

    public void setAddress1(String address1) {
        throw new UnsupportedOperationException();
    }

    public void setAddress2(String address2) {
        throw new UnsupportedOperationException();
    }
}
