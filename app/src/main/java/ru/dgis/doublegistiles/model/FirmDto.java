package ru.dgis.doublegistiles.model;

public class FirmDto {

    private long id;
    private String name;
    private String floor;
    private String mainRubric;

    public FirmDto(long id, String name, String floor, String mainRubric) {
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.mainRubric = mainRubric;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFloor() {
        return floor;
    }

    public String getMainRubric() {
        return mainRubric;
    }
}
