package median_of_two_sorted_arrays;

import java.util.Arrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return median(nums1, 0, nums1.length, nums2, 0, nums2.length);
    }
    
    public double median(int[] S1, int lo1, int n1, int[] S2, int lo2, int n2) {
        if (n1 > n2) return median(S2, lo2, n2, S1, lo1, n1);
        if (n2 < 6) return trivialMedian(S1, lo1, n1, S2, lo2, n2);
        if (2 * n1 < n2) return median(S1, lo1, n1, S2, lo2 + (n2 - n1 - 1) / 2, n1 + 2 - (n2 - n1) % 2);
        int mi1 = lo1 + n1 / 2;
        int mi2a = lo2 + (n1 - 1) / 2;
        int mi2b = lo2 + n2 - 1 - n1 / 2;
        if (S1[mi1] > S2[mi2b]) {
            return median(S1, lo1, n1 / 2 + 1, S2, mi2a, n2 - (n1 - 1) / 2);
        } else if (S1[mi1] < S2[mi2a]) {
            return median(S1, mi1, (n1 + 1) / 2, S2, lo2, n2 - n1 / 2);
        } else {
            return median(S1, lo1, n1, S2, mi2a, n2 - (n1 - 1) / 2 * 2);
        }
    }
    
    public double trivialMedian(int[] S1, int lo1, int n1, int[] S2, int lo2, int n2) {
        int[] list = new int[n1 + n2];
        for (int i = 0; i < n1; i ++) {
            list[i] = S1[lo1 + i];
        }
        for (int i = 0; i < n2; i ++) {
            list[i + n1] = S2[lo2 + i];
        }
        Arrays.sort(list);
        return (list[list.length / 2] + list[(list.length - 1) / 2]) / 2.0;
    }
}