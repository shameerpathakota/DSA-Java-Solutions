class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] arr : reservedSeats){
            int row = arr[0];
            int seat = arr[1];

            if(!map.containsKey(row)){
                map.put(row, new HashSet<>());
            }
            map.get(row).add(seat);
        }

        int result = (n - map.size()) * 2;

        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
            Set<Integer> seats = entry.getValue();

            boolean groupA = !seats.contains(2) && !seats.contains(3) && !seats.contains(4) && !seats.contains(5);
            boolean groupB = !seats.contains(4) && !seats.contains(5) && !seats.contains(6) && !seats.contains(7);
            boolean groupC = !seats.contains(6) && !seats.contains(7) && !seats.contains(8) && !seats.contains(9);

            if(groupA && groupC){
                result += 2;
            }
            else if(groupA || groupB || groupC){
                result += 1;
            }

        }

        return result;
    }
}