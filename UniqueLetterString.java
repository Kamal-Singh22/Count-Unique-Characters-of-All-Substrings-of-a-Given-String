import java.util.*;

public class UniqueLetterString {
    public static int uniqueLetterString(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();

        // Store the last two positions of each character
        int[][] index = new int[26][2];
        for (int[] arr : index) {
            arr[0] = -1;  // second last occurrence
            arr[1] = -1;  // last occurrence
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            int prev = index[c][0];
            int last = index[c][1];

            // Count contribution: (last - prev) * (i - last)
            result += (long)(last - prev) * (i - last);
            result %= MOD;

            // Update positions
            index[c][0] = index[c][1];
            index[c][1] = i;
        }

        // Process trailing substrings after the last occurrence
        for (int c = 0; c < 26; c++) {
            int prev = index[c][0];
            int last = index[c][1];

            result += (long)(last - prev) * (n - last);
            result %= MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "ABA";

        System.out.println("Output for 'ABC': " + uniqueLetterString(s1));
        System.out.println("Output for 'ABA': " + uniqueLetterString(s2));
    }
}
