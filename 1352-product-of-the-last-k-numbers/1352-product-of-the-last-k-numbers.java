class ProductOfNumbers {
    ArrayList<Integer> list;
    int n; // size of the list.
    public ProductOfNumbers() {
        list = new ArrayList<>();
        n = 0;
    }
    
    public void add(int num) {
        if(num == 0){
            list.clear();
            n = 0;
            return;
        }
        else if(n == 0){
            list.add(num);
            n++;
            return;
        }
        list.add(list.get(n-1)*num);
        n++;
    }
    
    public int getProduct(int k) {
        if(k == n){
            return list.get(n-1);
        }
        else if(k > n){
            return 0;
        }

        return list.get(n-1)/list.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */