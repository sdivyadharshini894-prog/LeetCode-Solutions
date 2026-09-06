class Solution {
    private static final int MOD = 1000000007;

    public int checkRecord(int n) {
        int[][] transitions = {
            {0, 0, 0, 0, 1, 1, 0},
            {1, 1, 1, 0, 0, 0, 0},
            {1, 1, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 0}
        };

        int[][] pathsMatrix = matrixPower(transitions, n - 1);

        int[] initialState = {1, 1, 1, 0, 0, 0, 0};

        int[] finalState = new int[pathsMatrix[0].length];

        for (int i = 0; i < pathsMatrix[0].length; i++) {
            for (int j = 0; j < initialState.length; j++) {
                finalState[i] = (int) ((finalState[i] + (long) initialState[j] * pathsMatrix[j][i] % MOD) % MOD);
            }
        }

        int totalPaths = 0;
        for (int val : finalState) {
            totalPaths = (totalPaths + val) % MOD;
        }

        return totalPaths;
    }

    private int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length, colsA = A[0].length;
        int rowsB = B.length, colsB = B[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] = (int) ((result[i][j] + (long) A[i][k] * B[k][j] % MOD) % MOD);
                }
            }
        }

        return result;
    }

    private int[][] matrixPower(int[][] matrix, int n) {
        int size = matrix.length;
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }

        int[][] base = matrix;
        while (n > 0) {
            if (n % 2 == 1) {
                result = multiplyMatrices(result, base);
            }
            base = multiplyMatrices(base, base);
            n /= 2;
        }

        return result;
    }
}