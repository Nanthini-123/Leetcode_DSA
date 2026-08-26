class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> basket=new HashMap<>();
        int left=0;
        int maxfruit=0;

        for(int right=0;right<fruits.length;right++){
            int currentfruit=fruits[right];
            basket.put(currentfruit, basket.getOrDefault(currentfruit,0)+1);

            while(basket.size()>2){
                int leftfruit=fruits[left];
                basket.put(leftfruit, basket.get(leftfruit)-1);

                if(basket.get(leftfruit)==0){
                    basket.remove(leftfruit);
                }
                left++;
            }

            maxfruit=Math.max(maxfruit, right-left+1);

            
        }
        return maxfruit;
        
    }
}