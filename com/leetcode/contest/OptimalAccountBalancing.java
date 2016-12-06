package com.leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {
    // Using bit manipulation
    public static int minTransfers(int[][] transactions) {
        // id : money
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int[] tran : transactions) {
            int from = tran[0];
            int to = tran[1];
            int money = tran[2];
            if (map.containsKey(from)) {
                map.put(from, map.get(from) + money);
            } else {
                map.put(from, money);
            }

            if (map.containsKey(to)) {
                map.put(to, map.get(to) - money);
            } else {
                map.put(to, -money);
            }
        }

        List<Integer> debts = new ArrayList<Integer>();
        for (Integer key : map.keySet()) {
            if (map.get(key) != 0) {
                debts.add(map.get(key));
            }
        }
        System.out.println(debts);

        int atMost = debts.size();
        // if atMost = 3, using mask = 111 to represent all debt can use in
        // debts
        // if mask = 110, means debts[0] can't be used for subset sum
        int mask = (1 << atMost) - 1;
        System.out.println(debts);
        int[] group = new int[1];
        subsetSum(mask, 0, group, debts);

        return atMost - group[0];
    }

    public static void subsetSum(int mask, int pair, int[] group, List<Integer> debts) {
        if (mask == 0) {
            group[0] = pair;
            return;
        }

        for (int i = mask; i != 0; i = ((i - 1) & mask)) {
            System.out.println(Integer.toBinaryString(i));
            if (posSum(i, debts) == 0) {
                subsetSum(mask - i, pair + 1, group, debts);
            }
        }
    }

    // calculate sum for mask, ex 1101, sum all debts except index 1
    public static int posSum(int mask, List<Integer> debts) {
        int sum = 0;
        for (int i = 0; i < debts.size(); i++) {
            if ((mask & (1 << i)) != 0) {
                sum += debts.get(i);
            }
        }
        return sum;
    }

    // public static int minTransfers(int[][] transactions) {
    // // id : money in the pocket
    // Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    //
    // for (int[] tran : transactions) {
    // int from = tran[0];
    // int to = tran[1];
    // int money = tran[2];
    //
    // if (map.containsKey(from)) {
    // map.put(from, map.get(from) + money);
    // } else {
    // map.put(from, money);
    // }
    //
    // if (map.containsKey(to)) {
    // map.put(to, map.get(to) - money);
    // } else {
    // map.put(to, -money);
    // }
    // }
    //
    // List<Integer> userWithZeroBalance = new ArrayList<Integer>();
    // for (Integer key : map.keySet()) {
    // if (map.get(key) == 0) {
    // userWithZeroBalance.add(key);
    // }
    // }
    //
    // for (Integer user : userWithZeroBalance) {
    // map.remove(user);
    // }
    //
    // List<Integer> pos = new ArrayList<Integer>();
    // List<Integer> neg = new ArrayList<Integer>();
    //
    // int count = 0;
    // for (Integer key : map.keySet()) {
    // int money = map.get(key);
    // if (money > 0) {
    // if (neg.remove((Integer) (-money))) {
    // count++;
    // } else {
    // pos.add(money);
    // }
    // } else {
    // if (pos.remove((Integer) (-money))) {
    // count++;
    // } else {
    // neg.add(money);
    // }
    // }
    // }
    // // System.out.println(map);
    // // System.out.println(pos);
    // // System.out.println(neg);
    // // System.out.println(count);
    //
    // Map<Integer, List<List<Integer>>> posMap = new HashMap<Integer,
    // List<List<Integer>>>();
    // Map<Integer, List<List<Integer>>> negMap = new HashMap<Integer,
    // List<List<Integer>>>();
    // subsetSum(posMap, pos);
    // subsetSum(negMap, neg);
    // // System.out.println(posMap);
    // // System.out.println(negMap);
    //
    // while (true) {
    // for (Integer posKey : posMap.keySet()) {
    // List<List<Integer>> posList = posMap.get(posKey);
    // if (posList.size() > 0 && negMap.containsKey(-posKey)) {
    // List<List<Integer>> negList = negMap.get(-posKey);
    // if (negList.size() > 0) {
    // count += pairCount(pos, neg, posList.get(0), negList.get(0));
    // posList.remove(0);
    // negList.remove(0);
    // }
    // }
    // if (pos.isEmpty() || neg.isEmpty()) {
    // return count;
    // }
    // }
    // }
    //
    // }
    //
    // public static int pairCount(List<Integer> pos, List<Integer> neg,
    // List<Integer> posList, List<Integer> negList) {
    // for (Integer i : posList) {
    // if (!pos.contains(i)) {
    // return 0;
    // }
    // }
    // for (Integer i : negList) {
    // if (!neg.contains(i)) {
    // return 0;
    // }
    // }
    //
    // for (Integer i : posList) {
    // pos.remove((Object) (i));
    // }
    // for (Integer i : negList) {
    // neg.remove((Object) (i));
    // }
    //
    // PriorityQueue<Integer> pospq = new PriorityQueue<Integer>(1,
    // Collections.reverseOrder());
    // PriorityQueue<Integer> negpq = new PriorityQueue<Integer>();
    // pospq.addAll(posList);
    // negpq.addAll(negList);
    //
    // int count = 0;
    // while (!pospq.isEmpty() && !negpq.isEmpty()) {
    // int max = pospq.poll();
    // int min = negpq.poll();
    // int diff = max + min;
    // count++;
    // if (diff < 0) {
    // negpq.offer(diff);
    // } else {
    // pospq.offer(diff);
    // }
    // }
    //
    // return count;
    // }
    //
    // public static void subsetSum(Map<Integer, List<List<Integer>>> res,
    // List<Integer> lst) {
    // if (lst.isEmpty()) {
    // List<List<Integer>> empty = new ArrayList<List<Integer>>();
    // empty.add(new ArrayList<Integer>());
    // res.put(0, empty);
    // return;
    // }
    //
    // int num = lst.get(0);
    // lst.remove(0);
    // subsetSum(res, lst);
    // Set<Integer> keys = new HashSet<Integer>(res.keySet());
    // for (Integer key : keys) {
    // int newKey = num + key;
    // if (!res.containsKey(newKey)) {
    // res.put(newKey, new ArrayList<List<Integer>>());
    // }
    // for (List<Integer> list : res.get(key)) {
    // List<Integer> newList = new ArrayList<Integer>(list);
    // newList.add(num);
    // res.get(newKey).add(newList);
    // }
    // }
    // lst.add(0, num);
    // }

    public static void main(String[] args) {
        // int[][] a = { { 0, 1, 10 }, { 1, 0, 1 }, { 1, 2, 5 }, { 2, 0, 5 } };
        // int[][] a = { { 0, 1, 10 }, { 2, 0, 5 } };
        // int[][] a = { { 10, 11, 6 }, { 12, 13, 7}, {14, 15, 2}, {14, 16, 2},
        // {14, 17, 2}, {14, 18, 2} };
        // int[][] a = { { 1, 2, 3 }, { 1, 3, 3 }, { 6, 4, 1 }, { 5, 4, 4 } };
        // int[][] a = { { 0, 1, 5 }, { 2, 3, 1 }, { 2, 0, 1 }, { 4, 0, 2 } };
        // int[][] a = { { 0, 6, 7 }, { 0, 7, 7 }, { 1, 4, 5 }, { 1, 5, 4 }, {
        // 2, 5, 2 }, { 3, 7, 1 } };
        int[][] a = { { 2, 0, 5 }, { 3, 4, 4 } };
        System.out.println(minTransfers(a));
    }

}
