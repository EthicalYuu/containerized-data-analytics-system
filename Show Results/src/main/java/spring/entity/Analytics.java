package spring.entity;


import jakarta.persistence.Id;

public class Analytics {

    @Id
    public String id;
    public int minTemp;
    public int maxTemp;
    public int avgTemp;

    public Analytics(){

    }

    public Analytics(int minTemp, int maxTemp, int avgTemp){
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.avgTemp = avgTemp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(int avgTemp) {
        this.avgTemp = avgTemp;
    }

    @Override
    public String toString() {
        return "Analytics{" +
                "id='" + id + '\'' +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                ", avgTemp=" + avgTemp +
                '}';
    }
}
