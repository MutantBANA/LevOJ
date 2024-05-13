package P1138;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String mid = scan.next();
        String pre = scan.next();
        char[] fin = new char[pre.length()];
        findFin(pre, mid, fin, 0, pre.length() - 1, 0, mid.length() - 1, 0, fin.length - 1);
        System.out.println(String.valueOf(fin));
    }

    //给定一棵树的前序遍历、中序遍历，求出后序遍历
    public static void findFin(String pre, String mid, char[] fin, int pL, int pR, int mL, int mR, int fL, int fR) {
        if (fR < fL) {
            return;
        }
        fin[fR] = pre.charAt(pL);//把根节点放在后序遍历的位置
        //找到根节点在中序遍历的下标
        int point = mid.indexOf(pre.charAt(pL));
        findFin(pre, mid, fin, pL + 1 + (point - mL), pR, point + 1, mR, fL + point - mL, fR - 1);
        findFin(pre, mid, fin, pL + 1, pR - (mR - point), mL, point - 1, fL, fL + point - mL - 1);
    }
}
