#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	queue<int> q;
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		q.push(i);
	}
	for (int i = 0; i < n - 1; i++) {
		int n;
		q.pop();
		n = q.front();
		q.pop();
		q.push(n);


	}
	cout << q.front() << '\n';
}