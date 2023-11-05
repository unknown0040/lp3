package Sem7.DAA;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int profit, weight;

    public Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b) {
            double r1 = (double) a.profit / (double) a.weight;
            double r2 = (double) b.profit / (double) b.weight;
            return Double.compare(r2, r1);
        }
    }

    public static double fractionalKnapsack(int w, Item[] arr) {
        Arrays.sort(arr, new ItemComparator());
        double result = 0.0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].weight <= w) {
                w -= arr[i].weight;
                result += arr[i].profit;
            } else {
                result += arr[i].profit * ((double) w / (double) arr[i].weight);
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int w = 50;
        Item[] arr = {new Item(60, 10), new Item(100, 20), new Item(120, 30)};

        System.out.println(fractionalKnapsack(w, arr));
    }
}

