public class newSorting {
    // print method to debug
    public void print(int[] A) {
        for (int i : A) {
            System.out.print(i);
        }
    }

    public void newSorting(int[] A, int size) {
        int L = 0;
        int R = A.length - 1;


//        ***** Test 2 correction*****
//        not valid
//        if(size==0){
//         return
//         }


        // Base case
        // check A length if is less than equal to size of array
        if (A.length <= size) {
            quickSort(A, L, R);


        } else {
            // Partition the Array
            int mid = A.length / 2;
            // Store from 0 up to midpoint to leftHalf
            int[] leftHalf = new int[mid];
            // Remaining array store into Right half
            int[] Right = new int[A.length - mid];
            // Assign each element to corresponding to the partitioned array
            // ***Test 1 correction***
            // Originally was going to A.length kept getting null pointer exception
            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = A[i];
                print(A);
                System.out.println();

            }
            System.out.println();
            // Loop that assigns right half of partitioned array.
            for (int i = mid; i < A.length; i++) {
                Right[i - mid] = A[i];
                print(A);
            }
            // Recursive call to complete the array as it is portioned
            newSorting(leftHalf, size);// Sort left half
            newSorting(Right, size);// sort right half
            mergeHalves(A, leftHalf, Right);//Merge sorted halves
        }


    }


    private int partition(int[] A, int L, int R) {
        // Pivot is first index of the array
        int pivot = A[L];
        // Less is the left side array checks will be conducted
        // Since pivot is A[L] you do not check Pivot it is the element being compared to
        int less = L + 1;
        // The last element of the array
        int moreR = R;
        // As long as less is less than the length
        while (less < moreR) {
            // while integer L is less than length and element at the last index is greater than the pivot
            // decrement the last index of array
            while (L < moreR && A[moreR] >= pivot) {
                moreR--;
            }
            // While less is less than length and the element is less than pivot
            // increment less.

            while (less <= R && A[less] <= pivot) {
                less++;
            }
            // Elements swap when the conditions less and greater than the pivot stop

            if (less < moreR) {
                int temp = A[less];
                A[less] = A[moreR];
                A[moreR] = temp;
            }
        }
        // Swap elements that are left
        int temp1 = pivot;
        A[L] = A[moreR];
        A[moreR] = temp1;
        return moreR;


    }


    private void quickSort(int[] A, int start, int end) {

        // base case checking if the array is of size
        // return
        if (start == end - 1) {
            // if the last element of array is less than the start  swap elements.
            if (A[end] < A[start]) {
                int temp2 = A[end];
                A[end] = A[start];
                A[start] = temp2;
            }
            return;
        }
        // if start is less than the size or length
        if (start < end) {

            // partition the array using the partition method
            int part = partition(A, start, end);

            // Recursive call for quick sort
            quickSort(A, start, part - 1);
            quickSort(A, part + 1, end);
        }


    }

    private void mergeHalves(int[] A, int[] LeftHalf, int[] rightHalf) {
        // Assigning pointers
        int leftStart = 0;
        int rightStart = 0;
        int merging = 0;
        // Checking partitioned array, left and right half. Beginning at a start point for both arrays.
        while (leftStart < LeftHalf.length && rightStart < rightHalf.length) {
            // if the first index element  of the left half is greater than first index element of right half.
            // Store the left element first into the Array A
            if (LeftHalf[leftStart] < rightHalf[rightStart]) {
                A[merging] = LeftHalf[leftStart];
                // increment leftStart to next index.
                leftStart++;
            } else {
                // if the right index element is greater than left index element
                // store the right element into Array A
                A[merging] = rightHalf[rightStart];
                // increment rightStart to next index
                rightStart++;
            }
            //increment Array A
            merging++;
        }
        // Traverse the rest of left half
        // assigning the index of left to new array as long it does not meet prior conditions
        // at same time incrementing left half of partitioned array and merging which in a sense is a pointer
        // for array A
        while (leftStart < LeftHalf.length) {
            A[merging] = LeftHalf[leftStart];
            leftStart++;
            merging++;

        }
        //Traverse the rest of right half
        // incrementing right half and merging
        while (rightStart < rightHalf.length) {
            A[merging] = rightHalf[rightStart];
            rightStart++;
            merging++;

        }


    }
}
