package multithreading.entity;


import multithreading.entity.Crystal;
import multithreading.entity.Planet;
import multithreading.entity.Rocket;

import java.util.ArrayList;
import java.util.List;

public class RaceMage extends Thread{
    private final int countFullContainer = 100;
    private String nameRace;
    private final Rocket raceMageRocket = new Rocket("MageRocket");
    private final List<Crystal> whiteCrystalList = new ArrayList<>();
    private final List<Crystal> redCrystalList = new ArrayList<>();

    @Override
    public void run() {
        while (redCrystalList.size()<countFullContainer||whiteCrystalList.size()<countFullContainer){
            List<Crystal> crystals = raceMageRocket.transportationProduction(Planet.createCrystal());
            crystalCounting(crystals);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }

        }
        System.out.println("Победил " + nameRace);

    }

    public void crystalCounting(List<Crystal> crystalsList) {

        for (Crystal crystal : crystalsList) {
            if (crystal == null) {
                System.out.println("Рокета ничего не собрала");
                break;
            } else if (crystal.equals(Crystal.RED) && redCrystalList.size() < 500) {
                this.redCrystalList.add(crystal);
            } else if (crystal.equals(Crystal.WHITE) && whiteCrystalList.size() < 500) {
                this.whiteCrystalList.add(crystal);
            }
        }

    }

    public RaceMage(String nameRace) {
        this.nameRace = nameRace;
    }

    public List<Crystal> getWhiteCrystalList() {
        return whiteCrystalList;
    }

    public List<Crystal> getRedCrystalList() {
        return redCrystalList;
    }


    @Override
    public String toString() {
        return "RaceMage{" +
                "nameRace='" + nameRace + '\'' +
                ", whiteCrystalList=" + whiteCrystalList +
                ", redCrystalList=" + redCrystalList +
                '}';
    }
}
