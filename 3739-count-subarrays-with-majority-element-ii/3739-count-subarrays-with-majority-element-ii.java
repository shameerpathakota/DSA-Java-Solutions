class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            if(nums[i] == target){
                arr[i] = 1;
            }
            else{
                arr[i] = -1;
            }
        }

        int[] prefixSum = new int[n+1];
        prefixSum[0] = 0;
        for(int k = 1; k < n+1; k++){
            prefixSum[k] = prefixSum[k-1] + arr[k-1];
        }

        return mergeSort(prefixSum, 0, n);
    }

    long mergeSort(int[] nums, int left, int right){
        long count = 0;
        if(right > left){
            int mid = left + (right - left)/2;
            count = mergeSort(nums, left, mid);
            count += mergeSort(nums, mid+1, right);
            count += merge(nums, left, mid, right);
        }

        return count;
    }

    long merge(int[] nums, int left, int mid, int right){
        long count = 0;
        int i = left;
        for(int j = mid+1; j <= right; j++){
            while(i <= mid && nums[i] < nums[j]){
                i++;
            }
            count += (i-left);
        }

        int a = left;
        int b = mid+1;
        int k = 0;
        int[] temp = new int[right-left+1];

        while(a <= mid && b <= right){
            if(nums[a] <= nums[b]){
                temp[k++] = nums[a++];
            }
            else{
                temp[k++] = nums[b++];
            }
        }

        while(a <= mid){
            temp[k++] = nums[a++];
        }

        while(b <= right){
            temp[k++] = nums[b++];
        }

        
        for(k = 0, a = left; k < temp.length; k++, a++){
            nums[a] = temp[k];
        }

        return count;

    }
}