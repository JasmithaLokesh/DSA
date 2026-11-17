class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
       HashMap<String, Long> map = new HashMap<>();
       long count = 0;

       for(int[] rect : rectangles) {
        int w = rect[0];
        int h = rect[1];

        int gcd = findGCD(w, h);

        w = w/ gcd;
        h = h / gcd;

        String ratio = w + "/" + h;
        long freq = map.getOrDefault(ratio, 0L);
        count += freq;
        map.put(ratio, freq + 1);
       } 
       return count;
    }

    public int findGCD(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}