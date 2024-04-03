public interface Move {
    void moveTo(MovePosition pos);
}

enum MovePosition {
    UP,
    DOWN,
    LEFT,
    RIGHT
}