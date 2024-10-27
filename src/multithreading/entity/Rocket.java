package multithreading.entity;

import java.util.ArrayList;
import java.util.List;

public class Rocket extends Thread {

    private final  List<Crystal> crystalOnRocket = new ArrayList<>(this.volumeContainer);
   private final int volumeContainer = 4;
    private String nameRocket;

    public Rocket(String nameRocket) {
        this.nameRocket = nameRocket;
    }

    public List<Crystal> transportationProduction(List<Integer> listCrystal) {
        if(listCrystal==null){
            return null;
        }
        for (Integer integer : listCrystal) {
            if (integer == 1) {
                this.crystalOnRocket.add(Crystal.WHITE);
            } else if (integer == 2) {
                this.crystalOnRocket.add(Crystal.RED);
            }
        }
        return this.crystalOnRocket;
    }

    public String getNameRocket() {
        return nameRocket;
    }

    public void setNameRocket(String nameRocket) {
        this.nameRocket = nameRocket;
    }
}
