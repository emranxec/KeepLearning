package programs;

import java.util.Arrays;

class FindTriplet {

    public static void find3Numbers(int[] a, int arr_size, int sum) {

       /* int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        int arr_size = A.length;*/

        //{ 1, 4, 45, 6, 10, 8 }
        //{ 1, 4, 6, 10, 8 }
        //{ 10, 8, 6, 4,1}
        Arrays.sort(a);
        int finalSum = 0;
        int count = 0;
        int[] finalArray = new int[3];
        for (int i = arr_size - 1; i >= 0; i--) {
            if (finalSum == sum) {
                if (count < 3) {
                    finalSum -= a[i + 1];
                    count--;
                }
                if (finalSum == sum) {
                    System.out.println(finalArray[0] + "," + finalArray[1] + "," + finalArray[2]);
                    return;
                }
            }
            if (finalSum + a[i] > sum) {
                continue;
            }
            finalSum += a[i];
            finalArray[count] = a[i];
            count++;
        }
        if (finalSum != sum) {
            System.out.println("no match found");
        } else {
            System.out.println(finalArray[0] + "," + finalArray[1] + "," + finalArray[2]);
        }
    }

    private static void findTriplet() {

        int A[] = { 0, 0, 0, 0, 0, 0 };
        int sum = 0;
        int arr_size = A.length;

        find3Numbers(A, arr_size, sum);
    }

    public static void main(String[] args) {
        findTriplet();
    }
}
