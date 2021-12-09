package com.armin.lc;

/**
 * 794. 有效井字游戏
 *
 * @author armin
 * @version 2021/12/9
 */
public class ValidTicTacToe {

    public static void main(String[] args) {
        ValidTicTacToe v = new ValidTicTacToe();
        boolean b = v.validTicTacToe(new String[]{"XOX", "O O", "XOX"});
        System.out.println("b = " + b);
    }

    /**
     * 判断这局游戏的布局是否是正常下的，分为胜利和过程中。
     *
     * @param board
     * @return
     */
    public boolean validTicTacToe(String[] board) {
        int x = 0, o = 0;
        // 转换为二维数组，并相应计数；
        char[][] cs = new char[3][3];
        for (int i = 0; i < 3; i++) { // 0~2
            for (int j = 0; j < 3; j++) { // 0~2
                char c = board[i].charAt(j);
                if (c == 'X') x++;
                else if (c == 'O') o++;
                cs[i][j] = c;
            }
        }

        boolean a = check(cs, 'X'), b = check(cs, 'O');
        // 总是X先下，所以X大于等于O～，且不能大于1
        if (o > x || x - o > 1) return false;
        // X 赢了，但是X比O少或者等于
        if (a && x <= o) return false;
        // O 赢了，但是O和X的数量不一致（O后手）
        if (b && o != x) return false;
        // 双方同时赢
        if (a && b) return false;
        return true;
    }

    /**
     * 判断是否已经赢了
     *
     * @param cs
     * @param c
     * @return
     */
    boolean check(char[][] cs, char c) {
        for (int i = 0; i < 3; i++) {
            // check 竖列 是否成功
            if (cs[i][0] == c && cs[i][1] == c && cs[i][2] == c) return true;
            // check 横列 是否成功
            if (cs[0][i] == c && cs[1][i] == c && cs[2][i] == c) return true;
        }
        boolean a = true, b = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 斜列 \ 是否成功
                if (i == j) a &= cs[i][j] == c; // 全是true 最后才为true
                // 斜列 / 是否成功
                if (i + j == 2) b &= cs[i][j] == c; // 全是true 最后才为true
            }
        }
        return a || b;
    }
}
