package programs;

public class SeparateValues {

    public static void main(String[] args) {
        int[] mynumbers = {2, 12, -3, 4, -5, 6, -7, 0, 8, -8}; //2,4,6,0,8,-3,-5,-7,-8
        int[] myNewnumbers = new int[mynumbers.length];
        int seq = 0;
        for (int k : mynumbers) {
            if (k > 0) {
                myNewnumbers[seq++] = k;
            }
        }
        for (int j : mynumbers) {
            if (j == 0) {
                myNewnumbers[seq++] = j;
            }
        }
        for (int mynumber : mynumbers) {
            if (mynumber < 0) {
                myNewnumbers[seq++] = mynumber;
            }
        }
        for (int number : mynumbers) {
            System.out.print(number);
            System.out.print(",");

        }
        System.out.println("");
        for (int number : myNewnumbers) {
            System.out.print(number);
            System.out.print(",");

        }

    }
}
