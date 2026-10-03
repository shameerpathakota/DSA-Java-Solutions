class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int x : set){
            list.add(x);
        }

        Collections.sort(list);

        ArrayList<Integer> temp = new ArrayList<>();
        int i = 0;
        
        while(!list.isEmpty()){
            int num = list.get(i);
            if(map.containsKey(num)){
                temp.add(num);
                map.put(num, map.getOrDefault(num, 0) - 1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
                i++;
                if(i == list.size()){
                    i = 0;
                }
            }
            else{
                list.remove(Integer.valueOf(num));
                if(i == list.size()){
                    i = 0;
                }
            }
        }

        for(int k = 0; k < n; k++){
            ans[k] = temp.get(k);
        }

        return ans;
    }
}