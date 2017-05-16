package po;

/**
 * Created by tangshilong on 2017/5/15.
 */
public class Info {
    private Integer id;
    private String stationId;
    private String stationName;
    private String date;
    private String dateCST;
    private String temperature;
    private String dewPoint;
    private String pressure;
    private String visibility;
    private String windDirection;
    private String windSpeed;
    private String conditions;
    private String windDirDegrees;
    private String dateUTC;

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", stationId='" + stationId + '\'' +
                ", stationName='" + stationName + '\'' +
                ", date='" + date + '\'' +
                ", dateCST='" + dateCST + '\'' +
                ", temperature='" + temperature + '\'' +
                ", dewPoint='" + dewPoint + '\'' +
                ", pressure='" + pressure + '\'' +
                ", visibility='" + visibility + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", conditions='" + conditions + '\'' +
                ", windDirDegrees='" + windDirDegrees + '\'' +
                ", dateUTC='" + dateUTC + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateCST() {
        return dateCST;
    }

    public void setDateCST(String dateCST) {
        this.dateCST = dateCST;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(String dewPoint) {
        this.dewPoint = dewPoint;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getWindDirDegrees() {
        return windDirDegrees;
    }

    public void setWindDirDegrees(String windDirDegrees) {
        this.windDirDegrees = windDirDegrees;
    }

    public String getDateUTC() {
        return dateUTC;
    }

    public void setDateUTC(String dateUTC) {
        this.dateUTC = dateUTC;
    }

    public Info() {
    }

    public Info(String stationId, String stationName, String date, String dateCST, String temperature, String dewPoint, String pressure, String visibility, String windDirection, String windSpeed, String conditions, String windDirDegrees, String dateUTC) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.date = date;
        this.dateCST = dateCST;
        this.temperature = temperature;
        this.dewPoint = dewPoint;
        this.pressure = pressure;
        this.visibility = visibility;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.conditions = conditions;
        this.windDirDegrees = windDirDegrees;
        this.dateUTC = dateUTC;
    }

    public Info(Integer id, String stationId, String stationName, String date, String dateCST, String temperature, String dewPoint, String pressure, String visibility, String windDirection, String windSpeed, String conditions, String windDirDegrees, String dateUTC) {
        this.id = id;
        this.stationId = stationId;
        this.stationName = stationName;
        this.date = date;
        this.dateCST = dateCST;
        this.temperature = temperature;
        this.dewPoint = dewPoint;
        this.pressure = pressure;
        this.visibility = visibility;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.conditions = conditions;
        this.windDirDegrees = windDirDegrees;
        this.dateUTC = dateUTC;
    }
}
