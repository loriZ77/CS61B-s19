public class Dog {
    public int weightInPounds;
    //static variable
    public static String binomen="Carni Familaris";

    public Dog(int w){
    weightInPounds=w;
    }

    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yipyipyip!");

        }
        else if (weightInPounds < 30) {
            System.out.println("bark. bark.");
        }
        else {
            System.out.println("woof!");
        }
    }


    //static method
    public static Dog biggerDog(Dog d1, Dog d2){
        if(d1.weightInPounds>d2.weightInPounds){
            return d1;
        }
        else{
            return d2;
        }
    }

        //non-static method
        public Dog biggerDog( Dog d2){
        if(this.weightInPounds>d2.weightInPounds) {
            return this;
        }
        else{
                return d2;
            }

    }




}


