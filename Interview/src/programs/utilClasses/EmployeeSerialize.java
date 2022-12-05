package programs.utilClasses;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class EmployeeSerialize implements Serializable {
    public static String id = "123";
    String name = "imran";
    String phone = "9096919090";
    transient
    String password = "123";

    public EmployeeSerialize() {
    }


    //Setters and Getters

    private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
        name = aInputStream.readUTF();
        phone = aInputStream.readUTF();

        aInputStream.defaultReadObject();

        // make defensive copy of the mutable Date field
        if (phone.equals("9096919090")) {
            System.out.println("tring");
            System.out.println("name :" + name);
        }

    }

    private void writeObject(ObjectOutputStream aOutputStream) throws IOException {
        aOutputStream.writeUTF(name);
        aOutputStream.writeUTF(phone);
        aOutputStream.defaultWriteObject();
    }

    private static final long SerialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
