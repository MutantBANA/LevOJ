package P1821;

import org.w3c.dom.Node;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: Main
 * Package: P1821
 * Description:
 *
 * @Author Benanalana
 * @Create 2024/3/5 14:53
 * @Version 1.0
 */
public class Main
{

    public static void main(String[] args)
    {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for (int i = 0; i < num - 1; i++)
        {
            int no1 = scan.nextInt();
            int no2 = scan.nextInt();
            ArrayList<Integer> list;
            if (map.containsKey(no1))
            {
                list = map.get(no1);
            } else
            {
                list = new ArrayList<>();
            }
            list.add(no2);
            map.put(no1, list);
        }
        int max = high(map, 1);
        System.out.println(max-1);
    }

    public static Integer high(HashMap<Integer, ArrayList<Integer>> map, int key)
    {
        if (map.get(key) == null)
        {
            return 1;
        }
        int max = 0;
        ArrayList<Integer> list = map.get(key);
        for (int i = 0; i < list.size(); i++)
        {
            max = Math.max(max, high(map, list.get(i)));
        }
        return max + 1;
    }
}
