class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> ans = new ArrayList<>();
        
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();
        //HashSet to avoid duplicay of mask, because letters could repeat
        
        //filling empty hashset to avoid nullpointer exception corresponding to every character from a to z;
        
        for(int i = 0; i < 26; i++){
            hm.put((char)('a' + i), new ArrayList<>());
        }
        
        
        for(String word : words){
            int wordmask = 0;
            
            for(char ch : word.toCharArray()){
                wordmask = wordmask | (1 << (ch - 'a'));
            }
            
            HashSet<Character> hs = new HashSet<>();
            
            for(char ch : word.toCharArray()){
                if(hs.contains(ch)) continue;
                
                hm.get(ch).add(wordmask);
                hs.add(ch);
            }
        }
        
        HashMap<String, Integer> phm = new HashMap<>();
        
        for(String puzzle : puzzles){
            if(phm.containsKey(puzzle)){
                ans.add(phm.get(puzzle));
                continue;
            }
            
            int puzzlemask = 0;
            
            for(char ch : puzzle.toCharArray()){
                puzzlemask = puzzlemask | (1 << (ch - 'a'));
            }
            
            int count = 0;
            
            //iterating over the mask of words having the first letter of puzzle
            for(int wordmask : hm.get(puzzle.charAt(0))){
                if(wordmask == (wordmask & puzzlemask)) count++;
            }
            
            ans.add(count);
            phm.put(puzzle, count);
        }
        
        return ans;
    }
}