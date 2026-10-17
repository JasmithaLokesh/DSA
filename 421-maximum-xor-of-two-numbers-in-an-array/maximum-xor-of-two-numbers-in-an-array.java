class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXOR = 0;
        int mask = 0;

        for(int i = 31; i >= 0; i--) {
            mask |= (1 << i);

            java.util.Set<Integer> set = new java.util.HashSet<>();

            for(int num : nums) {
                set.add(num & mask);
            }

            int candidate = maxXOR | (1 << i);

            for(int prefix : set) {
                if(set.contains(candidate ^ prefix)) {
                    maxXOR = candidate;
                    break;
                }
            }
        }
        return maxXOR;
    }
}