public class ArgsSum {

    public static void main(String[] args){
        int sum=0;
        for(int i=0;i<args.length;i++){

            //convert string to int
            sum+=Integer.parseInt(args[i]);
        }
        System.out.println("sum is: "+sum);
    }
}
