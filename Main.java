import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Sieve of Eratosthenes: " + getPrimes(100));
        System.out.println("Goldbach Conjecture: " + getPrimeAddends(100));
        System.out.println("Adding BigInts: " + add(new ArrayList<>(Arrays.asList(5, 5, 5)), new ArrayList<>(Arrays.asList(5, 5, 5, 5))));
    }

    public static ArrayList<Integer> getPrimes(int n)
    {
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);

        for(int i = 3; i < n; i += 2)
        {
            boolean b = true;

            for(int j = 0; j < primes.size() - 1 && b; j++)
                b = (i % primes.get(j) != 0);

            if(b) primes.add(i);
        }

        return primes;
    }

    public static ArrayList<Integer> getPrimeAddends(int n)
    {
        ArrayList<Integer> primes = getPrimes(n), addends = new ArrayList<>();

        for(int i = 0; i < primes.size() && addends.isEmpty(); i++)
        {
            if(primes.contains(n - primes.get(i)))
            {
                addends.add(primes.get(i));
                addends.add(n - primes.get(i));
            }
        }

        return addends;
    }

    public static ArrayList<Integer> add(ArrayList<Integer> a, ArrayList<Integer> b)
    {
        ArrayList<Integer> sum = new ArrayList<>();

        if(a.size() < b.size())
        {
            ArrayList<Integer> tmp = a;
            a = b;
            b = tmp;
        }

        int carry = 0;

        for(int i = 0; i < a.size(); i++)
        {
            int aD = a.get(a.size() - i - 1);

            if(i < b.size())
            {
                int bD = b.get(b.size() - i - 1);
                sum.add(0, (aD + bD + carry) % 10);
                carry = (aD + bD + carry) / 10;
            }
            else
            {
                sum.add(0, (aD + carry) % 10);
                carry = (aD + carry) / 10;
            }
        }

        if(carry == 1) sum.add(0, 1);
        return sum;
    }
}
