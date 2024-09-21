import java.util.Scanner;

class Library {
    //scanner
    public static Scanner input = new Scanner(System.in);
    //nextInt()    nextDouble()    nextBoolean()    nextLine()    next()

    public static int myRandom (int min, int max){
        //from min to one less than max
        int num =  (int) (Math.random() * (max - min)   + min);
        return num;
    }
    
}//class