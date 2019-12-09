package Customize.SQLTable.Oracle;

import java.util.Date;

/**
 * Created by zhangtianyu on 2017/11/3.
 * ÇþµÀ±í
 */

public class T_MARKET_CHANNEL_RELATION {

    private String RECORD_NO;
    private String MARKET_CFG_ID;
    private String TXN_CHANNEL;
    private String VALID_FLAG;
    private Date CREATE_TIME;
    private String CREATE_USER_ID;
    private Long CHECK_FLAG;
    private Date CHECK_TIME;
    private String CHECK_USER;
    private String MODY_USER;
    private Date UPDATE_TIME;
    private String REMARK;

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

    public String getTXN_CHANNEL() {
        return TXN_CHANNEL;
    }

    public void setTXN_CHANNEL(String TXN_CHANNEL) {
        this.TXN_CHANNEL = TXN_CHANNEL;
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

    public Long getCHECK_FLAG() {
        return CHECK_FLAG;
    }

    public void setCHECK_FLAG(Long CHECK_FLAG) {
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

    public String getMODY_USER() {
        return MODY_USER;
    }

    public void setMODY_USER(String MODY_USER) {
        this.MODY_USER = MODY_USER;
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
}
