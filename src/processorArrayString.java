import java.util.Scanner;



public class processorArrayString {
    static private String getString(Scanner sc)
    {
        return sc.next();
    }
    static private String[] enterStrings(Scanner sc)
    {
        int N = 0;
        System.out.println("Введите количество строк: ");
        for(;;)
        {
            try{
                N = Integer.parseInt(sc.next());
                if(N<=0) throw new Exception();
                break;
            }catch (Exception e){
                System.out.println("Пожалуйста введите целое положительное число");
            }
        }

        String data[] = new String[N];

        System.out.println("Введите " + N + " строк:");
        for(int i = 0 ; i < data.length ; i++)
        {
            data[i] = getString(sc);
        }
        return data;
    }

    static private void printArrayStrings(String [] data)
    {
        for(int i  = 0 ; i < data.length  ; i++)
        {
            System.out.print(data[i] + "   ");
        }
        System.out.println();
    }

    static private int longest(String[] data)
    {
        int longest_idx = 0;
        for(int i = 0 ; i < data.length ; i++)
        {
            if(data[longest_idx].length() < data[i].length()) longest_idx = i;
        }
        return longest_idx;
    }

    static private int shortest(String[] data)
    {
        int shortest_idx = 0;
        for(int i = 0 ; i < data.length ; i++)
        {
            if(data[shortest_idx].length() > data[i].length()) shortest_idx = i;
        }
        return shortest_idx;
    }

    static private boolean contains(String[] aStr, String str)
    {
        for(int i = 0 ; i < aStr.length ; i ++)
        {
            if(aStr[i].equals(str)) return true;
        }
        return false;
    }
    static private String[] deleteString(String[] oldArr, String search)
    {
        String newArr[] = null;
        boolean is_found = false;
        int found_idx = -1;
        for(int i = 0 ; i < oldArr.length ; i++)
        {
            if(oldArr[i].equals(search))
            {
                is_found = true;
                found_idx = i;
            }
        }

        if(is_found)
        {
            newArr = new String[oldArr.length - 1];
            for(int i = 0, j = 0 ; i < oldArr.length ; i++)
            {
                if(i == found_idx) continue;
                newArr[j] = oldArr[i];
                j++;
            }
        }
        return newArr;
    }

    static private boolean changeString(String[] data, String old_s, String new_s)
    {
        boolean is_changed = false;
        for (int i = 0; i < data.length ; i++) {
            if(data[i].equals(old_s)){
                is_changed = true;
                data[i] = new_s;
            }
        }
        return is_changed;
    }

    static public void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String aStr[] = enterStrings(sc);
        loop:
        for(;;)
        {
            System.out.println("Введите команду:");
            String cmd = getString(sc);
            switch(cmd.trim().toLowerCase())
            {
                case "exit": case"quit":
                    System.out.println("So long");
                    break loop;
                case"print":
                    printArrayStrings(aStr);
                    break;
                case "longest":
                    System.out.println("Самая длинная строка в массиве: " + aStr[longest(aStr)]);
                    break;
                case "shortest":
                    System.out.println("Самая короткая строка в массиве: " + aStr[shortest(aStr)]);
                    break;
                case "contains":
                    boolean contains = contains(aStr, sc.next());
                    if(contains) System.out.println("Да");
                    else System.out.println("Нет");
                    break;
                case "delete":
                    String new_s[] = deleteString(aStr, sc.next());
                    if(new_s != null)
                    {
                        System.out.println("Строка была удалена из массива");
                        aStr = new_s;
                    }else System.out.println("В массиве строк нет указанной строки");
                    break;
                case "change":
                    if(changeString(aStr, sc.next(), sc.next())) System.out.println("Строка была успешно изменена");
                    else System.out.println("В массиве строк нет указанной строки");
                    break;
                    default:System.out.println("Указанной команды не существует.");

            }
        }
    }
}
