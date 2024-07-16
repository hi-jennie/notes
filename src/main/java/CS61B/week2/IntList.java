package CS61B.week2;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int i, IntList l) {
        first = i;
        rest = l;
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.size());
        System.out.println(L.interSize());
        System.out.println(L.get(2));
    }

    // 很难！！！注意多看看思路
    public IntList[] partition(IntList lst, int k) {
        IntList[] array = new IntList[k];
        int index = 0;
        IntList L = reverse(lst);
        while (L != null) {
            // 前两步用于记录进入循环是array[index] 和 L 的信息，因为第三步和第四步要对array[index]和L进行相关操作会，如果不记录原始值会导致信息丢失；
            IntList tempArray = array[index];
            IntList tempL = L;
            // 将当前array[index]指向L，目的是为了取得L的第一个值；
            array[index] = L;
            // 已经取到L第一个值后，通过array[index].rest 将其于L的rest解开索引并指向原来array[index]（刚刚将原始的array[index]存入了tempArray里）
            array[index].rest = tempArray;
            // 此次循环已经通过以上四个不走取出了L的第一个值，现在将L往后移一位已经循环。
            L = tempL.rest;
            // 确定下一个IntList因为放在array中index的位置
            index = (index + 1) % array.length;
        }

        return array;
    }

    // 假设翻转lst，我没写，有点难，（翻转指针方向）因为往前添加更简单一些
    public IntList reverse(IntList lst) {
        return lst;
    }

    // get the size of IntList, using recursion
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int interSize() {
        IntList p = this;
        int totalSize = 0;
        // we step forward by following the rest,every step we made present 1 element until we reach the null
        while (p != null) {
            totalSize++;
            p = p.rest;
        }
        return totalSize;
    }

    // get the ith element;
    public int get(int i) {
        // when i == 0,it means we reach the element we want
        if (i == 0) {
            return first;
        }
        // else we need to step forward to find the element
        return this.rest.get(i - 1);
    }
}
