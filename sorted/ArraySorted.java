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
         * 二分排序
         * @param num 进行排序的数组
         */
        public void binarySort(int[] num){

        }

    }
