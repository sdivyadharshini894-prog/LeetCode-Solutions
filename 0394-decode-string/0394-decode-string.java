class Solution {
    Map<Integer, Integer> closePos = new HashMap<>();
    public String decodeString(String s) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '[')
                st.push(i);
            else if (s.charAt(i) == ']')
                closePos.put(st.pop(), i);
        }
        return solve(s, 0, s.length() - 1);
    }
    String solve(String s, int l, int r) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (l <= r) {
            char c = s.charAt(l);
            if (Character.isDigit(c))
                num = num * 10 + c - '0';
            else if (c == '[') {
                sb.append(solve(s, l + 1, closePos.get(l) - 1).repeat(num));
                num = 0;
                l = closePos.get(l);
            } else {
                sb.append(c);
            }
            l += 1;
        }
        return sb.toString();
    }
}