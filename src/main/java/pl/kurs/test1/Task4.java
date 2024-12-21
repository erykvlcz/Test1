package pl.kurs.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers separated by a single space: ");

        String[] extractedNumbers = (scanner.nextLine()).split(" ");
        double[] finalNumbers = new double[extractedNumbers.length];
        boolean error = false;
        for (int i = 0; i < extractedNumbers.length; i++) {
            try {
                finalNumbers[i] = Double.parseDouble(extractedNumbers[i]);
            } catch (NumberFormatException e) {
                error = true;
            }
        }

        if (error) {
            System.out.println("Invalid input");
            System.exit(0);
        } else {
            showMedian(finalNumbers);
            showNumWithMostNumberOfDivisors(finalNumbers);
            showPrimeNumbers(finalNumbers);
        }
    }

    static void showMedian(double[] array) {
        Arrays.sort(array);
        if (array.length % 2 == 1) {
            System.out.println("The median is: " + (array[((array.length - 1) / 2)]));
        } else {
            System.out.println("The median is: " + ((array[(array.length - 1) / 2] + array[array.length / 2]) / 2));
        }
    }

    static int getNumDivisors(double number) {
        int divisiorsNumber = 0;
        double absoluteNumber = Math.abs(number);

        if (number == Math.floor(number)) {
            int n = (int) absoluteNumber;
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    divisiorsNumber++;
                    if (i != n / i) divisiorsNumber++;
                }
            }
        } else {
            for (double i = 0.1; i <= absoluteNumber; i += 0.1) {
                if (absoluteNumber / i == Math.floor(absoluteNumber / i)) divisiorsNumber++;
            }
        }
        return divisiorsNumber;
    }

    static void showNumWithMostNumberOfDivisors(double[] array) {
        int currentMostNumDivisors = 0;
        ArrayList<Double> numsWithMostDivisors = new ArrayList<>();
        for (double num : array) {
            int divisors = getNumDivisors(num);


            if (divisors > currentMostNumDivisors) {
                currentMostNumDivisors = divisors;
                numsWithMostDivisors.clear(); // Reset the list
                numsWithMostDivisors.add(num);
            } else if (divisors == currentMostNumDivisors) {
                numsWithMostDivisors.add(num);
            }
        }
        System.out.println("The number with the most divisors: " + numsWithMostDivisors);
    }

    static boolean isPrime(double n) {
        if (n < 2 || n != Math.floor(n)) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static void showPrimeNumbers(double[] array) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (double n : array) {
            if (isPrime(n)) primeNumbers.add((int) n);
        }

        if (!primeNumbers.isEmpty()) {
            System.out.println("Prime numbers: " + primeNumbers);
        } else {
            System.out.println("No prime numbers");
        }
    }
}
