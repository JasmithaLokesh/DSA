class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }

        if(sum % k != 0) {
            return false;
        }

        int target = sum / k;

        for(int num : nums) {
            if(num > target) {
                return false;
            }
        }

        int totalMasks = 1 << n;
        int[] dp = new int[totalMasks];

        java.util.Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int mask = 0; mask < totalMasks; mask++) {
            if(dp[mask] == -1) {
                continue;
            }

            for(int i = 0; i < n; i++) {
                if((mask & (1 << i)) != 0) {
                    continue;
                }

                int nextSum = dp[mask] + nums[i];

                if(nextSum <= target) {
                    int nextMask = mask | (1 << i);
                    dp[nextMask] = nextSum % target;
                }
            }
        }
        return dp[totalMasks - 1] == 0;
    }
}