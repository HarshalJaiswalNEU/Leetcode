public class Solution {
    public string LicenseKeyFormatting(string s, int k) {

        String res = s.Replace("-", "");
        if( res == ""){
            return "";
        }
        StringBuilder builder = new StringBuilder();

        int i = 1;
        res = res.ToUpper();

        for( int j = res.Length-1; j>=0  ; j--){
            builder.Insert(0, res[j]);
            if( i == k){
                builder.Insert(0,"-");
                i =0;
            }
            i++;
        }
        // Console.WriteLine(builder.ToString());
        if(builder[0] == '-'){
            return builder.ToString(1, builder.Length-1);
        }
        


        return builder.ToString();
    }
}