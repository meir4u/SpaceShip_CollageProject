public class U2 extends Rocket {
    static final int LAUNCH_EXP = 4;
    static final int LAUNCH_CRASH = 8;
    public static final int COST = 120;

    public U2(){
        super(29000,18000);
        super.cost = this.COST;
    }

    public boolean land(){
        return randomByProbability(LAUNCH_EXP);
    }

    public boolean launch(){
        return randomByProbability(LAUNCH_CRASH);
    }



}
