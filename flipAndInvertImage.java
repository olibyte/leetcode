public class flipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }
}
// Intuition and Algorithm

// We can do this in place. In each row, the ith value from the left is equal to the inverse of the ith value from the right.

// We use (C+1) / 2 (with floor division) to iterate over all indexes i in the first half of the row, including the center.

// Complexity Analysis

// Time Complexity: O(N)O(N), where N is the total number of elements in A.

// Space Complexity: O(1)O(1) in additional space complexity.
