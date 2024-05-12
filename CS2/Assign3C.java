import java.util.Scanner;
public class Assign3C
{
  public static void main(String[] args)
  {
    int numComp,
      firstPos = 0, secondPos = 0, thirdPos = 0;
    int[] setOne = new int[5], setTwo = new int[5];
    double scoreOneAve, scoreTwoAve,
      firstVal = 0, secondVal = 0, thirdVal = 0;
    double[] scores;
    String[][] info;
    Scanner theInput = new Scanner(System.in);

    System.out.println("Please enter the number of competators. no more than 25 or less than 3");
    numComp = theInput.nextInt();
    info = new String[numComp][3];
    scores = new double[numComp];

    for(int I = 0; I < numComp; I++)
    {
      System.out.println("Please enter the fist name, last name, and state of the competator all separated by a space");
      info[I][0] = theInput.next();
      info[I][1] = theInput.next();
      info[I][2] = theInput.next();

      System.out.println("Enter scores from round 1:");
      for(int j = 0; j < 5; j++)
      {
        System.out.println("Score from judge " + (j +1));
        setOne[j] = theInput.nextInt();
      }

      System.out.println("Enter scores from round 2:");
      for(int j = 0; j < 5; j++)
      {
        System.out.println("Score from judge " + (j+1));
        setTwo[j] = theInput.nextInt();
      }

      removeMin(setOne);
      removeMax(setOne);
      scoreOneAve = getAve(setOne);
      removeMin(setTwo);
      removeMax(setTwo);
      scoreTwoAve = getAve(setTwo);
      if (scoreTwoAve > scoreOneAve)
      {
        scores[I] = scoreTwoAve;
      }
      else
      {
        scores[I] = scoreOneAve;
      }
    }

    for(int I = 0; I < numComp; I++)
    {
      System.out.printf("From %s, %s %s\'s score is: %.2f \n", info[I][2], info[I][0], info[I][1], scores[I]);
    }

    for(int I = 0; I < numComp; I++)
    {
      if(scores[I] > firstVal)
      {
        firstPos = I;
        firstVal = scores[I];
      }
      else if(scores[I] > secondVal)
      {
        secondPos = I;
        secondVal = scores[I];
      }
      else if(scores[I] > thirdVal)
      {
        thirdPos = I;
        thirdVal = scores[I];
      }
    }

    System.out.println("\nThe winners of the Competition are:");
    System.out.printf("Gold: %s %s\n", info[firstPos][0], info[firstPos][1]);
    System.out.printf("Silver: %s %s\n", info[secondPos][0], info[secondPos][1]);
    System.out.printf("Bronze: %s %s\n", info[thirdPos][0], info[thirdPos][1]);
  }

  public static void removeMin(int[] setScores)
  {
    int min = 100;
    int removePos = 5;
    for (int I = 0; I < 5; I++)
    {
      if(setScores[I] <= min)
      {
        min = setScores[I];
        removePos = I;
      }
    }
    setScores[removePos] = 0;
  }

  public static void removeMax(int[] setScores)
  {
    int max = 0;
    int removePos = 5;
    for (int I = 0; I < 5; I++)
    {
      if(setScores[I] >= max)
      {
        max = setScores[I];
        removePos = I;
      }
    }
    setScores[removePos] = 0;
  }

  public static double getAve(int[] setScores)
  {
    double total = 0;
    double ave = 0;
    for (int I = 0; I < 5; I++)
    {
      total = (double)setScores[I] + total;
    }
    ave = total/3.0;
    return ave;
  }
}
