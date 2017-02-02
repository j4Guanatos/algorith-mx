#!/usr/bin/python
__author__ = "mimibar"
__date__ = "01/feb/17"


def sort(a):
   print (str(a) + "\tiMin\tj\ta[i]\ta[j]")

   N = len(a)
   
   for i in range(0,N):
     min = i
     for j in range(i + 1,N):
         if a[j] < a[min]:
             min = j
     exch(a, i, min)

def exch(a,  i,  j):
    swap = a[i]
    a[i] = a[j]
    a[j] = swap
    show( a,j,i)

def show( a,i,j):
    print (str(a) + "\t" + str(i) + "\t" + str(j) + "\t" + str(a[i])+ "\t" + str(a[j]))
 
    
print ('========Selection Sort========')

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
