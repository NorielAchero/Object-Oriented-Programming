package Exception;
import java.util.*;

public class ExceptionMain{

    public static void main(String[] args) {

        String validPassword = "password";
        Scanner sc = new Scanner(System.in);

        System.out.println("Noriel Achero | 2 BSCS ");
        System.out.println();

        for(int i = 1; i <= 3; i++) {

            try {

                System.out.println("___________________________________");
                System.out.println("Log In Attempt " + i);
                System.out.print("Enter Password: ");
                String enteredPass = sc.nextLine();

                if(enteredPass.equals(validPassword)){
                    System.out.println();
                    System.out.println("Log In Successful");
                    System.out.println();
                    break;
                }
                else if ( i >= 3) {
                    throw new maximumException("Log In Attempts Exceeded. Log In Failed");
                }
                else if (!enteredPass.equals(validPassword)){
                    throw new invalidException("Invalid Password. Please try again");
                }


            } catch (maximumException e) {
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println();
            } catch (invalidException e) {
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println();
            }

        }

        System.out.println("Program Terminated");
        System.exit(0);

    }

}






