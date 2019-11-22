public class Calculations {
    public static double calculateAcceleration(Weight weight, Cart cart) {
        if(weight != null && cart != null) {
            double dblWeightMass = weight.getMass();
            double dblCartMass = cart.getMass();
            double dblForceGravity = calculateForceGravity(weight);
            return dblForceGravity/(dblWeightMass + dblCartMass);
        } 

        return -1;
    }

    public static double calculateForceGravity(Weight weight) {
        if(weight != null) {
            double dblWeightMass = weight.getMass();
            double dblGravity = weight.getGravity();
            return dblWeightMass * dblGravity;
        }

        return -1;
    }

    public static double calculateTension(Cart cart) {
        if(cart != null) {
            double dblCartMass = cart.getMass();
            double dblAcceleration = cart.getAcceleration();
            return dblCartMass * dblAcceleration;
        }
        return -1;
    }

    public static double calculateNetForce(Weight weight, Cart cart) {
        if(weight != null) {
            double dblForceGravity = calculateForceGravity(weight);
            double dblTension = calculateTension(cart);

            return dblForceGravity - dblTension;
        }
        return -1;
    }
}