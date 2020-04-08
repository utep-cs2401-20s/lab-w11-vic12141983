public class newSorting {



    public void newSorting1(int[]A, int size){
        // Base case
        // check A length if is equal to size
        if(A.length<=size){
            // do quick sort
            //quickSort(A, ); Modify this one
            //recursive call
            newSorting1(A,size);
        }else{
            // Partition the Array
            int mid = A.length/2;
            // Store from 0 up to midpoint to leftHalf
            int [] leftHalf = new int[mid];
            // Remaining array store into Right half
            int [] Right = new int[A.length-mid];
            // Assign each element to corresponding to the partitioned array
            for(int i=0;i<A.length;i++){
                leftHalf[i]=A[i];

            }
            for( int i =0;i<A.length;i++){
                Right[i]=A[mid+1];
            }
            // Recursive call to complete the array as it is partioned
            newSorting1(leftHalf,size);// Sort left half
            newSorting1(Right,size);// sort right half
            mergeHalves(A,leftHalf,Right);
        }



    }
    public int helper(int[]A,int L, int R){
        L =A[0];
        R =A[A.length-1];
        int pivot = A[0];
        for( int i =L;i<R;i++){
            if(A[i]<=pivot){
                L++;
                int temp = pivot;
                pivot =A[i];
                A[i]=temp;
            }
        }
        int temp = pivot+1;
        pivot =A[L];
        A[L] = temp;
        return pivot;


    }
    public void mergeHalves(int[] a, int[]LeftHalf,int[]rightHalf){
        int leftStart =0;
        int rightStart =0;
        for( int i =0;leftStart<LeftHalf.length||rightStart<rightHalf.length;i++){
            if(leftStart==LeftHalf.length){
            leftStart++;
            }
            if(rightStart==rightHalf.length){
            rightStart++;
            }
            if(LeftHalf[leftStart]<rightHalf[rightStart]){

            }else if(LeftHalf[leftStart]==rightHalf[rightStart]){
                // Save into A
            }else{
                // work on this one still
                rightStart++;
            }

        }

        if(LeftHalf[0]<rightHalf[0]){
            LeftHalf[0]=a[0];
        }


    }

    private void quickSort(int [] A,int start, int end) {

    }
}
