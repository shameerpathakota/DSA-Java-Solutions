class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for(int i = 0; i < s.length()-1; i++){
            int current = Roman(s.charAt(i));
            if(current < Roman(s.charAt(i+1))){
                result -= current;
            }
            else{
                result += current;
            }
        }

        result += Roman(s.charAt(s.length()-1));

        return result;
    }

    static int Roman(char ch){
        switch(ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            default : return 1000;
        }
    }
}