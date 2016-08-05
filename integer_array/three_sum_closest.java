package integer_array;

public class three_sum_closest {
    
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public static int threeSumClosest(int[] numbers, int target) {
        // runtime: nlogn
        int[] sorted = mergeSorted(numbers);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < sorted.length - 2; i++) {
            int left = i + 1;
            int right = sorted.length - 1;
            while (left < right) {
                int diff = sorted[i] + sorted[left] + sorted[right] - target;
                if (diff == 0) {
                    return target;
                } else if (Math.abs(diff) < Math.abs(minDiff)) {
                    minDiff = diff;
                }
                
                if (diff < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return minDiff + target;
    }
    
    public static int[] mergeSorted(int[] numbers) {
        if (numbers.length == 0 || numbers.length == 1) {
            return numbers;
        }
        int[] left = mergeSorted(slice(numbers, 0, numbers.length / 2));
        int[] right = mergeSorted(slice(numbers, numbers.length / 2, numbers.length));
        return mergeSortedList(left, right);
    }
    
    public static int[] mergeSortedList(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int count = 0;
        int[] res = new int[a.length + b.length];
        
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
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
            count++;
            i++;
        }
        
        while (j < b.length) {
            res[count] = b[j];
            count++;
            j++;
        }
        
        return res;
    }
    
    public static int[] slice(int[] a, int start, int end) {
        int[] res = new int[end - start];
        for (int i = start; i < end; i++) {
            res[i - start] = a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(numbers, target));
    }

}
