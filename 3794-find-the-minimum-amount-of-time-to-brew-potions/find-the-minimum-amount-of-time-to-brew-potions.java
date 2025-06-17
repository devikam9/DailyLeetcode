class Solution {
    public long minTime(int[] skill, int[] mana) {
        long[] done = new long[skill.length + 1];

        for(int j = 0; j < mana.length; j++){
            for(int i = 0; i < skill.length; i++){
                done[i+1] = Math.max(done[i],done[i+1]) + skill[i] * mana[j];
            }

            for(int i = skill.length-1; i >= 0; i--){
                done[i] = done[i+1] - (skill[i] * mana[j]);
            }
        }

       

        return done[skill.length];
        
    }
}