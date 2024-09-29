package space;

public abstract class CosmicBody {
    private String chemicalComposition;
    private Integer speedMovementInSpace;
    private String name;
    private Integer age;
    private Double density;

    private Double mass;

    private Integer temperature;
    private Double distanceFromSun;

    public CosmicBody(String chemicalComposition, Integer speedMovementInSpace, String name, Integer age, Double density,
                      Double mass, Integer temperature, Double distanceFromSun) {
        this.chemicalComposition = chemicalComposition;
        this.speedMovementInSpace = speedMovementInSpace;
        this.name = name;
        this.age = age;
        this.density = density;
        this.mass = mass;
        this.temperature = temperature;
        this.distanceFromSun = distanceFromSun;
    }

    public CosmicBody() {
    }

    public String getChemicalComposition() {
        return chemicalComposition;
    }

    public Integer getSpeedMovementInSpace() {
        return speedMovementInSpace;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getMass() {
        return mass;
    }

    public Double getDensity() {
        return density;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public Double getDistanceFromSun() {
        return distanceFromSun;
    }
}
