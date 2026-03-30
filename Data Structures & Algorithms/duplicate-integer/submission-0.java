class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for(Map.Entry<Integer, Integer> mp: map.entrySet()){
            if(mp.getValue()>1){
                return true;
            }
        }
        return false;
    }
}