class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int preffix_product = 1;
        int suffix_product = 1;
        for(int i = 0; i < n; i++){
            if(preffix_product == 0){// it means , we encounter the 0 so we are starting it as a new sub problem
                preffix_product = 1;
            }
            if(suffix_product == 0){
                suffix_product = 1;
            }

            preffix_product *= nums[i];
            suffix_product *= nums[n-i-1];

            max = Math.max(max, Math.max(preffix_product, suffix_product));
        }

        return max;
    }
    /*There are cases
     1 -> if all the values are +ve (Then simply multiply all the values in the array).
     2 -> if there are even count of -ve values (Then also multiply all the values in the array).
     3 -> if there are odd count of -ve values (Then we just simply need to remove one -ve number, so that it became the second case)
     4 -> if the array contains 0 (then the problem breaks into 2 sub problems i.e.. starting to just before 0 and after 0 to till end)
     5 -> if all the values are -Ve and the count was odd (Then we need to remove only one element from the array and those are either first element or last element. So that it became the case 2).

     So the Idea is
      start calculating the product from front and last simultaneously along with that maintain a max_variable to store the maximum product
    */
}