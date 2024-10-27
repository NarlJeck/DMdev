package multithreading.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Planet{
    private final static int numberCrystalsPlanet=4;


    public static synchronized List<Integer> createCrystal(){
             Random random = new Random();
             List<Integer> crystalList = new ArrayList<>();

             for(int i=0;i<numberCrystalsPlanet;i++){
                 int crystal = random.nextInt(2) + 1;
                 crystalList.add(crystal);
             }
             return crystalList;
         }




}
