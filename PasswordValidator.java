package challenges;

import java.util.Scanner;

/*
Password validator from SoloLearn app
password must be a minimum of 5 characters
password must be a maximum of 10 characters
password must contain at least 1 number
password must contain at least 1 non-numeric/non-alphabetic character
password must not contain any spaces
 */
public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your new password");
        String thePassword = scanner.next();

        scanner.close();
/*
        System.out.println("your password is " + thePassword);

 */
        boolean isValidPassword = validatePassword(thePassword);

        if(isValidPassword){
            System.out.println("Password is valid");
        }
        else{
            System.out.println("Password is not valid");
        }
    }

    public static boolean validatePassword(String incomingPassword){
        int passwordLength = incomingPassword.length();

        /*
        System.out.println("passwordLength " + passwordLength);
         */

        if(passwordLength < 5 || passwordLength > 10){
            return false;
        }
        else {
            int numberCount = 0;
            int specialCount = 0;
            int spaceCount = 0;

            for(int i=0 ; i < passwordLength ; i++){
                char thisCharacter = incomingPassword.charAt(i);

                boolean isSpace = Character.isSpaceChar(thisCharacter);
                boolean isNumber = Character.isDigit(thisCharacter);
                boolean isLetter = Character.isLetter(thisCharacter);
/*
                System.out.println("thisCharacter " + thisCharacter);
                System.out.println("isSpace " + isSpace);
                System.out.println("isNumber " + isNumber);
                System.out.println("isLetter " + isLetter);
*/

                if(isSpace){
                    spaceCount++;
                }

                if(isNumber){
                    numberCount++;
                }

                if(!isLetter && !isNumber && !isSpace){
                    specialCount++;
                }
            }
/*
            System.out.println("spaceCount " + spaceCount);
            System.out.println("numberCount " + numberCount);
            System.out.println("specialCount " + specialCount);
*/
            if(spaceCount > 0){
                return false;
            }
            else {
                if(numberCount > 0 && specialCount > 0){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
    }
}
