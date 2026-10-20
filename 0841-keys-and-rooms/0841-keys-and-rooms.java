class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);//initially it opens kadha😅
        boolean[] vis = new boolean[n];
        vis[0] = true;

        while(!stack.isEmpty()){
            int node = stack.pop();

            for(int neighbors : rooms.get(node)){
                if(!vis[neighbors]){
                    vis[neighbors] = true;
                    stack.push(neighbors);
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(!vis[i]) return false;
        }

        return true;
    }

}
/*idea enti antey stack use cheyyi. simple first 0th room open annadu kaabatti stack loki 0 ni push cheyyi mana daggara keys unnantha varaku antey stack empty ayye varaku chudu, first stack nunchi pop cheyyi neeku oka room value vastadhi aa room lo unnna neighbors andarini true mark cheyyi(avi mark avvakunda unteyney) then mark chesina prati room ni stack loki push cheyyi. simple gaa last lo oka traversal cheyyi vis array ni ekkadaina false untey(un visited room unte return false) otherwise return true*/