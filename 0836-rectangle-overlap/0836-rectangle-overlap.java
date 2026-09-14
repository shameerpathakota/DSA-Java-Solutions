class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //first condition
        //if the second rectangle lies on top of the first rectanlge.
        if(rec2[1] >= rec1[3]){
            return false;
        }
        //second condition
        //if the second rectangle lies on bottom of the first rectangle.
        if(rec1[1] >= rec2[3]){
            return false;
        }
        //third condition
        //if the second rectangle lies on left side of the first rectangle. 
        if(rec2[2] <= rec1[0]){
            return false;
        }
        //fourth condition
        //if the second rectangle lies on right side of the first rectangle.
        if(rec2[0] >= rec1[2]){
            return false;
        }

        return true;
    }
    /*
    consider the rectangle non-overlap conditions. if any one of the conditions is true then the two rectangles are not overlap.if all are false then the two rectangles are overlap with each other
    */
}