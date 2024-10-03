public class Detector {
    // attributes
    private boolean isActive;
    private String type;
    private boolean isDetected;
    private Siren siren = new Siren();
    private Sprinkler sprinkler = new Sprinkler();

    //constructors
    public Detector(String type) {
        this.isActive = false;
        this.type = type;
    }

    //methods
    public void activate(){
        this.isActive = true;
        //System.out.println(type + " is active");
    }
    public void deactivate(){
        this.isActive = false;
        this.isDetected=false;
        siren.deactivate();
        //System.out.println(type + " is deactive");
    }
    public void detect(){
        this.isDetected = true;
        System.out.println(type + " detektor aktiverats!");
        siren.activate();
    }
    public void unDetect(){
        this.isDetected = false;
        siren.deactivate();
       // test method
        //System.out.println(type + " detektor återställdes");
    }


    //getters and setters
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

    public void setActive(boolean active){
        this.isActive = active;
    }
    public boolean isActive(){
        return this.isActive;
    }

    public void setDetected(boolean detected){
        this.isDetected = detected;
    }
    public boolean isDetected(){
        return this.isDetected;
    }
    // override
    @Override
    public String toString() {
        return "Detectors: ";
    }
}
