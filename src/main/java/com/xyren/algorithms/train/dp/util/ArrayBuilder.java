package com.xyren.algorithms.train.dp.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author renxiaoya
 * @date 2022-04-26
 **/
public class ArrayBuilder {

    public static int[][] buildArray(String fileName) throws IOException {
        List<String> lines = FileUtils.readLines(new File("src/main/resources/" + fileName), Charset.defaultCharset());
        int rowCount = Integer.parseInt(lines.get(0));
        int[][] res = new int[rowCount + 1][rowCount + 1];
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] segs = line.split(" ");
            int length = segs.length;
            for (int j = 0; j < length; j++) {
                res[i][j] = Integer.parseInt(segs[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String fileName = "triangle-array.txt";
        try {
            int[][] array = buildArray(fileName);
            System.out.println(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
