package Customize.SQLTable.Oracle;

import java.util.Date;

/**
 * Created by chukaimin on 2017/11/3.
 *返利规则表
 */
public class T_MARKET_REBATE_TYPE {

    private String RECORD_NO;
    private String REBATE_CODE_ID;//必填,返利ID
    private Long MIN_TXN_AMT;//最低消费金额
    private Long MAX_TXN_AMT;//最高消费金额
    private Long MIN_REBATE_AMT;//返利每笔最小金额
    private Long MAX_REBATE_AMT;//返利每笔最大金额
    private Long TXN_COUNT_STEP;//笔数分阶
    private Long TXN_AMOUNT_STEP;//金额分阶
    private Long CALC_TYPE;//必填,返利计算方式:按比例返利(2),固定金额返利(1)
    private Long BASIC_AMT;//返利基数
    private String REBATE_PERCENTAGE;//返利百分比
    private Long FIXED_AMT;//固定返利金额
    private String REBATE_TYPE_DESC;//返利类型描述
    private String EFF_DATE;//生效时间
    private String EXP_DATE;//失效时间
    private Date CREATE_TIME;
    private String CREATE_USER_ID;
    private Long CHECK_FLAG;//审核标志
    private Date CHECK_TIME;
    private String CHECK_USER;
    private String UPDATE_USER;
    private Date UPDATE_TIME;
    private String REMARK;//备注
    private Long UPPER_AMT;//固返随机最大金额
    private Long LOWER_AMT;//固返随机最小金额
    private String MARKET_CFG_ID;//对应营销活动编号
    private String REBATE_LEVEL;//返利力度:1低,2中,3高

    public String getRECORD_NO() {
        return RECORD_NO;
    }

    public void setRECORD_NO(String RECORD_NO) {
        this.RECORD_NO = RECORD_NO;
    }

    public String getREBATE_CODE_ID() {
        return REBATE_CODE_ID;
    }

    public void setREBATE_CODE_ID(String REBATE_CODE_ID) {
        this.REBATE_CODE_ID = REBATE_CODE_ID;
    }

    public Long getMIN_TXN_AMT() {
        return MIN_TXN_AMT;
    }

    public void setMIN_TXN_AMT(Long MIN_TXN_AMT) {
        this.MIN_TXN_AMT = MIN_TXN_AMT;
    }

    public Long getMAX_TXN_AMT() {
        return MAX_TXN_AMT;
    }

    public void setMAX_TXN_AMT(Long MAX_TXN_AMT) {
        this.MAX_TXN_AMT = MAX_TXN_AMT;
    }

    public Long getMIN_REBATE_AMT() {
        return MIN_REBATE_AMT;
    }

    public void setMIN_REBATE_AMT(Long MIN_REBATE_AMT) {
        this.MIN_REBATE_AMT = MIN_REBATE_AMT;
    }

    public Long getMAX_REBATE_AMT() {
        return MAX_REBATE_AMT;
    }

    public void setMAX_REBATE_AMT(Long MAX_REBATE_AMT) {
        this.MAX_REBATE_AMT = MAX_REBATE_AMT;
    }

    public Long getTXN_COUNT_STEP() {
        return TXN_COUNT_STEP;
    }

    public void setTXN_COUNT_STEP(Long TXN_COUNT_STEP) {
        this.TXN_COUNT_STEP = TXN_COUNT_STEP;
    }

    public Long getTXN_AMOUNT_STEP() {
        return TXN_AMOUNT_STEP;
    }

    public void setTXN_AMOUNT_STEP(Long TXN_AMOUNT_STEP) {
        this.TXN_AMOUNT_STEP = TXN_AMOUNT_STEP;
    }

    public Long getCALC_TYPE() {
        return CALC_TYPE;
    }

    public void setCALC_TYPE(Long CALC_TYPE) {
        this.CALC_TYPE = CALC_TYPE;
    }

    public Long getBASIC_AMT() {
        return BASIC_AMT;
    }

    public void setBASIC_AMT(Long BASIC_AMT) {
        this.BASIC_AMT = BASIC_AMT;
    }

    public String getREBATE_PERCENTAGE() {
        return REBATE_PERCENTAGE;
    }

    public void setREBATE_PERCENTAGE(String REBATE_PERCENTAGE) {
        this.REBATE_PERCENTAGE = REBATE_PERCENTAGE;
    }

    public Long getFIXED_AMT() {
        return FIXED_AMT;
    }

    public void setFIXED_AMT(Long FIXED_AMT) {
        this.FIXED_AMT = FIXED_AMT;
    }

    public String getREBATE_TYPE_DESC() {
        return REBATE_TYPE_DESC;
    }

    public void setREBATE_TYPE_DESC(String REBATE_TYPE_DESC) {
        this.REBATE_TYPE_DESC = REBATE_TYPE_DESC;
    }

    public String getEFF_DATE() {
        return EFF_DATE;
    }

    public void setEFF_DATE(String EFF_DATE) {
        this.EFF_DATE = EFF_DATE;
    }

    public String getEXP_DATE() {
        return EXP_DATE;
    }

    public void setEXP_DATE(String EXP_DATE) {
        this.EXP_DATE = EXP_DATE;
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

    public Long getUPPER_AMT() {
        return UPPER_AMT;
    }

    public void setUPPER_AMT(Long UPPER_AMT) {
        this.UPPER_AMT = UPPER_AMT;
    }

    public Long getLOWER_AMT() {
        return LOWER_AMT;
    }

    public void setLOWER_AMT(Long LOWER_AMT) {
        this.LOWER_AMT = LOWER_AMT;
    }

    public String getMARKET_CFG_ID() {
        return MARKET_CFG_ID;
    }

    public void setMARKET_CFG_ID(String MARKET_CFG_ID) {
        this.MARKET_CFG_ID = MARKET_CFG_ID;
    }

    public String getREBATE_LEVEL() {
        return REBATE_LEVEL;
    }

    public void setREBATE_LEVEL(String REBATE_LEVEL) {
        this.REBATE_LEVEL = REBATE_LEVEL;
    }
}
