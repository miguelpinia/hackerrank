package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/plus-minus/problem
 *
 * @author miguel
 */
public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        float size = arr.size();
        long totalPositive = arr.stream().filter(n -> n > 0).count();
        long totalNegative = arr.stream().filter(n -> n < 0).count();
        float positive = totalPositive / size;
        float negative = totalNegative / size;
        float zeros = (arr.size() - (totalPositive + totalNegative)) / size;
        System.out.println(String.format("%.6f\n%.6f\n%.6f", positive, negative, zeros));
    }

    public static void main(String[] args) throws IOException {
//        STDIN           Function
//-----           --------
//6               arr[] size n = 6
//-4 3 -9 0 4 1   arr = [-4, 3, -9, 0, 4, 1]
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            plusMinus(arr);
        }
    }

}
