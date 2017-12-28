package Generic.genricClass;

/**
 * 泛型类
 * <P>
 *     在编译期，是无法知道K和V具体是什么类型，只有在运行时才会真正根据类型来构造和分配内存。
 * </P>
 * @Author daiwei
 * @Date 2017/11/14
 * @sees https://segmentfault.com/a/1190000002646193
 */
public class Container<K,V> {

    private K key;
    private V value;


    public Container(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }


    public static void main(String[] args) {
        Container<String, String> c1 = new Container<String, String>("name", "findingsea");
        Container<String, Integer> c2 = new Container<String, Integer>("age", 24);
        Container<Double, Double> c3 = new Container<Double, Double>(1.1, 2.2);
        System.out.println(c1.getKey() + " : " + c1.getValue());
        System.out.println(c2.getKey() + " : " + c2.getValue());
        System.out.println(c3.getKey() + " : " + c3.getValue());
    }
}
