abstract public class Rocket implements  SpaceShip{
    int cargo;
    final int CARGO_LIMIT;
    protected int cost;

    public Rocket(int cargoLimit, int cargo){
        this.cargo = cargo;
        this.CARGO_LIMIT = cargoLimit;
    }

    abstract public boolean launch();

    abstract public boolean land();

    public boolean canCarry(Item item){
        return (this.CARGO_LIMIT <= (item.getWeight() + this.cargo) );
    }

    public void carry(Item item){
        this.cargo += item.getWeight();
        cost += item.getPrice();
    }

    /*
    *we can probability that something will happen
    *for example if probability that explosion will happen 5%
    * then 1/95
    * */
    protected boolean randomByProbability(int percent){
        int random = (int) (Math.random() * 100);
        return (random > (int)(percent * cargo / CARGO_LIMIT));
    }

    public int getTotalCost(){
        return cost;
    }
}
