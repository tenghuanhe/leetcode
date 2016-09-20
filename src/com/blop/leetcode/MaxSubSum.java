package com.blop.leetcode;

/**
 * Created by tenghuanhe on 2016/7/22.
 */
public class MaxSubSum {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, -3, 2};
        System.out.println(maxArraySubSum(arr));

        int[][] mat = {{1, 2}, {2, 1}, {-1, -2}, {-1, -1}};
        System.out.println(maxMatrixSubSum1(mat));
        System.out.println(maxMatrixSubSum2(mat));

        int[][] matrix = {{2, 2, -1}};
        System.out.println(maxMatrixSubSumLessThanK(matrix, 0));
    }

    public static int maxArraySubSum(int[] arr) {
        if (arr.length == 0) return 0;
        int currSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currSum > 0) {
                currSum += arr[i];
            } else {
                currSum = arr[i];
            }

            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }

        return maxSum;
    }

    public static int maxMatrixSubSum1(int[][] mat) {
        int m = mat.length; //  rows
        int n = mat[0].length; // columns

        int ps[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            ps[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            ps[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i_min = 1; i_min <= m; i_min++) {
            for (int i_max = i_min; i_max <= m; i_max++) {
                for (int j_min = 1; j_min <= n; j_min++) {
                    for (int j_max = 1; j_max <= n; j_max++) {
                        result = Math.max(result, ps[i_max][j_max]
                                - ps[i_min - 1][j_max]
                                - ps[i_max][j_min - 1]
                                + ps[i_min - 1][j_min - 1]);
                    }
                }
            }
        }

        return result;
    }

    public static int maxMatrixSubSum2(int[][] mat) {
        int m = mat.length; // rows
        int n = mat[0].length; // columns
        int ps[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            ps[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            ps[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int result = Integer.MIN_VALUE;

        for (int r_t = 1; r_t <= m; r_t++) {
            for (int r_b = r_t; r_b <= m; r_b++) {
                int start = ps[r_b][1] - ps[r_t - 1][1] - ps[r_b][0] + ps[r_t - 1][0];
                int all = ps[r_b][1] - ps[r_t - 1][1] - ps[r_b][0] + ps[r_t - 1][0];

                for (int col = 2; col <= n; col++) {
                    if (start < 0) {
                        start = 0;
                    }
                    start += ps[r_b][col] - ps[r_t - 1][col] - ps[r_b][col - 1] + ps[r_t - 1][col - 1];

                    if (start > all) {
                        all = start;
                    }
                }

                if (all > result) {
                    result = all;
                }
            }
        }

        return result;
    }


    public static int maxMatrixSubSumLessThanK(int[][] matrix, int k) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns
        int ps[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            ps[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            ps[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int result = Integer.MIN_VALUE;
        int all = Integer.MIN_VALUE;

        if (m < n) {
            for (int r_t = 1; r_t <= m; r_t++) {
                for (int r_b = r_t; r_b <= m; r_b++) {
                    int start = ps[r_b][1] - ps[r_t - 1][1] - ps[r_b][0] + ps[r_t - 1][0];
                    if (start == k) {
                        return k;
                    } // short_circuit

                    if (start < k) {
                        all = ps[r_b][1] - ps[r_t - 1][1] - ps[r_b][0] + ps[r_t - 1][0];
                    }

                    if (start > k) {
                        start = 0;
                    }
                    for (int col = 2; col <= n; col++) {
                        if (start < 0) {
                            start = 0;
                        }
                        start += ps[r_b][col] - ps[r_t - 1][col] - ps[r_b][col - 1] + ps[r_t - 1][col - 1];

                        if (start == k) {
                            return k;
                        } // short_circuit

                        if (start < k && start > all) {
                            all = start;
                        }
                    }

                    if (all <= k && all > result) {
                        result = all;
                    }
                }
            }
        } else {
            for (int c_l = 1; c_l <= n; c_l++) {
                for (int c_r = c_l; c_r <= n; c_r++) {
                    int start = ps[1][c_r] - ps[0][c_r] - ps[1][c_l - 1] + ps[0][c_l - 1];
                    if (start == k) {
                        return k;
                    } // short_circuit
                    if (start < k) {
                        all = ps[1][c_r] - ps[0][c_r] - ps[1][c_l - 1] + ps[0][c_l - 1];
                    }
                    for (int row = 2; row <= m; row++) {
                        if (start < 0) {
                            start = 0;
                        }
                        start += ps[row][c_r] - ps[row - 1][c_r] - ps[row][c_l - 1] + ps[row - 1][c_l - 1];

                        if (start == k) {
                            return k;
                        } // short_circuit

                        if (start > all) {
                            all = start;
                        }
                    }

                    if (all > result && all <= k) {
                        result = all;
                    }
                }

            }
        }

        return result;
    }


}
