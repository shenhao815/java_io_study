package com.it.recursion;

/**
 * @author ch
 * @date 2020-11-4
 */
/*
    递归：方法自己调用自己
    - 递归的分类：
        - 递归分为两种，直接递归和间接递归。
        - 直接递归称为方法自身调用自己。
        - 间接递归可以A方法调用B方法，B方法调用C方法，C方法调用A方法。
    - 注意事项：
        - 递归一定要有条件限定，保证递归能够停止下来，否则会发生栈内存溢出。
        - 在递归中虽然有限定条件，但是递归次数不能太多。否则也会发生栈内存溢出。
        - 构造方法禁止递归。
    递归的使用前提：
        当调用方法的时候，方法的主体不变，每次调用方法的参数不同，就可以使用递归。
 */
public class recursion01 {

    public static void main(String[] args) {
        int b = sum(5);
        System.out.println(b);
        int c = test(5);
        System.out.println(c);
    }

    /*
        定义一个方法，使用递归计算1-n之间的和
        1+2+3+...+n
        n+(n-1)+(n-2)+...+1
        已知：
            最大值：n
            最小值：1
        使用递归必须明确：
            1.递归的结束条件
                获取到1的时候结束
            2.递归的目的
                获取下一个被加的数字（n-1）
     */
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    public static int test(int n) {
        if (n==1) {
            return 1;
        }
        return n * test(n - 1);
    }

}
