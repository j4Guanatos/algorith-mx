using System;
using System.Collections.Generic;
using System.Linq;

namespace ResizableArrays
{
    internal class Program
    {
        private static int[] ConstructRootFromdArray(IReadOnlyList<int> a, int from, int to)
        {
            var queue = new Queue<int>();

            for (var i = from; i <= to; i++)
                queue.Enqueue(a[i]);

            return queue.ToArray();
        }

        private static int[] UnionWith(IReadOnlyCollection<int> s, IReadOnlyCollection<int> t)
        {
            var merged = new int[s.Count + t.Count];
            var c = 0;
            var mine = s.GetEnumerator();
            var theirs = t.GetEnumerator();
            bool mineEnded = !mine.MoveNext(), theirsEnded = !theirs.MoveNext();
            while (!mineEnded && !theirsEnded)
            {
                var comp = mine.Current.CompareTo(theirs.Current);
                if (comp < 0)
                {
                    merged[c++] = mine.Current;
                    mineEnded = !mine.MoveNext();
                }
                else if (comp == 0)
                {
                    merged[c++] = theirs.Current;
                    mineEnded = !mine.MoveNext();
                    theirsEnded = !theirs.MoveNext();
                }
                else
                {
                    merged[c++] = theirs.Current;
                    theirsEnded = !theirs.MoveNext();
                }
            }

            if (mineEnded && theirsEnded) return ConstructRootFromdArray(merged, 0, c - 1);
            var remaining = mineEnded ? theirs : mine;
            do
            {
                merged[c++] = remaining.Current;
            } while (remaining.MoveNext());

            return ConstructRootFromdArray(merged, 0, c - 1);
        }

        private static int[] IntersectWith(IReadOnlyCollection<int> s, IReadOnlyCollection<int> t)
        {
            var merged = new int[s.Count];
            var c = 0;
            var mine = s.GetEnumerator();
            var theirs = t.GetEnumerator();
            bool mineEnded = !mine.MoveNext(), theirsEnded = !theirs.MoveNext();
            while (!mineEnded && !theirsEnded)
            {
                var comp = mine.Current.CompareTo(theirs.Current);
                if (comp < 0)
                {
                    mineEnded = !mine.MoveNext();
                }
                else if (comp == 0)
                {
                    merged[c++] = theirs.Current;
                    mineEnded = !mine.MoveNext();
                    theirsEnded = !theirs.MoveNext();
                }
                else
                {
                    theirsEnded = !theirs.MoveNext();
                }
            }

            return ConstructRootFromdArray(merged, 0, c - 1);
        }

        private static void Display(IEnumerable<int> list)
        {
            Console.ForegroundColor = ConsoleColor.White;
            foreach (var item in list)
                Console.Write($"{item} ");

            Console.WriteLine();
        }

        private static void Solution1()
        {
            var a1 = new SortedSet<int> {1, 5, 9, 10, 17, 20, 23};
            var a2 = new SortedSet<int> {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
            var a3 = new SortedSet<int> {3, 9, 18, 27};
            var a4 = new SortedSet<int> {2, 3, 5, 7, 11, 13, 17};

            a1.IntersectWith(a2);
            a1.UnionWith(a3);
            a1.UnionWith(a4);

            Display(a1);
        }

        private static void Solution2()
        {
            var a1 = new[] {1, 5, 9, 10, 17, 20, 23};
            var a2 = new[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
            var a3 = new[] {3, 9, 18, 27};
            var a4 = new[] {2, 3, 5, 7, 11, 13, 17};

            a1 = IntersectWith(a1, a2);
            a1 = UnionWith(a1, a3);
            a1 = UnionWith(a1, a4);

            Display(a1);
        }

        private static void Solution3()
        {
            var a1 = new List<int> {1, 5, 9, 10, 17, 20, 23};
            var a2 = new List<int> {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
            var a3 = new List<int> {3, 9, 18, 27};
            var a4 = new List<int> {2, 3, 5, 7, 11, 13, 17};

            var c = a1.Intersect(a2).Union(a3).Union(a4).OrderBy(x => x);

            Display(c);
        }

        private static void DisplayMenu()
        {
            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.WriteLine("Resizable Arrays");
            Console.WriteLine("  1. Solution based on SortedSet");
            Console.WriteLine("  2. Solution based on arrays");
            Console.WriteLine("  3. Solution based on Linq");
            Console.Write("Choose one (q to quit): ");
        }

        private static void Main(string[] args)
        {
            for (;;)
            {
                ConsoleKeyInfo choice;
                do
                {
                    DisplayMenu();
                    do
                    {
                        choice = Console.ReadKey();
                    } while (choice.Key == ConsoleKey.Enter);
                } while ((choice.KeyChar < '1') | ((choice.KeyChar > '3') & (choice.KeyChar != 'q')));

                if (choice.KeyChar == 'q') break;

                Console.WriteLine("\n");

                switch (choice.Key)
                {
                    case ConsoleKey.D1:
                        Solution1();
                        break;
                    case ConsoleKey.D2:
                        Solution2();
                        break;
                    case ConsoleKey.D3:
                        Solution3();
                        break;
                }
                Console.WriteLine();
            }
        }
    }
}