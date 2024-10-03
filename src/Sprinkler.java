public class Sprinkler{
    public boolean activated;

    public Sprinkler() {
        activated = false;
    }
    public void activate() {
        activated = true;
        System.out.println("Sprinklers aktiverade!");
    }
    public void deactivate() {
        activated = false;
        //test method
        // System.out.println("Sprinklers avaktivarade!");
    }
    public boolean isActivated() {
        return activated;
    }

}
