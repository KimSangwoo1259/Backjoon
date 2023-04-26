#include <iostream>
using namespace std;

#define SIZE 

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	long long int dp[101] = { 0 , };
	dp[1] = 1;
	dp[2] = 1;
	dp[3] = 1;
	dp[4] = 2;
	dp[5] = 2;
	for (int i = 6; i <= 100; i++) {
		dp[i] = dp[i - 1] + dp[i - 5];
	}
	int n; //테스트 횟수

	cin >> n;

	int temp;

	for (int j = 0; j < n; j++) {
		cin >> temp;
		
		cout << dp[temp] << '\n';
		
	}
	
	
	return 0;
	

}