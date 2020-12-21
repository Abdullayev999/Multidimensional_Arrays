package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    /*
    Задание 1
    Сформировать массив, элементами которого будут квадраты соответствующих индексов. Вывести результат на
    экран.
     */

    public static void fillArrSquaredIndices(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * i;
        }
    }

    // or
    /*static int[] fillArrSquaredIndices(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i*i;
        }
        return  arr;
    }*/
    public static void printArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /*
Задание 2
Создать массив из 20 случайных чисел в диапазоне от
-10 до 30. Написать программу, определяющую сумму элементов массива,
находящихся в массиве после первого отрицательного элемента (первый отрицательный элемент не
должен входить в сумму). Вывести на консоль полученный
массив и сумму.
     */
    static int[] fillArr(int size, int fromNum, int toNum) {
        Random random = new Random();
        int[] arr = new int[size];

        fromNum *= -1; // для правильной выдачи диапазон чисел

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(fromNum + toNum + 1) - fromNum; // формула выдачи любого диапазона
        }
        return arr;
    }

    static int firstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i + 1;
            }
        }
        return 0;
    }

    static int sumArr(int[] arr, int startIndex) {
        int sum = 0;
        for (int i = startIndex; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /*
Задание 3
Создать массив из 200 случайных чисел в диапазоне от 0
до 200. Определить количество одноразрядных, двухразрядных и трёхразрядных чисел в процентном отношении.
Вывести на консоль полученный массив и количество по разрядам.
Пример:
digit 1 = 4
digit 2 = 45
digit 3 = 39
     */

    // На 39 строчки уже создан метод заполнение с диапазоном static int[] fillArr(int size , int fromNum , int toNum);

    static int numberRank(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    static int[] countRankArr(int[] arr) {
        int digitOne = 0, digitTwo = 0, digitThree = 0;

        for (int i = 0; i < arr.length; i++) {
            int rank = numberRank(arr[i]);
            switch (rank) {
                case 0:
                case 1: {
                    digitOne++;
                    break;
                }
                case 2: {
                    digitTwo++;
                    break;
                }
                case 3: {
                    digitThree++;
                    break;
                }
                default:
                    break;
            }
        }

        int[] newArr = new int[3];
        newArr[0] = digitOne;
        newArr[1] = digitTwo;
        newArr[2] = digitThree;

        return newArr;
    }

    static void printPercent(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("\n#  Rank     Size        %");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + ") " + (i + 1) + " rank  -  " + arr[i] + "     =   " + arr[i] * 100 / sum + " %");
        }
    }

    /*
Задание 4
Создать массив из 100 случайных чисел в диапазоне от
- 300 до 555. Написать программу, копирующую один массив
в другой следующим образом: сначала копируются последовательно все элементы, большие 0, затем последовательно
все элементы, равные 0, а затем последовательно все элементы, меньшие 0. Вывести исходный массив. Вывести результирующий массив.
     */

    // На 39 строчки уже создан метод заполнение с диапазоном static int[] fillArr(int size , int fromNum , int toNum);

    static int[] copyArr(int[] arr) {
        int[] newArr = new int[arr.length];

        int newCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                newArr[newCount++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                newArr[newCount++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                newArr[newCount++] = arr[i];
            }
        }
        return newArr;
    }


    /*
Задание 5
Создать массив из 20 случайных чисел в диапазоне от -10
до 20. Определить максимальное количество подряд идущих положительных элементов, не прерываемых ни нулями,
ни отрицательными числами. Вывести на консоль исходный
массив и найденный фрагмент.
     */

    // На 39 строчки уже создан метод заполнение с диапазоном static int[] fillArr(int size , int fromNum , int toNum);

    static int[] maxFragment(int[] arr) {

        int startIndex = 0, startIndextmp = 0;
        int sum = 0, max = 0, count = 0;
        int countNewArr = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= 0) {
                if (sum > max && sum > 0) {
                    startIndex = startIndextmp;
                    max = sum;
                    countNewArr = count;
                }
                count = 0;
                startIndextmp = i + 1;
                sum = 0;
            } else {
                count++;
                sum += arr[i];
            }
            if (i == arr.length - 1) {
                if (sum > max) {
                    startIndex = startIndextmp;
                    max = sum;
                    countNewArr = count;
                }
            }
        }

        int[] sumArr = new int[countNewArr];
        for (int i = startIndex, b = 0; b < countNewArr; b++, i++) {
            sumArr[b] = arr[i];
        }
        return sumArr;
    }

    /*
Задание 6
Создать квадратный массив размерности n заполненный
случайными числами, вывести массив на экран в виде таблицы, найти наименьший и наибольший элемент массива
и вывести их на экран (если найдено несколько одинаковых
элементов – вывести индексы строка и столбца, где есть повторения). Вывести на экран время выполнения поиска, в
миллисекундах. Размерность массива должна задаваться с
клавиатуры.
     */

    static void fillTwoDimensionalArr(int[][] arr) {

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(50) + 10;// чтоб не высокие числа выходили  и легко проверять
            }
        }
    }

    static void printTwoDimensionalArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    static void maxMinElementAllIndex(int[][] arr) {
        long timeStart = System.currentTimeMillis();

        int min = arr[0][0];
        int max = arr[0][0];
        int rowMin = 0, colMin = 0;
        int rowMax = 0, colMax = 0;


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    rowMin = i;
                    colMin = j;
                }

                if (arr[i][j] > max) {
                    max = arr[i][j];
                    rowMax = i;
                    colMax = j;
                }
            }
        }
        System.out.println("\nMin = " + min);
        System.out.println("\nMax = " + max);

        int countMin = 1;
        int countMax = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == min) {
                    if (j != colMin || i != rowMin) {
                        System.out.println(countMin++ + ") Location : " + min + "  Row = " + i + "  Col = " + j);
                    }
                }

                if (arr[i][j] == max) {
                    if (j != colMax || i != rowMax) {
                        System.out.println(countMax++ + ") Location : " + max + "  Row = " + i + "  Col = " + j);
                    }
                }
            }
        }


        System.out.println("search was completed in " + (System.currentTimeMillis() - timeStart) + " milliseconds");
    }

    /*
Задание 7
Заполните n-мерный квадратный массив возрастающими
числами – змейкой. Выведите результат на экран с соблюдением ширины столбцов
Пример:
1 2 3 4
8 7 6 5
9 10 11 12
16 15 14 13
     */
    static void fillArrSnake(int[][] arr) {
        boolean stack = true;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (stack) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = count++;
                }
                stack = false;
            } else {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    arr[i][j] = count++;
                }
                stack = true;
            }
        }
    }

    /*
Задание 8
Заполните n-мерный квадратный массив числами, которые увеличиваются на 1 по спирали (число n должно задаваться с клавиатуры).
Выведите результат на экран с соблюдением ширины столбцов. Для примера массив 4 на 4 должен
выглядеть как указано в примере.
Пример:
1 2 3 4
12 13 14 5
11 16 15 6
10 9 8 7
Дополнительно: выполнить задачу с использованием
только одного цикла + 1 балл
     */
    static void fillArrSpiral(int[][] array) {

        int row = array.length,
                col = array[0].length,
                count = 1;

        //Заполняем массива по часовой стрелке.
        for (int y = 0; y < col; y++) array[0][y] = count++;

        for (int x = 1; x < row; x++) array[x][col - 1] = count++;

        for (int y = col - 2; y >= 0; y--) array[row - 1][y] = count++;

        for (int x = row - 2; x > 0; x--) array[x][0] = count++;


        //координаты ячейки, которую необходимо заполнить следующей.
        int c = 1;
        int d = 1;

        while (count < row * col) {
            //В Java инициализированный интовый массив заполняется нулями.
            //Периметр мы заполнили числами, отличными от нулей.
            //Вложенный цикл останавливается, если следующая ячейка имеет
            //значение, отличное от ноля. Ячейка, на которой остановился
            //цикл, не заполняется.

            //Движемся вправо.
            while (array[c][d + 1] == 0) {
                array[c][d++] = count++;
            }

            //Движемся вниз.
            while (array[c + 1][d] == 0) {
                array[c++][d] = count++;
            }

            //Движемся влево.
            while (array[c][d - 1] == 0) {
                array[c][d--] = count++;
            }

            //Движемся вверх.
            while (array[c - 1][d] == 0) {
                array[c--][d] = count++;
            }
        }

        //При данном решении в центре всегда остаётся незаполненная ячейка.
        //Убираем её при помощи следующего цикла.
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (array[x][y] == 0) {
                    array[x][y] = count;
                }
            }
        }
    }


    /*
Задание 9
Даны числа n и m. Создайте массив размерностью
[n][m] и заполните его числами по диагонали, как показано на примере. Выведите результат на экран с соблюдением
ширины столбцов.
1 2 4 7
3 5 8 11
6 9 12 15
10 13 16 18
14 17 19 20
     */

    public static void fill2dim(int[][] array, int diagonal) {
        int count = 1;

        for (int z = 0; z < diagonal; z++) {
            if (z % 2 == 0) {
                for (int i = 0; i <= z; i++) {
                    array[z - i][i] = count++;
                }
            } else {
                for (int i = 0; i <= z; i++) {
                    array[i][z - i] = count++;
                }
            }
        }

        for (int z = 1; z < diagonal; z++) {
            if (z % 2 == diagonal % 2) {
                for (int i = 1; i <= diagonal - z; i++) {
                    array[z + i - 1][diagonal - i] = count++;
                }
            } else {
                for (int i = 1; i <= diagonal - z; i++) {
                    array[diagonal - i][z + i - 1] = count++;
                }
            }
        }

    }
    /*
Задание 10
В кинотеатре n рядов по m мест в каждом (m и n должно
задаваться с клавиатуры). В двумерном массиве размерностью m на n хранится информация о проданных билетах.
Число 1 означает, что билет на данное место уже продан,
число 0 означает, что место свободно. Поступил запрос на
продажу k билетов на соседние места в одном ряду (k должно
задаваться с клавиатуры).
Определите, можно ли выполнить такой запрос. Если решения есть, вывести номера рядов и номера свободных мест
для продажи.
Число занятых мест и какие места заняты на момент запроса определите случайным образом.
Вывести исходный массив на экран.

     */

    public static void randomTicketSales(int[][] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(2);
            }
        }
    }

    public static boolean buyTickets(int[][] arr, int row, int col) {
        if (arr.length > row && arr[row].length > col) {
            if (arr[row][col] == 0) {
                arr[row][col] = 1;
                return true;
            }
        }
        return false;
    }

    public static boolean freeTickets(int[][] arr, int sizeRequest) {
        int countFreeTicets = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    countFreeTicets++;
                    if (countFreeTicets == sizeRequest) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static void printFreeTickets(int[][] arr) {
        System.out.print("       ");
        for (int i = 0; i < arr[0].length; i++) {
            System.out.print(i + " ");
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            System.out.print(i + ")  :  ");
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
        }
    }

    public static void printSellTickets(int[][] arr) {
        System.out.print("       ");
        for (int i = 0; i < arr[0].length; i++) {
            System.out.print(i + " ");
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            System.out.print(i + ")  :  ");
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
        }
    }

    /*
Задание 11
Ввести c клавиатуры число в диапазоне от 0 до 1 000 000
включительно. Озвучить его русскими словами. Учесть, что
для разных чисел могут быть различные окончание слов, например «одна тысяча», «две тысячи», «пять тысяч».
Например, при вводе числа 1125, программа должна вывести на консоль«одна тысяча сто двадцать пять».
 // на окончании не хватило времени чуть больше кода нужно было добавить и все
     */

    public static String rank1(int number) {
        String word = " ";
        switch (number) {
            case 0:
                word = "  ноль ";
                break;
            case 1:
                word = "  один ";
                break;
            case 2:
                word = "  два ";
                break;
            case 3:
                word = "  три ";
                break;
            case 4:
                word = "  четыре ";
                break;
            case 5:
                word = "  пять ";
                break;
            case 6:
                word = "  шесть ";
                break;
            case 7:
                word = "  семь ";
                break;
            case 8:
                word = "  восемь ";
                break;
            case 9:
                word = "  девять ";
                break;
        }
        return word;
    }

    public static String NumberToWord(int number) {
        String hundred = " сотен ";
        String ten = " десясок ";
        String thousand = " тысяча ";
        String tmp = " ";
        int tmpNumber;
        int num = numberRank(number);
        if (num == 0) {
            tmp = " Ноль";
        } else {
            tmp = numProcces(number, num);
        }
        return tmp;
    }

    public static String numProcces(int num, int razryad) {
        int tens = 1;
        for (int i = 1; i < razryad; i++) {
            tens *= 10;
        }
        String tmp = "";
        for (int i = 0; i < razryad; i++) {
            tmp += rank1(num / tens);
            if (tens == 10 || tens == 10000) {
                tmp += " десяток ";
            } else if (tens == 100 || tens == 100000) {
                tmp += " сотен ";
            } else if (tens == 1000) {
                tmp += " тысяч ";
            }
            num -= tens * (num / tens);
            tens /= 10;
        }
        return tmp + " единиц";
    }

    /*
Задание 12
Заполните квадратный массив размером n «ходом коня»
– (конь в шахматах ходит буквой «Г»). Существует простой
алгоритм, который позволяет гарантированно заполнить
доску ходом коня размерами от 5 до 70. Т. е. сначала заполните массив числом 0, а потом на первой клетке (элементе
массива) ставится число 1, на следующей, на которую прыгает конь – 2 и так до тех пор, пока не останется клеток, на
которые конь не ступал. Если остались нулевые значения
– значит алгоритм работает не верно. Выведите массив на
экран. Размерность массва должна задаваться с клавиатуры.
(См. Задача о ходе коня).
Рекомендуется для решения данной задачи использовать
правило Варнсдорфа.
     */

    public static void main(String[] args) {

        System.out.println("\n --------\n| Task 1 |" + "\n --------\n");

        int size = 10;
        int[] arr = new int[size];

        fillArrSquaredIndices(arr);
        printArr(arr);

        ///////////////////////////////////////////////////////////////////////////

        System.out.println("\n\n --------\n| Task 2 |" + "\n --------\n");

        size = 5;
        arr = fillArr(size, -10, 30);

        printArr(arr);
        int startIndex = firstNegative(arr);
        System.out.println("\nFirst neqativ + 1 index  = " + startIndex);
        System.out.println("Sum [from (first negative + 1) , last] )= " + sumArr(arr, startIndex));

        ///////////////////////////////////////////////////////////////////////////

        System.out.println("\n\n --------\n| Task 3 |" + "\n --------\n");

        arr = fillArr(5, 90, 120);
        int[] countDigit = new int[3];
        countDigit = countRankArr(arr);
        printArr(arr);
        printPercent(countDigit);

        ///////////////////////////////////////////////////////////////////////////

        System.out.println("\n\n --------\n| Task 4 |" + "\n --------\n");

        arr = fillArr(10, -300, 555);
        printArr(arr);
        int[] newArr = copyArr(arr);
        printArr(newArr);

        ///////////////////////////////////////////////////////////////////////////

        System.out.println("\n\n --------\n| Task 5 |" + "\n --------\n");

        arr = fillArr(10, -10, 10);
        System.out.print("Fill  arr    = ");
        printArr(arr);
        int[] multiArr = maxFragment(arr);
        System.out.print("Fragment arr = ");
        printArr(multiArr);
        System.out.println();


        ///////////////////////////////////////////////////////////////////////////

        System.out.println("\n\n --------\n| Task 6 |" + "\n --------\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter size arr : ");
        size = scanner.nextInt();
        int[][] multiArray = new int[size][size];

        fillTwoDimensionalArr(multiArray);

        maxMinElementAllIndex(multiArray);

        printTwoDimensionalArr(multiArray);

        ///////////////////////////////////////////////////////////////////////////

        System.out.println("\n\n --------\n| Task 7 |" + "\n --------\n");

        size = 5;
        multiArray = new int[size][size];
        fillArrSnake(multiArray);
        printTwoDimensionalArr(multiArray);

        ///////////////////////////////////////////////////////////////////////////

        System.out.println("\n\n --------\n| Task 8 |" + "\n --------\n");

        multiArray = new int[5][5];
        fillArrSpiral(multiArray);
        printTwoDimensionalArr(multiArray);


        ///////////////////////////////////////////////////////////////////////////

        System.out.println("\n\n --------\n| Task 9 |" + "\n --------\n");

        multiArray = new int[5][5];
        fill2dim(multiArray, 5);
        printTwoDimensionalArr(multiArray);


        ///////////////////////////////////////////////////////////////////////////

        System.out.println("\n\n --------\n| Task 10 |" + "\n --------\n");

        System.out.print("Enter quantity row cinema : ");
        int row = scanner.nextInt();
        System.out.print("Enter quantity col cinema : ");
        int col = scanner.nextInt();

        multiArray = new int[row][col];
        randomTicketSales(multiArray);

        boolean stop = false;
        do {
            System.out.println("\n1 - Exit");
            System.out.println("2 - Print all hall");
            System.out.println("3 - Buy");
            System.out.println("4 - Request the number of free tickets");
            System.out.println("5 - Print free places");
            System.out.println("6 - Print busy places");

            int select = scanner.nextInt();

            switch (select) {
                case 1:
                    stop = true;
                    break;
                case 2:
                    printTwoDimensionalArr(multiArray);
                    break;
                case 3:
                    printFreeTickets(multiArray);

                    System.out.print("\nEnter  row for by tickets : ");
                    row = scanner.nextInt();
                    System.out.print("Enter  col for by tickets : ");
                    col = scanner.nextInt();
                    if (buyTickets(multiArray, row, col)) {
                        System.out.println("Ticket buy successful");
                    } else {
                        System.out.println("this ticket is not");
                    }
                    break;
                case 4:
                    System.out.println("Enter count tickets which you need?");
                    int count = scanner.nextInt();
                    if (freeTickets(multiArray, count)) {
                        System.out.println("There are so many free tickets at the box office");
                    } else {
                        System.out.println("Unfortunately, there are no tickets at the box office.");
                    }
                    break;
                case 5:
                    printFreeTickets(multiArray);
                    break;
                case 6:
                    printSellTickets(multiArray);
                    break;
                default:
                    System.out.println("Incorrect select\n");
                    break;

            }
            System.out.println();
        } while (!stop);


        /////////////////////////////////////////////////////////////////////////

        System.out.println("\n\n --------\n| Task 11 |" + "\n --------\n");

        System.out.println(NumberToWord(123456));


        /////////////////////////////////////////////////////////////////////////

        System.out.println("\n\n --------\n| Task 12 |" + "\n --------\n");

        System.out.println("-");
    }

}


