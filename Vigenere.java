import java.util.ArrayList;

public class Vigenere {
  public static void run() {
    char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
        'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    char[][] array = createTable(alphabet);
    printTable(array);


    //user input
    System.out.println("what is your key?");
    String key = Library.input.nextLine();
    ArrayList<Integer> keyList = new ArrayList<Integer>();
    for (int i = 0; i < key.length(); i++) {
      keyList.add(linearSearch(alphabet, key.charAt(i)));
    }

    System.out.println("Encrypt (1) or decrypt(2) a message?");
    int choice = Library.input.nextInt();
    Library.input.nextLine();

    //encrypt flow
    if (choice == 1) {
      System.out.println("What plain text message?");
      String plain = Library.input.nextLine();
      ArrayList<Integer> plainList = new ArrayList<Integer>();
      for (int i = 0; i < plain.length(); i++) {
        plainList.add(linearSearch(alphabet, plain.charAt(i)));
      }

      System.out.println("");
      System.out.println("Your encrypted message is: ");
      System.out.println(encrypt(array, keyList, plainList));
    }

    //decrypt flow
    if (choice == 2) {
      System.out.println("What encrypted message?");
      String code = Library.input.nextLine();
      ArrayList<Integer> codeList = new ArrayList<Integer>();
      for (int i = 0; i < code.length(); i++) {
        codeList.add(linearSearch(alphabet, code.charAt(i)));
      }

      System.out.println("");
      System.out.println("Your decrypted message is: ");
      System.out.println(decrypt(array, keyList, code));
    }
  }




  //DECRYPT
  public static String decrypt(char [][] arr, ArrayList<Integer> k, String c) {
    ArrayList<Integer> message = new ArrayList<Integer>();
    for(int i =0; i < c.length(); i++){
      message.add(linearSearch(arr[k.get(i%(k.size()))], c.charAt(i)));
    }
    String messageret = "";
    for(int i =0; i < message.size(); i++){
      messageret += Character.toString(arr[0][message.get(i)]);
    }
    return messageret; 
  }

  //ENCRYPT
  public static String encrypt(char [][] arr, ArrayList<Integer> k, ArrayList<Integer> c) {
    String message = "";
    for(int i =0; i < c.size(); i++){
      message += arr[c.get(i)][k.get(i%(k.size()))];
    }
    System.out.println();
    return message; 
  }

  //2D LIST OF LETTERS
  private static char[][] createTable(char[] alphabet) {
    char[][] table = new char[alphabet.length][alphabet.length];
    int a;
    for (int row = 0; row < alphabet.length; row++) {
      for (int col = 0; col < alphabet.length; col++) {
        a = row + col;
        if (a >= alphabet.length) {
          a = a - alphabet.length;
        }
        table[row][col] = alphabet[a];
      }
    }
    return table;
  
  }


  //PRINT TABLE
  private static void printTable(char[][] table) {
    System.out.println("    A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
    System.out.println();
    for (int r = 0; r < table.length; r++) {
      System.out.print(table[r][0] + "   ");
      for (int c = 0; c < table[r].length; c++) {
        System.out.print(table[r][c] + " ");
      }
      System.out.println();
    }
  }// end printTable

  public static void getChar(char[][] arr, int r, int c) {
    System.out.println(arr[r][c]);
  }

  //
  public static int linearSearch(char[] arr, char searchTerm) {
    for (int i = 0; i < arr.length; i++) {
      if (Character.toLowerCase(arr[i]) == Character.toLowerCase(searchTerm)) {
        return i;
      }
    }
    return -1;
  }

}// end class