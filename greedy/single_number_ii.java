package greedy;

public class single_number_ii {
    
    
    public static int singleNumberII(int[] A) {
        int res = 0;
        
        
//        (Idea coming from the internet)
//        Since we know that XOR operation can be used for testing if 1 bit occurs twice,
//        in other words, for a single bit, if 1 occurs twice, it turns to 0. 
//        Now we need a 3-time criteria for each bit, by utilizing the bit operations.
//        This 3-time criteria needs every bit turns to 0 if  '1' occurs three times.
//
//        If we know on which bits '1' occurs twice, and also know on which bits '1' occurs 1-time,
//        a simple '&' operation would result in the bit where '1' occurs three times.
//        Then we turn these bit to zero, would do well for this problem.
//
//        (1). Check bits which have 1-time '1', use the XOR operation.
//        (2). Check bits which have 2-times '1's, use current 1-time result & current number.
//        (3). Check bits which have 3-times '1's, use '1-time' result & '2-times' result
//        (4). To turn 3-times bits into 0:   ~(3-times result) & 1-time result
//                                                             ~(3-times result) & 2-times result
        
//        E.g.,We have numbers:  101101,   001100, 101010
//        To count the occurrence of 1's:
//        101101
//        001100
//        101010
//        count:  {2,0,3,2,1,1}
//
//        Denote:
//        t1: bit=1 if current bit has 1-time '1'
//        t2: bit=1 if current bit  has 2-times '1'
//        t3: bit=1 if current bit  has 3-times '1'
//        Result:
//            t1 = 000011, t2 = 100100, t3 = 001000
//        1 ^ 1 ^ 1 = 1, 0 ^ 0 ^ 0 = 0
        
//        01
//        01
//        01
//        11
        
        // one pass
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        
        for (int i = 0; i < A.length; i++) {
            t2 |= (t1 & A[i]);
            t1 ^= A[i];
            t3 = t1 & t2;
            // turn 3-times bits into 0
            t3 = ~t3;
            // turn off above 0 bit position in t1 and t2
            t1 &= t3;
            t2 &= t3;
        }
        
        return t1;
    }

//    /**
//     * @param A
//     *            : An integer array
//     * @return : An integer
//     */
//    public static int singleNumberII(int[] A) {
//        // pass 32 times.
//        int res = 0;
//        
//        // starting from most significant bit
//        for (int i = 31; i >= 0; i--) {
//            int count = 0;
//            for (int j = 0; j < A.length; j++) {
//                int mask = (1 << i);
//                if ((A[j] & mask) != 0) {
//                    count++;
//                }
//            }
//            count %= 3;
//            res <<= 1;
//            res |= count;
//        }
//        
//        return res;
//    }

    public static void main(String[] args) {
        int[] A = {1,1,2,3,3,3,2,2,4,1};
        System.out.println(singleNumberII(A));
    }

}
