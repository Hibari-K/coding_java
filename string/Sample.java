public class Sample{
    public static void main(String[] args){
       

        System.out.println("===== isUniquieChars =====");
        String str1 = "abcdefghijklmnopqrstuvwxyz";
        String str2 = "abcdefghijklmnopqrstuvwxyy";
        System.out.println(str1 + " : " + Judge.isUniqueChars(str1));
        System.out.println(str2 + " : " + Judge.isUniqueChars(str2));

        System.out.println("===== isPerm =====");
        String str3 = "god and dog";
        String str4 = "dog adn gdo";
        System.out.println(str3 + ", " + str4 + " : " + Judge.isPerm(str3, str4));


        System.out.println("===== URLify =====");
        String str5 = URLify.replaceSpaces(str3, str3.length());
        System.out.println("Before : " + str3);
        System.out.println("After  : " + str5);


        System.out.println("===== isPermOfPalindrome =====");
        String str6 = "A Santa Lived As a Devil At NASA";
        System.out.println(str6);
        System.out.println(Judge.isPermOfPalindrome(str6));

        System.out.println("===== oneEdit =====");
        String str7 = "god and doo";
        System.out.println("Str1 : " + str3);
        System.out.println("Str2 : " + str7);
        System.out.println(Judge.oneEdit(str1, str2));


        System.out.println("===== Compress =====");
        String str8 = "aaaaaaaabbbcccccccdddddddd";
        String str9 = Compress.compress(str8);
        System.out.println("Before : " + str8);
        System.out.println("After  : " + str9);


        System.out.println("===== rotateMatrix =====");
        int[][] X1 = {{1, 1, 1, 3},
                     {7, 2, 4, 3},
                     {7, 8, 6, 3},
                     {7, 5, 5, 5}};

        Matrix A1 = new Matrix(X1);

        System.out.println("Before rotate");
        A1.show();

        System.out.println("");
        System.out.println("After rotate");
        
        if(!A1.rotate()) System.out.println("Rotate Failure");
        else A1.show();


        System.out.println("===== setZerosMatrix =====");
        int[][] X2 = {{1, 1, 1, 3, 2, 3},
                     {7, 2, 0, 3, 4, 5},
                     {7, 8, 6, 3, 8, 9},
                     {7, 5, 5, 5, 1, 2},
                     {7, 5, 5, 4, 0, 2},
                     {9, 5, 6, 5, 1, 2}
                     };

        Matrix A2 = new Matrix(X2);

        System.out.println("Before zeros");
        A2.show();

        System.out.println("");
        System.out.println("After zeros");
       
        A2.setZeros();
        A2.show();


        System.out.println("===== rotateString =====");
        String str10 = "gamebuilder";
        String str11 = "buildergame";
        System.out.println("Str1 : " + str10);
        System.out.println("Str2 : " + str11);
        System.out.println(Judge.isRotate(str10, str11));


    }
}
