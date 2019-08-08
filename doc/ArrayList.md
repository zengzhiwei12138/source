## ArrayList @jdk1.8.0_144

### 问题集

带着问题看源码~   

关于List的相关问题有：

（1）ArrayList和LinkedList有什么区别？

（2）ArrayList是怎么扩容的？

（3）ArrayList插入、删除、查询元素的时间复杂度各是多少？

（4）怎么求两个集合的并集、交集、差集？

（5）ArrayList是怎么实现序列化和反序列化的？

（6）集合的方法toArray()有什么问题？

（7）什么是fail-fast？

（8）LinkedList是单链表还是双链表实现的？

（9）LinkedList除了作为List还有什么用处？

（10）LinkedList插入、删除、查询元素的时间复杂度各是多少？

（11）什么是随机访问？

（12）哪些集合支持随机访问？他们都有哪些共性？

（13）CopyOnWriteArrayList是怎么保证并发安全的？

（14）CopyOnWriteArrayList的实现采用了什么思想？

（15）CopyOnWriteArrayList是不是强一致性的？

（16）CopyOnWriteArrayList适用于什么样的场景？

（17）CopyOnWriteArrayList插入、删除、查询元素的时间复杂度各是多少？

（18）CopyOnWriteArrayList为什么没有size属性？

（19）比较古老的集合Vector和Stack有什么缺陷？

### 源码分析

关于源码的说明都写在 Java文件的注释上了 这里不一一说明

[ArrayList源码]()

（1）DEFAULT_CAPACITY

默认容量为10，也就是通过new ArrayList()创建时的默认容量。

（2）EMPTY_ELEMENTDATA

空的数组，这种是通过new ArrayList(0)创建时用的是这个空数组。

（3）DEFAULTCAPACITY_EMPTY_ELEMENTDATA

也是空数组，这种是通过new ArrayList()创建时用的是这个空数组，与EMPTY_ELEMENTDATA的区别是在添加第一个元素时使用这个空数组的会初始化为DEFAULT_CAPACITY（10）个元素。

（4）elementData

真正存放元素的地方，使用transient是为了不序列化这个字段。

至于没有使用private修饰，后面注释是写的“为了简化嵌套类的访问”，但是楼主实测加了private嵌套类一样可以访问。

*private表示是类私有的属性，只要是在这个类内部都可以访问，嵌套类或者内部类也是在类的内部，所以也可以访问类的私有成员。*

（5）size

真正存储元素的个数，而不是elementData数组的长度。