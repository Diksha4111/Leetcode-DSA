class Solution {
    public int[] twoSum(int[] nums, int target) {
        /* Method1 - Brute Force */
        // int[] ans = new int[2];
        // for(int first=0 ; first<nums.length-1 ; first++){
        //     for(int second=first+1 ; second<nums.length ; second++){
        //         if(nums[first] + nums[second] == target){
        //             ans[0] = first;
        //             ans[1] = second;
        //         }
        //     }
        // }
        // return ans;


        /* Method2 - Optimal - Hash Map */
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0 ; i<nums.length ; i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                ans[0] = map.get(rem);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i] , i);
        }
        return ans;
    }
}
