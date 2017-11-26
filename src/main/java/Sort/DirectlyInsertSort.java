package Sort;

/**
 * 直接插入排序的时间复杂度为O(n2)。
 * @descripiton 直接插入排序（从后向前找到合适位置后插入）
 * @author daiwei
 * @date 2017/11/26.
 * @sees https://www.cnblogs.com/liuling/p/2013-7-24-01.html
 *
 */
public class DirectlyInsertSort {


    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //直接插入排序
        for (int i = 1; i < a.length; i++) {
            //待插入元素
            int temp = a[i];
            int j;
            for (j = i-1; j>=0; j--) {
                //将大于temp的往后移动一位
                if(a[j]>temp){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = temp;
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
