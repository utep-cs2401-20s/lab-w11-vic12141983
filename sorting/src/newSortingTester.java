import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class newSortingTester {
    // Test Case 1:
    // Testing method with array with size 6.
    // Original size of array is 7.
    // Expectation: Expecting test to pass.
    // Result: test failed.
    // Correction modify the newSorting method.
    /*Reflection: After creating print methods to debug the issue was in the NewSorting
     *in the first loop of the code instead of traversing the left side to the length of Mid which the first half
     * The code was traversing to the end of length of array A. Resulting in a stackoverflow error.
     *
    */
    @Test
    void newSorting1() {
        newSorting test1 = new newSorting();
        int [] arr ={1,4,3,6,2,5,7};
        int [] expect ={1,2,3,4,5,6,7};
        test1.newSorting(arr,6);
        for(int i:arr){
            System.out.print(i);
        }
        assertArrayEquals(expect,arr);
    }
    // Test Case 2:
    // Testing with size zero
    // Pass array of size 7  to newSorting method and give the size of 0 to method.
    // Expectation fail. There is no condition to that checks if the array size is zero.
    // Result test met expectations Stack overflow error.
    // Correction possibly adding another base case to verify that if array is equal to null.

    @Test
    void newSorting2() {
        newSorting test2 = new newSorting();
        int [] arr ={1,4,3,6,2,5,7};
        int [] expect ={1,2,3,4,5,6,7};
        test2.newSorting(arr,0);
        for(int i:arr){
            System.out.print(i+ " ");
        }
        assertArrayEquals(expect,arr);
    }


    // Test Case 3:
    // Testing with an empty array
    // Expectation: Test will fail
    // Result: Test passed
    /*Reflection: Test passed because it did not matter size
      since the array was empty there was nothing to be compared.
      That is what I think so empty array will not cause test to fail.
     */

    @Test
    void newSorting3() {
        newSorting test3 = new newSorting();
        int [] arr ={};
        int [] expect ={};
        test3.newSorting(arr,3);
        for(int i:arr){
            System.out.print(i+ " ");
        }
        assertArrayEquals(expect,arr);
    }
    // Test Case 4:
    // Passing an array with multiple indices with the same value. and Testing with negative numbers.
    // Expectation: Tests will pass.
    // Result: Expectations were met.
    //
    @Test
    void newSorting4() {
        newSorting test4 = new newSorting();
        int [] arr ={1,4,2,2,2,5,7};
        int [] neg = {-1,-4,0,1};
        int [] negCorrect ={-4,-1,0,1};
        int [] expect ={1,2,2,2,4,5,7};
        test4.newSorting(arr,7);
        test4.newSorting(neg,4);

        for(int i:neg){
            System.out.print(i+ " ");
        }
        assertArrayEquals(expect,arr);
        assertArrayEquals(neg,negCorrect);
    }
    //Test case 5:
    //Testing with input of negative size and doubles
    //Expectation: fail, negative int value will not meet requirements of size of array.
    //Result: Test failed. The newSorting method requires and integers as parameters inputting doubles to
    // the array will not function.
    //Result: Expectation met for negative size. Correct this have user not input a size that is not negative, or have input
    //be absolute value of any input that is given.
    //Correction: modify newSorting in order to have parameter doubles.
    //Reflection: Two examples were tested and negative value will always given an stackoverflow error I think.
    
    @Test
    void newSorting5() {
        newSorting test5 = new newSorting();
       // double [] arr ={1.0,-1.0,0};
        //double [] expect ={-1.0,0,1.0};
        int [] arr ={1,-1,0};
        int [] expect ={-1,0,1};


        test5.newSorting(arr,-3);
        for(double i:arr){
            System.out.print(i+ ", "+" ");
        }
        assertArrayEquals(expect,arr);
    }

}