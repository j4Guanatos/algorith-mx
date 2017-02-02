#!/usr/bin/python
__author__ = "mimibar"
__date__ = "01/feb/17"


def sort(a):
    N = len(a)
    all = []
    
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
    show( a,i,j)

def show( a,i,j):
    print (str(a) + "\t" + str(i) + "\t" + str(j) + "\t" + str(a[i])+ "\t" + str(a[j]))
 
    
print ('========Selection Sort========')

a=[1,6,2,4]
print (str(a) + "\tiMin\tj\ta[i]\ta[j]")
sort (a)
print()

a=[10,20,30,49,38,2,14,5,25,45,30]
print (str(a) + "\tiMin\tj\ta[i]\ta[j]")
sort (a)
print()

a=[2,13,25,22,16,27,28,5,38,44,37,44]
print (str(a) + "\tiMin\tj\ta[i]\ta[j]")
sort (a)
print()
