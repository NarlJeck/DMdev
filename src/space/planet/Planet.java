package space.planet;

import space.CalculatingDiameter;
import space.CalculatingMass;
import space.ComparingMasses;
import space.CosmicBody;

import java.util.Objects;

public class Planet extends CosmicBody implements CalculatingMass, ComparingMasses, CalculatingDiameter {
    private Double speedRotationAroundAxis;
    private Integer numberOfSatellites;
    private Double accelerationOfGravity;
    private final Double GRAVITATIONAL_CONSTANT = 0.0000000000667;

    public Planet(String chemicalComposition, Integer speedMovementInSpace, String name, Integer age, Double density,
                  Double mass, Integer temperature, Double distanceFromSun, Double speedRotationAroundAxis, Integer numberOfSatellites,
                  Double accelerationOfGravity) {
        super(chemicalComposition, speedMovementInSpace, name, age, density, mass, temperature, distanceFromSun);
        this.speedRotationAroundAxis = speedRotationAroundAxis;
        this.numberOfSatellites = numberOfSatellites;
        this.accelerationOfGravity = accelerationOfGravity;
    }

    public Planet() {
    }

    @Override
    public double massDetermination(Double accelerationOfGravity, Double radius) {
        return accelerationOfGravity * Math.pow(radius, 2) / GRAVITATIONAL_CONSTANT;
    }

    @Override
    public boolean compareMass(CosmicBody object1, CosmicBody object2) {
        if(Objects.equals(object1.getMass(), object2.getMass())){
            System.out.println("Обекты ровны");
            return true;
        }
        else if(object1.getMass() > object2.getMass()){
            System.out.println("Объект 1 больше объета 2");
            return true;
        }
        System.out.println("Объект 2 больше объета 1");

        return false;
    }


    public Double getSpeedRotationAroundAxis() {
        return speedRotationAroundAxis;
    }

    public Integer getNumberOfSatellites() {
        return numberOfSatellites;
    }

    public Double getAccelerationOfGravity() {
        return accelerationOfGravity;
    }

    public Double getGRAVITATIONAL_CONSTANT() {
        return GRAVITATIONAL_CONSTANT;
    }


    @Override
    public double calculatesDiameter(CosmicBody planet) {
        return planet.getDistanceFromSun()* (accelerationOfGravity / 4 * GRAVITATIONAL_CONSTANT) * 2;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "speedRotationAroundAxis=" + speedRotationAroundAxis +
                ", numberOfSatellites=" + numberOfSatellites +
                ", accelerationOfGravity=" + accelerationOfGravity +
                ", GRAVITATIONAL_CONSTANT=" + GRAVITATIONAL_CONSTANT +
                '}';
    }
}

