package dp;

public class LongestTurbulentSubarray {
        public int maxTurbulenceSize(int[] A) {
            if(A.length == 0){
                return 0;
            }
//每个元素可以有两种方式形成湍流数组，例如：3>2<4,或者3<4>2。因此使用两个变量记录在这个元素之前，这两种模式的个数，初始为1。
            int typeOne = 1;
            int typeTwo = 1;
            int returnInt = 1;
            for(int i = 0; i < A.length - 1; i++){
                if(A[i] == A[i + 1]){
                    typeOne = 1;
                    typeTwo = 1;
                    continue;
                }

                if(i >= 1 && i % 2 == 1 && A[i] > A[i + 1]){
                    if(i == 1 && A[i] > A[i - 1]){
                        typeOne++;
                    }
                    typeOne++;
                    typeTwo = 1;
                    returnInt = Math.max(returnInt, typeOne);
                }else if(i >= 1 && i % 2 == 0 && A[i] < A[i + 1]){
                    typeOne++;
                    typeTwo = 1;
                    returnInt = Math.max(returnInt, typeOne);
                }else if(i >= 1 && i % 2 == 1 && A[i] < A[i + 1]){
                    if(i == 1 && A[i] < A[i - 1]){
                        typeTwo++;
                    }
                    typeTwo++;
                    typeOne = 1;
                    returnInt = Math.max(returnInt, typeTwo);
                }else if(i >= 1 && i % 2 == 0 && A[i] > A[i + 1]){
                    typeTwo++;
                    typeOne = 1;
                    returnInt = Math.max(returnInt, typeTwo);
                }
            }
            return returnInt;
        }
}
