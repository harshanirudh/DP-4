//Time Complexity: O(mn)2
//Space Complexity:O(1)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        boolean flag=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if( matrix[i][j]=='1'){
                    flag=true;
                    int curr=1;
                    while(i+curr<m && j+curr<n && flag){

                        //To Check 
                        for(int k=i+curr;k>=i;k--){
                            if(matrix[k][j+curr]=='0'){
                                flag=false;
                                break;
                            }
                        }
                        for(int k=j+curr;k>=j;k--){
                            if(matrix[i+curr][k]=='0'){
                                flag=false;
                                break;
                            }
                        }
                        if(flag)
                            curr++;
                    }
                    max=Math.max(curr,max);
                }
            }
        }
        return max*max;
    }
}

//Time Complexity: O(mn)
//Space Complexity:O(mn)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][]=new int[m+1][n+1];
        int max=0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
                max=Math.max(dp[i][j],max);
            }
        }
        return max*max;
    }
}

//Time Complexity: O(mn)
//Space Complexity:O(n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[]=new int[n+1];
        int max=0;
        int diagUp=0;
        int temp=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                temp=dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j]=Math.min(Math.min(dp[j-1],dp[j]),diagUp)+1;
                    max=Math.max(dp[j],max);
                }else{
                    dp[j]=0;
                }
                diagUp=temp;
            }
        }
        return max*max;
    }
}
