package Customize.SQLTable.Oracle;

import java.util.Date;

/**
 * Created by zhangtianyu on 2017/11/3.
 * …Ãªß±Ì
 */

public class T_MARKET_MERCHANT_RELATION {

    private String RECORD_NO;
    private String MARKET_CFG_ID;
    private String MERCHANT_ID;
    private String VALID_FLAG;
    private Date CREATE_TIME;
    private String CREATE_USER_ID;
    private String CHECK_FLAG;
    private Date CHECK_TIME;
    private String CHECK_USER;
    private String UPDATE_USER;
    private Date UPDATE_TIME;
    private String REMARK;
    private String MERCHANT_ALTERNATE_NAME;
    private String GOODS_GROUP_CODE;
    private String STORE_GROUP_CODE;
    private String GOODS_MARKETING_FLAG;
    private String STORE_MARKETING_FLAG;

    public String getRECORD_NO() {
        return RECORD_NO;
    }

    public void setRECORD_NO(String RECORD_NO) {
        this.RECORD_NO = RECORD_NO;
    }

    public String getMARKET_CFG_ID() {
        return MARKET_CFG_ID;
    }

    public void setMARKET_CFG_ID(String MARKET_CFG_ID) {
        this.MARKET_CFG_ID = MARKET_CFG_ID;
    }

    public String getMERCHANT_ID() {
        return MERCHANT_ID;
    }

    public void setMERCHANT_ID(String MERCHANT_ID) {
        this.MERCHANT_ID = MERCHANT_ID;
    }

    public String getVALID_FLAG() {
        return VALID_FLAG;
    }

    public void setVALID_FLAG(String VALID_FLAG) {
        this.VALID_FLAG = VALID_FLAG;
    }

    public Date getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(Date CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public String getCREATE_USER_ID() {
        return CREATE_USER_ID;
    }

    public void setCREATE_USER_ID(String CREATE_USER_ID) {
        this.CREATE_USER_ID = CREATE_USER_ID;
    }

    public String getCHECK_FLAG() {
        return CHECK_FLAG;
    }

    public void setCHECK_FLAG(String CHECK_FLAG) {
        this.CHECK_FLAG = CHECK_FLAG;
    }

    public Date getCHECK_TIME() {
        return CHECK_TIME;
    }

    public void setCHECK_TIME(Date CHECK_TIME) {
        this.CHECK_TIME = CHECK_TIME;
    }

    public String getCHECK_USER() {
        return CHECK_USER;
    }

    public void setCHECK_USER(String CHECK_USER) {
        this.CHECK_USER = CHECK_USER;
    }

    public String getUPDATE_USER() {
        return UPDATE_USER;
    }

    public void setUPDATE_USER(String UPDATE_USER) {
        this.UPDATE_USER = UPDATE_USER;
    }

    public Date getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(Date UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public String getMERCHANT_ALTERNATE_NAME() {
        return MERCHANT_ALTERNATE_NAME;
    }

    public void setMERCHANT_ALTERNATE_NAME(String MERCHANT_ALTERNATE_NAME) {
        this.MERCHANT_ALTERNATE_NAME = MERCHANT_ALTERNATE_NAME;
    }

    public String getGOODS_GROUP_CODE() {
        return GOODS_GROUP_CODE;
    }

    public void setGOODS_GROUP_CODE(String GOODS_GROUP_CODE) {
        this.GOODS_GROUP_CODE = GOODS_GROUP_CODE;
    }

    public String getSTORE_GROUP_CODE() {
        return STORE_GROUP_CODE;
    }

    public void setSTORE_GROUP_CODE(String STORE_GROUP_CODE) {
        this.STORE_GROUP_CODE = STORE_GROUP_CODE;
    }

    public String getGOODS_MARKETING_FLAG() {
        return GOODS_MARKETING_FLAG;
    }

    public void setGOODS_MARKETING_FLAG(String GOODS_MARKETING_FLAG) {
        this.GOODS_MARKETING_FLAG = GOODS_MARKETING_FLAG;
    }

    public String getSTORE_MARKETING_FLAG() {
        return STORE_MARKETING_FLAG;
    }

    public void setSTORE_MARKETING_FLAG(String STORE_MARKETING_FLAG) {
        this.STORE_MARKETING_FLAG = STORE_MARKETING_FLAG;
    }

    @Override
    public String toString() {
        return "t_market_merchant_relation{" +
                "RECORD_NO='" + RECORD_NO + '\'' +
                ", MARKET_CFG_ID='" + MARKET_CFG_ID + '\'' +
                ", MERCHANT_ID='" + MERCHANT_ID + '\'' +
                ", VALID_FLAG='" + VALID_FLAG + '\'' +
                ", CREATE_TIME=" + CREATE_TIME +
                ", CREATE_USER_ID='" + CREATE_USER_ID + '\'' +
                ", CHECK_FLAG='" + CHECK_FLAG + '\'' +
                ", CHECK_TIME=" + CHECK_TIME +
                ", CHECK_USER='" + CHECK_USER + '\'' +
                ", UPDATE_USER='" + UPDATE_USER + '\'' +
                ", UPDATE_TIME=" + UPDATE_TIME +
                ", REMARK='" + REMARK + '\'' +
                ", MERCHANT_ALTERNATE_NAME='" + MERCHANT_ALTERNATE_NAME + '\'' +
                ", GOODS_GROUP_CODE='" + GOODS_GROUP_CODE + '\'' +
                ", STORE_GROUP_CODE='" + STORE_GROUP_CODE + '\'' +
                ", GOODS_MARKETING_FLAG='" + GOODS_MARKETING_FLAG + '\'' +
                ", STORE_MARKETING_FLAG='" + STORE_MARKETING_FLAG + '\'' +
                '}';
    }
}
