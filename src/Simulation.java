import java.util.ArrayList;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;

public class Simulation{
    ArrayList<Item> items;

    //public Simulation(String fileName){ }
    public void setItems(String fileName){
        items = this.loadItems(fileName);
    }

    private ArrayList<Item> loadItems(String fileName){
        ArrayList<Item> items = new ArrayList<>(0);
        BufferedReader reader;
        String line;
        String[] tmp;
        try{
            reader = new BufferedReader( new FileReader(fileName));
            line = reader.readLine();
            while(line != null){
                /*
                tmp[0] - hold item name
                tmp[1] - item weight
                tmp[3] - item price, if no set default price will created.
                 */
                tmp = line.split("[=,]",4);
                //if price added it will set item price else default price will set in items.
                if (tmp.length == 4 ){
                    items.add(new Item(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[3])));
                }else{
                    items.add(new Item(tmp[0],Integer.parseInt(tmp[1])));
                }
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e){
            e.printStackTrace();
        }
        return items;
    }

    private ArrayList<Rocket> loadU1(ArrayList<Item> items){
        ArrayList<Rocket> u1 = new ArrayList<>(0);
        u1.add(new U1());
        int index = 0;
        for (Item item :
                items) {
            if(!u1.get(index).canCarry(item)){
                ++index;
                u1.add(new U1());
            }
            u1.get(index).carry(item);
        }

        return u1;
    }

    private ArrayList<Rocket> loadU2(ArrayList<Item> items){
        ArrayList<Rocket> u2 = new ArrayList<>(0);

        int index = 0;
        u2.add(new U2());
        for (Item item :
                items) {
            if(!u2.get(index).canCarry(item)){
                ++index;
                u2.add(new U2());
            }
            u2.get(index).carry(item);
        }

        return u2;
    }

    public int runSimulation(String type){
        ArrayList<Rocket> rockets;
        switch (type.toUpperCase(Locale.ROOT)){
            case "U1":
                rockets = loadU1(items);
                break;
            default:
                rockets = loadU2(items);
                break;
        }

        int cost = 0;
        for (Rocket rocket : rockets) {
            do {
                cost += rocket.getTotalCost();
            } while (!(rocket.land() && rocket.launch()));
        }

        return cost;
    }
    /*
    public int runSimulationU1(){
        ArrayList<U1> rockets = loadU1(items);
        int cost = 0;
        for (U1 rocket : rockets) {
            do {
                cost += rocket.getCost();
                System.out.println(cost);
            } while (!(rocket.land() && rocket.launch()));
        }

        return cost;
    }

    public int runSimulationU2(){
        ArrayList<U2> rockets = this.loadU2(this.items);
        System.out.println(rockets.size());
        int cost = 0;
        for (U2 rocket : rockets) {
            do {
                cost += rocket.getCost();
            } while (!rocket.land() || !rocket.launch());
        }

        return cost;
    }


     */
}
