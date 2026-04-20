class Solution {
    public int solution(int a, int b, int n) {
        int totalNewCoke = 0;

        while (n >= a) {
            int newCoke = (n / a) * b;
            totalNewCoke += newCoke;
            n = newCoke + (n % a);
        }

        return totalNewCoke;
    }
}