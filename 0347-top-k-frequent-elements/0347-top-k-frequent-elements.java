class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(key);
        }

        int[] result = new int[k];
        int index = 0;

        for(int pos = bucket.length-1; pos >= 0 && index < k; pos--){
            if(bucket[pos] != null){
                for(Integer value : bucket[pos]){
                    if(index == k){
                        break;
                    }
                    result[index] = value;
                    index++;
                }
            }
        }

        return result;
    }
}