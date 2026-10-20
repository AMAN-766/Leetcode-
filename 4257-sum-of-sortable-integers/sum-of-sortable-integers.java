class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int sum = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean isValid = true;

            for (int i = 0; i < n; i += k) {

                // build strings for easy rotation check
                StringBuilder a = new StringBuilder();
                StringBuilder b = new StringBuilder();

                for (int j = 0; j < k; j++) {
                    a.append(nums[i + j]).append(",");
                    b.append(sorted[i + j]).append(",");
                }

                String block = a.toString();
                String sortedBlock = b.toString();

                // check rotation
                String doubled = sortedBlock + sortedBlock;

                if (!doubled.contains(block)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) sum += k;
        }

        return sum;
    }
}