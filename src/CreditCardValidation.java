import java.util.Scanner;

public class CreditCardValidation
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter the credit card number:");
      long cardNumber = Long.parseLong(input.nextLine());
      if (isValid(cardNumber) == true)
      {
         System.out.print("The number " + cardNumber +" is valid");
      }
      else
      {
         System.out.print("The number " + cardNumber +" is invalid");
      }

   }
   public static boolean isValid(long number)
   {
      int sizeOfNumber = getSize(number);
      long determinationNumber ;
      int evenTotal = 0;
      int oddTotal = 0;

      if (sizeOfNumber >= 13 && sizeOfNumber <= 16)
      {    
         if(Character.toString(String.valueOf(number).charAt(0)) == "3")
         {
            determinationNumber = getPrefix(number,2);
         }
         else
         {
            determinationNumber = getPrefix(number,1);
         }
         if(checkTruth(determinationNumber) == true)
         {
            evenTotal = sumOfDoubleEvenPlace(number);
            oddTotal = sumOfOddPlace(number);
            int total = oddTotal + evenTotal;
            if(total % 10 == 0)
            {
               return true;
            }
            else
            {
               return false;
            }
         }
         else
         {
            return false;
         }
      }
      else
      {
         return false;
      }
   }

   public static int sumOfDoubleEvenPlace(long number)
   {
      String covertNumber = String.valueOf(number);
      int total = 0;
      for (int i = 0;i < covertNumber.length(); i+=2)
      {
         String character = Character.toString(covertNumber.charAt(i));
         int currentNumber = (Integer.parseInt(character))*2;
         int currentNumberValue = getDigit(currentNumber);
         total += currentNumberValue;
      }
      return total;
   }
   public static int sumOfOddPlace(long number)
   {
      String covertNumber = String.valueOf(number);
      int total = 0;
      for (int i = 1;i < covertNumber.length(); i+=2)
      {
         String character = Character.toString(covertNumber.charAt(i));
         int currentNumber = (Integer.parseInt(character));
         total += currentNumber;
      }
      return total;
   }
   public static int getDigit(int number)
   {
      String covertNumber = String.valueOf(number);

      int sum = 0;
      for (int i=0;i < covertNumber.length(); i++)
      {
         String character = Character.toString(covertNumber.charAt(i));
         sum+= Integer.parseInt(character);
      }
      return sum;
   }
   /**Return true if card number is valid*/
   public static boolean prefixMatched(long number,int d)
   {
      if(number == d)
      {
         return true;
      }
      else
      {
         return false;
      }

   }
   public static boolean checkTruth(long number)
   {
      boolean check1 = prefixMatched(number,37);
      boolean check2 = prefixMatched(number,4);
      boolean check3 = prefixMatched(number,5);
      boolean check4 = prefixMatched(number,6);
      if(check1 || check2 || check3 || check4)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   public static int getSize(long d)
   {
      String convertNumber = String.valueOf(d);
      return convertNumber.length();

   }
   public static long getPrefix(long number, int k)
   {
      String covertNumber = String.valueOf(number);
      String newNumber = "";
      for (int i = 0;i < k; i++)
      {
         String character = Character.toString(covertNumber.charAt(i));
         newNumber = newNumber + character;
      }
      return Long.parseUnsignedLong(newNumber);
   }
}
