package com.blop.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tenghuanhe on 2016/7/17.
 */
public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(getRow(3));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            if (i == 1) {
                row.add(1);
            } else if (i == 2) {
                row.add(1);
                row.add(1);
            } else {
                List<Integer> lastRow = result.get(i - 2);
                row.add(1);
                for (int j = 1; j < i - 1; j++) {
                    row.add(lastRow.get(j - 1) + lastRow.get(j));
                }
                row.add(1);
            }

            result.add(row);
        }

        return result;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> lastRow = new ArrayList<>();

        for (int i = 1; i <= rowIndex + 1; i++) {
            List<Integer> row = new ArrayList<>();
            if (i == 1) {
                row.add(1);
                lastRow = row;
            } else if (i == 2) {
                row.add(1);
                row.add(1);

                lastRow = row;
            } else {
                row.add(1);
                for (int j = 1; j < i - 1; j++) {
                    row.add(lastRow.get(j - 1) + lastRow.get(j));
                }
                row.add(1);
                lastRow = row;
            }
        }

        return lastRow;
    }
}
