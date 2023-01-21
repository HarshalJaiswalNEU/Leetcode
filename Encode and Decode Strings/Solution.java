public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String res="";
        for(String s:strs){
            if( s.equals("")){
                res = res+"@@#@@"+"##,##";
            }else{
                res = res+s+"##,##";
            }
        }
        return res.substring(0,res.length()-5);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        // System.out.println("s "+s);
        List<String> res = new ArrayList();
    
        for(String ss: s.split("##,##")){
            if(ss.equals("@@#@@")){
                res.add("");
            }else{
                res.add(ss);
            }
        }
        return res;
    }
}
