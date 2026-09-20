class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n < m) return "";
        int count = 0;/* this is for keep track of whether all the characters in the string t is presnt in the window or not.*/
        //count < m means we don't have all the characters in the window yet

        int startIndex = -1;
        int min_length = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        //create an HashMap and store the string t characters frequencies
        HashMap<Character, Integer> map = new HashMap<>();
        for(int k = 0; k < m; k++){
            char ch = t.charAt(k);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }


        while(j < s.length()){
            char ch = s.charAt(j);

            if(map.containsKey(ch)){
                if(map.get(ch) > 0){
                    count++;
                }
                map.put(ch, map.getOrDefault(ch, 0) - 1);
            }

            while(count == m){
                if(j-i+1 < min_length){
                    min_length = j-i+1;
                    startIndex = i;
                }

                char leftchar = s.charAt(i);
                if(map.containsKey(leftchar)){
                    map.put(leftchar, map.getOrDefault(leftchar, 0)+1);
                    if(map.get(leftchar) > 0){
                        count--;
                    }
                }

                i++;
            }
            j++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex+min_length);

    }
}