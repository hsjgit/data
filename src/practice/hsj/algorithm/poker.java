package practice.hsj.algorithm;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import static java.lang.Math.abs;

/**
 * Created by 黄仕杰 on 2018/4/2.
 */
public class poker {
    public static void main(String[] args){
        double sum=0.0;
        boolean bool = true;
        double start = 1.0;
        double tmp=1.0;

        while (bool){
            //数计算，变小
            if(sum >= 0.1 || sum == 0)
            {
                tmp = (start % 2 ==0?-tmp:+abs(tmp));
                sum = sum+(tmp/start);

                System.out.println(start+"||"+sum);
                poker.putout(sum,start);
                start++;
            }else {

                bool =false;
            }
        }
    }

    private static void putout(double sum,double start){
        try {
            PrintStream out = System.out;// 保存原输出流
            PrintStream ps=new PrintStream("D:/log.txt");// 创建文件输出流1

            System.setOut(ps);// 设置使用新的输出流
            System.out.println("使用新的输出流将log输出到 E:/log.txt");

            System.setOut(out);// 恢复原有输出流
            System.out.println("程序运行完毕，恢复为原输出流。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
