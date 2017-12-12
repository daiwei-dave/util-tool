ArrayList集合：


@see https://www.cnblogs.com/xrq730/p/4989451.html(图解集合1：ArrayList)


1.扩容
构造ArrayList的时候，默认的底层数组大小是10，

扩容算法：

public void ensureCapacity(int minCapacity) {
modCount++;
int oldCapacity = elementData.length;
if (minCapacity > oldCapacity) {
    Object oldData[] = elementData;
    int newCapacity = (oldCapacity * 3)/2 + 1;
        if (newCapacity < minCapacity)
    newCapacity = minCapacity;
           // minCapacity is usually close to size, so this is a win:
           elementData = Arrays.copyOf(elementData, newCapacity);
}
}

看到扩容的时候把元素组大小先乘以3，再除以2，最后加1。

2.删除元素

其实做的事情就是两件:

1、把指定元素后面位置的所有元素，利用System.arraycopy方法整体向前移动一个位置

2、最后一个位置的元素指定为null，这样让gc可以去回收它



3.插入元素

看到插入的时候，按照指定位置，把从指定位置开始的所有元素利用System.arraycopy方法做一个整体的复制，向后移动一个位置（当然先要用ensureCapacity方法进行判断，加了一个元素之后数组会不会不够大），然后指定位置的元素设置为需要插入的元素，完成了一次插入的操作。用图表示这个过程是这样的：


4.ArrayList的优缺点

从上面的几个过程总结一下ArrayList的优缺点。ArrayList的优点如下：

1、ArrayList底层以数组实现，是一种随机访问模式，再加上它实现了RandomAccess接口，因此查找也就是get的时候非常快

2、ArrayList在顺序添加一个元素的时候非常方便，只是往数组里面添加了一个元素而已

不过ArrayList的缺点也十分明显：

1、删除元素的时候，涉及到一次元素复制，如果要复制的元素很多，那么就会比较耗费性能

2、插入元素的时候，涉及到一次元素复制，如果要复制的元素很多，那么就会比较耗费性能

因此，ArrayList比较适合顺序添加、随机访问的场景。

5.ArrayList和Vector的区别

ArrayList是线程非安全的，这很明显，因为ArrayList中所有的方法都不是同步的，在并发下一定会出现线程安全问题。那么我们想要使用ArrayList并且让它线程安全怎么办？一个方法是用Collections.synchronizedList方法把你的ArrayList变成一个线程安全的List，比如：


List<String> synchronizedList = Collections.synchronizedList(list);
synchronizedList.add("aaa");
synchronizedList.add("bbb");
for (int i = 0; i < synchronizedList.size(); i++)
{
    System.out.println(synchronizedList.get(i));
}

另一个方法就是Vector，它是ArrayList的线程安全版本，其实现90%和ArrayList都完全一样，区别在于：

1、Vector是线程安全的，ArrayList是线程非安全的

2、Vector可以指定增长因子，如果该增长因子指定了，那么扩容的时候会每次新的数组大小会在原数组的大小基础上加上增长因子；如果不指定增长因子，那么就给原数组大小*2，源代码是这样的：

int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                 capacityIncrement : oldCapacity);
