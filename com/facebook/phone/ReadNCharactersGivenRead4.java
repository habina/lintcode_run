package com.facebook.phone;

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

public class ReadNCharactersGivenRead4 {
    int read4(char[] buf) {
        return 0;
    }

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];

        for (int i = 0; i < n; i+=4) {
            int t = this.read4(tmp);
            System.arraycopy(tmp, 0, buf, i, Math.min(t, n - i));
            if (t < 4) {
                return Math.min(i + t, n);
            }
        }

        return n;
    }

}
