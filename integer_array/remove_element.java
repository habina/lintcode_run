package integer_array;

public class remove_element {

    /**
     * @param A:
     *            A list of integers
     * @param elem:
     *            An integer
     * @return: The new length after remove
     */
    public static int removeElement(int[] A, int elem) {
        // write your code here
        int count = 0;
        int i = 0;
        int j = 0;
        if (A.length == 0) {
            return count;
        }
        while (i < A.length) {
            if (A[i] == elem) {
                j = i + 1;
                while (j < A.length) {
                    if (A[j] != elem) {
                        count++;
                        swap(A, i, j);
                        break;
                    }
                    j++;
                }
            } else {
                count++;
            }
            i++;
        }

        return count;
    }

    public static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public static void main(String[] args) {
        int[] x = { 0, 4, 4, 0, 0, 2, 4, 4 };
        System.out.println(removeElement(x, 4));
    }

}
