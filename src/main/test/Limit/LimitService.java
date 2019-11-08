package Limit;

import java.util.Date;

/**
 * Created by zengyouzu on 2019/8/6.
 */
public class LimitService {
    private String LimitType;
    private String LimitMainNo;
    private String ActivityId;
    private String EquityId;
    private String ToolId;
    private String AddRequestNo;
    private String CanRequestNo;
    private String RequestSystem;
    private Date AddRequestDate;
    private Date CanRequestDate;
    private String ProductNo;
    private String MerchantNo;
    private String ContralNo;
    private String CustomerNo;
    private String DeviceNo;
    private String UserMerchantNo;
    private Date LimitMainNoStartDate;
    //单次笔数金额限额(随累加次数增加)
    private long LimitMainNoSumCnt = 1L;
    private long LimitMainNoSumAmt = 2L;
    //用户日月周期笔数金额限额(-1L不限,不会入用户限额表,必须大于单次笔数金额限额,不随累加次数增加)
    private long DayLimitCnt = 100L;
    private long DayLimitAmt = 100L;
    private long MonthLimitCnt = 100L;
    private long MonthLimitAmt = 100L;
    private long LimitCnt = 100L;
    private long LimitAmt = 100L;
    //活动总笔数金额限额(-1L不限,必须大于Redis中已用名额和用户限额之和)
    private long ActivityDayLimitCnt = 1000000L;
    private long ActivityDayLimitAmt = 1000000L;
    private long ActivityMonthLimitCnt = 1000000L;
    private long ActivityMonthLimitAmt = 1000000L;
    private long ActivityLimitCnt = 1000000L;
    private long ActivityLimitAmt = 1000000L;
    //权益笔数金额限额
    private long TotalCnt = 100000L;
    private long TotalAmt = 100000L;
    private long SumCnt = 10000L;
    private long SumAmt = 10000L;

    public String getLimitType() {
        return LimitType;
    }

    public void setLimitType(String limitType) {
        LimitType = limitType;
    }

    public String getLimitMainNo() {
        return LimitMainNo;
    }

    public void setLimitMainNo(String limitMainNo) {
        LimitMainNo = limitMainNo;
    }

    public String getActivityId() {
        return ActivityId;
    }

    public void setActivityId(String activityId) {
        ActivityId = activityId;
    }

    public String getEquityId() {
        return EquityId;
    }

    public void setEquityId(String equityId) {
        EquityId = equityId;
    }

    public String getToolId() {
        return ToolId;
    }

    public void setToolId(String toolId) {
        ToolId = toolId;
    }

    public String getAddRequestNo() {
        return AddRequestNo;
    }

    public void setAddRequestNo(String addRequestNo) {
        AddRequestNo = addRequestNo;
    }

    public String getCanRequestNo() {
        return CanRequestNo;
    }

    public void setCanRequestNo(String canRequestNo) {
        CanRequestNo = canRequestNo;
    }

    public String getRequestSystem() {
        return RequestSystem;
    }

    public void setRequestSystem(String requestSystem) {
        RequestSystem = requestSystem;
    }

    public Date getAddRequestDate() {
        return AddRequestDate;
    }

    public void setAddRequestDate(Date addRequestDate) {
        AddRequestDate = addRequestDate;
    }

    public Date getCanRequestDate() {
        return CanRequestDate;
    }

    public void setCanRequestDate(Date canRequestDate) {
        CanRequestDate = canRequestDate;
    }

    public String getProductNo() {
        return ProductNo;
    }

    public void setProductNo(String productNo) {
        ProductNo = productNo;
    }

    public String getMerchantNo() {
        return MerchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        MerchantNo = merchantNo;
    }

    public String getContralNo() {
        return ContralNo;
    }

    public void setContralNo(String contralNo) {
        ContralNo = contralNo;
    }

    public String getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(String customerNo) {
        CustomerNo = customerNo;
    }

    public String getDeviceNo() {
        return DeviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        DeviceNo = deviceNo;
    }

    public String getUserMerchantNo() {
        return UserMerchantNo;
    }

    public void setUserMerchantNo(String userMerchantNo) {
        UserMerchantNo = userMerchantNo;
    }

    public Date getLimitMainNoStartDate() {
        return LimitMainNoStartDate;
    }

    public void setLimitMainNoStartDate(Date limitMainNoStartDate) {
        LimitMainNoStartDate = limitMainNoStartDate;
    }

    public long getLimitMainNoSumCnt() {
        return LimitMainNoSumCnt;
    }

    public void setLimitMainNoSumCnt(long limitMainNoSumCnt) {
        LimitMainNoSumCnt = limitMainNoSumCnt;
    }

    public long getLimitMainNoSumAmt() {
        return LimitMainNoSumAmt;
    }

    public void setLimitMainNoSumAmt(long limitMainNoSumAmt) {
        LimitMainNoSumAmt = limitMainNoSumAmt;
    }

    public long getDayLimitCnt() {
        return DayLimitCnt;
    }

    public void setDayLimitCnt(long dayLimitCnt) {
        DayLimitCnt = dayLimitCnt;
    }

    public long getDayLimitAmt() {
        return DayLimitAmt;
    }

    public void setDayLimitAmt(long dayLimitAmt) {
        DayLimitAmt = dayLimitAmt;
    }

    public long getMonthLimitCnt() {
        return MonthLimitCnt;
    }

    public void setMonthLimitCnt(long monthLimitCnt) {
        MonthLimitCnt = monthLimitCnt;
    }

    public long getMonthLimitAmt() {
        return MonthLimitAmt;
    }

    public void setMonthLimitAmt(long monthLimitAmt) {
        MonthLimitAmt = monthLimitAmt;
    }

    public long getLimitCnt() {
        return LimitCnt;
    }

    public void setLimitCnt(long limitCnt) {
        LimitCnt = limitCnt;
    }

    public long getLimitAmt() {
        return LimitAmt;
    }

    public void setLimitAmt(long limitAmt) {
        LimitAmt = limitAmt;
    }

    public long getActivityDayLimitCnt() {
        return ActivityDayLimitCnt;
    }

    public void setActivityDayLimitCnt(long activityDayLimitCnt) {
        ActivityDayLimitCnt = activityDayLimitCnt;
    }

    public long getActivityDayLimitAmt() {
        return ActivityDayLimitAmt;
    }

    public void setActivityDayLimitAmt(long activityDayLimitAmt) {
        ActivityDayLimitAmt = activityDayLimitAmt;
    }

    public long getActivityMonthLimitCnt() {
        return ActivityMonthLimitCnt;
    }

    public void setActivityMonthLimitCnt(long activityMonthLimitCnt) {
        ActivityMonthLimitCnt = activityMonthLimitCnt;
    }

    public long getActivityMonthLimitAmt() {
        return ActivityMonthLimitAmt;
    }

    public void setActivityMonthLimitAmt(long activityMonthLimitAmt) {
        ActivityMonthLimitAmt = activityMonthLimitAmt;
    }

    public long getActivityLimitCnt() {
        return ActivityLimitCnt;
    }

    public void setActivityLimitCnt(long activityLimitCnt) {
        ActivityLimitCnt = activityLimitCnt;
    }

    public long getActivityLimitAmt() {
        return ActivityLimitAmt;
    }

    public void setActivityLimitAmt(long activityLimitAmt) {
        ActivityLimitAmt = activityLimitAmt;
    }

    public long getTotalCnt() {
        return TotalCnt;
    }

    public void setTotalCnt(long totalCnt) {
        TotalCnt = totalCnt;
    }

    public long getTotalAmt() {
        return TotalAmt;
    }

    public void setTotalAmt(long totalAmt) {
        TotalAmt = totalAmt;
    }

    public long getSumCnt() {
        return SumCnt;
    }

    public void setSumCnt(long sumCnt) {
        SumCnt = sumCnt;
    }

    public long getSumAmt() {
        return SumAmt;
    }

    public void setSumAmt(long sumAmt) {
        SumAmt = sumAmt;
    }
}
