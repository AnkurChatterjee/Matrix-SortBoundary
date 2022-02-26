import java.io.*;
class BoundarySort
{
    int arr[][],m,n,t[];
    public BoundarySort(int a,int b)    //parameterized constructor to initialize the matrix
    {
        m=a;
        n=b;
        arr=new int[a][b];
    }

    public void accept()throws IOException
    {
        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader input=new BufferedReader(reader);
        System.out.println("\nEnter elements of the matrix row-wise.");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print("Enter element ");
                arr[i][j]=Integer.parseInt(input.readLine());
            }
        }
    }

    public void display()
    {
        System.out.println("\nORIGINAL MATRIX:");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.print("\n\n");
        }
    }

    public void sort()  //function to sort boundary elements
    {
        int c=(m*n)-((m-2)*(n-2)),d=-1;
        t=new int[c];   //array to store boundary elements only
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0||j==0||i==m-1||j==n-1)
                {
                    d++;
                    t[d]=arr[i][j];
                }
            }
        }
        for(int i=0;i<c;i++)    //sorting the boundary elements using bubble sort
        {
            for(int j=0;j<c-i-1;j++)
            {
                if(t[j]>t[j+1])
                {
                    int temp=t[j];
                    t[j]=t[j+1];
                    t[j+1]=temp;
                }
            }
        }
        d=-1;
        for(int j=0;j<n;j++)
        {
            d++;
            arr[0][j]=t[d];
        }
        for(int i=1;i<m;i++)
        {
            d++;
            arr[i][n-1]=t[d];
        }
        for(int j=n-2;j>=0;j--)
        {
            d++;
            arr[m-1][j]=t[d];
        }
        for(int i=m-2;i>0;i--)
        {
            d++;
            arr[i][0]=t[d];
        }
        System.out.println("MATRIX BOUNDARY ELEMENTS SORTED:");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.print("\n\n");
        }
    }

    public void show()
    {
        int s=0;
        System.out.println("BOUNDARY ELEMENTS:");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0||j==0||i==m-1||j==n-1)  //checking for boundary elements only
                {
                    System.out.print(arr[i][j]+"\t");
                    s=s+arr[i][j];
                }
                else
                    System.out.print(" "+"\t");
            }
            System.out.print("\n\n");
        }
        System.out.println("Sum of boundary elements= "+s);
    }

    public static void main(String args[])throws IOException
    {
        int ch;
        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader input=new BufferedReader(reader);
        while(true)
        {
            System.out.println("\nINPUT MATRIX:");
            System.out.print("Enter the number of rows: ");
            int x=Integer.parseInt(input.readLine());
            System.out.print("Enter the number of columns: ");
            int y=Integer.parseInt(input.readLine());
            BoundarySort obj=new BoundarySort(x,y);
            obj.accept();
            obj.display();
            obj.sort();
            obj.show();
            System.out.print("\n1. Continue\n2. Exit\nEnter your choice: ");
            ch = Integer.parseInt(input.readLine());
            switch(ch)
            {
                case 1: continue;
                case 2: System.exit(0);
                    break;
                default: System.out.println("Invalid Entry. Please enter from the given choices.");
            }

        }
    }
}