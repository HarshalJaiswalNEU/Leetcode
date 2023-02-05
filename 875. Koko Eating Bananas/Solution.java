class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        Arrays.sort(piles);
        
        int r = piles[ piles.length-1 ];
        int l = 1;
        int k;
        int[] res = new int[piles.length];

        int min = r;
        while(true){
            int sum = 0;
            k = l + ((r-l)/2) ;
            for( int i =0; i< piles.length; i++){
                int d =  piles[i]/ k;
                if( piles[i] % k != 0){
                    d++;
                }
                res[i] = d;
            }
            for( int i =0; i< piles.length; i++){
                sum+= res[i];
                if( sum > h ) break;
            }
            // System.out.println(sum+ " k "+k +" l"+l+ " r"+r);
            if( sum <= h ){
                r = k;
                // System.out.println(" r->k");
                
            }else{
               l = k+1;
            //    System.out.println(" l->k");
            }

            if( k < min && sum <= h){
                min = k;
            }


            // System.out.println(sum+ " k "+k +" l "+l+ " r"+r);
            if( l >= r && sum <= h ){
                // System.out.println("ret "+k);
                return k;
            }
               
        }
    }
}