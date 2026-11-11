class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = (long) need1 * cost1 + (long) need2 * cost2;
        long c2 = (long) Math.max(need1, need2) * costBoth;
        long c3;
        if (need1 > need2) {
            c3 = (long) need2 * costBoth + (long) (need1 - need2) * cost1;
        } else {
            c3 = (long) need1 * costBoth + (long) (need2 - need1) * cost2;
        }
        return Math.min(c1, Math.min(c2, c3));
    }
}