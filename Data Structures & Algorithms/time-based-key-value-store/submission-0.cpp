class TimeMap {
public:
    unordered_map<string, vector<pair<int, string>>> keyValueStore;

    TimeMap() {
        
    }
    
    void set(string key, string value, int timestamp) {
        keyValueStore[key].push_back ({timestamp, value});
    }
    
    string get(string key, int timestamp) {
        vector<pair<int, string>> valueList = keyValueStore[key];

        int low = 0;
        int high = valueList.size() - 1;

        string value = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;
            auto midVal = valueList[mid];

            if (midVal.first <= timestamp) {
                value = midVal.second;
                low = mid + 1;
            } else if (midVal.first > timestamp) {
                high = mid - 1;
            }
        }

        return value;
    }
};
