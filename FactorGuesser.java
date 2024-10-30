import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
public class FactorGuesser
{
    public static Set<Integer> listofFactors(int number)
    {
        Set<Integer> factors = new HashSet<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
    public static String factorguessgame(int number, Set<Integer>factors)
    {
        System.out.println("Welcome to the factor guessing game.");
        System.out.println("You have to guess all of the factors of "+number);
        System.out.println("There are "+factors.size()+ " factors.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 'quit' to exit the game at any time.");
        Set<Integer>guessedfactors = new HashSet<>();
        while(true)
        {
            if(guessedfactors.equals(factors))
            {
                return "You guessed every factor. Great job";
            }
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine();
            // Check if the user wants to quit
            if (input.equalsIgnoreCase("quit")) {
                return "Thank you for playing! Here are all of the factors. "+factors;
                
            }
            try {
                int guess = Integer.parseInt(input); // Convert input to an integer
                if(factors.contains(guess))
                {
                    if(guessedfactors.contains(guess))
                    {
                        System.out.println("This factor is already guessed and it correct.");
                    }
                    else
                    {
                        System.out.println("Good job! "+guess+ " is a factor of "+number+".");
                        guessedfactors.add(guess);
                    }
                }
                else{
                    System.out.println(guess+ " is not a factor of "+number);
                }
            }   
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid number or type 'quit' to exit.");
            }
        }

    }
    public static void main(String[]args)
    {
        Random rand = new Random();
        int number = rand.nextInt(501);
        System.out.println(factorguessgame(number, listofFactors(number)));
    }
}