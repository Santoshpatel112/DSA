class Solution {
    public int findKthPositive(int[] arr, int k) {

        HashSet<Integer> set = new HashSet<>();

        for (int n : arr) {
            set.add(n);
        }

        int[] num = new int[k];
        int j = 0;
        int i = 1;

        while (j < k) {
            if (!set.contains(i)) {
                num[j++] = i;
            }
            i++;
        }

        return num[k - 1];
    }
}