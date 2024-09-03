package leetcode;

/**
 * https://leetcode.com/problems/h-index/description/
 *
 * 274. H-Index.
 *
 * Given an array of integers citations where citations[i] is the number of
 * citations a researcher received for their ith paper, return the researcher's
 * h-index.
 *
 *
 * According to the definition of h-index on Wikipedia: The h-index is defined
 * as the maximum value of h such that the given researcher has published at
 * least h papers that have each been cited at least h times.
 *
 * @author miguel
 */
public class HIndex {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] data = new int[n + 1];
        for (int c : citations) {
            data[Math.min(n, c)]++;
        }
        int hIndex = n;
        int papers = data[n];
        while (papers < hIndex) {
            papers += data[--hIndex];
        }
        return hIndex;
    }

}
