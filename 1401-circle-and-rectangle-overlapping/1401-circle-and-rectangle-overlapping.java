class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        //find the nearest point to the circle.
        int xi = Integer.MIN_VALUE;
        int yi = Integer.MIN_VALUE;

        if(x1 > xCenter){
            xi = x1;
        }
        else if(x2 < xCenter){
            xi = x2;
        }
        else{
            xi = xCenter;
        }

        if(y1 > yCenter){
            yi = y1;
        }
        else if(y2 < yCenter){
            yi = y2;
        }
        else{
            yi = yCenter;
        }

        double distance = Math.sqrt((xi-xCenter)*(xi-xCenter) + (yi-yCenter)*(yi-yCenter));
        return distance <= radius;
    }
}