package space.star;

import space.CalculatingDiameter;
import space.CalculatingMass;
import space.ComparingMasses;
import space.CosmicBody;

public class Star extends CosmicBody implements CalculatingDiameter, ComparingMasses, CalculatingMass {
    private String classStar;
    private Double luminosity;
    private final Double STEFAN_BOLTZMANN_CONSTANT = 0.00000006;
    private final Double PI = 3.14;

    public Star(String chemicalComposition, Integer speedMovementInSpace, String name, Integer age, Double density,
                Double mass, Integer temperature, Double distanceFromSun, String classStar, Double luminosity) {
        super(chemicalComposition, speedMovementInSpace, name, age, density, mass, temperature, distanceFromSun);
        this.classStar = classStar;
        this.luminosity = luminosity;
    }

    public Star() {
    }

    public Double luminosityDetermination(Double radius, Integer temperature) {
        return 4 * PI * Math.pow(radius, 2) * STEFAN_BOLTZMANN_CONSTANT * Math.pow(temperature, 4);
    }

    public String getClassStar() {
        return classStar;
    }

    public void setClassStar(String classStar) {
        this.classStar = classStar;
    }

    public Double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(Double luminosity) {
        this.luminosity = luminosity;
    }


    @Override
    public boolean compareMass(CosmicBody object1, CosmicBody object2) {
        return object1.getMass() > object2.getMass();
    }



    @Override
    public double massDetermination(Double density, Double radius) {
        return 4 / 3 * PI * density * Math.pow(radius, 3);
    }

    @Override
    public double calculatesDiameter(CosmicBody star) {
        return star.getTemperature() * (getLuminosity() / 4 * PI * STEFAN_BOLTZMANN_CONSTANT) * 2;
    }
    @Override
    public String toString() {
        return "Star{" +
                "classStar='" + classStar + '\'' +
                ", luminosity=" + luminosity +
                ", STEFAN_BOLTZMANN_CONSTANT=" + STEFAN_BOLTZMANN_CONSTANT +
                ", PI=" + PI +
                '}';
    }

}
