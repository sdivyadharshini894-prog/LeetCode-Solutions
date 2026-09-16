class Solution {
    public int totalNumbers(int[] digits) {

        // Store the frequency of each digit
        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        int ans = 0;

        // Choose the first digit.
        // It cannot be 0 because we need a 3-digit number.
        for (int i = 1; i < freq.length; i++) {

            // No digit i available
            if (freq[i] == 0) {
                continue;
            }

            // Use digit i as the first digit
            freq[i]--;

            // Choose the second digit.
            // It can be any digit from 0 to 9.
            for (int j = 0; j < freq.length; j++) {

                // No digit j available
                if (freq[j] == 0) {
                    continue;
                }

                // Use digit j as the second digit
                freq[j]--;

                // Choose the last digit.
                // It must be even: 0, 2, 4, 6, or 8.
                for (int k = 0; k < freq.length; k += 2) {

                    // No even digit k available
                    if (freq[k] == 0) {
                        continue;
                    }

                    // This forms one valid 3-digit even number
                    ans++;
                }

                // Restore the second digit
                freq[j]++;
            }

            // Restore the first digit
            freq[i]++;
        }

        return ans;
    }
}