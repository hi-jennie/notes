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
    








