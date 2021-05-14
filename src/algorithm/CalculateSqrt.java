package algorithm;

public class CalculateSqrt {
    /**
     * 已知2开平方为1.414，如何不用数学库，求开平方的值，精确到小数点儿后面10位
     *  2 - 1.4142135623730951
     * @param n 开平方数
     * @param k 精度
     * @return 开平方值
     */
    public double calculateSqrt(double n,double k){
        double left=0;
        double right=n;
        double mid;
        do {
            mid=(left+right)/2;
            if(mid*mid>n){
                right=mid;
            }else{
                left=mid;
            }
        }while(Math.abs(right-left)>k);
        return mid;
    }


    public double calculateSqrt_3(double num,double jingdu){
        if(num<0)
        {
            return -1;
        }

        double x=num,y=0.0;
        while(Math.abs(x-y)>0.00001){
            y=x;
            x=0.5*(x+num/x);
        }
        return x;
    }
}
