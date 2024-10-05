package space.star.satellite;

import space.planet.Planet;

public class Satellite extends Planet {
    Boolean gravitationalConnection;

    public Satellite(String chemicalComposition, Integer speedMovementInSpace, String name, Integer age, Double density,
                     Double mass, Integer temperature, Double distanceFromSun, Double speedRotationAroundAxis, Integer numberOfSatellites,
                     Double accelerationOfGravity, Boolean gravitationalConnection) {
        super(chemicalComposition, speedMovementInSpace, name, age, density, mass, temperature, distanceFromSun, speedRotationAroundAxis,
                numberOfSatellites, accelerationOfGravity);
        this.gravitationalConnection = gravitationalConnection;
    }

    public Satellite() {
    }

    public boolean definitionGravitationalConnection(Planet planet1, Planet planet2) {
        if (planet1.getDistanceFromSun() / planet2.getDistanceFromSun() < 1) {

            boolean isSatellite = planet1.getMass() < planet2.getMass();
            System.out.println("Обект является спутником");
            return isSatellite;

        }
        System.out.println("Обект не является спутником");
        return false;
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "gravitationalConnection=" + gravitationalConnection +
                '}';
    }
}
