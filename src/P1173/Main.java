package P1173;

import java.util.Scanner;
import java.util.Stack;

/**
 * ClassName: Main
 * Package: P1173
 * Description:
 *
 * @Author Benanalana
 * @Create 2024/3/2 17:03
 * @Version 1.0
 */

/*
VISIT http://acm.ashland.edu/
VISIT http://acm.baylor.edu/acmicpc/
BACK
BACK
BACK
FORWARD
VISIT http://www.ibm.com/
BACK
BACK
FORWARD
FORWARD
FORWARD
QUIT
 */
public class Main
{
    public static void main(String[] args)
    {
        Stack<String> backStack = new Stack();
        Stack<String> forwardStack = new Stack();
        String cur = "http://www.acm.org/ ";
        Scanner scan = new Scanner(System.in);
        String com = scan.next();
        while (!com.equals("QUIT"))
        {
            switch (com)
            {
                case "BACK":
                    cur = Back(cur, backStack, forwardStack);
                    break;
                case "FORWARD":
                    cur = Forward(cur, backStack, forwardStack);
                    break;
                case "VISIT":
                    cur = Visit(backStack, forwardStack, cur, scan);
                    break;
            }
            com = scan.next();
        }
        scan.close();
    }

    public static String Back(String cur, Stack<String> backStack, Stack<String> forwardStack)
    {
        if (backStack.isEmpty())
        {
            System.out.println("Ignored");
            return cur;
        }
        forwardStack.add(cur);
        cur = backStack.pop();
        System.out.println(cur);
        return cur;
    }

    public static String Forward(String cur, Stack<String> backStack, Stack<String> forwardStack)
    {
        if (forwardStack.isEmpty())
        {
            System.out.println("Ignored");
            return cur;
        }
        backStack.add(cur);
        cur = forwardStack.pop();
        System.out.println(cur);
        return cur;
    }

    public static String Visit(Stack<String> backStack, Stack<String> forwardStack, String cur, Scanner scan)
    {
        forwardStack.clear();
        backStack.add(cur);
        cur = scan.next();
        System.out.println(cur);
        return cur;
    }
}
