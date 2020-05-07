package leetcode;

/**
 * @program: code
 * @description: LeetCode289
 * @author: Mr.Wang
 * @create: 2020-04-23 20:06
 **/

public class GameofLife {
            /**
            * @Description: 原确定位置的0代表死亡,1代表存活,|2代表下一轮是存活,|0代表下一轮死亡,向右移动一位代表一轮更新结束
            * @Param:
            * @return:
            * @Author: Mr.Wang
            * @Date: 2020/4/23
            */
    public void gameOfLife(int[][] board) {
        int[][]pos={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                int cnt=0;
                for(int k=0;k<pos.length;k++)
                {
                    int posx=pos[k][0]+i;
                    int posy=pos[k][1]+j;
                    if(posx>=0&&posx<board.length&&posy>=0&&posy<board[0].length&&(board[posx][posy]&1)==1)
                    {
                        cnt++;
                    }
                }
                if(board[i][j]==1)
                {
                    if(cnt<2||cnt>3)
                    {
                        board[i][j]|=0;
                    }
                    else board[i][j]|=2;

                }
                else
                {
                    if(cnt==3)
                    {
                        board[i][j]|=2;
                    }
                    else board[i][j]|=0;
                }
            }

        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                board[i][j]>>=1;
            }
        }

    }
}
