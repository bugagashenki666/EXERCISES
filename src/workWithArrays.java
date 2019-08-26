import java.util.Random;

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
    public void init(int N) {
        this.arrayT = new int[N];
        Random r = new Random();
        for (int i = 0; i < this.arrayT.length; i++)
        {
            arrayT[i] = r.nextInt();
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
    public void sortBySelection(int start_idx, int end_idx)
    {
        for(int i = start_idx ; i <= end_idx ; i++)
        {
            int min = i;
            for(int j = i + 1 ; j <= end_idx ; j++)
            {
                if(arrayT[min] > arrayT[j]) min = j;
            }
            this.exchange(i, min);
        }
    }
}
