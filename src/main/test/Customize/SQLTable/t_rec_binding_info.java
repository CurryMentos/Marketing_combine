package Customize.SQLTable;

import java.sql.Date;

/**
 * Created by zengyouzu on 2019/9/18.
 * 推荐人工具信息表字段
 */
public class t_rec_binding_info {
    private long ID;
    private Date CREATED_AT;
    private String CREATED_BY;
    private Date UPDATED_AT;
    private String UPDATED_BY;
    private String REMARKS;
    private String TOOL_ID;
    private String TOOL_TYPE;
    private String TOOL_NAME;
    private String ACTIVITY_ID;
    private String ACTIVITY_TYPE;
    private String ACTIVITY_NAME;
    private String REC_OPERATION;
    private String REC_LOGIN_NO;
    private String REC_CONTRACT_NO;
    private String REC_CUSTOMER_NO;
    private String REC_NAME;
    private String RECOMMENDED_OPERATION;
    private String RECOMMENDED_LOGIN_NO;
    private String RECOMMENDED_CONTRACT_NO;
    private String RECOMMENDED_CUSTOMER_NO;
    private String RECOMMENDED_NAME;
    private String RECOMMENDED_DEVICE_NO;
    private String STATUS;
    private String REBATE_TRIGGER_TYPE;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Date getCREATED_AT() {
        return CREATED_AT;
    }

    public void setCREATED_AT(Date CREATED_AT) {
        this.CREATED_AT = CREATED_AT;
    }

    public String getCREATED_BY() {
        return CREATED_BY;
    }

    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    public Date getUPDATED_AT() {
        return UPDATED_AT;
    }

    public void setUPDATED_AT(Date UPDATED_AT) {
        this.UPDATED_AT = UPDATED_AT;
    }

    public String getUPDATED_BY() {
        return UPDATED_BY;
    }

    public void setUPDATED_BY(String UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
    }

    public String getREMARKS() {
        return REMARKS;
    }

    public void setREMARKS(String REMARKS) {
        this.REMARKS = REMARKS;
    }

    public String getTOOL_ID() {
        return TOOL_ID;
    }

    public void setTOOL_ID(String TOOL_ID) {
        this.TOOL_ID = TOOL_ID;
    }

    public String getTOOL_TYPE() {
        return TOOL_TYPE;
    }

    public void setTOOL_TYPE(String TOOL_TYPE) {
        this.TOOL_TYPE = TOOL_TYPE;
    }

    public String getTOOL_NAME() {
        return TOOL_NAME;
    }

    public void setTOOL_NAME(String TOOL_NAME) {
        this.TOOL_NAME = TOOL_NAME;
    }

    public String getACTIVITY_ID() {
        return ACTIVITY_ID;
    }

    public void setACTIVITY_ID(String ACTIVITY_ID) {
        this.ACTIVITY_ID = ACTIVITY_ID;
    }

    public String getACTIVITY_TYPE() {
        return ACTIVITY_TYPE;
    }

    public void setACTIVITY_TYPE(String ACTIVITY_TYPE) {
        this.ACTIVITY_TYPE = ACTIVITY_TYPE;
    }

    public String getACTIVITY_NAME() {
        return ACTIVITY_NAME;
    }

    public void setACTIVITY_NAME(String ACTIVITY_NAME) {
        this.ACTIVITY_NAME = ACTIVITY_NAME;
    }

    public String getREC_OPERATION() {
        return REC_OPERATION;
    }

    public void setREC_OPERATION(String REC_OPERATION) {
        this.REC_OPERATION = REC_OPERATION;
    }

    public String getREC_LOGIN_NO() {
        return REC_LOGIN_NO;
    }

    public void setREC_LOGIN_NO(String REC_LOGIN_NO) {
        this.REC_LOGIN_NO = REC_LOGIN_NO;
    }

    public String getREC_CONTRACT_NO() {
        return REC_CONTRACT_NO;
    }

    public void setREC_CONTRACT_NO(String REC_CONTRACT_NO) {
        this.REC_CONTRACT_NO = REC_CONTRACT_NO;
    }

    public String getREC_CUSTOMER_NO() {
        return REC_CUSTOMER_NO;
    }

    public void setREC_CUSTOMER_NO(String REC_CUSTOMER_NO) {
        this.REC_CUSTOMER_NO = REC_CUSTOMER_NO;
    }

    public String getREC_NAME() {
        return REC_NAME;
    }

    public void setREC_NAME(String REC_NAME) {
        this.REC_NAME = REC_NAME;
    }

    public String getRECOMMENDED_OPERATION() {
        return RECOMMENDED_OPERATION;
    }

    public void setRECOMMENDED_OPERATION(String RECOMMENDED_OPERATION) {
        this.RECOMMENDED_OPERATION = RECOMMENDED_OPERATION;
    }

    public String getRECOMMENDED_LOGIN_NO() {
        return RECOMMENDED_LOGIN_NO;
    }

    public void setRECOMMENDED_LOGIN_NO(String RECOMMENDED_LOGIN_NO) {
        this.RECOMMENDED_LOGIN_NO = RECOMMENDED_LOGIN_NO;
    }

    public String getRECOMMENDED_CONTRACT_NO() {
        return RECOMMENDED_CONTRACT_NO;
    }

    public void setRECOMMENDED_CONTRACT_NO(String RECOMMENDED_CONTRACT_NO) {
        this.RECOMMENDED_CONTRACT_NO = RECOMMENDED_CONTRACT_NO;
    }

    public String getRECOMMENDED_CUSTOMER_NO() {
        return RECOMMENDED_CUSTOMER_NO;
    }

    public void setRECOMMENDED_CUSTOMER_NO(String RECOMMENDED_CUSTOMER_NO) {
        this.RECOMMENDED_CUSTOMER_NO = RECOMMENDED_CUSTOMER_NO;
    }

    public String getRECOMMENDED_NAME() {
        return RECOMMENDED_NAME;
    }

    public void setRECOMMENDED_NAME(String RECOMMENDED_NAME) {
        this.RECOMMENDED_NAME = RECOMMENDED_NAME;
    }

    public String getRECOMMENDED_DEVICE_NO() {
        return RECOMMENDED_DEVICE_NO;
    }

    public void setRECOMMENDED_DEVICE_NO(String RECOMMENDED_DEVICE_NO) {
        this.RECOMMENDED_DEVICE_NO = RECOMMENDED_DEVICE_NO;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getREBATE_TRIGGER_TYPE() {
        return REBATE_TRIGGER_TYPE;
    }

    public void setREBATE_TRIGGER_TYPE(String REBATE_TRIGGER_TYPE) {
        this.REBATE_TRIGGER_TYPE = REBATE_TRIGGER_TYPE;
    }
}
