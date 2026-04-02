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



    //操作方式（用WASD控制）
    public void move(){


    }
    public boolean moveLeft(){
        boolean isMove = false;
        for(int i = 0; i < N; i++){
            int[] line = new int[N];
            int k = 0;
            int j;
            //复制一个，便于判断是否发生有效移动or合并
            int[] old = new int[N];
            for (j = 0; j < N; j++) {
                old[j] = board[i][j];
            }
            //压缩
            for (j = 0; j < N; j++){
                if (board[i][j] != 0) {
                    line[k] = board[i][j];
                    k++;
                }
            }
            //原数据清空
            for (j = 0; j < N; j++){
                board[i][j] = 0;
            }
            //合并
            for(j = 0; j < N - 1; j++){
                if (line[j] != 0 && line[j] ==line[j+1]){
                    line[j] = 2 * line[j];
                    score += line[j];
                    line[j+1] = 0;
                    j++;
                }
            }
            //压缩写回
            for(k = 0,j = 0; k < N ; k++){
                if(line[k] != 0){
                    board[i][j] = line[k];
                    j++;
                }
            }
            for (j = 0; j < N; j++) {
                if (old[j] != board[i][j]) {
                    isMove = true;
                    break;
                }
            }
        }

        return isMove;
    }
    private void reverseRow(int r) {
        for (int j = 0; j < N / 2; j++) {
            int tmp = board[r][j];
            board[r][j] = board[r][N - 1 - j];
            board[r][N - 1 - j] = tmp;
        }
    }
    public boolean moveRight() {
        //反转方向，直接使用moveLeft
        for (int i = 0; i < N; i++)
        {
            reverseRow(i);
        }
        boolean isMove = moveLeft();

        //恢复方向
        for (int i = 0; i < N; i++) {
            reverseRow(i);
        }
        return isMove;
    }

    //合并规则

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
}
