package leetcode.easy;

public class ImageSmoother_661 {
    public int[][] imageSmoother(int[][] img) {
        int h = img.length;
        int w = img[0].length;
        int[][] res = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                res[i][j] = getScore(img, i, j);
            }
        }

        return res;
    }

    private int getScore(int[][] img, int h, int w) {
        int count = 0;
        int sum = 0;
        for (int i = h - 1; i <= h + 1; i++) {
            for (int j = w - 1; j <= w + 1; j++) {
                if (i >= 0 && i < img.length && j >= 0 && j < img[0].length) {
                    count++;
                    sum += img[i][j];
                }
            }
        }
        return sum / count;
    }
}
