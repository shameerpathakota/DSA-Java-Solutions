class StockSpanner {
    class Node{
        int cost;
        int span;

        Node(int price, int span){
            this.cost = price;
            this.span = span;
        }
    }

    Stack<Node> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        while(!stack.isEmpty() && stack.peek().cost <= price){
            span += stack.pop().span;
        }

        stack.push(new Node(price, span));

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */