class Solution {
    private void Sort(int nums[], int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        Sort(nums, low, mid);
        Sort(nums, mid + 1, high);

        merg(nums, low, mid, high);
    }

    private void merg(int[] nums, int low, int mid, int high) {
        int temp[] = new int[high - low + 1];
        int right = mid + 1;
        int left = low;
        int k = 0;
        while (left <= mid && right <= high) {
            if (nums[left] < nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = nums[left++];
        }
        while (right <= high) {
            temp[k++] = nums[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }

    public int[] sortArray(int[] nums) {
        Sort(nums, 0, nums.length - 1);
        return nums;
    }
}