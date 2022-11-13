package programs;

import programs.utilClasses.EmployeeSerialize;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;

public class LetsSerialize{

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        EmployeeSerialize employee=new EmployeeSerialize();
        FileOutputStream fileOutputStream=new FileOutputStream("abc.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employee);

        FileInputStream fileInputStream=new FileInputStream("abc.txt");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        EmployeeSerialize employee1= (EmployeeSerialize) objectInputStream.readObject();
        System.out.println(employee1.id);

        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(10);
        arrayBlockingQueue.add(7);
        arrayBlockingQueue.add(2);
        arrayBlockingQueue.add(3);
        arrayBlockingQueue.add(4);
        arrayBlockingQueue.add(5);
        System.out.println( arrayBlockingQueue.peek());
        System.out.println( arrayBlockingQueue.poll());
        System.out.println( arrayBlockingQueue.peek());

    }
}

