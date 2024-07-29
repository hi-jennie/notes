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
* 集合：
    * collection（单列集合-interface）：List/Set
    * List:添加的元素有序(存取有序）、可重复、有索引[]
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
   