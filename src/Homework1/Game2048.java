package Homework1;

import java.util.Random;
import java.util.Scanner;

public class Game2048 {
    //定义棋盘
    private static final int N = 4;
    private final int[][] board = new int[N][N];
    private final Random random = new Random();
    private int score = 0;
    private boolean winAnnouncement = false;

    //打印棋盘
    public void printBoard() {
        System.out.println("Score: " + score);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    System.out.printf("%5s", ".");
                } else {
                    System.out.printf("%5d", board[i][j]);
                }
            }
            System.out.println();
        }
    }

    //获取分数
    public int getScore(){
        return score;
    }

    //初始状态（90%为2 10%为4 随机出现两个方块）
    public void start(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                    board[i][j] = 0;
                }
            }
        winAnnouncement = false;
        score = 0;
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
        if (empty == 0)
            return;
        int k = random.nextInt(empty);
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

    //读取移动方向，做合并or移动，并计分
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
                    break findMerge;
                }
            }
        }
        return !isEmpty && !canMerge;
    }

    //游戏胜利判定（仅第一次）
    public boolean isWinned() {
        if(winAnnouncement)
            return false;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (board[i][j] >= 2048 ){
                    System.out.println("游戏胜利！");
                    winAnnouncement = true;
                    return true;
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        Game2048 game = new Game2048();
        game.start();
        Scanner in = new Scanner(System.in);
        while (true) {
            game.printBoard();
            if (game.isGameOver()) {
                System.out.println("Game Over! Final Score: " + game.getScore());
                break;
            }

            System.out.print("Move (W/A/S/D), Q to quit, R to restart: ");
            String s = in.nextLine().trim();
            if (s.isEmpty())
                continue;
            char cmd = Character.toLowerCase(s.charAt(0));
            if (cmd == 'q') {
                System.out.println("Quit. Final Score: " + game.getScore());
                break;
            }
            if (cmd == 'r') {
                game.start();
                continue;
            }
                //避免玩家输入其他字母，影响游玩
            if (cmd != 'w' && cmd != 'a' && cmd != 's' && cmd != 'd') {
                System.out.println("无效命令，请输入 W/A/S/D, R 或 Q。");
                continue;
            }
            boolean moved = game.move(cmd);
            if (moved) {
                // 如果这一步刚刚触发胜利提示，就询问是否继续
                if (game.isWinned()) {
                    System.out.print("是否继续游戏？(y/n): ");
                    String ans = in.nextLine().trim().toLowerCase();
                    if (ans.isEmpty() || ans.charAt(0) != 'y') {
                        System.out.println("最终得分: " + game.getScore());
                        break;
                    }
                }

            }else {
                System.out.println("无效移动（棋盘未变化），请换个方向。");
            }
        }
        in.close();
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
    //上下左右
    public boolean moveLeft() {
        boolean moved = false;
        for (int i = 0; i < N; i++) {
            int[] old = new int[N];
            //复制一份
            for (int j = 0; j < N; j++) {
                old[j] = board[i][j];
            }
            int[] merged = mergeLineLeft(old);
            for (int j = 0; j < N; j++) {
                //判断是否有效移动
                if (board[i][j] != merged[j])
                    moved = true;
                board[i][j] = merged[j];
            }
        }
        return moved;
    }
    public boolean moveRight() {
        boolean moved = false;
        for (int i = 0; i < N; i++) {
            int[] old = new int[N];
            for (int j = 0; j < N; j++) {
                old[j] = board[i][j];
            }
            // 反转后做“左合并”，再反转回来
            int[] merged = reverse(mergeLineLeft(reverse(old)));
            for (int j = 0; j < N; j++) {
                if (board[i][j] != merged[j])
                    moved = true;
                board[i][j] = merged[j];
            }
        }
        return moved;
    }
    public boolean moveUp() {
        boolean moved = false;
        for (int j = 0; j < N; j++) {
            int[] old = new int[N];
            //取列
            for (int i = 0; i < N; i++) {
                old[i] = board[i][j];
            }
            //调用mergeLineLeft对列做合并处理
            int[] merged = mergeLineLeft(old);
            for (int i = 0; i < N; i++) {
                if (board[i][j] != merged[i])
                    moved = true;
                board[i][j] = merged[i];
            }
        }
        return moved;
    }
    public boolean moveDown() {
        boolean moved = false;
        for (int j = 0; j < N; j++) {
            int[] old = new int[N];
            for (int i = 0; i < N; i++) {
                old[i] = board[i][j];
            }
            // 反转后取列做合并，再反转回来
            int[] merged = reverse(mergeLineLeft(reverse(old)));
            for (int i = 0; i < N; i++) {
                if (board[i][j] != merged[i])
                    moved = true;
                board[i][j] = merged[i];
            }
        }
        return moved;
    }
}
