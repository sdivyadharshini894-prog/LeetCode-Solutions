class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int a[] = new int[n + 1];

        for (int i = 0; i < nums.length; i++) {
            a[nums[i]]++;
        }

        int d = 0;
        int m = 0;

        for (int i = 1; i <= n; i++) {
            if (a[i] == 0) {
                m = i;
            } else if (a[i] == 2) {
                d = i;
            }
        }

        return new int[]{d, m};
    }
}