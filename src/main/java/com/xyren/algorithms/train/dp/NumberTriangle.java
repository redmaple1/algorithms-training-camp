package com.xyren.algorithms.train.dp;

import java.util.Scanner;

/**
 * 数字三角形
 * 题目：POJ1163
 *
 * @author renxiaoya
 * @date 2022-04-26
 **/
public class NumberTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("input: ");
        int n = scanner.nextInt();

        int[][] a = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                a[i][j] = scanner.nextInt();
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }


        dp[0][0] = a[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + a[i][0];
            for (int j = 1; j <= i; j++) {
                dp[i][j] = a[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        int res = dp[n - 1][0];
        for (int j = 0; j < n; j++) {
            res = Math.max(res, dp[n - 1][j]);
        }
        System.out.println(res);
    }

}
