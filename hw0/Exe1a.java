/**
 * triangle method is used to print a triangle with *, nth times
 */
public class Exe1a {

    public  static void triangle(int n){
        for (int i=1;i<=n;i++){

            for(int k=1;k<=i;k++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args){
        triangle(5);
    }

}