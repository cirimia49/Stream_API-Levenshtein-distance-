package package1;

import java.util.Arrays;

public class Levenshtein
{
    public static int calculateEditDistance(String x, String y) {
        int[][] dis = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dis[i][j] = j;
                }
                else if (j == 0) {
                    dis[i][j] = i;
                }
                else {
                    dis[i][j] = min(dis[i - 1][j - 1]
                                    + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dis[i - 1][j] + 1,
                            dis[i][j - 1] + 1);
                }
            }
        }

        return dis[x.length()][y.length()];
    }

    private static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    private static int min(int... numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }
}
