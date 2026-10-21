class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordset=new HashSet<>(wordList);

        if(!wordset.contains(endWord)){
            return 0;
        }

        Queue<String>queue=new LinkedList<>();
        queue.offer(beginWord);

        int changes=1;
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
            String currentword=queue.poll();

            if(currentword.equals(endWord)){
                return changes;
            }

            char[] wordchar=currentword.toCharArray();
            for(int j=0;j<wordchar.length;j++){
                char originalchar=wordchar[j];

                for(char c='a';c<='z';c++){
                    if(c==originalchar){
                        continue;
                    }

                    wordchar[j]=c;
                    String nextword=String.valueOf(wordchar);

                    if(wordset.contains(nextword)){
                        queue.offer(nextword);
                        wordset.remove(nextword);
                    }
                }

                wordchar[j]=originalchar;
            }
            }
            changes++;

        }
        return 0;
        
        
    }
}