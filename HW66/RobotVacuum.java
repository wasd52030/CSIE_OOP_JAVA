public class RobotVacuum extends Appliances implements IOperate {

    private boolean status;

    public RobotVacuum(String type, String name, String location, int consumption) {
        super(type, name, location, consumption);
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean s) {
        status = s;
    }

    @Override
    void showProfile() {
        super.showProfile();
        System.out.printf("status= %b\n", getStatus());
    }

    @Override
    public void Operate() {
        if (status) {
            System.out.println("掃地機器人(開始打掃)");
        } else {
            System.out.println("掃地機器人(打掃完畢)");
        }
    }
}
