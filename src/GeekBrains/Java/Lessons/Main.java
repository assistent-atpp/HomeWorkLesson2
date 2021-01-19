package GeekBrains.Java.Lessons;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // задание 1
        int[] arrayWithInterchangedElements = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arrayWithInterchangedElements.length; i++) {
            switch (arrayWithInterchangedElements[i]) {
                case 1:
                    arrayWithInterchangedElements[i] = 0;
                    break;
                case 0:
                    arrayWithInterchangedElements[i] = 1;
                    break;
            }
        }
        System.out.println("Массив со взаимозаменёнными элементами " + Arrays.toString(arrayWithInterchangedElements));

        // задание 2
        int[] arrayWithShiftOfThree = new int[8];
        int k = 0;
        for (int i = 0; i < arrayWithShiftOfThree.length; i++) {
            arrayWithShiftOfThree[i] = k;
            k += 3;
        }
        System.out.println("Массив со значениями элементов, сдвинутыми на +3 " + Arrays.toString(arrayWithShiftOfThree));

        // задание 3
        int[] arrayOfValuesLessThanSixTimesTwo = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrayOfValuesLessThanSixTimesTwo.length; i++) {
            if (arrayOfValuesLessThanSixTimesTwo[i] < 6) {
                arrayOfValuesLessThanSixTimesTwo[i] = arrayOfValuesLessThanSixTimesTwo[i] * 2;
            }
        }
        System.out.println("Массив со значениями, которые были < 6, *2 " + Arrays.toString(arrayOfValuesLessThanSixTimesTwo));

        // задание 4
        int[][] arraySquare = new int[5][5];
        System.out.println("Массив с единицами по диагоналям:");
        for (int i = 0; i < arraySquare.length; i++) {
            for (int j = 0, y = arraySquare.length; j < arraySquare.length; j++, y--) {
                if (i == j || i == y - 1) {
                    arraySquare[i][j] = 1;
                }
            }
            System.out.println(Arrays.toString(arraySquare[i]));
        }

        // задание 5
        int[] arrayOfMaxAndMinValues = {12, 6, 26, 15, 75, 1, 4, 34, 8, 65, 28, 41, 2};
        int arrayMin = arrayOfMaxAndMinValues[0];
        int arrayMax = arrayOfMaxAndMinValues[0];
        for (int i = 1; i < arrayOfMaxAndMinValues.length; i++) {
            if (arrayOfMaxAndMinValues[i] < arrayMin) {
                arrayMin = arrayOfMaxAndMinValues[i];
            } else if (arrayOfMaxAndMinValues[i] > arrayMax) {
                arrayMax = arrayOfMaxAndMinValues[i];
            }
        }
        System.out.println("Минимальное значение элемента = " + arrayMin);
        System.out.println("Максимальное значение элемента = " + arrayMax);

        // по заданию 6
        int[] someArray = {2, 3, 4, 4, 3, 2};
        boolean checkBalance = checkBalanceSumElementsArray(someArray);
        System.out.println("В массиве есть место, в котором сумма левой и правой части массива равны: " + checkBalance);
    }

    // задание 6
    private static boolean checkBalanceSumElementsArray(int[] nonEmptyIntegerArray) {
        int sumElementsNonEmptyIntegerArray = 0;
        int[] accumulatedSumNonEmptyIntegerArray = new int[nonEmptyIntegerArray.length];
        for (int i = 0; i < nonEmptyIntegerArray.length; i++) {
            // нахожу сумму всех элементов массива [2, 3, 4, 4, 3, 2] = 18
            sumElementsNonEmptyIntegerArray += nonEmptyIntegerArray[i];
            // нахожу накопленную сумму элементов массива [2, 5, 9, 13, 16, 18]
            accumulatedSumNonEmptyIntegerArray[i] = sumElementsNonEmptyIntegerArray;
            System.out.println(Arrays.toString(new int[]{accumulatedSumNonEmptyIntegerArray[i]}));
        }
        System.out.println("Сумма элементов = " + sumElementsNonEmptyIntegerArray);

        for (int i = 0; i < (accumulatedSumNonEmptyIntegerArray.length - 1); i++) {
            if (sumElementsNonEmptyIntegerArray - accumulatedSumNonEmptyIntegerArray[nonEmptyIntegerArray.length - 1 - i] == sumElementsNonEmptyIntegerArray - accumulatedSumNonEmptyIntegerArray[i]) {
                // алгоритм условия
                // i = 0: 18 - 16 = 18 - 2; false
                // i = 1: 18 - 13 = 18 - 5; false
                // i = 2: 18 - 9  = 18 - 9; true
                // следующие итерации не имеют значения, но всё же
                // i = 3: 18 - 5  = 18 - 13; false
                // i = 4: 18 - 2  = 18 - 16; false
                // метод всегда возвращает только false, пока не могу разобраться почему
                return true;
            }
        }
        return false;
    }
}

