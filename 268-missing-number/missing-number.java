class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return n;
    }
}