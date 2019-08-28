import java.util.Scanner;

public class arrayProcessor {

    public static int[] enterData(Scanner sc)
    {

        System.out.println("Введите количество элементов массива: ");
        int n;
        while (true) {
            try {
                n = Integer.parseInt(sc.next());
                if (n < 0) throw new java.lang.NumberFormatException();
                break;
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Вы ввели не целое положительное число.");
            }
        }

        int[] data = new int[n];
        System.out.println("Введите " + n + " элементов массива: ");
        for (int i = 0; i < n; i++) {
            data[i] = enterN(sc);
        }

        return data;
    }

    public static void add(int [] data, int mm)
    {
        for(int i = 0 ; i < data.length ; i++)
        {
            data[i] +=mm;
        }
    }

    public static void printData(int [] data)
    {
        System.out.println("Текущие значения массива");
        String str = "";
        for(int i = 0 ; i < data.length ; i++)
        {
            str = str + data[i] + "  ";
        }
        System.out.println(str);
    }

    public static int max(int [] data)
    {
        int max = data[0];
        for(int i = 0 ; i < data.length ; i++)
        {
            if(max < data[i]) max = data[i];
        }
        return max;
    }

    public static int min(int [] data)
    {
        int min = data[0];
        for(int i = 0 ; i < data.length ; i++)
        {
            if(min > data[i]) min = data[i];
        }
        return min;
    }

    public static void sub(int mm, int[] data)
    {
        for(int i = 0 ; i < data.length ; i++)
        {
            data[i] -=mm;
        }
    }

    public static void mul(int mm, int []data)
    {
        for(int i = 0 ; i < data.length ; i++)
        {
            data[i] *=mm;
        }
    }

    public static void div(int mm, int [] data)
    {
        for(int i = 0 ; i < data.length ; i++)
        {
            data[i] /=mm;
        }
    }

    public static void exchange(int idx1, int idx2, int[] data)
    {
        int t = data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = t;
    }
    public static void reverse(int [] data)
    {
        for(int i = 0 ; i < data.length/2 ; i++)
        {
            exchange(i, data.length - i - 1, data);
        }
    }

    public static int enterN(Scanner sc)
    {
        while (true) {
            try {
                int n = Integer.parseInt(sc.next());
                return n;
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Введено некорректное значение");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data[] = enterData(sc);
        printData(data);
        loopRun:
        while (true) {
            System.out.println("Введите команду add, sub, mul, div, min, max, reverse или update");
            String cmd = sc.next();
            switch (cmd.toLowerCase().trim()) {
                case "add":
                    add(data, enterN(sc));
                    printData(data);
                    break;
                case "min":
                    System.out.println("min=" + min(data));
                    break;
                case "max":
                    System.out.println("max=" + max(data));
                    break;
                case "sub":
                    sub(enterN(sc), data);
                    printData(data);
                    break;
                case "mul":
                    mul(enterN(sc), data);
                    printData(data);
                    break;
                case "div":
                    div(enterN(sc), data);
                    printData(data);
                    break;
                case "update":
                    data = enterData(sc);
                    printData(data);
                    break;
                case "reverse":
                    reverse(data);
                    printData(data);
                    break;
                case "quit":
                case "exit":
                    break loopRun;
            }
        }
    }
}
