public class DogLauncher {

    public static void main(String[] args){
        Dog lisa = new Dog(22);
        Dog hub=new Dog(33);
        Dog myDog=new Dog(55);

        //invoke static-method, using class.
        Dog bigger1=Dog.biggerDog(lisa,myDog);
        bigger1.makeNoise();

        //invoke non-static method, using instance name
        Dog bigger2= myDog.biggerDog(hub);
        bigger2.makeNoise();
        System.out.println(bigger2.binomen);


    }
}
