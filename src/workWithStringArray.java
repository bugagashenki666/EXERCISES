public class workWithStringArray {
    public static void main(String[] args) {
        String[] values = {"aasasfas", "dfgdfgdfh", "sdsfs", "ffffffffffffffff", "ddfssdfs"};
        int max = values[0].length();
        int idx = 0 ;
        for (int i = 0; i < values.length; i++)
        {
            if(max < values[i].length()) {
                max = values[i].length();
                idx = i;
            }
        }
        System.out.println(max + "  " + values[idx]);
    }
}
