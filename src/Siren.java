public class Siren{
    //attributes
    private boolean isActivated;
    //constructors
    public Siren() {
        isActivated = false;
    }
    //methods
    public void activate() {
        if (isActivated) {
            System.out.println("Siren redan aktiverat!");
        }
        if (!isActivated) {
            isActivated = true;
            System.out.println("Siren aktiverade!");


        }
    }
    public void deactivate() {
        if (!isActivated) {
            //test
            //System.out.println("siren redan avaktiverat!");
        }
        if (isActivated) {
            isActivated = false;
            System.out.println("Siren avaktiverat!");
        }
    }
    //getters and setters
    public boolean isActivated() {
        return isActivated;
    }
    public void setActivated(boolean activated) {
        isActivated = activated;
    }
    //override toString
    @Override
    public String toString() {
        return "Siren";
    }
}
