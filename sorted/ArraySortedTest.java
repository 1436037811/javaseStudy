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
            test.bubbleSorted(num);
            System.out.println("冒泡排序后："+test.showArray(num));

            int[] num1 = {12,11,20,21,2,3,6,8,1,10};
            test.selectSorted(num1);
            System.out.println("选择排序后："+test.showArray(num1));
        }
    }
