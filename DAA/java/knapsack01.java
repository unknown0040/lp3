public class knapsack01 {
    public static void main(String[] args) {
        int[] p = {0, 1, 2, 5, 6}, wt = {0, 2, 3, 4, 5};
        int n = p.length - 1, m = 10;
        knapsack(p, wt, n, m);
//        System.out.println(knapsack(p, wt, n, m));

    }

    static void knapsack(int[] p, int[] wt, int n, int m) {
        int[][] k = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= m; w++) {
                if (i == 0 || w == 0) k[i][w] = 0;
                else if (wt[i] > w) k[i][w] = k[i - 1][w];
                else k[i][w] = Math.max(k[i - 1][w], k[i - 1][w - wt[i]] + p[i]);
            }
        }
        int i=n, j=m, res=0;
        while (i>0 && j>0){
            if (k[i][j]==k[i-1][j]) {
                System.out.println(i + " = 0");
                i--;
            }
            else {
                System.out.println(i + " = 1");
                j = j - wt[i];
                i--;
                res = res + p[i+1];
            }
        }
        System.out.println("Profit: " + res);
//        return k[n][m];
    }
}
