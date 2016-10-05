using System;

namespace threesandfives
{
    class Program
    {
        public static string ThreesAndFives(int num)
        {
            // http://www.cs.cmu.edu/~adamchik/21-127/lectures/divisibility_5_print.pdf
            // generalization of linear Diophantine equation integer positive solutions

            //  ax + by = c
            // specific case is 5x + 3y = c (n in the algorithm)
            var a = 5.0;
            var b = 3.0;
            double c = num;

            // By extended Euclidean algorithm we find gcd and such n and m that  a * n + b * m = gcd(a, b)
            // 3 and 5 are primes, so their gcd is 1, leaving us with 5 * n + 3 * m = 1
            // therefore  n = -1; m = 2 so that 5*(-1) + 3*2 = 1

            var n = -1.0;
            var m = 2.0;

            // By substituting in the original equation the base solutions are
            /*
                    n*c					m*c
            X0 = -------------; Y0 = -------------
                    gcd(a,b)			gcd(a,b)

            In our specific case that is:
            X0 = -1*c/1 = -c 
            Y0 = 2*c/1 = 2c

            To find ALL solutions a constant k is introduced so that the equation for gcd ends up as:

            gcd(a,b)*c = a*n*c +b*m*c +a*b*k -a*b*k

            allowing to rearrange as 

            a*(nc+bk) + b*(mc-ak) = gcd(a,b) *c

            in our case:
            5*(-c+3k) + 3*(2c-5k)=c

            which leaves the general solution:

            X = X0 + bk ; Y = Y0 -ak, in our case X = X0+3k ; y = Y0-5k

            giving us two inequalities

            nc+bk > 0
            mc-ak > 0

            from which we calculate the lowest posible k and apply to get the maximum possible value for y that satisfies the equation 
            (as many 5s as possible)

            */

            var lower = (int)Math.Ceiling(-(n * c) / b); 
            var higher = (int)Math.Floor(m * c / a);

            if (lower > higher) return "-1";
            var k = lower;
            var x = (n * c) + (3 * k);
            var y = (m * c) - (5 * k);
            if (x * y < 0) return "-1";

            var res = new string('5', 3 * (int)y) + new string('3', 5 * (int)x);// love me some casts
            return res;
        }

        public static void Main()
        {
            var t = int.Parse(Console.ReadLine());
            for (var i = 0; i < t; i++)
            {
                Console.WriteLine(ThreesAndFives(int.Parse(Console.ReadLine())));
            }
            Console.ReadLine();
        }
    }
}
