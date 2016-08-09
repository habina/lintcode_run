package binary_search;

public class first_bad_version {

    public static class SVNRepo {
        public static boolean isBadVersion(int k) {
            return false;
        }
    }

    /**
     * @param n:
     *            An integers.
     * @return: An integer which is the first bad version.
     */
    public static int findFirstBadVersion(int n) {
        int begin = 1;
        int end = n;
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;

            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        
        if (SVNRepo.isBadVersion(begin)) {
            return begin;
        } else {
            return end;
        }
    }

    public static void main(String[] args) {
        System.out.println(findFirstBadVersion(5));
    }

}
