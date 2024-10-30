import java.util.ArrayList;
import java.util.List;
public class FactorGuesser
{
    public static List<Integer> listofFactors(int number)
    {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
    public static void main(String[]args)
    {
        int number = 70;
        System.out.println(listofFactors(number));
    }
}