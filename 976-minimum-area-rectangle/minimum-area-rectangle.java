class Solution {
    public int minAreaRect(int[][] points) {
        HashSet<String> set = new HashSet<>();

        for(int[] p : points) {
            set.add(p[0] + "," + p[1]);
        }

        int minArea = Integer.MAX_VALUE;

        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if(x1 != x2 && y1 != y2) {
                    String p1 = x1 + "," + y2;
                    String p2 = x2 + "," + y1;

                    if(set.contains(p1) && set.contains(p2)) {
                        int area = Math.abs(x2 - x1) * Math.abs(y2 - y1);
                        minArea = Math.min(minArea, area);
                    }
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}