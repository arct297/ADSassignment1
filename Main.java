import java.util.HashMap;
import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    }
}

class Task1{
    // Big O notation: O(n)
    public static Scanner scanner = new Scanner(System.in);
    public static int findMinimum(int sequenceLength){
        int new_value = scanner.nextInt();
        return findMinimum(new_value, new_value, sequenceLength - 1);
    }

    private static int findMinimum(int new_value, int minimum, int limit){
        if (limit <= 0) return minimum;
        if (new_value < minimum) minimum = new_value;
        new_value = scanner.nextInt();
        return findMinimum(new_value, minimum, limit - 1);
    }

    public static void main(String[] args) {
        int sequenceLength = scanner.nextInt();
        System.out.println(findMinimum(sequenceLength));

    }
}

class Task2 {
    // Big O notation: O(n)
    public static Scanner scanner = new Scanner(System.in);
    public static float findAvg(int sequenceLength){
        int value = scanner.nextInt();
        return (float) findSumOfSequence(value, sequenceLength - 1) / sequenceLength;
    }

    private static int findSumOfSequence(int sum, int limit){
        if (limit <= 0) return sum;
        sum += scanner.nextInt();
        return findSumOfSequence(sum, limit - 1);
    }

    public static void main(String[] args) {
        int sequenceLength = scanner.nextInt();
        System.out.println(findAvg(sequenceLength));

    }
}

class Task3 {
    // Big O notation: O(root of n)
    public static Scanner scanner = new Scanner(System.in);
    public static boolean isPrime(int number){
        if (number == 1) return false;
        return isPrime(2, number, sqrt(number));
    }

    private static boolean isPrime(int divisor, int number, double squareRootOfNumber){
        if (divisor > squareRootOfNumber) return true;
        if (number % divisor == 0) return false;
        return isPrime(divisor + 1, number, squareRootOfNumber);
    }

    public static void main(String[] args) {
        int number = scanner.nextInt();
        if (isPrime(number)){
            System.out.println("Prime");
        } else {
            System.out.println("Composite");
        }

    }
}

class Task4 {
    // Big O notation: O(n)
    public static Scanner scanner = new Scanner(System.in);
    public static int findFactorial(int number){
        if (number == 0) return 1;
        return findFactorial(number - 1, number);
    }

    private static int findFactorial(int multiplyBy, int product){
        if (multiplyBy <= 1) return product;
        product *= multiplyBy;
        return findFactorial(multiplyBy - 1, product);
    }

    public static void main(String[] args) {
        int number = scanner.nextInt();
        System.out.println(findFactorial(number));
    }
}

class Task5 {
    // Big O notation: O(n)
    public static Scanner scanner = new Scanner(System.in);

    public static long fib(int index){
        return fib(index, new HashMap<>());
    }

    private static long fib(int index, HashMap<Integer, Long> map){
        if (index <= 1) return index;
        if (map.containsKey(index)){
            return map.get(index);
        }

        long number = fib(index - 2, map) + fib(index - 1, map);
        map.put(index, number);

        return number;
    }

    public static void main(String[] args) {
        int number = scanner.nextInt();
        System.out.println(fib(number));
    }
}

class Task6 {
    // Big O notation: O(log2 n)
    public static Scanner scanner = new Scanner(System.in);
    public static int power(int number, int times){
        return countPower(1, number, times);
    }

    private static int countPower(int product, int number, int last){
        if (last == 0) return product;
        return countPower(product * number, number, last - 1);
    }

    public static void main(String[] args) {
        int number = scanner.nextInt();
        int times = scanner.nextInt();
        System.out.println(power(number, times));
    }
}

class Task7 {
    // Big O notation: O(n!)
    public static Scanner scanner = new Scanner(System.in);
    private static void printPermutations(char[] string, int index){
        if (index == string.length - 1){
            System.out.println(new String(string));
            return;
        }
        for (int i = index; i < string.length; i++) {
            swap(string, index, i);
            printPermutations(string, index + 1);
            swap(string, index, i);
        }
    }

    private static void swap(char[] string, int i, int j) {
        char temp = string[i];
        string[i] = string[j];
        string[j] = temp;
    }

    public static void printPermutations(String string){
        printPermutations(string.toCharArray(), 0);
    }

    public static void main(String[] args) {
        String string = scanner.nextLine();
        printPermutations(string);
    }

}

class Task8 {
    // Big O notation: O(n)
    public static Scanner scanner = new Scanner(System.in);
    public static boolean isStringDigit(String string){
        return isStringDigit(string, string.length() - 1);
    }

    private static boolean isStringDigit(String string, int index){
        if (index < 0) return true;
        if (!Character.isDigit(string.charAt(index))) return false;
        return isStringDigit(string, index - 1);
    }

    public static void main(String[] args) {
        String string = scanner.nextLine();
        if (isStringDigit(string)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        };
    }

}
class Task9 {
    // Big O notation: O(2^n)
    public static Scanner scanner = new Scanner(System.in);

    public static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(binomialCoefficient(n, k));
    }
}

class Task10 {
    // Big O notation: O(n)
    public static Scanner scanner = new Scanner(System.in);

    public static int GCD(int a, int b) {
        if (b > a) return findGCD(b, a);
        return findGCD(a, b);
    }

    private static  int findGCD(int b, int remainder){
        if (remainder == 0){
            return b;
        }
        return findGCD(remainder, b % remainder);
    }

    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(GCD(a, b));
    }
}
