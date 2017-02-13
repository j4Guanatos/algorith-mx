#!/usr/bin/python
__author__ = "mimibar"
__date__ = "02/feb/17"


def sort(a):
    print (str(a) + "\t    i\t\t    j")
    
    N = len(a)
    for i in range(0,N):
        j = i
        while j > 0 and a[j] < a[j - 1]:
            exch(a, j, j - 1);
            j-=1


def exch(a,  i,  j):
    swap = a[i]
    a[i] = a[j]
    a[j] = swap
    show( a,j,i)

def show( a,i,j):
    print (str(a) + "\ta[" + str(i) + "] = " + str(a[i])+ "\ta[" + str(j) + "] = " + str(a[j]))
 
    
print ('========Insertion Sort========')

a=[1,6,2,4]
sort (a)
print()

a=[4, 2, 3, 4, 1]
sort (a)
print()

a=[10,20,2,14,5,28,45,30]
sort (a)
print()

a=[2,23,16,47,35,44]
sort (a)
print()
