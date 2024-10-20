package space;

public final class SpaceUtils {
    private final static Double STEFAN_BOLTZMANN_CONSTANT = 0.00000006;
    private final static Double PI = 3.14;

    private SpaceUtils() {
    }

    public static double findingGravityBetweenBodies(CosmicBody cosmicBody1, CosmicBody cosmicBody2) {
        double gravity1 = cosmicBody1.getDistanceFromSun() * cosmicBody1.getMass() * STEFAN_BOLTZMANN_CONSTANT * PI;
        double gravity2 = cosmicBody2.getDistanceFromSun() * cosmicBody2.getMass() * STEFAN_BOLTZMANN_CONSTANT * PI;
        return gravity1 / gravity2;

    }

    public static boolean definitionStarOrNot(CosmicBody cosmicBody) {
        if (cosmicBody.getTemperature() > 1000) {
            System.out.println("Тело является звездой");
            return true;
        }
        System.out.println("Обект не является звездой");
        return false;
    }
}
