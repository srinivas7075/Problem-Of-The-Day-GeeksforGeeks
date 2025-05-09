import java.util.*;

class Solution {

    static int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] trans = new int[n];

        // Step 1: Transform the array
        for (int i = 0; i < n; i++) {
            trans[i] = (arr[i] > k) ? 1 : -1;
        }

        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        int prefixSum = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += trans[i];

            // Case 1: if prefix sum > 0, the subarray from 0 to i is valid
            if (prefixSum > 0) {
                maxLen = i + 1;
            }

            // Case 2: check if prefixSum - 1 occurred before
            if (firstOccurrence.containsKey(prefixSum - 1)) {
                maxLen = Math.max(maxLen, i - firstOccurrence.get(prefixSum - 1));
            }

            // Store first occurrence of prefix sum
            firstOccurrence.putIfAbsent(prefixSum, i);
        }

        return maxLen;
    }

}
