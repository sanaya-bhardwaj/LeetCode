//You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
//Implement the SmallestInfiniteSet class:
//SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
//int popSmallest() Removes and returns the smallest integer contained in the infinite set.
//void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.

class SmallestInfiniteSet {

    int arr[];
    int ind;

    public SmallestInfiniteSet() {
        arr = new int[1001];
        ind = 1;
    }
    
    public int popSmallest() {
        while(arr[ind] == 1) ind++;
        arr[ind] = 1;
        return ind;
    }
    
    public void addBack(int num) {
        if(num < ind) ind = num;
        arr[num] = 0;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
