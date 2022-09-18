import java.util.Scanner;


/**
 * 1
 * 2
 * 3
 * 4
 * 5
 *   A B C D E
 */
public class Solution2488 {
    static int fStep=0;
    static int[][] visited;
    static String[] path;

    static int orderX[] = {-2,-2,-1,-1,1,1,2,2};

    static int orderY[] = {-1,1,-2,2,-2,2,-1,1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 1;
        while(n-- >0){
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            fStep = x * y;
            path = new String[fStep];
            visited = new int[x][y];
            path[0] = "A1";
            visited[0][0] =1;
            System.out.println("Scenario #"+ count +":");
            if(dfs(0,0,1)){
                showPath();
            }
            else {
                System.out.println("impossible");
            }
            count++;
        }
    }

    static boolean dfs(int x,int y,int nowStep){
        if(nowStep==fStep){
            return true;
        }
        for(int i=0;i<8;i++){
            int nowX = x+orderX[i];
            int nowY = y+orderY[i];
            //不出界，没去过
            if(nowX>=0&&nowX<visited.length&&
                    nowY>=0&&nowY<visited[0].length&&visited[nowX][nowY]==0){
                path[nowStep] = (char)(65+nowX)  +"" + (nowY+1) ;
                visited[x][y] = 1;
                if(dfs(nowX,nowY,nowStep+1)){
                    return true;
                }
                else{
                    visited[x][y]=0;
                }
            }
        }
        return false;
    }

    static void showPath(){
        for(String eachPath : path){
            System.out.print(eachPath);
        }
        System.out.print("\n");
    }
}

