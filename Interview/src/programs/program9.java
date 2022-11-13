package programs;

import java.util.EnumSet;
import java.util.Set;

enum week{
    MONDAY, TUESDAY, WEDNESDAY
};

public class program9 {

    public static void main(String[] args) {
        Set<week> weekSet= EnumSet.of(week.MONDAY,week.TUESDAY,week.WEDNESDAY);
        Set<week> weekSet1=EnumSet.allOf(week.class);
        System.out.println(weekSet);
        System.out.println(weekSet1);

        for(week a:week.values()){
            if(a.name().equalsIgnoreCase("Monday")){
                System.out.print("present");
            }
        }
    }
}
