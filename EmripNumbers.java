package challenges;

import java.math.BigDecimal;
import java.util.Scanner;

public class EmripNumbers {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Number to test? ");
        int emrip = scanner.nextInt();
        scanner.close();

        if(emrip > 10) {
            int newIntEmrip = reverseDigits(emrip);

            boolean isPrime = checkPrimeNumber(emrip);
            boolean isNewPrime = checkPrimeNumber(newIntEmrip);

            if (isNewPrime && isPrime) {
                System.out.println(emrip + " is an Emrip number! " + newIntEmrip + " is also a prime");
            } else {
                System.out.println(emrip + " is not an Emrip number");
            }
        }
        else{
            System.out.println(emrip + " must be greater than 10 for a proper emrip number!");
        }
    }

    public static boolean checkPrimeNumber(int numberToCheck){

        System.out.println("checking " + numberToCheck);

        double sqRoot = Math.sqrt(numberToCheck);

        boolean isPrime = true;

        for(int i=2 ; i < sqRoot ; i++){
            int divisor = numberToCheck/i;
            int newSum = divisor * i;
            int remainder = numberToCheck - newSum;

           /*
            System.out.println("remainder " + numberToCheck + "/" + i + " = " + remainder);
            */

            if(remainder == 0){
                System.out.println(numberToCheck + " is divisble by " + i);
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    public static int reverseDigits(int number ){
        String emripAsString = Integer.toString(number);
        String newEmrip = "";
        int emripLength = emripAsString.length();
        for(int i=emripLength; i > 0 ; i--){
            newEmrip = newEmrip + emripAsString.charAt(i-1);
        }

        int newIntEmrip = Integer.parseInt(newEmrip);

        System.out.println("reversed = " + newEmrip);

        return newIntEmrip;
    }
}
