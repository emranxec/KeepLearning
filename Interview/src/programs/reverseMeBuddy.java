package programs;

public class reverseMeBuddy {
    public static void main(String[] args) {
        System.out.println(reverseMeBuddy("qwertyujikjhgfdcvbnmjhgvnjgfvbnmkjgfvbnmkjhgvnmjhgvbnmjhgv mjhvsjdfsdfjnsdjkfnjksdfnkjsdnfkjsdjfnsdkjfnskjdfnkjsfnkjsdklfnblksdbflksbdlkfj"));
        System.out.println(reverseMeBuddyInBetterWay("qwertyujikjhgfdcvbnmjhgvnjgfvbnmkjgfvbnmkjhgvnmjhgvbnmjhgv mjhvsjdfsdfjnsdjkfnjksdfnkjsdnfkjsdjfnsdkjfnskjdfnkjsfnkjsdklfnblksdbflksbdlkfj"));

    }

    static String reverseMeBuddy(String original){
        char[] myArray= original.toCharArray();
        for(int i=0,j=original.length()-1;i<j;j--,i++){
            System.out.println("calling these many times");
            char temp=myArray[i];
            myArray[i]=myArray[j];
            myArray[j]=temp;
        }
        return String.valueOf(myArray);
    }

    static String reverseMeBuddyInBetterWay(String original){
        char[] myArray= original.toCharArray();
        String empty = "";
        for(int i=0;i<original.length();i++){
            System.out.println("calling these many times in better way");
            empty=myArray[i]+empty;
        }
        return empty;
    }
    static String reverseMeBuddyusingBuilder(String original){
        return String.valueOf(new StringBuilder(original).reverse());
    }
}
