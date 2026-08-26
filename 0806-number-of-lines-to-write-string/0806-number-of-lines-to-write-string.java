class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1, sum = 0;
        for(char c : s.toCharArray()) {
            int w = widths[c - 'a'];
            if(sum + w > 100) {
                lines++;
                sum = 0;
            }
            sum += w;
        }
        return new int[]{lines, sum};
    }
}