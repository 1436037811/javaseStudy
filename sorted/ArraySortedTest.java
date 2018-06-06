    package study.javase.homework5;

    /**
     * 测试排序算法
     * @author Administrator
     * @version 1.0 2018-6-3
     */
    public class ArraySortedTest {
        public static void main(String[] args){
            ArraySorted test = new ArraySorted();

            //测试冒泡排序
            int[] num = {12,11,20,21,2,3,6,8,1,10};
            test.bubbleSort(num);
            System.out.println("冒泡排序后："+test.showArray(num));

            //测试选择排序
            int[] num1 = {12,11,20,21,2,3,6,8,1,10};
            test.selectSort(num1);
            System.out.println("选择排序后："+test.showArray(num1));

            //测试插入排序
            int[] num2 = {12,11,20,21,2,3,6,8,1,10};
            test.insertSort(num2);
            System.out.println("插入排序后："+test.showArray(num2));

            //测试堆排序
            int[] num3 = {12,11,20,21,2,3,6,8,1,10};
            test.heapSort(num3);
            System.out.println("堆排序后："+test.showArray(num3));

            //测试快速排序
            int[] num4 = {12,11,20,21,2,3,6,8,1,10};
            test.quickSort(num4,0,num4.length-1);
            System.out.println("快速排序后："+test.showArray(num4));

            //测试二分排序
            int[] num5 = {12,11,20,21,2,3,6,8,1,10};
            test.binarySort(num5);
            System.out.println("二分排序后："+test.showArray(num5));

        }
    }
