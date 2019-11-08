package Customize.SQLTable;

import java.sql.Date;

/**
 * Created by zengyouzu on 2019/9/26.
 */
public class t_bal_person_unwithdraw {
    private long ID;
    private String ACCOUNT_TYPE;
    private String ACCOUNT_NO;
    private String CONTRACT_NO;
    private String CCY;
    private long CURR_BAL;
    private long FREEZE_AMT;
    private long AVAILABLE_BAL;
    private Date ACC_DATE;
    private long LAST_PERIOD_BAL;
    private long CURR_PERIOD_BAL;
    private String SETTLE_BRANCH;
    private String ACC_ATTRIBUTE;
    private String ACC_NATURE;
    private String DRCR_FLAG;
    private String STATUS;
    private String AREA_CODE;
    private Date CREATED_AT;
    private String CREATED_BY;
    private Date UPDATED_AT;
    private String UPDATED_BY;
    private String LAST_DAY_NATURE;
    private String PAYESU_NO;
    private String PAYESU_NATURE;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getACCOUNT_TYPE() {
        return ACCOUNT_TYPE;
    }

    public void setACCOUNT_TYPE(String ACCOUNT_TYPE) {
        this.ACCOUNT_TYPE = ACCOUNT_TYPE;
    }

    public String getACCOUNT_NO() {
        return ACCOUNT_NO;
    }

    public void setACCOUNT_NO(String ACCOUNT_NO) {
        this.ACCOUNT_NO = ACCOUNT_NO;
    }

    public String getCONTRACT_NO() {
        return CONTRACT_NO;
    }

    public void setCONTRACT_NO(String CONTRACT_NO) {
        this.CONTRACT_NO = CONTRACT_NO;
    }

    public String getCCY() {
        return CCY;
    }

    public void setCCY(String CCY) {
        this.CCY = CCY;
    }

    public long getCURR_BAL() {
        return CURR_BAL;
    }

    public void setCURR_BAL(long CURR_BAL) {
        this.CURR_BAL = CURR_BAL;
    }

    public long getFREEZE_AMT() {
        return FREEZE_AMT;
    }

    public void setFREEZE_AMT(long FREEZE_AMT) {
        this.FREEZE_AMT = FREEZE_AMT;
    }

    public long getAVAILABLE_BAL() {
        return AVAILABLE_BAL;
    }

    public void setAVAILABLE_BAL(long AVAILABLE_BAL) {
        this.AVAILABLE_BAL = AVAILABLE_BAL;
    }

    public Date getACC_DATE() {
        return ACC_DATE;
    }

    public void setACC_DATE(Date ACC_DATE) {
        this.ACC_DATE = ACC_DATE;
    }

    public long getLAST_PERIOD_BAL() {
        return LAST_PERIOD_BAL;
    }

    public void setLAST_PERIOD_BAL(long LAST_PERIOD_BAL) {
        this.LAST_PERIOD_BAL = LAST_PERIOD_BAL;
    }

    public long getCURR_PERIOD_BAL() {
        return CURR_PERIOD_BAL;
    }

    public void setCURR_PERIOD_BAL(long CURR_PERIOD_BAL) {
        this.CURR_PERIOD_BAL = CURR_PERIOD_BAL;
    }

    public String getSETTLE_BRANCH() {
        return SETTLE_BRANCH;
    }

    public void setSETTLE_BRANCH(String SETTLE_BRANCH) {
        this.SETTLE_BRANCH = SETTLE_BRANCH;
    }

    public String getACC_ATTRIBUTE() {
        return ACC_ATTRIBUTE;
    }

    public void setACC_ATTRIBUTE(String ACC_ATTRIBUTE) {
        this.ACC_ATTRIBUTE = ACC_ATTRIBUTE;
    }

    public String getACC_NATURE() {
        return ACC_NATURE;
    }

    public void setACC_NATURE(String ACC_NATURE) {
        this.ACC_NATURE = ACC_NATURE;
    }

    public String getDRCR_FLAG() {
        return DRCR_FLAG;
    }

    public void setDRCR_FLAG(String DRCR_FLAG) {
        this.DRCR_FLAG = DRCR_FLAG;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getAREA_CODE() {
        return AREA_CODE;
    }

    public void setAREA_CODE(String AREA_CODE) {
        this.AREA_CODE = AREA_CODE;
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

    public String getLAST_DAY_NATURE() {
        return LAST_DAY_NATURE;
    }

    public void setLAST_DAY_NATURE(String LAST_DAY_NATURE) {
        this.LAST_DAY_NATURE = LAST_DAY_NATURE;
    }

    public String getPAYESU_NO() {
        return PAYESU_NO;
    }

    public void setPAYESU_NO(String PAYESU_NO) {
        this.PAYESU_NO = PAYESU_NO;
    }

    public String getPAYESU_NATURE() {
        return PAYESU_NATURE;
    }

    public void setPAYESU_NATURE(String PAYESU_NATURE) {
        this.PAYESU_NATURE = PAYESU_NATURE;
    }
}
