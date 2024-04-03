public abstract class Role extends RPGCharacter implements Move {
    public Role(String name, int level) {
        super(name, level);
    }

    public void moveTo(MovePosition pos) {
        switch (pos) {
            case UP:
                System.out.println("往上移動 1 步");
                break;
            case DOWN:
                System.out.println("往下移動 1 步");
                break;
            case LEFT:
                System.out.println("往左移動 1 步");
                break;
            case RIGHT:
                System.out.println("往右移動 1 步");
                break;
            default:
                break;
        }
    }

    abstract void attack();
}
