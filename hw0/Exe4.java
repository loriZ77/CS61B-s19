import java.util.Arrays;

public class Exe4 {
    /**
     * Write a function windowPosSum(int[] a,
     * int n) that replaces each element a[i] with the sum of a[i] through a[i + n],
     * but only if a[i] is positive valued. If there are not enough values because we reach the end of the array,
     * we sum only as many values as we have.
     */
    public static void windowPosSum(int[] a, int n) {
        for(int i=0;i<a.length;i++){
            //ignore if value is negative
            if(a[i]<0){
                continue;
            }

            for(int k=1;k<=n;k++){
                //(i+k) should <=(a.length-1)
                if(i+k>=a.length){
                    break;
                }
                a[i]=a[i]+a[i+k];

            }

        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(Arrays.toString(a));
    }
}