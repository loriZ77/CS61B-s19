public class Body {

    //6 public instance variables
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double G=6.67e-11;

    //first constructor
    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;

    }
    //second constructor：initialize an identical Body object
    public Body(Body b){
        xxPos=b.xxPos;
        yyPos=b.yyPos;
        xxVel=b.xxVel;
        yyVel=b.yyVel;
        mass=b.mass;
        imgFileName=b.imgFileName;

    }
    //calculate the distance between two Bodys
    public double calcDistance(Body b){
        double dx=b.xxPos-this.xxPos;
        double dy=b.yyPos-this.yyPos;
        double r=Math.hypot(dx,dy);
        return r;
    }
    // return a double describing the force exerted on this body by the given body
    public double calcForceExertedBy(Body b){
        double F;
        F=(G*this.mass*b.mass)/Math.pow(this.calcDistance(b),2);
        return F;

    }
    //return the total force, describe the force exerted in the X direction
    public double calcForceExertedByX(Body b){
        double FX;
        double dx=b.xxPos-this.xxPos;
        double dy=b.yyPos-this.yyPos;
        double r=Math.hypot(dx,dy);
        FX=this.calcForceExertedBy(b)*dx/r;
        return FX;
    }
    //return the total force, describe the force exerted in the Y direction
    public double calcForceExertedByY(Body b){
        double FY;
        double dx=b.xxPos-this.xxPos;
        double dy=b.yyPos-this.yyPos;
        double r=Math.hypot(dx,dy);
        FY=this.calcForceExertedBy(b)*dy/r;
        return FY;
    }
    //calculate the net force in x direction
    public double calcNetForceExertedByX(Body[] allB){
        double netForceX=0;
        //enhanced for loop
        for(Body b:allB){
            if (this.equals(b)){
                continue;
            }
            netForceX+=this.calcForceExertedByX(b);
        }
        return netForceX;
    }
    //calculate the net force in y direction
    public double calcNetForceExertedByY(Body[] allB){
        double netForceY=0;
        for(Body b:allB){
            if (this.equals(b)){
                continue;
            }
            netForceY+=this.calcForceExertedByY(b);
        }
        return netForceY;

    }
    //update the body’s position and velocity instance variables
    public void update(double dt, double fX,double fY){
        double accelerationX=fX/this.mass;
        double accelerationY=fY/this.mass;
        this.xxVel+=dt*accelerationX;
        this.yyVel+=dt*accelerationY;
        this.xxPos+=dt*this.xxVel;
        this.yyPos+=dt*this.yyVel;

    }
    //drawing one body
    public void draw(){

        //StdDraw.clear(); 不能clear 因为之前draw background了
        StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);//一开始"images"路径忘加了
    }

}
