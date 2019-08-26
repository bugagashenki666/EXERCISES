
import java.util.Random;
import java.util.Scanner;

public class workWithArrays{
    public int arrayT[];
    public workWithArrays(int N)
    {
        this.arrayT = new int[N];
        for (int i = 0; i < this.arrayT.length; i++)
        {
            if(i%2 == 0) arrayT[i] = 1;
            else arrayT[i] = 2;
        }
    }

    public workWithArrays()
    {

    }

    public void enterNumbers() {
        enterNumbers(10);
    }

    public void enterNumbers(int N)
    {
        Scanner sc = new Scanner(System.in);
        this.arrayT = new int[N];
        for(int i = 0 ; i < N;)
        {
            try
            {
                this.arrayT[i] = Integer.parseInt(sc.next());
                i++;
            }
            catch(java.lang.NumberFormatException e)
            {

            }
        }
    }

    public void init(int N) {
        this.arrayT = new int[N];
        Random r = new Random();
        for (int i = 0; i < this.arrayT.length; i++)
        {
            arrayT[i] = r.nextInt(10);
        }
    }
    public String toString()
    {
        String str = "";
        for(int i = 0 ; i < this.arrayT.length - 1 ; i++)
        {
            str += arrayT[i] + "    ";
        }
        return str + this.arrayT[this.arrayT.length - 1];
    }

    public boolean isPositive()
    {
        for(int i = 0 ; i < this.arrayT.length ; i++)
        {
            if(this.arrayT[i] < 0) return false;
        }
        return true;
    }

    public int replaceNegative()
    {
        int count = 0;
        for(int i = 0 ; i < this.arrayT.length ; i++)
        {
            if(this.arrayT[i] < 0)
            {
                count++;
                this.arrayT[i] = 0;
            }
        }
        return count;
    }

    public int CountOfEven()
    {
        int count = 0 ;
        for(int i = 0 ; i < this.arrayT.length ; i++)
        {
            if(this.arrayT[i]%2 == 0)
            {
                count++;
            }
        }
        return count;
    }

    public boolean obey()
    {
        boolean obey = true ;

        for(int i = 1 ; i < this.arrayT.length - 1 ; i++)
        {
            if(!((this.arrayT[i] > this.arrayT[i-1]) && (this.arrayT[i] > this.arrayT[i + 1]) ||
                    (this.arrayT[i] < this.arrayT[i-1]) && (this.arrayT[i] < this.arrayT[i + 1])))
            {
                return  false;
            }
        }
        return obey;
    }
    private void exchange(int a, int b)
    {
        int t = arrayT[a]; arrayT[a] = arrayT[b]; arrayT[b] = t;
    }
    public void sortBySelection(int start_idx, int end_idx, String direction)//direction = "ASC" - упорядочивает по возрастанию по умолчанию упорядочивает по убыванию
    {
        if(direction.equals("ASC")) {
            for (int i = start_idx; i <= end_idx; i++) {
                int min = i;
                for (int j = i + 1; j <= end_idx; j++) {
                    if (arrayT[min] > arrayT[j]) min = j;
                }
                this.exchange(i, min);
            }
        }
        else
        {
            for (int i = start_idx; i <= end_idx; i++)
            {
                int max = i;
                for (int j = i + 1; j <= end_idx; j++)
                {
                    if (arrayT[max] < arrayT[j]) max = j;
                }
                this.exchange(i, max);
            }
        }
    }

    public void sortByBubble(int start_idx, int stop_idx, String direction)//direction = "ASC" - упорядочивает по возрастанию по умолчанию упорядочивает по убыванию
    {
        if(direction.equals("ASC"))
        {
            for(int i = start_idx ; i < stop_idx ; i++) {
                for (int j = stop_idx; j > i; j--) {
                    if (arrayT[j] < arrayT[j - 1]) this.exchange(j, j - 1);
                }
            }
        }
        else
        {
            for(int i = start_idx ; i < stop_idx ; i++) {
                for (int j = stop_idx; j > i; j--) {
                    if (arrayT[j] > arrayT[j - 1]) this.exchange(j, j - 1);
                }
            }
        }
    }
}
