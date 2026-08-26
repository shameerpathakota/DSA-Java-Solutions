class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int start = -1;
        int end = -1;
        int min = Integer.MAX_VALUE;
        String dummy = "";
        HashMap<Character, Integer> map = new HashMap<>();
        boolean flag = true;
        while(j < n){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);

                while(map.containsKey('1') && map.get('1') >= k && i <= j){
                    if(j - i + 1 <= min){
                        start = i;
                        end = j;
                        min = end - start + 1;
                        if(flag == true){
                            dummy = s.substring(start, end+1);
                            flag = false;
                        }
        
                        else if(j-i+1 == dummy.length() && dummy.compareTo(s.substring(i, j+1)) > 0){
                            dummy = s.substring(i, j+1);
                        }

                        else if(j-i+1 < dummy.length()){
                            dummy = s.substring(i, j+1);
                        }

                    }
                    char c = s.charAt(i);
                    map.put(c, map.getOrDefault(c, 0)-1);
                    i++;
                }

            j++;
        }

        return start == -1 ? "" : dummy;
    }
}