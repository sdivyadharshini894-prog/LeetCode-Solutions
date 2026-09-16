class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int totalOpt = 9;      // choices for the first digit (1–9)
        int availableOpt = 9;  // choices for each subsequent digit
        int res = 10;          // base: all 1-digit numbers (0–9)

        for (int i = 2; i <= n; i++) {
            totalOpt *= availableOpt;
            res += totalOpt;
            availableOpt--;
        }

        return res;
    }
}