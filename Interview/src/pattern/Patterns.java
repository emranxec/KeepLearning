package pattern;

public class Patterns {

    public static void main(String[] args) {
        pattern1(5);

        pattern2(5);
        pattern3(5);
        pattern4(5);
        pattern5(5);
        pattern6(5);
        pattern7(5);
    }

    static void pattern1(int n){
        for(int row= 1;row<=n;row++){
            for(int column=1 ; column<=n;column++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern2(int n){
        for(int row= 1;row<=n;row++){
            for(int column=1 ; column<=row;column++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for(int row= n;row>=1;row--){
            for(int column=1 ; column<=row;column++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern4(int n){
        for(int row= 1;row<=n;row++){
            for(int column=1 ; column<=row;column++){
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        int pattern=0;
        for(int row= 1;row<=n*2-1;row++){
            int rowInCol=row>n?2*n-row:row;
            for(int column=1 ; column<=rowInCol;column++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n){
        for(int row= 1;row<=n*2-1;row++){
            int rowInCol=row>n?2*n-row:row;
            int noOfSpaces=n-rowInCol;
            for(int s=0;s<noOfSpaces;s++){
                System.out.print(" ");
            }
            for(int column=1 ; column<=rowInCol;column++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern7(int n){
        for(int row= 1;row<=n;row++){
            int noOfSpaces=n-row;
            for(int s=0;s<noOfSpaces;s++){
                System.out.print("  ");
            }
            for(int column=row ; column>=1;column--){
                System.out.print(column + " ");
            }
            for(int column=2 ; column<=row;column++){
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }
}
