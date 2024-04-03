public class SecurityCamera extends Appliances implements IOperate {

    private boolean status;

    public SecurityCamera(String type, String name, String location, int consumption) {
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
            System.out.println("安全攝影機(開啟)");
        } else {
            System.out.println("安全攝影機(關閉)");
        }
    }
}
