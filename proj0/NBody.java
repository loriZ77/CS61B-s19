/**
 * actually run simulation
 */
public class NBody {
    //Given a file name as a String,
    // it return a double corresponding to the radius of the universe in that file
    public static double readRadius(String fileName){
         In in= new In(fileName);
         int N= in.readInt();
         double R=in.readDouble();
         return R;

    }
    //Given a file name, it should return an array of Bodys corresponding to the bodies in the file,
    // e.g. readBodies("./data/planets.txt") should return an array of five planets.
    public static Body[] readBodies(String fileName){
        In in=new In(fileName);
        int N=in.readInt();
        double R=in.readDouble();
        Body[] planets=new Body[N];

        for(int i=0;i<N;i++){
            double xP=in.readDouble();
            double yP=in.readDouble();
            double xV=in.readDouble();
            double yV=in.readDouble();
            double m=in.readDouble();
            String img=in.readString();
            planets[i]=new Body(xP,yP,xV,yV,m, img);

            }
        return planets;
        }

        //main method
    public static void main (String[] args){

        //collecting all needed input
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        Body[] planets=NBody.readBodies(filename);
        double radius=NBody.readRadius(filename);

        //drawing the background
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0,0, "images/starfield.jpg");

        //drawing more than one body
        for(int i=0;i<planets.length;i++){
            planets[i].draw();
        }
        //graphics technique to prevent flickering in the animation
        StdDraw.enableDoubleBuffering();

        //drawing get copied from the offscreen canvas to the onscreen canvas
        StdDraw.show();

        for(double time=0;time<=T;time+=dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            for (int i = 0; i<planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);

                for (int j=0;j<planets.length;j++){
                    planets[j].update(dt,xForces[j],yForces[j]);
                }
                StdDraw.picture(0, 0, "images/starfield.jpg");

                    for (Body b : planets) {
                    b.draw();

                }
                StdDraw.enableDoubleBuffering();
                StdDraw.show();
                StdDraw.pause(10);

            }
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }





    }



}



