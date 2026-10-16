class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for(int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                if((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            Collections.sort(subset);
            set.add(subset);
        }
        result.addAll(set);
        return result;
    }
}