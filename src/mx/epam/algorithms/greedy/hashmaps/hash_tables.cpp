
#include <stdlib.h>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

int* twoSum(int arr[], int target, int n);

int main() {
	int N = 4;
	int target = 9;
	int arr[] = {7,2,10,11};
	int* result;
	result = twoSum(arr, target, N);

	vector<int>::iterator it;
	cout <<"[" << result[0] << ", " << result[1] << "]";
	
	delete[] result;
	getchar();
	return 0;
}

int* twoSum(int arr[], int target, int n) {
	int* indexes = new int[2]{ -1, -1 };
	map<int,int> compliments;
	map<int, int>::iterator it;

	for (int i = 0; i < n; i++)
	{
		it = compliments.find( arr[i]);
		if (it != compliments.end())
		{
			// this is our result
			indexes[0] = i;
			indexes[1] = it->second;
			return indexes;
		}
		else {
			// save the compliment as key and the index as value
			pair<int, int> entry(target - arr[i], i);
			compliments.insert(entry);
		}
	}
	return indexes;
}

