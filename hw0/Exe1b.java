/**
 * triangle method is used to print a triangle with *, nth times
 */
public class Exe1b {

    public  static void drawTriangle(int n){
        for (int i=1;i<=n;i++){

            for(int k=1;k<=i;k++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args){
        drawTriangle(10);
    }

}