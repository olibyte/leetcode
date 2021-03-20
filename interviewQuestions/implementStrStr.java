package interviewQuestions;

class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int L = haystack.length(), n = needle.length();
        if (L < n) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        char first = needle.charAt(0);
        int max = L - n;
        for (int i = 0; i <= max; i++) {
            if (haystack.charAt(i) != first) {
                while (++i <= max && haystack.charAt(i) != first)
                    ;
            }

            if (i <= max) {
                int j;
                for (j = 1; j < n; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }

                if (j == n) {
                    return i;
                }
            }

        }

        return -1;
    }
    //kmp algorithm
    public int strStr2(String haystack, String needle) {
        int L = haystack.length(), n = needle.length();
        if (L < n) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        int[][] kmp = getKMP(needle);
        int j = 0;
        for (int i = 0; i < L; i++) {
            j = kmp[j][haystack.charAt(i)];
            if (j == n) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public int[][] getKMP(String needle) {
        int length = needle.length();
        int[][] kmp = new int[length][256];
        int x = 0;
        kmp[0][needle.charAt(0)] = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < 256; j++) {
                kmp[i][j] = kmp[x][j];
            }
            kmp[i][needle.charAt(i)] = i + 1;
            x = kmp[x][needle.charAt(i)];
        }
        return kmp;
    }

    public int strStr3(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}