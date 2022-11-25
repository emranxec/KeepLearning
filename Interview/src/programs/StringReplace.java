package programs;

public class StringReplace {

    // Function to replace all the occurrences
// of the subString S1 to S2 in String S
    static void modifyString(String original, String search, String replace)
    {
        // Stores the resultant String
        String ans = "";

        // Traverse the String s
        for (int i = 0; i < original.length(); i++) {

            int k = 0;

            // If the first character of
            // String s1 matches with the
            // current character in String s
            if (original.charAt(i) == search.charAt(k)
                    && i + search.length() <= original.length()) {

                int j;

                // If the complete String
                // matches or not
                for (j = i; j < i + search.length(); j++) {

                    if (original.charAt(j) != search.charAt(k)) {
                        break;
                    }
                    else {
                        k = k + 1;
                    }
                }

                // If complete String matches
                // then replace it with the
                // String s2
                if (j == i + search.length()) {
                    ans += (replace);
                    i = j - 1;
                }

                // Otherwise
                else {
                    ans += (original.charAt(i));
                }
            }

            // Otherwise
            else {
                ans += (original.charAt(i));
            }
        }

        // Print the resultant String
        System.out.print(ans);
    }

    // Driver Code
    public static void main(String[] args)
    {
        String original = "Was it a car or a cat I saw";
        String search = "a";
        String replace = "b";
        modifyString(original, search, replace);
    }
}

