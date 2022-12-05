package programs;

import programs.utilClasses.week;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

;

public class program9 {

    public static void main(String[] args) {
        Set<week> weekSet= EnumSet.of(week.MONDAY,week.TUESDAY,week.WEDNESDAY);
        Set<week> weekSet1=EnumSet.allOf(week.class);
        EnumMap<week, String> weekMap= new EnumMap<week, String>(week.class);
        weekMap.put(week.MONDAY, "Start Coding");
        weekMap.put(week.TUESDAY, "Start giving interview");
        weekMap.put(week.WEDNESDAY, "resign");
        System.out.println(weekSet);
        System.out.println(weekSet1);
        System.out.println(weekMap);

        for(week a:week.values()){
            if(a.name().equalsIgnoreCase("Monday")){
                System.out.print("present");
            }
        }


    }
}
