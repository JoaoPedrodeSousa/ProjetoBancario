package model.Entities.impl;

import java.util.Date;

public class LogInvestiment extends Log{
    private String assetType;

    public LogInvestiment(String type, Double value, String assetType) {
        super(type, value);
        this.assetType = assetType;
    }

    public LogInvestiment(String type, Double value, Date date, String assetType) {
        super(type, value, date);
        this.assetType = assetType;
    }

    public LogInvestiment(Integer id, String type, Double value, String assetType) {
        super(id, type, value);
        this.assetType = assetType;
    }

    public LogInvestiment(Integer id, String type, Double value, Date date, String assetType) {
        super(id, type, value, date);
        this.assetType = assetType;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

}
