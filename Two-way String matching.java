public static int maxSuf(String x, int m, int p) {
        int ms, j, k;
        char a, b;

        ms = -1;
        j = 0;
        k = p = 1;
        while (j + k < m) {
            a = x.charAt(j + k);
            b = x.charAt(ms + k);
            if (a < b) {
                j += k;
                k = 1;
                p = j - ms;
            } else if (a == b)
                if (k != p)
                    ++k;
                else {
                    j += p;
                    k = 1;
                }
            else { /* a > b */
                ms = j;
                j = ms + 1;
                k = p = 1;
            }
        }
        return (ms);
    }

    /* Computing of the maximal suffix for >= */
    static int maxSufTilde(String x, int m, int p) {
        int ms, j, k;

        ms = -1;
        j = 0;
        k = p = 1;
        while (j + k < m) {
            char a = x.charAt(j + k);
            char b = x.charAt(ms + k);

            if (a > b) {
                j += k;
                k = 1;
                p = j - ms;
            } else if (a == b)
                if (k != p)
                    ++k;
                else {
                    j += p;
                    k = 1;
                }
            else { /* a < b */
                ms = j;
                j = ms + 1;
                k = p = 1;
            }
        }
        return ms;
    }


    /* Two Way string matching algorithm. */
    public static int TW(String x, int m, String y, int n) {
        int i, j, ell, memory, p = 0, per, q = 0;

        /* Preprocessing */
        i = maxSuf(x, m, p);
        j = maxSufTilde(x, m, q);

        System.out.println(i + " " + j);
        if (i > j) {
            ell = i;
            per = p;
        } else {
            ell = j;
            per = q;
        }

        /* Searching */
        if (memcmp(x, 0, x, per, ell + 1) == 0) {
            System.out.println("here");
            j = 0;
            memory = -1;
            while (j <= n - m) {
                i = Math.max(ell, memory) + 1;
                while (i < m && x.charAt(i) == y.charAt(i + j))
                    ++i;
                if (i >= m) {
                    i = ell;
                    while (i > memory && x.charAt(i) == y.charAt(i + j))
                        --i;
                    if (i <= memory)
                        return j;
                    j += per;
                    memory = m - per - 1;
                } else {
                    j += (i - ell);
                    memory = -1;
                }
            }
        } else {
            per = Math.max(ell + 1, m - ell - 1) + 1;
            j = 0;
            while (j <= n - m) {
                i = ell + 1;
                while (i < m && x.charAt(i) == y.charAt(i + j))
                    ++i;
                if (i >= m) {
                    i = ell;
                    while (i >= 0 && x.charAt(i) == y.charAt(i + j))
                        --i;
                    if (i < 0)
                        return j;
                    j += per;
                } else
                    j += (i - ell);
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int memcmp(String x1, int start1, String x2, int start2, int length) {
        for (int i = 0; i < length; i++) {
            if (x1.charAt(start1 + i) != x2.charAt(start2 + i)) {
                return x1.charAt(start1 + i) - x2.charAt(start2 + i);
            }
        }
        return 0;
    }
