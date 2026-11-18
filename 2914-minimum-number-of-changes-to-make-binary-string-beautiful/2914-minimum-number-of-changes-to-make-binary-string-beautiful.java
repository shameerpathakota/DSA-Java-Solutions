class Solution {
    public int minChanges(String s) {
        int count = 0;
        char ch = s.charAt(0);

        int changes = 0;

        for(int i = 0; i < s.length(); i++){
            //if current character matches with previous character
            if(s.charAt(i) == ch){
                count++;
                continue;
            }

            //if current character doesnot equal to previous character..
            //then check whether the just before substring length is even or odd.
            //if odd make the change equals change + 1.
            //if even start counting from here by count = 1;
            if(count % 2 == 0){
                count = 1;
            }
            else{
                changes++;
                count = 0;
            }

            ch = s.charAt(i);
        }

        return changes;
    }
}