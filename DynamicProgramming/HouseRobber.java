package DynamicProgramming;

public class HouseRobber {
    // top to bootom 
    public static int houseRobberMem( int[] arr, int idx)
    {
        if( idx == 0 ) return arr[0];
        if( idx < 0 ) return 0;
        int pick = arr[idx] + houseRobberMem(arr,idx-2);
        int notPick = houseRobberMem(arr,idx-1);
        return Math.max(pick, notPick);
    }
    public static void main(String[] args) {
        int[] arr = { 2,1,4,9  };
        int[] houseRobbingOne = new int[arr.length-1] ;
        int[] houseRobbingTwo = new int[arr.length-1] ;;

        for(int i = 0; i < arr.length; i++) {
             if(i != arr.length - 1) houseRobbingOne[i] = arr[i];
             if(i != 0) houseRobbingTwo[i-1] = arr[i];
        }
        int one  = houseRobberMem(houseRobbingOne,houseRobbingOne.length - 1);
        int two  = houseRobberMem(houseRobbingTwo,houseRobbingTwo.length - 1);
        System.out.print(Math.max(one, two));
    }
}
