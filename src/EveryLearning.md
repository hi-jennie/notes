## 7.25

* system:exit(),currentTimeMillis(),arrayCopy()
* Runtime: getRuntime(),availableProcessor(),maxMemory(),exec()——shutdown
* Object:toString(),equals(),clone-**shadow clone**-only copy the address
    * implement cloneable
    * override clone()
    * **deep clone:** for reference type:create a new memory and copy the item to the new address
    * **学会使用Gson library????**
* Objects:**equals(Object a,Object b)**_ 进行非空判断；isNull(),nonNull();
* BigInteger :无法改变
    * **BigInteger(String val)**
    * **BigInteger.valueOf**(**long** val) -16~16池子
    * BigInteger(int, Random)-获取随机大整数
    * BigInteger("100",2):2进制的100
    * .add() +
    * .subtract()
    * multiply()
    * divide()
    * divideAndRemainder() -返回商和余数
    * pow(int exponent)
    * intValue(BigInteger),longValue(),floatValue(),doubleValue()
    * max min(BigInteger)
    * equals(BigInteger val)
* **BigDecimal**:表示较大小数和小数计算失真的问题
  **BigDecimal(String val)**
    * **BigDecimal.valueOf(double val)**）0-10之间的数值池子
        * BigDecimal(double val) ——不精确不推荐
        * BigDecimal(int val)
        * add()
        * subtract()
        * multiply()
        * **divide()**
        * divideAndRemainder()
        * pow(int exponent)
        * intValue(),longValue(),floatValue(),doubleValue()
        * max(),min()
        * equals()
        * compareTo()
        * scale() -小数位数
        * setScale(int newScale) -设置小数位数
        * stripTrailingZeros() -去掉末尾的0
        * abs() -绝对值
        * negate() -取反
        * movePointLeft(int n) -左移n位
        * movePointRight(int n) -右移n位
        * round(new MathContext(2,RoundingMode.HALF_UP)) -四舍五入
        * **RoundingMode.HALF_UP** .UP .DOWN .CEILING .FLOOR .HALF_DOWN .HALF_EVEN

**p163-p173没看**

## 7.26

* **wrap class**:List<**Integer**,Long,Short,Byte,**Character**,Float,Double,Boolean>
    * autoboxing and unboxing
    * **Integer i = 10; -auto boxing**
    * new Integer(10) -deprecated
    * Integer.valueOf(10)  数据池子-128~127
    * **Integer.parseInt("10")**_将**字符串**转换为int,除了Character类，其他都有这个方法
    * String Integer.toBinaryString(10) -转换为二进制
    * “1”-“0”：int 1
* localDate:
    * .of(2019,7,26)
    * .now()
* Calendar:
    * Calendar.getInstance()
* Search:
    * **basic search:**
    * **binarySearch**:min/max/ mid=（max+min)/2
    * **Interpolation search差值查找-**：**Data distribution is uniform.**-等比例缩放
        * mid = min + ((key-arr[min])/(arr[max]-arr[min]))*(max-min)
    * **blockSearch** :regular and irregular(块之间没有交集)-可查找与添加
    * **Fibonacci search**
    * hashSearch:hashMap
    * treeSearch:binaryTree
* class AlienAlphabet:
* class IteratorOfIterators:
* 04 slides:
* Hacker-JavaIterator
* StringBuilder :**insert**(index,value);append()

## 7.27

* **bubbleSort**:arr.length-1
* **selectionSort**:
* **insertionSort**:
* recursionSum/factorialRecursion：**p180递归算法**
* **quickSort**:很快
* **Arrays**: some useful tools
    * toString(arr)
    * binarySearch(arr,value)：arr有序且升序如果存在返回索引，不存在返回-插入点-1
    * copyOf(old arr,**new arr length**)/copeOfRang()-前闭后开
    * fill(arr,item)
    * sort(arr)——默认升序
    * **!!!!sort(arr,comparator)**——Dog.comparator

* lambda_**JavaLambda**:对象不重要，interface方法更重要——简化接口匿名内部类的书写
    * 只能简化函数式接口的的匿名内部类的书写
    * 函数式接口：有且仅有一个抽象方法的接口：**comparable/iterable**

## 7.28

* 五道经典算法题：
    * FriendTest.java：里面对temp的处理
    * Fibonacci.java:
    * Peach.java:
    * **!!!ClimbStairs.java**:
* 集合：* collection（单列集合-interface）：List/Set
* List:添加的元素有序(存取有序）、可重复、有索引
    * Set:添加的元素无序、不重复、无索引
    * Collection<String> coll = new ArrayList();
    * coll.add():if add item to a List,return true; if add item to a Set(if the item already exist),return false
    * coll.remove(item,not index):if remove successfully,return true
    * **coll.contains()**:if the item exist,return true
        * 细节：contains()调用的是equals()方法,如果是自定义类，**需要重写equals()方法**——理一下思路(
          比如同一个学生姓名年龄相同就认为一直，就算作contains)
    * coll.isEmpty():if the collection is empty,return true
    * coll.size():return the size of the collection
    * coll.clear():clear the collection
* 迭代器遍历：**Iterator**
    * noSuchElementException:Calling `next()` when there are no elements.
    * After the iterator has finished traversing, the pointer does not reset: a new iterator needs to be obtained for
      another traversal.
    * When iterating, you **cannot** use collection methods to **add or remove elements**:
      ConcurrentModificationException(*
      *iterator.remove() is allowed)**
        * Iterator<String> it = list.iterator();
        * next():Remove the current element and move the iterator to the next position.
    * enhanced for loop:for-each loop:所有的单列结合和数组都可以使用增强for循环

## 7.29

* List：ListDemo.java
    * void add(index,element):原来索引元素向后挪
    * remove(index)：返回被删除的元素
    * set(index,element):modify a specific element
    * get(index)
    * **how to iterate**:five ways
        * **iterator:.remove()**
        * **ListIterator**:lsIt.add()/lsIt.remove()
        * enhanced for
        * Lambda expression
        * ordinary for:操作索引
* stack(LIFO)/queue(FiFO)
* **List：ArrayList/LinkedList(single\double)/vector**
    * ArrayList:when we add the first element, we create an array at size 10; resize at 1.5 times,addAll()
    * LinkedList:addFirst()/addLast()/removeFirst()/removeLast()
    * expectModCount/modCount;
* **generics**:
    * 不写type都以Object的方式存储，但会导致无法访问子类的特有功能（把runtime期间存在的问题提前到compile
      time，避免了强制类型转换可能出现的异常）
    * no primitive type(<int,double,boolean,char>)
    * 指定具泛型的具体类型之后，传递数据时可以传递该类类型或其子类类型
    * 如果不写泛型的具体类型，默认位Object类型
    * add2() method:
    * 泛型接口：
        * 实现类给出具体类型:class MyArrayList implements MyList<String>
        * 实例化时给出具体类型:class MyArrayList<T> implements MyList<T>
    * generics.java

##

* binary search tree:how to iterate
    * preOrder:root-left-right
    * **inOrder:left-root-right**:from small to large
    * postOrder:left-right-root
    * levelOrder:root-left-right
* balanced tree:AVL tree——
    * when the height of left and right subtree differ by more than 1, we need to rotate the tree to balance it
    * 左旋和右旋保持平衡 四种不平衡的情况下如何保持平衡——downside：添加节点的时间浪费
* **Red-Black Tree**：a special binary search tree（not necessarily balanced)
    * 每一个节点必须位red or black，the root node必须是black
    * 如果一个节点没有子节点或者父节点，则盖节点的指针属性为nil，视为叶节点，每个叶节点是black
    * 如果一个节点是红色的，那么它的子节点必须是黑色的（不能出现两个红色节点相连的情况）；
    * 对每一个节点，从改节点到其所有后代叶节点（nil节点）的节点路径上，均包含相同数目的黑色节点
    * **添加节点时：默认红色效率更高**

##                                                                                                                       

* **Set**:**Interface** SetDemo.java
* **HashSet**:**no order**，**no duplicate**，**no index**
* **LinkedHashSet**:**order**，**no duplicate**，**no index**
* **TreeSet**:**sorted**，**no duplicate**，**no index**
    * add(E): add an element to the set,if the element already exists,return false
    * remove(E): remove an element from the set
    * contains(Object): check if the set contains an element
    * size(): return the number of elements in the set
    * isEmpty(): check if the set is empty
    * clear(): clear the set

* hash value:
    * 根据hashCode计算出来的int类型的整数（对象的整数表现形式——通识符）
    * Object类：默认使用地址值进行计算
    * 一般根据对象内部的属性重写hashCode()方法，重新计算hash value
    * 如果没有重写hashCode方法，不同对象计算的hash value不同
    * 如果重写了hashCode方法，相同对象计算的hash value相同
    * hash conflict:不同对象计算的hash value相同
* **hashSet：**
    * 创建一个默认长度16的数组，加载因子0.75，当数组长度超过12时，扩容为原来的2倍
    * 根据元素的hashCode值计算出在数组中的位置，如果该位置没有元素null，则直接添加，如果有元素，则调用equals方法进行比较
    * 如果equals方法返回true，则认为是重复元素，不添加；如果equals方法返回false，则认为不是重复元素，添加到数组中
    * 一样：不存；不一样：存入数组，形成链表
    * JDK8前：新元素存入数组，老元素挂在后面
    * JDK8之后：新元素挂在老元素下面，当链表长度超过8时且数组长度大于等于64时，链表转为红黑树
    * **如果集合中存储的是自定义对象，必须重写hashCode和equals方法**
    * **no order**
* **linkedHashSet**:**order**——存取顺序一致
* **treeSet** :sorted——底层是红黑树
  如果自定义类，需要实现comparable接口充血compareTo方法或者传入comparator
    * 方式1:(默认)compareTo方法 return 负数，表示当前元素小，存入左边，正数表示当前元素大存右边；return 0 表示当前元素存在，舍弃
    * 方式2:使用comparator比较器，实现compare方法.当compareTo方法不满足需求时（已经存在不好修改），可以使用comparator比较器
    * 方式2和方式1都存在时，优先使用方式2

## 8.1

* map：V getOrDefault(Object key, V defaultValue)
* week6:FindDuplicate.java

## 8.2

* git 各项操作
* map(双列集合)——JavaMap.java and MapPractice.java
    * **put (key,value)**:return the previous value of the key
    * remove(key):return the value of the key
    * get(key):return the value of the key
    * containsKey(key):check if the map contains the key
    * containsValue(value):check if the map contains the value
    * size():return the number of key-value pairs
    * isEmpty():check if the map is empty
    * clear():clear the map
    * .keySet()
    * .entrySet()
    * lambda expression to iterate the map
* hashMap:no order/no duplicate/no index;都是指key
    * 都是hash table的结构（如果key 一样，就会覆盖）
    * 依赖hashCode方法和equals方法来保证键的唯一
    * 如果key是自定义类，必须重写hashCode和equals方法，value不需要
* LinkedHashMap:**order**(存取元素的顺序一致)——有双链表记录前一个和后一个node的地址值

## 8.3

* B-Tree：
* treeMap：**order**/no index /no duplicate(底层和treeSet一样——都是红黑树结构)
    * **实现comparable接口，指定比较规则**
    * **传递Comparator对象，指定比较规则**(都用于比较优先级然后去重)
        * // 如果返回值是0，表示两个对象是相等的，TreeMap会认为是同一个对象，不会插入
          // 如果返回值是正数，表明o1比o2大，o1会存在红黑树右边
          // 如果返回值是负数，表明o1比o2小，o1会存在红黑树左边
    * 不需要重写hashCode和equals方法

## 8.4

* relationship between B-tree and RB-tree
* hash table:conception
* floorMod:

## 8.6

* 判断是否为有效BST

```java
public class IsBST {

    public static boolean isBST(BST T) {
        return isBSTHelper(T, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBSTHelper(BST T, int min, int max) {
        if (T == null) {
            return true;
        } else if (T.key <= min || T.key >= max) {
            return false;
        } else {
            return isBSTHelper(T.left, min, T.key)
                    && isBSTHelper(T.right, T.key, max);
        }
    }

}
```

## 8.9

* 创建不可变集合：和python的tuple类似
    * ImmutableList.java
    * List.of
    * Set.of
    * Map.of
    * Map.ofEntries

## 8.11

* Collections.addAll()
* Arrays.toString(arr)
* hacker:**LambdaExpression.java**(有一些细节有点重要记得回去看)
* stream 流:**JavaStream.java**
    * stream上的集合不会影响原来的集合
    * combine with lambda expression
    * utilise API like filter, map, reduce, collect to get my ideal result
    * four methods to get my stream
    * but Stream.of()方法的形参是一个可变参数，可以传递一堆零散的数据，也可以传递数组，但是数组必须是reference type
        * 如果是基本数据类型，就会把整个数组当作一个元素放入Stream中
    * **filter**:
    * **limit**/**skip**
    * **distinct**
    * **concat**:合并两个流之后再做相应的处理，如果两个集合里面是两个不同的自定义类，则会提升为共同的父类并且无法使用子类特有功能
    * **map**:将一个元素转换为另一个元素

    * **forEach**:遍历流中的每一个元素

## 8.12

* stream:JavaStreamCollect.java
    * collect(Collectors.toList)
    * collect(Collectors.toSet)
    * collect(Collectors.toMap)


* 方法引用： MethodReference.java
    * className::staticMethod
    * object::instanceMethod
        * this::method
        * super::method
    * constructor reference:ConstructorReference.java
        * className::new
    * 特殊例子：类名::成员方法

## 8.14

* Exception:**JavaException.java**
    * RuntimeException:unchecked exception
    * CompileTimeException:checked exception

* 异常处理方式：
    * JVM处理：将异常信息打印到控制台，并且终止程序
    * 自己处理：try-catch-finally——当代码块中出现异常时，会立即跳转到catch块中执行，然后继续执行finally块，不会中止虚拟机和程序运行
    * throws:抛出异常，交给调用者处理
    * 自定义异常
        * 类名要反映信息
        * 要继承对于的异常类
        * 空参/带参构造器














