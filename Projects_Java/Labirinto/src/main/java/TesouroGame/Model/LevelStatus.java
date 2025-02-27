package TesouroGame.Model;

public class LevelStatus {
    private Position PlayerPosition;

    @Override
    public String toString() {
        return "LevelStatus{" +
                "PlayerPosition=" + PlayerPosition +
                '}';
    }
}

class Position{
    int x;
    int y;

}