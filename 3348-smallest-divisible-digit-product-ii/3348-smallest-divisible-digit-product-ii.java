class Solution {

    // factor[d] tells us how many (2,3,5,7) factors digit d contributes
    // factor[d] = {count of 2, count of 3, count of 5, count of 7}
    int[][] factor = {
        {0, 0, 0, 0}, // 0
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };

    public String smallestNumber(String num, long t) {

        // need = required number of prime factors:
        // need[0] -> number of 2s
        // need[1] -> number of 3s
        // need[2] -> number of 5s
        // need[3] -> number of 7s
        int[] need = new int[4];

        // Factorize t using only 2,3,5,7
        int[] primes = {2, 3, 5, 7};

        for (int i = 0; i < 4; i++) {
            while (t % primes[i] == 0) {
                need[i]++;
                t /= primes[i];
            }
        }

        // If something is left, it contains a prime other than
        // 2,3,5,7. No digit can provide that prime.
        if (t != 1) {
            return "-1";
        }

        /*
         * Find the minimum number of digits required to produce
         * all factors of t.
         *
         * Example:
         * t = 256 = 2^8
         *
         * 8 = 3 + 3 + 2
         * so digits 8,8,4 can produce 2^8.
         */
        int[] requiredDigits = getRequiredDigits(need);

        int minDigits = countDigits(requiredDigits);

        // If we need more digits than num has,
        // the answer must have one more/more digits.
        if (minDigits > num.length()) {
            return buildNumber(requiredDigits, num.length() + 1);
        }

        /*
         * Calculate how many prime factors are provided by
         * the entire num.
         */
        int[] total = getFactors(num);

        // If num has no zero and already provides all required factors,
        // num itself is the answer.
        boolean zeroFree = true;

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                zeroFree = false;
                break;
            }
        }

        if (zeroFree && covers(total, need)) {
            return num;
        }

        /*
         * Now we need to construct a number > num.
         *
         * We go from RIGHT TO LEFT.
         *
         * Why?
         *
         * Example:
         *
         * 1234
         *
         * Changing the last digit is cheaper than changing
         * the second-last digit.
         *
         * So first try:
         * 1235, 1236, ...
         *
         * If impossible, go one position left:
         * 124...
         */
        int[] prefix = total.clone();

        // Find the first zero.
        // We cannot keep a zero because the answer must be zero-free.
        int firstZero = num.indexOf('0');

        if (firstZero == -1) {
            firstZero = num.length();
        }

        for (int i = num.length() - 1; i >= 0; i--) {

            int currentDigit = num.charAt(i) - '0';

            // Remove current digit from prefix.
            // After this, prefix contains factors from digits [0 ... i-1].
            subtract(prefix, factor[currentDigit]);

            /*
             * If i is AFTER the first zero, then keeping the prefix
             * would already contain that zero.
             *
             * Therefore we cannot construct an answer from this position.
             */
            if (i > firstZero) {
                continue;
            }

            /*
             * Try replacing num[i] with a larger digit.
             *
             * We try in increasing order because we want the
             * smallest possible answer.
             */
            for (int biggerDigit = currentDigit + 1;
                 biggerDigit <= 9;
                 biggerDigit++) {

                // Calculate factors already obtained from:
                // prefix + biggerDigit
                int[] remaining = need.clone();

                subtract(remaining, prefix);
                subtract(remaining, factor[biggerDigit]);

                /*
                 * Now remaining contains the factors that the
                 * suffix still needs to provide.
                 */

                int[] suffixDigits = getRequiredDigits(remaining);

                int requiredCount = countDigits(suffixDigits);

                // Number of positions available after i
                int positions = num.length() - i - 1;

                /*
                 * If we can fit all required digits in the suffix,
                 * then this choice works.
                 */
                if (requiredCount <= positions) {

                    StringBuilder ans = new StringBuilder();

                    // Keep everything before i unchanged.
                    ans.append(num.substring(0, i));

                    // Put our larger digit here.
                    ans.append(biggerDigit);

                    /*
                     * Fill unused positions with 1.
                     *
                     * 1 doesn't change the product.
                     * And 1 is the smallest zero-free digit.
                     */
                    for (int j = 0;
                         j < positions - requiredCount;
                         j++) {
                        ans.append('1');
                    }

                    // Add the required digits in increasing order.
                    ans.append(buildRequiredDigits(suffixDigits));

                    return ans.toString();
                }
            }
        }

        /*
         * If no same-length number works,
         * we need a number with one additional digit.
         *
         * Example:
         *
         * num = 9999
         *
         * Any answer must be at least 10000.
         *
         * Since zero is forbidden, we start with 1
         * and fill the rest with the smallest required digits.
         */
        return buildNumber(requiredDigits, num.length() + 1);
    }


    /*
     * Converts the required prime factors into actual digits.
     *
     * We want to use as FEW digits as possible.
     *
     * For example:
     *
     * 2^8
     *
     * Instead of:
     * 2 2 2 2 2 2 2 2
     *
     * use:
     * 8 8 4
     *
     * because:
     * 8 = 2^3
     * 8 = 2^3
     * 4 = 2^2
     */
    private int[] getRequiredDigits(int[] need) {

        int[] result = new int[10];

        int two = need[0];
        int three = need[1];

        // Use as many 8s as possible.
        result[8] = two / 3;
        two %= 3;

        // Use as many 9s as possible.
        result[9] = three / 2;
        three %= 2;

        // Remaining 2s can form 4.
        result[4] = two / 2;
        two %= 2;

        /*
         * If we have one 2 and one 3,
         * combine them into 6.
         */
        if (two == 1 && three == 1) {
            result[6]++;
            two = 0;
            three = 0;
        }

        /*
         * If one 3 and one 4 are left,
         *
         * 3 × 4 = 12
         *
         * We can represent them using 6 and 2.
         */
        if (three == 1 && result[4] > 0) {
            result[4]--;
            result[6]++;
            two++;
            three = 0;
        }

        result[2] += two;
        result[3] += three;

        // 5 and 7 cannot be combined with anything.
        result[5] = need[2];
        result[7] = need[3];

        return result;
    }


    /*
     * Calculate the total prime factors contributed by num.
     */
    private int[] getFactors(String num) {

        int[] count = new int[4];

        for (int i = 0; i < num.length(); i++) {

            int digit = num.charAt(i) - '0';

            for (int j = 0; j < 4; j++) {
                count[j] += factor[digit][j];
            }
        }

        return count;
    }


    /*
     * Check whether available factors contain
     * everything we need.
     */
    private boolean covers(int[] available, int[] need) {

        for (int i = 0; i < 4; i++) {
            if (available[i] < need[i]) {
                return false;
            }
        }

        return true;
    }


    /*
     * remaining[i] -= remove[i]
     *
     * But never let the value go below 0.
     *
     * We only care about how many factors are STILL missing.
     */
    private void subtract(int[] remaining, int[] remove) {

        for (int i = 0; i < 4; i++) {
            remaining[i] = Math.max(0, remaining[i] - remove[i]);
        }
    }


    /*
     * Count how many actual digits are required.
     */
    private int countDigits(int[] digits) {

        int count = 0;

        for (int i = 2; i <= 9; i++) {
            count += digits[i];
        }

        return count;
    }


    /*
     * Build the required digits in increasing order.
     *
     * Example:
     *
     * digits[2] = 1
     * digits[4] = 1
     * digits[8] = 2
     *
     * returns:
     *
     * "2488"
     */
    private String buildRequiredDigits(int[] digits) {

        StringBuilder sb = new StringBuilder();

        for (int digit = 2; digit <= 9; digit++) {

            for (int j = 0; j < digits[digit]; j++) {
                sb.append(digit);
            }
        }

        return sb.toString();
    }


    /*
     * Build the smallest number of the requested length
     * that contains all required factors.
     *
     * First put 1s because 1 is the smallest zero-free digit.
     */
    private String buildNumber(int[] requiredDigits, int length) {

        int required = countDigits(requiredDigits);

        StringBuilder sb = new StringBuilder();

        // Unused positions become 1.
        for (int i = 0; i < length - required; i++) {
            sb.append('1');
        }

        sb.append(buildRequiredDigits(requiredDigits));

        return sb.toString();
    }
}