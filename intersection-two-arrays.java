public class Solution {
    /*total runtime O(2m)*/
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] r = {};
        if(nums1.length==0||nums2.length==0) return r; /*best case: O(1)*/
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(nums1.length>nums2.length){
            return compare(nums2, nums1);
        }else{
            return compare(nums1, nums2);
        }
    }
     public int[] compare(int[] s, int[] l){
        HashSet<Integer> set = new HashSet<Integer>();
        for(Integer i: s){                     /*O(m) if n>=m*/
            if(Arrays.binarySearch(l,i)>=0){
                set.add(i);
            }
        }
        int[] r = new int[set.size()];
        int x=0;
        for(Integer i: set){  /*O(x) if n>=m>=x*/
        	r[x++]=i;
        }
        return r;
    }
}
