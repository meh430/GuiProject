public class Calculations {
    public static double calculateAcceleration(Weight weight, Cart cart) {
        double dblWeightMass = weight.getMass();
        double dblCartMass = 0;//cart.getMass();
        double dblForceGravity = calculateForceGravity(weight);
        return dblForceGravity/(dblWeightMass + dblCartMass);
    }

    public static double calculateForceGravity(Weight weight) {
        double dblWeightMass = weight.getMass();
        double dblGravity = weight.getGravity();
        return dblWeightMass * dblGravity;
    }

    public static double calculateTension(Cart cart) {
        double dblCartMass = 0;//cart.getMass();
        double dblAcceleration = 0;//cart.getAcceleration();

        return dblCartMass * dblAcceleration;
    }

    public static double calculateNetForce(Weight weight) {
        double dblForceGravity = weight.getForceGravity();
        double dblTension = weight.getTension();

        return dblForceGravity - dblTension;
    }
}