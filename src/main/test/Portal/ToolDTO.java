package Portal;

import com.bestpay.marketing.config.api.activity.models.request.ApplyAttachmentReqDTO;
import com.bestpay.marketing.config.api.tools.request.*;

/**
 * Created by zengyouzu on 2019/9/9.
 */
public class ToolDTO {
    private ApplyToolRecommendBasicInfoReqDTO applyToolRecommendBasicInfoReqDTO;
    private ApplyRecommendRuleReqDTO applyRecommendRuleReqDTO;
    private ApplyRecommendPreferentialReqDTO applyRecommendPreferentialReqDTO;
    private ApplyRecommendedRuleReqDTO applyRecommendedRuleReqDTO;
    private ApplyAttachmentReqDTO applyAttachmentReqDTO;

    private String ToolId;
    private String ApplyId;

    public ApplyToolRecommendBasicInfoReqDTO getApplyToolRecommendBasicInfoReqDTO() {
        return applyToolRecommendBasicInfoReqDTO;
    }

    public void setApplyToolRecommendBasicInfoReqDTO(ApplyToolRecommendBasicInfoReqDTO applyToolRecommendBasicInfoReqDTO) {
        this.applyToolRecommendBasicInfoReqDTO = applyToolRecommendBasicInfoReqDTO;
    }

    public ApplyRecommendRuleReqDTO getApplyRecommendRuleReqDTO() {
        return applyRecommendRuleReqDTO;
    }

    public void setApplyRecommendRuleReqDTO(ApplyRecommendRuleReqDTO applyRecommendRuleReqDTO) {
        this.applyRecommendRuleReqDTO = applyRecommendRuleReqDTO;
    }

    public ApplyRecommendPreferentialReqDTO getApplyRecommendPreferentialReqDTO() {
        return applyRecommendPreferentialReqDTO;
    }

    public void setApplyRecommendPreferentialReqDTO(ApplyRecommendPreferentialReqDTO applyRecommendPreferentialReqDTO) {
        this.applyRecommendPreferentialReqDTO = applyRecommendPreferentialReqDTO;
    }

    public ApplyRecommendedRuleReqDTO getApplyRecommendedRuleReqDTO() {
        return applyRecommendedRuleReqDTO;
    }

    public void setApplyRecommendedRuleReqDTO(ApplyRecommendedRuleReqDTO applyRecommendedRuleReqDTO) {
        this.applyRecommendedRuleReqDTO = applyRecommendedRuleReqDTO;
    }

    public ApplyAttachmentReqDTO getApplyAttachmentReqDTO() {
        return applyAttachmentReqDTO;
    }

    public void setApplyAttachmentReqDTO(ApplyAttachmentReqDTO applyAttachmentReqDTO) {
        this.applyAttachmentReqDTO = applyAttachmentReqDTO;
    }

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
}
