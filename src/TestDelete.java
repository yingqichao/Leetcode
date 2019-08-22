import java.util.LinkedList;
import java.util.List;

/**
 * @author Qichao Ying
 * @date 2019/8/16 14:22
 * @Description DEFAULT
 */
public class TestDelete {

    public static void main(String[] args) {
        List<Integer> origin = new LinkedList<>();List<Integer> toBeRemovedIndex = new LinkedList<>();
        origin.add(10);origin.add(8);origin.add(6);origin.add(4);origin.add(2);
        toBeRemovedIndex.add(2);
        removeObject(origin,toBeRemovedIndex);
        removeIndex(origin);
    }

    public static void removeObject(List<Integer> origin,List<Integer> toBeRemovedIndex){
        System.out.println("--调用removeObject--");
        List<Integer> temp = new LinkedList<>(origin);
        System.out.println("    remove Object 返回的是："+temp.remove(toBeRemovedIndex.get(0)));
        System.out.print("    现在的List：");
        for(int in:temp)   System.out.print(in+" ");
        System.out.println();
    }

    public static void removeIndex(List<Integer> origin){
        System.out.println("--调用removeIndex--");
        List<Integer> temp = new LinkedList<>(origin);
        System.out.println("    remove Index 返回的是："+temp.remove(2));
        System.out.print("    现在的List：");
        for(int in:temp)   System.out.print(in+" ");
        System.out.println();
    }
}

