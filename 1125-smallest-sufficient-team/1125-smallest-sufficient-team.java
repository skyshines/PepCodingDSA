class Solution {
    ArrayList<Integer> ans;
    
    public int helper2(int[] peoples, int cp,int skillmask,ArrayList<Integer> team, int uniskills,int count,int[][] dp){
        if(cp == peoples.length){
            if(skillmask == ((1 << uniskills) - 1)){
               if(ans.size() == 0 || ans.size() > team.size()){
                   ans = new ArrayList<>(team);
               }
            }
            return Integer.MAX_VALUE;
        }
        
        if(dp[count][skillmask] != 0){
            return dp[count][skillmask];
        }
        
        //cp becomes part of team
        team.add(cp);
        int take = helper2(peoples,cp + 1,skillmask | peoples[cp],team,uniskills,count + 1,dp);
        team.remove(team.size() - 1);
        
        //cp doesnt become part of team
        int nottake = helper2(peoples,cp + 1,skillmask, team,uniskills,count,dp);
        
        dp[count][skillmask] = (int)Math.min(take, nottake);
        
        return dp[count][skillmask];
    }
    
    public ArrayList<Integer> helper(String[] req_skills, List<List<String>> people_skills){
        ans = new ArrayList<>();
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < req_skills.length; i++){
            hm.put(req_skills[i], i);
        }
        
        int[] peoples = new int[people_skills.size()];
        int i = 0;
        
        for(List<String> skills : people_skills){
            int mask = 0;
            
            for(String skill : skills){
                mask = mask | (1 << hm.get(skill));
            }
            
            peoples[i] = mask;
            i++;
        }
        
        int n = req_skills.length;
        
        ArrayList<Integer> team = new ArrayList<>();
        
        
        helper2(peoples, 0, 0,team, n,0,new int[peoples.length + 1][(1 << req_skills.length)]);
        
        return ans;
    }
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        helper(req_skills,people);
        
        int[] arr = new int[ans.size()];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = ans.get(i);
        }
        
        return arr;
    }
}