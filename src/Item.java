public class Item {
    private String name;
    private int weight;
    private int price;

    public Item(String n, int w){
        name = n;
        weight = w;
        price = 0;
    }

    public Item(String n, int w,int p){
        this.name = n;
        this.weight = w;
        this.price = p;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
