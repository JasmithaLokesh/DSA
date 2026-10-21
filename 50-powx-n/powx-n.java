class Solution {

    public double myPow(double x, int n) {
        long power = n;

        if(n < 0) {
            power = -power;
            return 1.0 / calculatePow(x, power);
        }
        return calculatePow(x , power);
    }

    public double calculatePow(double x, long n) {
        if(n == 0) {
            return 1;
        }

        double halfPower = calculatePow(x, n/2);
        double halfPowerSq = halfPower * halfPower;

        if(n % 2 != 0) {
            halfPowerSq = x * halfPowerSq;
        }

        return halfPowerSq;
    }
}