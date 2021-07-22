public class FindStrInArray {
    private boolean flag = false;

    public boolean findStrInArray(char[][] array, String str) {
        int height = array.length;
        int width = array[0].length;
        char[] chars = str.toCharArray();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int[][] path = new int[height][width];
                bfs(array, i, j, chars, 0, path);
            }
        }
        return flag;
    }


    private void bfs(char[][] array, int i, int j, char[] str, int index, int[][] path) {
        if (i < 0 || i > array.length - 1)
            return;
        if (j < 0 || j > array[0].length - 1)
            return;
        if (index > str.length - 1) {
            return;
        }
        if (path[i][j] == 1) {
            return;
        }
        path[i][j] = 1;
        if (index == str.length - 1 && array[i][j] == str[index]) {
            //success
            flag = true;
        }
        if (array[i][j] == str[index]) {
            bfs(array, i - 1, j, str, index + 1, path);
            bfs(array, i, j + 1, str, index + 1, path);
            bfs(array, i + 1, j, str, index + 1, path);
            bfs(array, i, j - 1, str, index + 1, path);
        }
    }

}
