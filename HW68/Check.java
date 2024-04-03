public interface Check {
    final public int OilValue = 31;

    void checkMilage(int Milage);

    int getMilage();

    void checkOilConsumption(int OilConsumption); // 檢查耗油量

    int TotalCost(int OilValue, int Milage, int OilConsumption); // 計算總成本
}