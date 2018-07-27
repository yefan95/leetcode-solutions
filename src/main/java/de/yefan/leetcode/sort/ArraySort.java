package de.yefan.leetcode.sort;

public class ArraySort {

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 冒泡排序
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] < nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 改进后的冒泡排序
     *
     * @param nums
     */
    public static void bubbleSort1(int[] nums) {

        //是否交换的标志
        boolean flag;
        //表示趟数，一共arr.length-1次。
        for (int i = 0; i < nums.length - 1; i++) {

            flag = false;
            for (int j = nums.length - 1; j > i; j--) {

                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 选择排序
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int minIndex, len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }

    }

    /**
     * 插入排序
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len - 1; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * 希尔排序
     * 时间复杂度O(nlogn^2)
     * 空间复杂度O(1)
     *
     * @param nums
     */
    public static void shellSort(int[] nums) {
        int length = nums.length;
        int incre = length;

        while (true) {
            incre = incre / 2;

            for (int k = 0; k < incre; k++) {
                for (int i = k + incre; i < length; i += incre) {
                    for (int j = i; j > k; j -= incre) {
                        if (nums[j] < nums[j - incre]) {
                            swap(nums, j, j - incre);
                        } else {
                            break;
                        }
                    }
                }
            }

            if (incre == 1) {
                break;
            }
        }

    }

    /**
     * 快速排序
     * 时间复杂度O(nlogn)
     * 空间复杂度O(logn)
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort(int[] arr, int left, int right) {
        //如果左索引大于右索引，直接返回
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        //左半边
        quickSort(arr, left, p - 1);
        //右半边
        quickSort(arr, p + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int base = arr[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (base > arr[i]) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, left, j);

        //返回一躺排序后基准值的下角标
        return j;
    }

    /**
     * 归并排序
     * 时间复杂度O(nlogn^2)
     * 空间复杂度O(1)
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        sort(arr, low, mid, high);
    }

    private static void sort(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        int[] temp = new int[high - low + 1];
        int k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[x + low] = temp[x];
        }
    }


    /**
     * 堆排序
     * 时间复杂度O(nlogn)
     * 空间复杂度O(1)
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        //构建最大堆
        buildMaxHeap(arr);

        for (int i = arr.length - 1; i >= 1; i--) {
            //交换堆顶和第0位置元素
            swap(arr, 0, i);
            //因为交换元素后，有可能违反堆的性质，所以沉降元素
            maxHeap(arr, i, 0);
        }

    }

    /**
     * 构建最大堆
     *
     * @param arr
     */
    private static void buildMaxHeap(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int half = arr.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }
    }

    private static void maxHeap(int[] arr, int heapSize, int index) {
        //左子树上的元素
        int left = index * 2 + 1;
        //右子树上的元素
        int right = index * 2 + 2;
        //初始化最大元素
        int largest = index;

        if (left < heapSize && arr[left] > arr[index]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        //判断根元素是否为最大元素
        if (index != largest) {
            swap(arr, index, largest);
            maxHeap(arr, heapSize, largest);
        }
    }


    /**
     * 基数排序(桶排序)
     * 时间复杂度O(n)
     * 空间复杂度O(m)
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int n = 1;
        int k = 0;
        int len = arr.length;
        int[][] bucket = new int[10][len];
        int[] order = new int[len];

        while (n < max) {
            for (int num : arr) {
                int digit = (num / n) % 10;
                bucket[digit][order[digit]] = num;
                order[digit]++;
            }
            for (int i = 0; i < len; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        arr[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
        }
    }

    /**
     * 计数排序
     * 时间复杂度O(n+m)
     * 空间复杂度O(n+m)
     *
     * @param arr
     */
    public static void countSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //找出数组中的最大最小值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int[] help = new int[max + 1];
        //找出每个数字出现的次数
        for (int i = 0; i < arr.length; i++) {
            int mapPos = arr[i] - min;
            help[mapPos]++;
        }

        int index = 0;
        //找出每个数字出现的次数
        for (int i = 0; i < help.length; i++) {
            while (help[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }

    public static int[] countSort2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大最小值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int[] help = new int[max - min + 1];

        //找出每个数字出现的次数
        for (int i = 0; i < arr.length; i++) {
            int mapPos = arr[i] - min;
            help[mapPos]++;
        }

        //计算每个数字应该在排序后数组中应该处于的位置
        for (int i = 1; i < help.length; i++) {
            help[i] = help[i - 1] + help[i];
        }

        //根据help数组进行排序
        int res[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int post = --help[arr[i] - min];
            res[post] = arr[i];
        }

        return res;
    }


    public static void main(String[] args) {
        int length = 30000;
        int max = 50000;
        int[] nums = NumberUtils.getRandomArs(length, max);
        long startTime = System.currentTimeMillis();
        bubbleSort(nums);
        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序用时：" + (endTime - startTime) + "毫秒");

        nums = NumberUtils.getRandomArs(length, max);
        startTime = System.currentTimeMillis();
        bubbleSort1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("改进后冒泡排序用时：" + (endTime - startTime) + "毫秒");

        nums = NumberUtils.getRandomArs(length, max);
        startTime = System.currentTimeMillis();
        selectSort(nums);
        endTime = System.currentTimeMillis();
        System.out.println("选择排序用时：" + (endTime - startTime) + "毫秒");

        nums = NumberUtils.getRandomArs(length, max);
        startTime = System.currentTimeMillis();
        insertSort(nums);
        endTime = System.currentTimeMillis();
        System.out.println("插入排序用时：" + (endTime - startTime) + "毫秒");

        nums = NumberUtils.getRandomArs(length, max);
        startTime = System.currentTimeMillis();
        shellSort(nums);
        endTime = System.currentTimeMillis();
        System.out.println("希尔排序用时：" + (endTime - startTime) + "毫秒");

        nums = NumberUtils.getRandomArs(length, max);
        startTime = System.currentTimeMillis();
        quickSort(nums, 0, nums.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("快速排序用时：" + (endTime - startTime) + "毫秒");

        nums = NumberUtils.getRandomArs(length, max);
        startTime = System.currentTimeMillis();
        mergeSort(nums, 0, nums.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("归并排序用时：" + (endTime - startTime) + "毫秒");

        nums = NumberUtils.getRandomArs(length, max);
        startTime = System.currentTimeMillis();
        radixSort(nums);
        endTime = System.currentTimeMillis();
        System.out.println("基数排序用时：" + (endTime - startTime) + "毫秒");

        nums = NumberUtils.getRandomArs(length, max);
        startTime = System.currentTimeMillis();
        heapSort(nums);
        endTime = System.currentTimeMillis();
        System.out.println("堆排序用时：" + (endTime - startTime) + "毫秒");

        nums = NumberUtils.getRandomArs(length, max);
        startTime = System.currentTimeMillis();
        countSort(nums);
        endTime = System.currentTimeMillis();
        System.out.println("计数排序用时：" + (endTime - startTime) + "毫秒");

    }

}
