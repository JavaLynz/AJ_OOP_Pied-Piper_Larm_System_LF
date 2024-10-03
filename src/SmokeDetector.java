public class SmokeDetector extends Detector{

    private final Sprinkler sprinkler = new Sprinkler();

    public SmokeDetector() {
        super("Rök");
        super.setActive(true);
    }

    public void detect(){
        super.detect();
        sprinkler.activate();
    }

    public void unDetect(){
        super.unDetect();
        sprinkler.deactivate();
    }
    @Override
    public void deactivate() {
       // System.out.println("Smoke detectors always active!");
    }

    @Override
    public String toString() {
        return "Rökdetektor";
    }


}
