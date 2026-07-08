class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergesort(nums, 0, n-1);
    }

    public static int mergesort(int[] nums, int left, int right){
        int count = 0;
        if(right > left){
            int mid = left + (right - left)/2;
            count = mergesort(nums, left, mid);
            count += mergesort(nums, mid + 1, right);
            count += merge(nums, left, mid, right);
        }

        return count;
    }

    public static int merge(int[] nums, int left, int mid, int right){
        int count = 0;

        int j = mid + 1;
        for(int i = left; i <= mid; i++){
            while(j <= right && nums[i] > 2L * nums[j]){
                j++;
            }
            count += (j - ( mid + 1));
        }
        int i = left;
        j = mid+1;
        int k = 0;
        int[] temp = new int[right - left + 1];

        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }
            else{
                temp[k++] = nums[j++];
            }
        }

        while(i <= mid){
            temp[k++] = nums[i++];
        }

        while(j <= right){
            temp[k++] = nums[j++];
        }

        for(k = 0, i = left; k < temp.length; k++,i++){
            nums[i] = temp[k];
        }

        return count;
    }
}