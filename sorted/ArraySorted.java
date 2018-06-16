package study.javase.homework5;

/**
 * 排序算法工具类
 * @author Administrator
 * @version 1.0 2018-6-3
 */
class ArraySorted {
    /**
     * 无参构造方法
     */
    ArraySorted(){}

    /**
     * 交换数组中的两个数
     * @param data 指定数组
     * @param before 要交换的数在数组中的下标
     * @param after 要交换的数在数组中的下标
     */
    public void swap(int[] data, int before, int after) {
        if (before == after) {
            return;
        }
        int temp = 0;
        temp = data[before];
        data[before] = data[after];
        data[after] = temp;
    }

    /**
     * 显示数组
     * @param num 要进行显示的数组
     * @return 由数组元素拼接成的字符串
     */
    public String showArray(int[] num){
        String showStr = "";

        for(int i = 0;i<num.length;i++){
            showStr += Integer.toString(num[i])+" ";
        }

        return showStr;
    }

    /**
     * 冒泡排序算法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param num 进行排序的数组
     */
    public void bubbleSort(int[] num){
        int temp = 0;

        for(int i = 0;i<num.length;i++){
            for(int j = 0;j<num.length-i-1;j++){
                if(num[j]>num[j+1]){
                    temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param num 进行排序的数组
     */
    public void selectSort(int[] num){
        int temp = 0;
        for(int i=0;i<num.length-1;i++){
            int min = i;
            for(int j = i+1;j<num.length;j++){
                if(num[min] > num[j]){
                    temp = num[j];
                    num[j] = num[min];
                    num[min] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param num 进行排序的数组
     */
    public void insertSort(int[] num){
        int temp = 0;

        for(int i = 1;i<num.length;i++){
            temp = num[i];
            int j = i - 1;
            while(j>-1&&temp<num[j]){
                num[j+1] = num[j];
                j--;
            }
            num[j+1] = temp;
        }
    }

    /**
     * 创建最大堆
     * @param num 无序序列
     * @param lastIndex 无序序列的长度
     */
    public void createMaxdHeap(int[] num,int lastIndex){
        for(int i = (lastIndex-1)/2;i>=0;i--){
            int k = i;//保存当前正在判断的节点
            //若当前节点的子节点存在
            while(2*k + 1<=lastIndex){
                //先假设左节点为值最大
                int biggerIndex = 2*k+1;
                //若右子节点存在，则比较左右子节点的大小
                if(biggerIndex < lastIndex){
                    if(num[biggerIndex]<num[biggerIndex+1]){
                        biggerIndex++;
                    }
                }
                //若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
                if(num[k]<num[biggerIndex]){
                    swap(num,k,biggerIndex);
                    k = biggerIndex;
                }else{
                    break;
                }
            }
        }
    }

    /**
     * 堆排序
     * 时间复杂度：O(nlog2n)
     * 空间复杂度：O(1)
     * @param num 进行排序的数组
     */
    public void heapSort(int[] num){
        for(int i = 0;i<num.length;i++){
            createMaxdHeap(num,num.length-i-1);
            swap(num,0,num.length-1-i);
        }
    }

    /**
     * 将数组的某一段元素进行划分，小的在左边，大的在右边
     * @param num 进行划分的数组
     * @param start 起始位置
     * @param end 终止位置
     * @return key的位置
     */
    public int divide(int[] num,int start,int end){
        //每次都是以最右边的元素为key
        int base = num[end];
        //start一旦等于end，就说明左右两个指针合并到了同一位置，划分完毕
        while(start<end){
            //从左边开始遍历，如果不比key大就接着向右zou
            while(start<end&&num[start]<=base){
                start ++;
            }
            //大于key，和key进行交换
            if(start < end){
                int temp = num[start];
                num[start] = num[end];
                num[end] = temp;
                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位
                end--;
            }

            //从右边开始遍历，如果不比key小就接着向左走
            while(start<end&&num[end]>=base) {
                end--;
            }
            //上面的while循环结束时，就说明当前的a[end]的值比基准值小，应与基准值进行交换
            if (start < end) {
                //交换
                int temp = num[start];
                num[start] = num[end];
                num[end] = temp;
                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值左边)，因此左边也要同时向后移动一位
                start++;
            }

        }

        //这里返回start或者end皆可，此时的start和end都为基准值所在的位置
        return end;
    }

    /**
     * 快速排序
     * 时间复杂度：O(nlog2n)
     * 空间复杂度：O(nlog2n)
     * @param num 进行排序的数组
     * @param start 开始位置
     * @param end 结束位置
     */
    public void quickSort(int[] num,int start,int end) {
        if (start > end) {
            //如果只有一个元素，就不用再排下去了
            return;
        } else {
            //如果不止一个元素，继续划分两边递归排序下去
            int partition = divide(num, start, end);
            quickSort(num, start, partition - 1);
            quickSort(num, partition + 1, end);
        }
    }

    /**
     * 二分插入排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param num 进行排序的数组
     */
    public void binarySort(int[] num){
        for (int i = 1; i < num.length; i++) {
            int temp = num[i];
            int low = 0, high = i - 1;
            int mid = -1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (num[mid] > temp) {
                    high = mid - 1;
                } else { // 元素相同时，也插入在后面的位置
                    low = mid + 1;
                }
            }
            for(int j = i - 1; j >= low; j--) {
                num[j + 1] = num[j];
            }
            num[low] = temp;
        }
    }

    /**
     * 归并排序
     * 时间复杂度：O(nlog2n)
     * 空间复杂度：O(n)
     * @param num 进行排序的数组
     * @param left 指向数组的第一个元素
     * @param right 指向数组的最后一个元素
     */
    public void mergeSort(int[] num,int left,int right){
        //如果只有一个元，那就不用排序了
        if(left == right){
            return;
        }else{
            //取中间的数，进行拆分
            int mid = (left+right)/2;

            //左边的数不断进行拆分
            mergeSort(num,left,mid);

            //右边的数不断进行拆分
            mergeSort(num,mid +1,right);

            //合并
            merge(num,left,mid + 1,right);
        }
    }

    /**
     * 合并数组
     * @param num 进行合并的数组
     * @param left 指向数组的第一个元素
     * @param mid 指向数组分割的元素
     * @param right 指向数组最后的元素
     */
    public void merge(int[] num, int left, int mid, int right){
        int[] leftArray = new int[mid-left];//左边的数组
        int[] rightArray = new int[right - mid + 1];
        //两个数组填充数据
        for(int i = left;i<mid;i++){
            leftArray[i-left] = num[i];
        }
        for(int i = mid;i<=right;i++){
            rightArray[i - mid] = num[i];
        }

        int i = 0,j = 0;
        //数组的第一个元素
        int k = left;

        //比较这两个数组的值，哪个小，就数组上放
        while(i<leftArray.length&&j<rightArray.length){
            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            if (leftArray[i] < rightArray[j]) {
                num[k] = leftArray[i];
                i++;
                k++;
            } else {
                num[k] = rightArray[j];
                j++;
                k++;
            }
        }

        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArray.length) {
            num[k] = leftArray[i];
            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArray.length) {
            num[k] = rightArray[j];
            k++;
            j++;
        }

    }

}
