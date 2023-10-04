public class Nemo {

    private Integer positionX = 0;
    private Integer positionY = 0;
    private Integer positionZ = 0;
    private Integer direction = 0;
    public Nemo ( Integer positionX, Integer positionY, Integer positionZ, Integer direction  ) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.direction = direction;
    }

    public Integer positionX() { return positionX; }
    public Integer positionY() { return positionY; }
    public Integer positionZ() { return positionZ; }
    public Integer direction() { return direction; }
}
