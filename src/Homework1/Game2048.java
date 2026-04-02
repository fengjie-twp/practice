package Homework1;

import java.util.Random;


public class Game2048 {
    //定义棋盘
    private static final int N = 4;
    private final int[][] board = new int[N][N];
    private final Random random = new Random();
    private int score = 0;
    private  boolean winAnnouncement = false;

    //初始状态（90%为2 10%为4 随机出现两个方块）
    public void start(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                    board[i][j] = 0;
                }
            }

        spawn();
        spawn();
    }

    //方块生成规则（随机在空位生成新的方块）
    public void spawn(){
        int empty = 0;
        //统计空位数量
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
               if (board[i][j] == 0)
                   empty ++;
            }
        }
        int r = -1 ,c = -1;
        //随机挑选一个空位
        int k = random.nextInt(empty);
        if (empty == 0)
            return;
        outer:
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if (board[i][j] == 0){
                    if (k == 0){
                        r = i;
                        c = j;
                        break outer;
                    }else k--;
                }

            }
        }
        int percent = random.nextInt(10);
        int value;
        if (percent == 0) {
            value = 4;   // 10%
        } else {
            value = 2;   // 90%
        }
        board[r][c] = value;

    }
    
    //统一调用，读取指令，并做相应变化
    public boolean move(char direction) {
        boolean moved = false;
        switch (Character.toLowerCase(direction)) {
            case 'a': // left
                moved = moveLeft();
                break;
            case 'd': // right
                moved = moveRight();
                break;
            case 'w': // up
                moved = moveUp();
                break;
            case 's': // down
                moved = moveDown();
                break;
            default:
                return false;
        }

        if (moved) {
            spawn();
        }

        return moved;
    }

    //游戏结束判定
    public boolean isGameOver(){
        boolean isEmpty = false ;
        findEmpty:
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if (board[i][j] == 0){
                    isEmpty = true;
                    break findEmpty;
                }

            }
        }
        boolean canMerge = false;
        findMerge:
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if (i +1 < N && board[i][j] == board[i+1][j]) {
                    canMerge = true;
                    break findMerge;
                }
                if (j +1 < N && board[i][j] == board[i][j+1]) {
                    canMerge = true;
                    break outer;
                }
            }
        }
        return !isEmpty && !canMerge;
    }


    //积分规则


    public static void main(String[] args){


    }


    //预处理 & 调用方法
    //取行处理变化
    private int[] mergeLineLeft(int[] raw) {
        int[] line = new int[N];
        int k = 0;
        // 压缩
        for (int j = 0; j < N; j++) {
            if (raw[j] != 0)
                line[k++] = raw[j];
        }
        // 合并
        for (int j = 0; j < N - 1; j++) {
            if (line[j] != 0 && line[j] == line[j + 1]) {
                line[j] *= 2;
                score += line[j];
                line[j + 1] = 0;
                j++;
            }
        }
        // 再压缩成最终结果（把合并后的 0 挤走）
        int[] res = new int[N];
        int out = 0;
        for (int j = 0; j < N; j++) {
            if (line[j] != 0) res[out++] = line[j];
        }

        return res;
    }
    //反转
    private int[] reverse(int[] a) {
        int[] r = new int[N];
        for (int i = 0; i < N; i++) {
            r[i] = a[N - 1 - i];
        }
        return r;
    }
    //上下左右合并，并计分
    public boolean moveLeft() {
        boolean moved = false;

        for (int i = 0; i < N; i++) {
            int[] old = new int[N];
            for (int j = 0; j < N; j++) old[j] = board[i][j];

            int[] merged = mergeLineLeft(old);

            for (int j = 0; j < N; j++) {
                if (board[i][j] != merged[j]) moved = true;
                board[i][j] = merged[j];
            }
        }

        return moved;
    }
    public boolean moveRight() {
        boolean moved = false;

        for (int i = 0; i < N; i++) {
            int[] old = new int[N];
            for (int j = 0; j < N; j++) old[j] = board[i][j];

            // 右移：反转后做“左合并”，再反转回来
            int[] merged = reverse(mergeLineLeft(reverse(old)));

            for (int j = 0; j < N; j++) {
                if (board[i][j] != merged[j]) moved = true;
                board[i][j] = merged[j];
            }
        }

        return moved;
    }
    public boolean moveUp() {
        boolean moved = false;

        for (int c = 0; c < N; c++) {
            int[] old = new int[N];
            for (int r = 0; r < N; r++) old[r] = board[r][c];

            int[] merged = mergeLineLeft(old);

            for (int r = 0; r < N; r++) {
                if (board[r][c] != merged[r]) moved = true;
                board[r][c] = merged[r];
            }
        }

        return moved;
    }
    public boolean moveDown() {
        boolean moved = false;

        for (int c = 0; c < N; c++) {
            int[] old = new int[N];
            for (int r = 0; r < N; r++) old[r] = board[r][c];

            // 下移：反转后做“左合并”，再反转回来
            int[] merged = reverse(mergeLineLeft(reverse(old)));

            for (int r = 0; r < N; r++) {
                if (board[r][c] != merged[r]) moved = true;
                board[r][c] = merged[r];
            }
        }

        return moved;
    }
}
