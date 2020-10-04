public class ParkingSystem {
    static int[] capacity;
    public ParkingSystem(int big, int medium, int small) {
        capacity = new int[] {big,medium,small};
    }
    public boolean addCar(int carType) {
        return capacity[carType - 1]-- > 0;
    }
}
