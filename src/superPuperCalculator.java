public class superPuperCalculator {
    public superPuperCalculator()
    {

    }
    public String[] parseExpression(String expr)
    {
        //System.out.println(expr);

        expr = expr.replaceAll("[A-Za-z]", "");
        if(Character.isDigit(expr.charAt(0))) expr = "+" + expr;
        //System.out.println(expr);
        String numbers[] = expr.split("[*+-/%]{1,2}");
        String signs[] = expr.split("[0-9]+");

        //for(int i = 0 ; i < numbers.length ; i ++){System.out.print(numbers[i] + "     ");}
        //for(int i = 0 ; i < signs.length ; i ++){System.out.print(signs[i] + "     ");}

        String numbers_sings[] = new String[numbers.length + signs.length];
        int in = 0;
        int is = 0;
        try {
            for (int i = 0; i < numbers_sings.length; i++) {
                if ((i % 2) == 0) {
                    numbers_sings[i] = numbers[in];
                    in++;
                }
                if ((i % 2) == 1) {
                    numbers_sings[i] = signs[is];
                    is++;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Введеное некорректное выражение.");
            return null;
        }
        return numbers_sings;
    }
    public int calculate(String[] exprAr, int result)
    {
        for(int i = 0 ; i < exprAr.length - 1 ; i ++) {
            try {
                switch (exprAr[i]) {
                    case "+": case "--":
                        result = result + Integer.parseInt(exprAr[i + 1]);
                        break;
                    case "-":case"+-":
                        result = result - Integer.parseInt(exprAr[i + 1]);
                        break;
                    case "*-":
                        result = -result * Integer.parseInt(exprAr[i + 1]);
                    case "*":
                        result = result * Integer.parseInt(exprAr[i + 1]);
                        break;
                    case "/-":
                        result = - result / Integer.parseInt(exprAr[i + 1]);
                    case "/":
                        result = result / Integer.parseInt(exprAr[i + 1]);
                        break;
                    case "%":
                        result = result % Integer.parseInt(exprAr[i + 1]);
                        break;

                    default:
                }
            }catch(Exception e){System.out.println("Введено некорректное выражение.");}
        }
        return result;
    }
}
