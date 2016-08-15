package greedy;

public class gas_station {

    /**
     * @param gas:
     *            an array of integers
     * @param cost:
     *            an array of integers
     * @return: an integer
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int netGasSum = 0;
        int curGasSum = 0;
        int index = 0;
        
        for (int i = 0; i < gas.length; i++) {
            int curDiff = gas[i] - cost[i];
            netGasSum += curDiff;
            curGasSum += curDiff;
            if (curGasSum < 0) {
                index = i + 1;
                curGasSum = 0;
            }
        }
        
        if (index >= gas.length || netGasSum < 0) {
            return -1;
        }
        
        return index;
    }

    public static void main(String[] args) {
        int[] gas = { 1, 1, 3, 1 };
        int[] cost = {2,2,1,1};
        System.out.println(canCompleteCircuit(gas, cost));
    }

}
