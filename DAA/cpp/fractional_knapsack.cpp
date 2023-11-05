#include <iostream>
#include <algorithm>
using namespace std;

struct Item
{
   int profit, weight;

   Item(int profit, int weight)
   {
      this->profit = profit;
      this->weight = weight;
   }
};

static bool cmp(struct Item a, struct Item b)
{
   double r1 = (double)a.profit / (double)a.weight;
   double r2 = (double)b.profit / (double)b.weight;

   return (r1 > r2);
}

double fractionalKnapsack(int w, struct Item arr[], int n)
{
   sort(arr, arr + n, cmp);
   double result = 0.0;

   for (int i = 0; i < n; i++)
   {
      if (arr[i].weight <= w)
      {
         w -= arr[i].weight;
         result += arr[i].profit;
      }
      else
      {
         result += arr[i].profit * ((double)w / (double)arr[i].weight);
      }
   }

   return result;
}

int main()
{
   int w = 50;
   Item arr[] = {{60, 10}, {100, 20}, {120, 30}};
   int n = sizeof(arr) / sizeof(arr[0]);

   cout << fractionalKnapsack(w, arr, n) << endl;

   return 0;
}
