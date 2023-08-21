public class QuickSort {

    public int[] sortArray(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public void merge(int[] nums, int start, int mid, int end) {
        // merge nums[start,mid] with nums[mid+1,end]
        int i = start;
        int j = mid + 1;
        int k = 0;
        int res[] = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                res[k++] = nums[i++];
            } else {
                res[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            res[k++] = nums[i++];
        }
        while (j <= end) {
            res[k++] = nums[j++];

        }
        for (int x = 0, y = start; x < res.length; x++, y++) {
            nums[y] = res[x];
        }

    }




    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = pivot(nums, start, end);
        quickSort(nums, start, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, end);
    }

    public int pivot(int[] nums, int start, int end) {
        int pivotVal = nums[end];
        int pivot = start;

        for (int i = start; i < end; i++) {
            if (nums[i] < pivotVal) {
                swap(nums, i, pivot);
                pivot += 1;
            }
        }
        swap(nums, end, pivot);
        return pivot;
    }


    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
