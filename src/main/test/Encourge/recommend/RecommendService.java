package Encourge.recommend;

import java.util.Map;

/**
 * Created by zengyouzu on 2019/9/7.
 */
public class RecommendService {
    private String ToolId;
    private String ApplyId;
    private String ActvityId;
    private String ToolName;
    private String Province;
    private String ProductNo;
    private String RecommendProductNo;
    private String RecommendUrl;
    private Map BindingInfoMap;
    private Map TradeProductMap;

    public String getToolId() {
        return ToolId;
    }

    public void setToolId(String toolId) {
        ToolId = toolId;
    }

    public String getApplyId() {
        return ApplyId;
    }

    public void setApplyId(String applyId) {
        ApplyId = applyId;
    }

    public String getActvityId() {
        return ActvityId;
    }

    public void setActvityId(String actvityId) {
        ActvityId = actvityId;
    }

    public String getToolName() {
        return ToolName;
    }

    public void setToolName(String toolName) {
        ToolName = toolName;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getProductNo() {
        return ProductNo;
    }

    public void setProductNo(String productNo) {
        ProductNo = productNo;
    }

    public String getRecommendProductNo() {
        return RecommendProductNo;
    }

    public void setRecommendProductNo(String recommendProductNo) {
        RecommendProductNo = recommendProductNo;
    }

    public String getRecommendUrl() {
        return RecommendUrl;
    }

    public void setRecommendUrl(String recommendUrl) {
        RecommendUrl = recommendUrl;
    }

    public Map getBindingInfoMap() {
        return BindingInfoMap;
    }

    public void setBindingInfoMap(Map bindingInfoMap) {
        BindingInfoMap = bindingInfoMap;
    }

    public Map getTradeProductMap() {
        return TradeProductMap;
    }

    public void setTradeProductMap(Map tradeProductMap) {
        TradeProductMap = tradeProductMap;
    }
}
