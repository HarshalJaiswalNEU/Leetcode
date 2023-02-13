class Solution {
    public int lastStoneWeight(int[] stones) {
        
        Queue<Integer> heap = new PriorityQueue<Integer>((a,b)->{
             return (b - a); });

        for( int n: stones){
            heap.add(n);
        }
        while(heap.size() > 1){
            int dif = heap.poll() - heap.poll();
            if(dif != 0){
                heap.add(dif);
            }
        }

        return heap.size() == 1 ? heap.poll():0;
    }
}