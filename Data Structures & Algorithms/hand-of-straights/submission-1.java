class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0) return false;

        Map<Integer, Integer> count = new HashMap<>();
        for(int card : hand){
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);

        for(int i=0; i<hand.length; i++){
            if(count.get(hand[i])==0) continue;

            for(int next=hand[i]; next < hand[i] + groupSize; next++){
                if(count.getOrDefault(next, 0)==0) return false;
                count.put(next, count.get(next) - 1);
            }
        }

        return true;
    }
}
