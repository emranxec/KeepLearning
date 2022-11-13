package programs.utilClasses;

public class AnagramEfficient {

    static boolean isAnagram(String first, String second) {
        int letterCount[] = new int[126];
        for (char ch : first.toCharArray()) {
            letterCount[ch]++;
        }
        for (char ch : second.toCharArray()) {
            letterCount[ch]--;
        }
        for (int count : letterCount) {
            if (count != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("aa","aab"));
    }
}

