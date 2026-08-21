class Solution {

    public long findKthSmallest(int[] coins, int k) {

        // The answer cannot be greater than:
        // smallest coin * k
        long low = 1;
        long high = Long.MAX_VALUE;

        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        // Binary search for the smallest number x
        // such that there are at least k valid numbers <= x
        while (low < high) {

            long mid = low + (high - low) / 2;

            long count = countValid(mid, coins);

            if (count >= k) {
                // mid is big enough, so try a smaller answer
                high = mid;
            } else {
                // mid is too small, so move right
                low = mid + 1;
            }
        }

        return low;
    }

    // Returns how many numbers from 1 to x
    // are divisible by at least one coin.
    private long countValid(long x, int[] coins) {

        return generateSubsets(
            0,          // start from first coin
            1,          // LCM initially 1
            0,          // no coins selected initially
            x,
            coins
        );
    }

    // Generates every possible subset of coins using recursion.
    //
    // At every coin we have two choices:
    // 1. Don't select it
    // 2. Select it
    //
    // Inclusion-Exclusion:
    // odd number of selected coins  -> ADD
    // even number of selected coins -> SUBTRACT
    private long generateSubsets(
            int index,
            long currentLCM,
            int selected,
            long x,
            int[] coins) {

        // We have considered all coins.
        if (index == coins.length) {

            // Empty subset doesn't contribute anything.
            if (selected == 0) {
                return 0;
            }

            // Number of multiples of currentLCM <= x
            long count = x / currentLCM;

            // Inclusion-Exclusion
            if (selected % 2 == 1) {
                return count;
            } else {
                return -count;
            }
        }

        // OPTION 1:
        // Don't select the current coin.
        long withoutCurrent =
            generateSubsets(
                index + 1,
                currentLCM,
                selected,
                x,
                coins
            );

        // Calculate LCM if we select the current coin.
        long newLCM =
            lcm(currentLCM, coins[index]);

        // OPTION 2:
        // Select the current coin.
        long withCurrent = 0;

        // If LCM > x, then x / LCM = 0,
        // so this subset cannot contribute anything.
        if (newLCM <= x) {

            withCurrent =
                generateSubsets(
                    index + 1,
                    newLCM,
                    selected + 1,
                    x,
                    coins
                );
        }

        // Combine both choices.
        return withoutCurrent + withCurrent;
    }

    // Greatest Common Divisor
    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    // Least Common Multiple
    private long lcm(long a, long b) {

        return (a / gcd(a, b)) * b;
    }
}