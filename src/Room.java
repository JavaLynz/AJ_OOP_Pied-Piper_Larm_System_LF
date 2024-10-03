import java.util.ArrayList;
import java.util.List;

public class Room {
    //attributes
    private String name;
    private Sprinkler sprinkler;
    private List<Detector> detectors;

    //constructors
    public Room(String name) {
        this.name = name;
        this.detectors = new ArrayList<>();
        this.sprinkler = new Sprinkler();

        detectors.add(new SmokeDetector());
    }
    //methods
    public void activateAllDetectors() {
        for (Detector detector : detectors) {
            detector.activate();
        }

        boolean alarmActive = false;
        if (alarmActive) {
            for (Detector md : detectors) {
                ((MotionDetector) md).activate();
            }
            for (Detector dd : detectors) {
                ((DoorDetector) dd).activate();
            }
            for (Detector wd : detectors) {
                ((WindowDetector) wd).activate();
            }
        }
    }

    public void deActivateAllDetectors() {
        for (Detector detector : detectors) {
            detector.deactivate();
            detector.unDetect();
        }

        boolean alarmActive = true;
        if (alarmActive) {
            for (Detector d : detectors) {
                d.deactivate();
            }

        }
    }


    //getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Sprinkler getSprinkler() {
        return sprinkler;
    }
    public void setSprinkler(Sprinkler sprinkler) {
        this.sprinkler = sprinkler;
    }
    public List<Detector> getDetectors() {
        return detectors;
    }
    public void addMotionDetector(MotionDetector motionDetector) {
        detectors.add(new MotionDetector());
    }
    public void addDoorDetector(DoorDetector doorDetector) {
        detectors.add(doorDetector);
    }

    public void addWindowDetector(WindowDetector windowDetector) {
        detectors.add(windowDetector);
    }

}
