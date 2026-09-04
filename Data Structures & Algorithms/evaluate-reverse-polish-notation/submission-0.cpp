#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isNumber (string s) {
        return !(s == "+" || s == "-" || s == "*" || s == "/");
    }

    int getVal (int num1, int num2, string op) {
        if (op == "+") {
            return num1 + num2;
        } else if (op == "-") {
            return num1 - num2;
        } else if (op == "*") {
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }

    int evalRPN(vector<string>& tokens) {
        stack<int> st;

        for (string &s : tokens) {
            if (isNumber (s)) {
                st.push (stoi(s));
            } else {
                int num2 = st.top(); st.pop();
                int num1 = st.top(); st.pop();

                st.push (getVal (num1, num2, s));
            }
        }

        return st.top();
    }
};
