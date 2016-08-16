package greedy;

public class largest_number {

    /**
     * @param num:
     *            A list of non negative integers
     * @return: A string
     */
    public static String largestNumber(int[] num) {
        if (allZeros(num)) {
            return "0";
        }

        int[] sorted = mergeSort(num);
        String res = "";

        for (int i : sorted) {
            res += i;
        }

        return res; 
    }
    
    public static boolean allZeros(int[] num) {
        for (int i : num) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] mergeSort(int[] num) {
        if (num.length < 2) {
            return num;
        }

        int mid = num.length / 2;
        int[] leftSorted = mergeSort(slice(num, 0, mid));
        int[] rightSorted = mergeSort(slice(num, mid, num.length));
        return merge(leftSorted, rightSorted);
    }

    public static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < a.length && j < b.length) {
            if (comparator(a[i], b[j])) {
                res[count] = a[i];
                i++;
            } else {
                res[count] = b[j];
                j++;
            }
            count++;
        }

        while (i < a.length) {
            res[count] = a[i];
            i++;
            count++;
        }

        while (j < b.length) {
            res[count] = b[j];
            j++;
            count++;
        }
        return res;
    }

    // return true if a's most significant digit larger than b's most
    // significant digit
    public static boolean comparator(int a, int b) {
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        int i = 0;
        while (i < aStr.length() && i < bStr.length()) {
            if (aStr.charAt(i) > bStr.charAt(i)) {
                return true;
            } else if (aStr.charAt(i) == bStr.charAt(i)) {
                i++;
            } else {
                return false;
            }
        }

        if (aStr.length() == bStr.length()) {
            return false;
        } else {
            if (aStr.length() < bStr.length()) {
                bStr = bStr.substring(1);
            } else {
                aStr = aStr.substring(1);
            }
            return comparator(Integer.valueOf(aStr), Integer.valueOf(bStr));
        }
    }

    public static int[] slice(int[] a, int start, int end) {
        int[] res = new int[end - start];
        for (int i = start; i < end; i++) {
            res[i - start] = a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = { 1, 20, 23, 4, 8 };
        System.out.println(largestNumber(num));
    }

}
