class MedianFinder {

    List<Integer> al ;
    Queue<Integer> maxheap ;
    Queue<Integer> heap ;
    int i;
    public MedianFinder() {
        al = new LinkedList();
        maxheap = new PriorityQueue<Integer>((a,b)-> {
            return b - a;
        });
        i = 0;
        heap = new PriorityQueue<Integer>();
        // ((a,b)-> {
        //     return b - a;
        // });
    }
    
    public void addNum(int num) {
        // al.add(bst(num, 0, al.size()-1 ) ,  num );
        // al.add(num);
        // Collections.sort( al );
        i++;
        heap.add(num);
        
        maxheap.add(heap.poll());
        if( maxheap.size() > heap.size() ){
            heap.add( maxheap.poll() );
        }
        // System.out.println("max "+maxheap);
        // System.out.println("hp "+heap);
    }

    public int bst(int n, int l, int r){
        int m = (l+r)/2;

        if( l > r) return l;

        if( al.get(m) == n){
            return m;
        }

        if( al.get(m) > n){
            return bst(n, l ,m-1);
        }else{
            return bst(n, m+1, r);
        }
    }
    
    public double findMedian() {
        if( ( i) % 2 == 0){
            int ii = (al.size()/2 )-1;
            // return ( Double.valueOf(al.get(i)) + Double.valueOf( al.get(i+1)))/2;
            return ( Double.valueOf(heap.peek()) + Double.valueOf( maxheap.peek()))/2;
        } else{
            int ii = al.size()/2;
            // return al.get(ii);
            return  heap.size() > 0 ? heap.peek() :maxheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */