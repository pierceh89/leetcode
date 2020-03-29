package io.github.pierceh89.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndergroundSystem {
    Map<Integer, Customer> map = new HashMap<>();
    Map<String, List<Integer>> travelTime = new HashMap<>();

    public UndergroundSystem() {
    }

    private static class Customer {
        String from;
        int inTime;
        public Customer(String f, int in) {
            from = f;
            inTime = in;
        }
    }

    public void checkIn(int id, String stationName, int t) {
        Customer c = new Customer(stationName, t);
        map.put(id, c);
    }

    public void checkOut(int id, String stationName, int t) {
        Customer c = map.get(id);
        int travelT = t - c.inTime;
        String travel = c.from + stationName;
        List<Integer> timeList = travelTime.computeIfAbsent(travel, k -> new ArrayList<>());
        timeList.add(travelT);
    }

    public double getAverageTime(String startStation, String endStation) {
        String travel1 = startStation + endStation;
        String travel2 = endStation + startStation;
        int sum = 0;
        int cnt = 0;
        List<Integer> travel1Time = travelTime.get(travel1);
        if(travel1Time != null) {
            cnt += travel1Time.size();
            for(int t : travel1Time) {
                sum += t;
            }
        }
        List<Integer> travel2Time = travelTime.get(travel2);
        if(travel2Time != null) {
            cnt += travel2Time.size();
            for(int t : travel2Time) {
                sum += t;
            }
        }
        return sum / (double)cnt;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

