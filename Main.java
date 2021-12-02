import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(addBigInts(new ArrayList<Integer>(Arrays.asList(1, 2, 3)), new ArrayList<Integer>(Arrays.asList(1, 2))));
    }
    
    public static ArrayList<Integer> getPrimes(int n)
    {
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        
        for(int i = 3; i < n; i += 2)
        {
            boolean b = true;
            
            for(int j = 0; j < primes.size() - 1 && b; j++)
                if(i % primes.get(j) == 0) b = false;
                
            if(b) primes.add(i);
        }
        
        return primes;
    }
    
    public static ArrayList<Integer> getPrimeAddends(int n)
    {
        ArrayList<Integer> primes = getPrimes(n), addends = new ArrayList<>();
        
        for(int i = 0; i < primes.size() && addends.size() < 2; i++)
        {
            if(primes.contains(n - primes.get(i)))
            {
                addends.add(primes.get(i));
                addends.add(n - primes.get(i));
            }
        }
        
        return addends;
    }
    
    public static ArrayList<Integer> addBigInts(ArrayList<Integer> a, ArrayList<Integer> b)
    {
        ArrayList<Integer> sum = new ArrayList<>();
        
        if(a.size() < b.size())
        {
            ArrayList<Integer> tmp = a;
            a = b;
            b = tmp;
        }
        
        for(int i = 0; i < a.size(); i++)
        {
            if(i < b.size()) sum.add(0, a.get(a.size() - 1 - i) + b.get(b.size() - 1 - i));
            else sum.add(0, a.get(a.size() - 1 - i));
        }
        
        return sum;
    }
}
