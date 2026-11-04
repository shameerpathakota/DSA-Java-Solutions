
class Solution {
public:

    // PART 1: Find the minimum cost of every size-x window
    vector<long long> medianSlidingWindow(vector<int>& nums, int k) {

        int n = nums.size();
        vector<long long> res;

        multiset<int> left, right;

        long long sumLeft = 0;
        long long sumRight = 0;

        int i = 0, j = 0;

        while (j < n) {

            // 1. Insert current element
            if (left.size() <= right.size()) {
                left.insert(nums[j]);
                sumLeft += nums[j];
            }
            else {
                right.insert(nums[j]);
                sumRight += nums[j];
            }

            // 2. Maintain ordering between left and right
            while (!left.empty() && !right.empty()) {

                auto left_max = prev(left.end());
                auto right_min = right.begin();

                if (*left_max > *right_min) {

                    int a = *left_max;
                    int b = *right_min;

                    left.erase(left_max);
                    right.erase(right_min);

                    sumLeft -= a;
                    sumRight -= b;

                    left.insert(b);
                    right.insert(a);

                    sumLeft += b;
                    sumRight += a;
                }
                else {
                    break;
                }
            }

            // 3. Process complete window
            if (j - i + 1 == k) {

                long long median = *prev(left.end());

                long long cost =
                    median * left.size() - sumLeft
                    + sumRight - median * right.size();

                res.push_back(cost);

                // 4. Remove outgoing element
                int val = nums[i];

                auto it = left.find(val);

                if (it != left.end()) {
                    sumLeft -= val;
                    left.erase(it);
                }
                else {
                    it = right.find(val);
                    sumRight -= val;
                    right.erase(it);
                }

                i++;
            }

            j++;
        }

        return res;
    }


    // PART 2: Select exactly k non-overlapping windows
    long long minOperations(vector<int>& nums, int x, int k) {

        int n = nums.size();

        // Get the cost of every size-x window
        vector<long long> operations =
            medianSlidingWindow(nums, x);

        int m = operations.size();

        const long long INF = 1e18;

        // DP initialization
        vector<vector<long long>> dp(
            n + 1, vector<long long>(k + 1, INF)
        );

        dp[0][0] = 0;

        // DP transitions
        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= k; j++) {

                if (dp[i][j] == INF) continue;

                // Choice 1: Skip current position
                dp[i+1][j] = min(
                    dp[i+1][j],
                    dp[i][j]
                );

                // Choice 2: Select current window
                if (j < k && i < m) {

                    dp[i+x][j+1] = min(
                        dp[i+x][j+1],
                        dp[i][j] + operations[i]
                    );
                }
            }
        }

        return dp[n][k];
    }
};

/*
APPROACH: Sliding Window + Two Multisets + DP

STEP 1: Calculate the cost of every size-x subarray
---------------------------------------------------
1. Use a sliding window of size x.
2. Maintain two multisets:
   - left  -> smaller half of elements
   - right -> larger half of elements
3. Keep left.size() >= right.size() and the size
   difference at most 1.
4. The median is the largest element in left.

STEP 2: Calculate the cost of making a window equal
---------------------------------------------------
1. The median gives the minimum cost of making all
   elements in the window equal.
2. Maintain:
   - sumLeft  -> sum of elements in left
   - sumRight -> sum of elements in right
3. Calculate the cost in O(1):

   cost = median * left.size() - sumLeft
        + sumRight - median * right.size()

4. Store each window's cost in the operations array.
5. Slide the window by removing the outgoing element
   and inserting the next element.

STEP 3: DP to select exactly k non-overlapping windows
-------------------------------------------------------
DP STATE:
dp[i][j] = Minimum cost to select exactly j
           non-overlapping windows from the first i
           positions of the original array.

INITIALIZATION:
dp[0][0] = 0
All other states = INF.

TWO CHOICES AT EACH POSITION i:

1. SKIP the current position:
   dp[i+1][j] = min(dp[i+1][j], dp[i][j])

2. SELECT the window starting at i:
   dp[i+x][j+1] = min(
       dp[i+x][j+1],
       dp[i][j] + operations[i]
   )

   Jump i+x to ensure selected windows do not overlap.

FINAL ANSWER:
dp[n][k]

COMPLEXITY:
Time  : O(n * log(x) + n * k)
Space : O(x + n * k)

KEY IDEA:
First calculate the minimum conversion cost of every
size-x window using its median. Then use DP to select
exactly k non-overlapping windows with minimum total cost.
*/

