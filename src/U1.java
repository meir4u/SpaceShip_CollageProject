public class U1 extends Rocket {
    public static final int LAUNCH_EXP = 5;
    public static final int LAUNCH_CRASH = 1;
    public static final int COST = 100;

   public U1(){
        super(18000,10000);
        super.cost = this.COST;
   }

    public boolean land(){
       return randomByProbability(LAUNCH_EXP);
   }

   public boolean launch(){
       return randomByProbability(LAUNCH_CRASH);
   }
}
