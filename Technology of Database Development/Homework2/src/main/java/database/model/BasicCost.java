package database.model;

import database.model.usage.ServiceType;

public class BasicCost {
    private int id;
    private double callCost;
    private double smsCost;
    private double localDataCost;
    private double domesticDataCost;

    public BasicCost() {
    }

    public BasicCost(double callCost, double smsCost, double localDataCost, double domesticDataCost) {
        this.callCost = callCost;
        this.smsCost = smsCost;
        this.localDataCost = localDataCost;
        this.domesticDataCost = domesticDataCost;
    }

    @Override
    public String toString() {
        return "基础资费{" +
            "id=" + id +
            ", 电话资费（每分钟）=" + callCost +
            ", 短信资费（每条）=" + smsCost +
            ", 本地流量资费（每M）=" + localDataCost +
            ", 国内流量资费（每M）=" + domesticDataCost +
            '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCallCost() {
        return callCost;
    }

    public void setCallCost(double callCost) {
        this.callCost = callCost;
    }

    public double getSmsCost() {
        return smsCost;
    }

    public void setSmsCost(double smsCost) {
        this.smsCost = smsCost;
    }

    public double getLocalDataCost() {
        return localDataCost;
    }

    public void setLocalDataCost(double localDataCost) {
        this.localDataCost = localDataCost;
    }

    public double getDomesticDataCost() {
        return domesticDataCost;
    }

    public void setDomesticDataCost(double domesticDataCost) {
        this.domesticDataCost = domesticDataCost;
    }

    public double getCostByServiceType(ServiceType serviceType) {
        switch (serviceType) {
            case CALL:
                return callCost;
            case SMS:
                return smsCost;
            case LOCAL_DATA:
                return localDataCost;
            case DOMESTIC_DATA:
                return domesticDataCost;
        }
        return 0;
    }
}
