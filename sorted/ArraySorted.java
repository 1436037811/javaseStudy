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
        public void bubbleSorted(int[] num){
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
        public void selectSorted(int[] num){
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

    }
