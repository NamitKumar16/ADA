package ADA;
import java.io.*;
import java.io.*;
public class Test
{
    double dydt(double t, double y,double x)
    {
        float a=2/3,b=4/3;
        return(a*x-b*x*y);
    }
    double dxdt(double t, double x,double y)
    {
        float c=1,d=1;
        return(-c*y+d*x*y);
    }

    double rK4(double t0, double y0, double t, double h,double x0)
    {
        Test d1 = new Test();
        // counting number of iteration
        int n = (int)((t - t0) / h);

        double k1, k2, k3, k4;
        double f1,f2,f3,f4;
        double y = y0;
        double x=x0;
        for (int i = 1; i <= n; i++)        //while [x<xn]
        {
            // runge kutta Formulas to find next value of y at t
            k1 = h*(d1.dydt(t0, y ,x));
            k2 = h*(d1.dydt(t0 + 0.5 * h, y + 0.5 * k1 ,x));
            k3 = h*(d1.dydt(t0 + 0.5 * h, y + 0.5 * k2 ,x));
            k4 = h*(d1.dydt(t0 + h, y + k3 ,x));
            y = y + (1.0 / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);

            // runge kutta Formulas to find next value of y at t
            f1 = h*(d1.dxdt(t0, x ,y));
            f2 = h*(d1.dxdt(t0 + 0.5 * h, x + 0.5 * f1, y));
            f3 = h*(d1.dxdt(t0 + 0.5 * h, x + 0.5 * f2 ,y));
            f4 = h*(d1.dxdt(t0 + h, x + f3 ,y));
            x = x + (1.0 / 6.0) * (f1 + 2 * f2 + 2 * f3 + f4);

//       incrementing t
            t0 = t0 + h;

            System.out.println(" t   "+ t0);
            System.out.println("y: " + y + "   " + "x" + x);

            System.out.println();

        }
        System.out.println("\n x : "+x);
        return y;
    }

    public static void main(String args[])
    {
        Test d2 = new Test();
//   double x0 = 0, y = 1, x = 2, h = 0.2;
//	 double t0 = 0, y = 0.5, t = 2, h = 0.1, x=0.5;
        double t0 = 2, y = 2, t = 8, h = 0.5, x=2;
//	 double t0 = 0, y = 2, t = 6, h = 0.5, x=2;
        System.out.println("\ny : "
                + d2.rK4(t0, y, t, h,x));
    }
}