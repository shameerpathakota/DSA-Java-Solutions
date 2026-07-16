class Solution {
    public int firstUniqChar(String s) {
        Queue<Character> q = new LinkedList<>();
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            q.offer(ch);

            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
                q.poll();
            }
        }

        if(q.isEmpty()){
            return -1;
        }
        return s.indexOf(q.peek());
    }
}