package pl.kurs.test1;

public class Task2 {
    public static void main(String[] args) {
        printNumberOfDivisorsForTwoDigitNumbers();
    }

    static void printNumberOfDivisorsForTwoDigitNumbers() {
        for (int i = 10; i <= 99; i++) {
            int divisorCounter = 0;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    divisorCounter++;
                    if (j != i / j) {
                        divisorCounter++;
                    }
                }
            }
            System.out.println("Number: " + i + ", number of divisors: " + divisorCounter);
        }
    }
}
