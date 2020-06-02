package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Solution sol = new Solution();
        int len = 5;
        int[] iArray = new int[len];

        for(int i=0; i<len; i++){
            iArray[i]=i+1;
        }

        iArray[0] = 6;
        iArray[1] = 5;
        iArray[2] = 3;
        iArray[3] = 2;
        iArray[4] = 1;

        int answer = sol.digitPermutations(iArray);
        System.out.println(answer);

    }
}

class Solution{

    int convertToNumber(int[] myNumber){
        int number = 0;
        int position = 0;
        for(int i=myNumber.length-1; i>=0; i--){
            if(position == 0){
                number += myNumber[i];
            }
            else{
                number += Math.pow(10,position) * myNumber[i];
            }
            position++;
        }
        return number;
    }

    int getPermutations(int[] number, int start, int end){

        int initialNumber = convertToNumber(number);
        int minNumber = -1;

        for(int i=start; i<=end; i++){
            for(int j=start; j<=end; j++){
                int[] permutation = number.clone();
                int temp = permutation[i];
                permutation[i] = permutation[j];
                permutation[j]= temp;

                int currentPerm = convertToNumber(permutation);

                if(currentPerm<initialNumber && currentPerm > minNumber){
                    minNumber = currentPerm;
                }
            }
        }

        if(minNumber==-1){
            return initialNumber;
        }
        else{
            return minNumber;
        }

    }


    int digitPermutations(int[] number){

        int len = number.length;
        int initialNumber = convertToNumber(number);

        for(int i=len-2; i>=0; i--){
            int currentMin = getPermutations(number,i, len-1 );
            if(currentMin < initialNumber){
                return currentMin;
            }
        }

        return initialNumber;
    }
}
