public class URLify{
    
    private static int countSpaces(char[] str){
        
        int count = 0;
        for(int i=0; i<str.length; i++)
            if(str[i] == ' ') count++;

        return count;
    } 

    public static String replaceSpaces(String s, int len){
       
       char[] str = s.toCharArray();

        int n_space = countSpaces(str);
        if(n_space == 0) return s;

        int index = len + n_space*2;
        char[] str2 = new char[index+1];

        int i;
        if(len < str.length) str2[len] = '\0';

        for(i=len-1; i>=0; i--){
            if(str[i] == ' '){
                str2[index-1] = '0';
                str2[index-2] = '2';
                str2[index-3] = '%';

                index -= 3;
            }
            else{
                str2[index-1] = str[i];
                index--;
            }
        }

        return new String(str2);

    }
}
