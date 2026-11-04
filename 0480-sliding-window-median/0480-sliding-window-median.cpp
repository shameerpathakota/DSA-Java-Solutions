
class Solution {
public:
    vector<double> medianSlidingWindow(vector<int>& nums, int k) {

        int n = nums.size();
        vector<double> res;

        // Left: smaller half (max at end)
        // Right: larger half (min at beginning)
        multiset<int> left, right;

        int i = 0, j = 0;

        while (j < n) {

            // 1. Insert element
            if (left.size() <= right.size()) {
                left.insert(nums[j]);
            }
            else {
                right.insert(nums[j]);
            }

            // 2. Balance ordering
            while (!left.empty() && !right.empty()) {

                auto left_max = prev(left.end());
                auto right_min = right.begin();

                if (*left_max > *right_min) {

                    int a = *left_max;
                    int b = *right_min;

                    left.erase(left_max);
                    right.erase(right_min);

                    left.insert(b);
                    right.insert(a);
                }
                else {
                    break;
                }
            }

            // 3. Process complete window
            if (j - i + 1 == k) {

                // Calculate median
                if (left.size() > right.size()) {
                    res.push_back(*prev(left.end()));
                }
                else {
                    double mid1 = *prev(left.end());
                    double mid2 = *right.begin();

                    res.push_back((mid1 + mid2) / 2.0);
                }

                // 4. Remove outgoing element
                int val = nums[i];

                auto it = left.find(val);

                if (it != left.end()) {
                    left.erase(it);
                }
                else {
                    it = right.find(val);
                    right.erase(it);
                }

                i++;
            }

            j++;
        }

        return res;
    }
};
