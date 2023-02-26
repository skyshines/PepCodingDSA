class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> text = new ArrayList<>();
        
        int i = 0;
        int j = i + 1;
        
        while(i < words.length){
            int wordsCharCount = words[i].length();
            int space = 1;
            
            while(j < words.length && wordsCharCount + space + words[j].length() <= maxWidth){
                wordsCharCount += words[j].length();
                j++;
                space++;
            }
            
            int wordsTottal = j - i;
            int noOfSpaces = j - i - 1;
            int vacantSpace = maxWidth - wordsCharCount;
            
            StringBuilder sb = new StringBuilder("");
            
            if(noOfSpaces > 0){
                int allSpace = vacantSpace / noOfSpaces;
                int extraSpace = vacantSpace % noOfSpaces;

                if(j == words.length){
                    extraSpace = 0;
                    allSpace = 1;
                }

                

                for(int k = i; k < j; k++){
                    sb.append(words[k]);

                    if(k == j - 1) break;

                    for(int sp = 1; sp <= allSpace; sp++) sb.append(" ");

                    if(extraSpace > 0){
                        sb.append(" ");
                        extraSpace--;
                    } 
                }                          
            
            }else{
                sb.append(words[i]);
            }
            
            while(sb.length() < maxWidth) sb.append(" ");
            
            text.add(sb.toString());
            
            i = j;
            j = i + 1;
        }
        
        return text;
    }
}