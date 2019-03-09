public class Compress{
    
    private static int countCompression(String str){
        
        int compLen = 0;
        int countConsec = 0;

        for(int i=0; i<str.length(); i++){
            
            countConsec++;

            if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                compLen += 1 + String.valueOf(countConsec).length(); // 12 is 2
                countConsec = 0;
            }
        }

        return compLen;
    }

    public static String compress(String str){
        
        int compLen = countCompression(str);
        if(compLen >= str.length()) return str;

        StringBuilder comp = new StringBuilder(compLen);
        int countConsec = 0;

        for(int i=0; i<str.length(); i++){
            countConsec++;

            if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                comp.append(str.charAt(i));
                comp.append(countConsec);

                countConsec = 0;
            }
        }

        return comp.toString();
    }
}
