package CS61B.week2;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int i,IntList l){
        first = i;
        rest = l;
    }

    // get the size of IntList, using recursion
    public  int size(){
        if(rest == null){
            return 1;
        }
        return 1+this.rest.size();
    }

    public int interSize(){
        IntList p = this;
        int totalSize = 0;
        // we step forward by following the rest,every step we made present 1 element until we reach the null
        while(p!=null){
            totalSize++;
            p=p.rest;
        }
        return totalSize;
    }

    // get the ith element;
    public int get(int i){
        // when i == 0,it means we reach the element we want
        if(i == 0){
            return first;
        }
        // else we need to step forward to find the element
        return this.rest.get(i-1);
    }

    public static void main(String[] args) {
        IntList L = new IntList(15,null);
        L = new IntList(10,L);
        L = new IntList(5,L);

        System.out.println(L.size());
        System.out.println(L.interSize());
        System.out.println(L.get(2));
    }
}
