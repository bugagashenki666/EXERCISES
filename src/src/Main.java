public class Main {

    public static void main(String[] args)
    {
        int N = 5;
        workWithArrays wwa = new workWithArrays(N);
        wwa.init(N);
        System.out.println("Исходный массив: " + wwa.toString());
        wwa.sortByBubble(0, N - 1, "DESC");
        //wwa.sortBySelection(0, N - 1, "ASC");
        System.out.println("Отсортированный массив: " + wwa.toString());
        if (wwa.isPositive()) System.out.println("Все элементы массива положительны");
        else System.out.println("Не все элементы массива положительны");
        wwa.replaceNegative();
        System.out.println("Текущий массив: " + wwa.toString());
        System.out.println("Количество четных элементов массива: " + wwa.CountOfEven());
        if(wwa.obey()) System.out.println("Исходный массив удовлетворяет условию a1<a2>a3< ....<aN-1>aN");
        else System.out.println("Исходный массив не удовлетворяет условию a1<a2>a3< ....<aN-1>aN");
    }
}
