package leetcode.difficult;

public class ReachingPoints_780 {
    //正向计算，分支太多，会超时或者栈溢出
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        }
        //必不会到达的情况
        if (sx > tx || sy > ty) {
            return false;
        }
        return reachingPoints(sx + sy, sy, tx, ty) || reachingPoints(sx, sy + sx, tx, ty);
    }

    //反向计算，使用递归报栈溢出
    public boolean reachingPoints_Optimize(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        }
        if (sx == tx) {
            return (ty - sy) % sx == 0;
        }
        if (ty == sy) {
            return (tx - sx) % sy == 0;
        }
        if (tx < 0 || ty < 0) {
            return false;
        }
        if (tx < sx || ty < sy) {
            return false;
        }
        //如何定义不可能到达的情况
        return reachingPoints_Optimize(sx, sy, tx - ty, ty) || reachingPoints_Optimize(sx, sy, tx, ty - tx);
    }

    public boolean reachingPoints_Optimize_Deep(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) {
                tx = tx % ty;
            } else {
                ty = ty % tx;
            }
        }
        if (sx == tx && sy == ty) {
            return true;
        } else if (sx == tx && ty > sy) {
            return (ty - sy) % sx == 0;
        } else if (ty == sy && tx > sx) {
            return (tx - sx) % sy == 0;
        } else {
            return false;
        }
    }

}
