import java.util.*;

public class Judge{
    
    // isUniqueChars
    // supposed to be ASCII
    public static boolean isUniqueChars(String str){
        if(str.length() > 128) return false;

        // hash array
        boolean[] judge = new boolean[128];
        for(int i=0; i<str.length(); i++){
            int chr = str.charAt(i);

            if(judge[chr]) return false;

            judge[chr] = true;
        }

        return true;
    }

    // isPerm
    // supposed to be ASCII
    private static String sort(String str){
        char[] chr = str.toCharArray();
        Arrays.sort(chr);

        return new String(chr);
    }

    public static boolean isPerm(String str1, String str2){
        
        if(str1.length() != str2.length()) return false;

        return sort(str1).equals(sort(str2));
    }

    // isPermOfPalindrome
    private static void countChar(String str, int[] count){
        
        // hash
        for(int i=0; i<str.length(); i++){       
            char c = str.charAt(i);
            if(c >= 'a' && c <= 'z')  count[c]++;
        }
    }

    private static boolean checkOddNumber(int[] count){
        
        int num_odd = 0;
        for(int i=0; i<count.length; i++){       
            if(count[i] % 2 != 0) num_odd++;
            if(num_odd > 1) return false;
        }
        return true;
    }

    private static String sanitizeString(String s){
        
        char[] chr = s.toCharArray();

        for(int i=0; i<chr.length; i++){
            if(chr[i] >= 'A'  && chr[i] <= 'Z'){
                chr[i] += 0x20;
            }
        }
        return new String(chr);
    }
    
    public static boolean isPermOfPalindrome(String s){
        
        int[] count = new int[128];

        String test_str = sanitizeString(s);

        countChar(test_str, count);

        return checkOddNumber(count);
    }


    // oneEdit
    private static boolean oneReplace(String str1, String str2){
       
       boolean alreadyFound = false;
       for(int i=0; i<str1.length(); i++){

            // check difference
            if(str1.charAt(i) != str2.charAt(i)){
                
                if(alreadyFound) return false;
                alreadyFound = true;
            }
       }

        // if str1 == str2, return false
        return alreadyFound;
    }

    // supposed to str1.length() > str2.length()
    // algorithm with pointer
    private static boolean _oneInsert(String str1, String str2){
        
        int i1, i2;
        for(i1=0, i2=0; i1 < str1.length() && i2 < str2.length();){     
            if(str1.charAt(i1) != str2.charAt(i2)){
                // (i1 != i2) == true means two char diff was found
                if(i1 != i2) return false;

                i1++;
            }
            else{
                i1++;
                i2++;
            }
        }
        
        return true;
    }

    private static int[] countASCII(String str){
        int[] count = new int[128];

        for(int i=0; i<str.length(); i++) count[str.charAt(i)]++;

        return count;
    }
        
    
    // algorithm with hash
    private static boolean oneInsert(String str1, String str2){
        
        int[] c1 = countASCII(str1);
        int[] c2 = countASCII(str2);

        int index;
        for(index=0; index<c1.length; index++){
            if(c1[index] != c2[index]) break;
        }

        char c = (char)index;

        for(int i=0; i<=str2.length(); i++){
            String test = str2.substring(0, i) + Character.toString(c) + str2.substring(i, str2.length());

            if(str1.equals(test)) return true;
        }

        return false;
    }

    public static boolean oneEdit(String str1, String str2){
        
        int len1 = str1.length();
        int len2 = str2.length();

        if(len1 == len2) return oneReplace(str1, str2);
        else if(len1+1 == len2) return oneInsert(str2, str1);
        else if(len1-1 == len2) return oneInsert(str1, str2);

        return false;
    }


    // isRotate
    private static boolean isSubstring(String ss, String s2){
        return ss.contains(s2);
    }

    public static boolean isRotate(String s1, String s2){
        
        if(s1.length() != s2.length()) return false;

        String ss = s1 + s1;

        // Example: s1 = gamebuilder, s2 = buildergame
        // ss = gamebuildergamebuilder = game"buildergame"builder
        // which means if isRotate(s1, s2) is true, ss contains s2
        return isSubstring(ss, s2);
    }

}
