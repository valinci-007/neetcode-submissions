class MinStack {
public:
    stack<int> s1, s2;
    MinStack() {
        
    }
    
    void push(int val) {
        s1.push (val);

        if (s2.empty()) {
            s2.push (val);
            return;
        }

        if (s2.top() < val) {
            s2.push (s2.top());
        } else {
            s2.push (val);
        }
    }
    
    void pop() {
        if (!s1.empty() && !s2.empty()) {
            s1.pop();
            s2.pop();
        }
    }
    
    int top() {
        return s1.top();
    }
    
    int getMin() {
        return s2.top();
    }
};
