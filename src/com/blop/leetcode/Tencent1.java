package com.blop.leetcode;

/**
 * Created by tenghuanhe on 2016/8/1.
 */
public class Tencent1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String str = sc.nextLine();
//            System.out.println(LCS(str));
//        }

        int cnt = 0;
        for (int i = 0; i < 9999; i++) {
            String s = String.valueOf(i);
            cnt += count7(s);
        }

        System.out.println(cnt);
    }

    public static int count7(String str) {
        int i = 0;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '7') {
                i++;
            }
        }
        return i;
    }

    public static int LCS(String str1) {
        String str2 = new StringBuffer(str1).reverse().toString();
        int length = str1.length();
        int[][] dp = new int[length + 1][length + 1];
        for (int i = 0; i <= length; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }

        }

        return length - dp[length][length];
    }
}
