package TestBolt.Jva;

public class Star1 {
    public static void main(String [] args)
    {
        for (int i = 1;i<=7;i+=2)
        {
            for (int s = 1; s<i;s+=2)
            {
                System.out.print(" ");
            }
            for (int k = 7; k>=i;k-=1)
            {
                System.out.print("*");

            }

            System.out.println();
        }

        System.out.println("Finish");


        for (int q=1; q<=6;q++)
        {
            for (int qw = 6; qw>=q; qw--)
            {
                System.out.print(" ");
            }
            for (int uy = 1; uy<=6;uy++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Finish");

        int n = 5;
        for (int i =1;i<=n; i++)
        {
            for (int j = 1 ;j<=i;j++)
            {
                System.out.print("*");
            }
            for (int k =1;k<=2*(n-i);k++)
            {
                System.out.print("0");
            }

            for (int o = 1; o<=i;o++)
            {
                System.out.print("*");
            }


            System.out.println();
        }

    }
}
