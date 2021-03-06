package com.company;

import java.util.Random;

public class PlanPath {
    PlanPath () {}

    private static Random rand = new Random();
    private static final double initialT = 100000, endT = 0.01, mul = 0.99998;
    private static boolean[][] dist;

    private static int[] get_can (int[] res) {
        int[] ans = new int[res.length];
        for (int i = 0; i < res.length; i++) {
            ans[i] = res[i];
        }
        int x = rand.nextInt(res.length), y = rand.nextInt(res.length);
        if (x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        while (x < y) {
            int tmp = ans[x];
            ans[x] = ans[y];
            ans[y] = tmp;
            ++x;
            --y;
        }
        return ans;
    }

    private static int calc_res (int[] res) {
        int ans = 0;
        if (!dist[res[0]][res[res.length - 1]]) ++ans;
        for (int i = 1; i < res.length; i++) {
            if (!dist[res[i]][res[i - 1]]) ++ans;
        }
        return ans;
    }

    public static int[] init (boolean[][] d) {
        dist = d;
        int n = d.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int to = rand.nextInt(n);
            int tmp = res[i];
            res[i] = res[to];
            res[to] = tmp;
        }
        int cur = calc_res(res);
        for (double t = initialT; t > endT; t *= mul) {
            if (cur == 0) break;
            int[] can = get_can(res);
            int ene = calc_res(can);
            if (ene < cur) {
                cur = ene;
                res = can;
            }
            else {
                double pr = Math.exp(-(ene - cur) / t);
                if (pr >= rand.nextDouble()) {
                    cur = ene;
                    res = can;
                }
            }
        }
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (res[i] == n - 1) {
                pos = i;
                break;
            }
        }
        int[] answer = new int[n - 1];
        int j = 0;
        for (int i = pos + 1; i < n; i++) {
            answer[j++] = res[i];
        }
        for (int i = 0; i < pos; i++) {
            answer[j++] = res[i];
        }
        return answer;
    }
}
