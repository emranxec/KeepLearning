package programs;
//not solved
public class FindCombinations {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] myArr={2,5,7,9,10,3,4, 6};
        findCombinations(myArr,16);
    }

    private static void findCombinations(int[] arr,int sum){

        for(int i=0;i<arr.length-2;i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] == sum) {
                        System.out.println(arr[i] + "," + arr[j]);
                    }
                    if (arr[i] + arr[k] == sum) {
                        System.out.println(arr[i] + "," + arr[k]);
                    }
                    if (arr[j] + arr[k] == sum) {
                        System.out.println(arr[j] + "," + arr[k]);
                    }
                    if (arr[i] + arr[j] + arr[k] == sum) {
                        System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
                    }
                }

            }
        }

    }
}
