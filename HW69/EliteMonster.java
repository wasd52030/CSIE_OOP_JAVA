public class EliteMonster extends Monster implements Move {

    public EliteMonster(String name,int level){
        super(name,level);
    }

    @Override
    void skill() {
        System.out.println("冰冷吐息");
    }

    @Override
    public void moveTo(MovePosition pos) {
        switch (pos) {
            case UP:
                System.out.println("往上移動 2 步");
                break;
            case DOWN:
                System.out.println("往下移動 2 步");
                break;
            case LEFT:
                System.out.println("往左移動 2 步");
                break;
            case RIGHT:
                System.out.println("往右移動 2 步");
                break;
            default:
                break;
        }
    }
}
