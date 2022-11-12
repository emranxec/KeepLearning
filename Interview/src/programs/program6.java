package programs;
import java.util.*;
public class program6 {

// Function to check if the given array
// forms an increasing decreasing
// sequence or vice versa
    static boolean canMake(int n, int ar[])
    {
        // Base Case
        if (n == 1)
            return true;
        else
        {

            // First subarray is
            // strictly increasing
            if (ar[0] < ar[1])
            {
//Check for every consecutive pair until at any index i arr[i + 1] is greater than arr[i].
//If at any index i, arr[i] is greater than arr[i + 1] then break the loop.
                int i = 1;

                // Check for strictly
                // increasing condition
                // & find the break point
                while (i < n && ar[i - 1] < ar[i])
                {
                    i++;
                }

                // Check for strictly
                // decreasing condition
                // & find the break point
                while (i + 1 < n && ar[i] > ar[i + 1])
                {
                    i++;
                }

                // If i is equal to
                // length of array
                if (i >= n - 1)
                    return true;
                else
                    return false;
            }

            // First subarray is
            // strictly Decreasing
            else if (ar[0] > ar[1])
            {
//Check for every consecutive pair until at any index i arr[i + 1] is less than arr[i].
//If at any index i, arr[i] is less than arr[i + 1] then break the loop.
                int i = 1;

                // Check for strictly
                // increasing condition
                // & find the break point
                while (i < n && ar[i - 1] > ar[i])
                {
                    i++;
                }

                // Check for strictly
                // increasing condition
                // & find the break point
                while (i + 1 < n && ar[i] < ar[i + 1])
                {
                    i++;
                }

                // If i is equal to
                // length of array - 1
                if (i >= n - 1)
                    return true;
                else
                    return false;
            }

            // Condition if ar[0] == ar[1]
            else
            {
                for (int i = 2; i < n; i++)
                {
                    if (ar[i - 1] <= ar[i])
                        return false;
                }
                return true;
            }
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Given array arr[]
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;

        // Function Call
        if (!canMake(n, arr)) {
            System.out.print("Inc");
        }
        else
        {
            System.out.print("no");
        }
    }
}

