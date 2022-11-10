/**
 * I have an Integer array where every number appears even number of time
 * except one. Find that number
 * how would you check if a number is even or odd using bit wise operator in
 * Java?
 */
public class OddNumberProblem {
        private int[] array = {1,1,2,3,4,5,2,3,4};
        public int findSingleOdd(){
            int result =0;
            for (int i : array) {
                result=result^i;
            }
            return result;
        }
        public static boolean checkOdd(long number){
            return ((number & 0x1) == 1);
        }

        public static void main(String[] args) {
            OddNumberProblem test = new OddNumberProblem();
            int singleOdd = test.findSingleOdd();
            System.out.println("singleOdd = " + singleOdd);
            System.out.println("check is Odd number  = " + checkOdd(singleOdd));
        }
}
