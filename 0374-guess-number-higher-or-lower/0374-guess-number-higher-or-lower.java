

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int rez = guess(middle);

            if (rez == 0) {
                return middle;
            } else if (rez == -1) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}