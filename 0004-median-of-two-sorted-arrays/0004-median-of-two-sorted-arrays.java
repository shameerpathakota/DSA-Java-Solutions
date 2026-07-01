class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int n = nums1.length;
        int m = nums2.length;
        int a = n + m;
        int[] ans = new int[a];
        while(i < n && j < m){
            if(nums1[i] <= nums2[j]) {
                ans[k] = nums1[i];
                i++;
                k++;
            } else{
                ans[k] = nums2[j];
                j++;
                k++;
            }
        }

        while(i < n){
            ans[k] = nums1[i];
            i++;
            k++;
        }

        while(j < m){
            ans[k] = nums2[j];
            j++;
            k++;
        }

        int start = 0;
        int end = ans.length-1;
        if(a % 2 != 0){
            int median = start + (end-start)/2;
            return ans[median];
        }

        int median1 = a/2 - 1;
        int median2 = a/2;
        float result = (ans[median1] + ans[median2])/2.0f;
        return result;
    }
}