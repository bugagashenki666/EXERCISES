import java.util.Scanner;

public class useSuperPuperCalculator {

    static private void printArray(String[] arr)
    {
        for(int i = 0 ; i < arr.length ; i++) {
            System.out.println(arr[i] + "    ");
        }
        }
    static public void main(String[] args) {
        superPuperCalculator spc = new superPuperCalculator();

        Scanner sc = new Scanner(System.in);
        int result = 0;
        while(true)
        {
            String expr = sc.next();
            if(expr.trim().toLowerCase().equals("quit") || expr.trim().toLowerCase().equals("exit"))break;
            String exprAr[] = spc.parseExpression(expr);
            //printArray(exprAr);
            if(exprAr != null) result = spc.calculate(exprAr, result);
            System.out.println("=" + result);
        }
    }
}
