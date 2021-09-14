import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

class Conversation {
  public static void main(String[] arguments) {
    //Declare variables
    int numRounds;
    int arrayLength; 
    int conversationSize;
    String introMessage = "Hey! What's going on?";
    String endMessage = "I hope you can find the support you need today. Bye!";
    String userString;
    String[] cannedResponse = new String[] {
      "What type of family do you come from?",
      "How connected do you feel to the people around you?",
      "Where is home to you?",
      "How do you practice self care?",
      "Does your support system meet your emotional needs?"
    };
    


    //Getting input for number of rounds
    Scanner reader = new Scanner(System.in);
    reader.useDelimiter("\n");
    System.out.print("Enter number of rounds: ");
    numRounds = reader.nextInt();
    

    //Making an array based on number of rounds
    arrayLength = (2*numRounds) + 2;

    //Making an array to store everything in that has the correct amount of spaces
    String[] conversation = new String[arrayLength];

    //Adding introMessage to the first place in the list
    conversation[0] = introMessage;

    //getting input
    System.out.print(introMessage + "\n");
    
    for (int i = 1; i < (arrayLength -1); i += 2) {
    userString = reader.next();
    conversation[i] = userString;
    String [] userList = userString.toLowerCase().split(" ");
    String mirrorString = "";
    
    for (int n=0; n < (userList.length); n++) {
      if (userList[n].equals("i")){
        userList[n] = "you";
      }
      if (userList[n].equals("i'm")){
        userList[n] = "you're";
      }
      if (userList[n].equals("me")){
        userList[n] = "you";
      }
      if (userList[n].equals("was")){
        userList[n] = "were";
      }
      if (userList[n].equals("my")){
        userList[n] = "your";
      }
      mirrorString = mirrorString.concat(userList[n] + " ");
    }
    conversation[i+1] = mirrorString;
    System.out.print(mirrorString + "? \n");
    }
    System.out.print(endMessage + "\n\n");
    conversation[arrayLength -1] = endMessage;
    
    //Printing transcript
    conversationSize = conversation.length;
    System.out.print("TRANSCRIPT \n");
    for (int w = 0; w < conversationSize; w++){
      System.out.println(conversation[w]);
    }
    reader.close();
    }
  }