package pl.kurs.test1;

public class Task1 {
    public static void main(String[] args) {
        listAll3DigitsNumbersWhichSumHundredsAndTensEqualsUnits();
    }

    static void listAll3DigitsNumbersWhichSumHundredsAndTensEqualsUnits() {
        for (int i = 100; i <= 999; i++) {
            if ((i / 100) + ((i / 10) % 10) == (i % 10)) //(hundreds) + (tens) == (units)
                System.out.println(i);
        }
    }
}
