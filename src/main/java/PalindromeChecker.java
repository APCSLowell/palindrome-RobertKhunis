import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  word = word.toLowerCase();
  word = noSpaces(word);
  word = onlyLetters(word);
  
  
  
  
  /*for(int i = 0; i < word.length()/2; i++){
    if(!word.substring(i, i+1).equals(word.substring(word.length() - 1 - i, word.length()-i))){
      return false;
    }
  }*/
  if(word.equals(reverse(word))){
  return true;
  }
  return false;
}


public String reverse(String str)
{
    String sNew = new String();
    for(int i = 0; i < str.length(); i++){
    sNew += str.substring(str.length() - i - 1, str.length() - i);
    }
    return sNew;
}

public String noSpaces(String sWord){
  String bob = "";
  for(int i = 0; i < sWord.length(); i++){
    if(!sWord.substring(i, i+1).equals(" ")){
      bob += sWord.substring(i, i+1);
    }
  }
  return bob;
}

public String onlyLetters(String sString){
  String bob = "";
  for(int i = 0; i < sString.length(); i++){
    if(Character.isLetter(sString.charAt(i))){
      bob+=sString.charAt(i);
    }
  }
  return bob;
}
}
