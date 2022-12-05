package programs;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class VishakhFiles {

    public static void main(String[] args)  {
        Map<String,String> myMap=new HashMap<>();
        try {
            File file = new File("vishakhFile.txt");    //creates a new file instance
            FileReader fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
            String line;
            while ((line = br.readLine()) != null) {
                if(line.startsWith("Average")){
                    int indexOfDevider=line.indexOf(":");
                    String key=line.substring(0,indexOfDevider);
                    String value=line.substring(indexOfDevider,line.length()-1);
                  //  System.out.println("key :" + key + " value :" + value);
                    myMap.put(key.trim(),value.trim());
                    sb.append(line);      //appends line to string buffer
                    sb.append("\n");
                }
            }
            fr.close();    //closes the stream and release the resources
            System.out.println("Contents of File: ");
            System.out.println(sb.toString());   //returns a string that textually represents the object
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

