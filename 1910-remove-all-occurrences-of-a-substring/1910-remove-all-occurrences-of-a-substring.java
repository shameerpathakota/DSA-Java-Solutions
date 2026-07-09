class Solution {
    public String removeOccurrences(String s, String part) {
        int n = part.length();
        int occurrence = s.indexOf(part);
        while(occurrence != -1){
            StringBuilder str = new StringBuilder();
            str.append(s, 0, occurrence);
            if(occurrence+ n <= s.length()){
                str.append(s, occurrence+n, s.length());
            }
            s = str.toString();
            occurrence = s.indexOf(part);
        }
        return s;
    }
}