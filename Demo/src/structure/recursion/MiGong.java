package structure.recursion;

/**
 * 迷宫回溯
 */
public class MiGong {
    public static void main(String[] args) {
        int [][] map = new int [8][7];

        for(int i = 0; i < 7 ;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[2][1] = 1;
        map[2][2] = 1;
        for(int i = 0;i<8;i++){
            for(int j = 0; j < 7 ;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        setWay(map , 1, 1);
        System.out.println("====================================");
        for(int i = 0;i<8;i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean setWay(int[][] map, int i, int j) {
        //如果走到右下角直接返回true
        if(map[6][5] == 2){
            return true;
        }else{
              //如果这个点还没有走过
            if(map[i][j] == 0){
                map[i][j] = 2;
                if(setWay(map, i+1, j)){
                    return true;
                }else if(setWay(map, i, j+1)){
                    return true;
                }else if(setWay(map , i-1, j)){
                    return true;
                }else if(setWay(map, i, j-1)){
                    return true;
                }else{
                    //3表示此路不通
                    map[i][j] = 3;
                    return false;
                }
            }else{
                //如果不是0，则只能是123，直接返回false
                return false;
            }
        }
    }
}
