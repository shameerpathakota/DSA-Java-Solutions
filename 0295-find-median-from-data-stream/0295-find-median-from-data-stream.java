class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size() <= right.size()){
            left.offer(num);
        }else{
            right.offer(num);
        }

        while(left.size() > 0 && right.size() > 0){
            int left_max = left.peek();
            int right_min = right.peek();

            if(left_max > right_min){
                left.offer(right_min);
                right.offer(left_max);

                left.poll();
                right.poll();
            }
            else{
                break;
            }
        }
    }
    
    public double findMedian() {
        if(left.size() != right.size()){
            return (double) left.peek();
        }

        double m1 = left.peek();
        double m2 = right.peek();

        return (m1+m2)/2.0;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */