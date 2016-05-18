public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        /*O(2n)*/
        HashMap<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        List<Integer> r = new ArrayList<>();
        Arrays.sort(nums);
        int c = 0;
        for(int i=0; i<nums.length; i++){                /*O(n)*/
            if(i==0){
                c++;
            }else if(i>=1 && nums[i]==nums[i-1]){
                c++;
            }else{
                updateMap(m, c, nums[i-1]);
                c=1;
            }
            if(i==nums.length-1){
                updateMap(m, c, nums[i]);
            }
        }
        List<Integer> keys = new ArrayList<>(m.keySet()); /*O(m) where m<n*/
        Collections.reverse(keys);
        Iterator<Integer> it = keys.iterator();
        while(k!=0 && it.hasNext()){
            int key = it.next();
            List<Integer> v = m.get(key);
            if(k>=v.size()){
                k-=v.size();
                r.addAll(v);
            }else{
                r.addAll(v.subList(0,k));
                k=0;
            }
        }
        return r;
    }
    public void updateMap(HashMap<Integer, List<Integer>> m, int c, int i){
        if(m.containsKey(c)){
            List<Integer> l = m.get(c);
		    l.add(i);
		    m.put(c,l);
        }else{
           List<Integer> l = new ArrayList<Integer>();
		   l.add(i);
		   m.put(c,l); 
        }
    }
}
