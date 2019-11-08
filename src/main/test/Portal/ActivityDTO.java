package Portal;

import com.xx.marketing.config.api.activity.models.request.*;

import java.io.Serializable;

/**
 * Created by zengyouzu on 2019/9/9.
 */
public class ActivityDTO implements Serializable {
    private ApplyActivityBasicInfoReqDTO activityBasicInfoApplyReqDTO;
    private ApplyActivityRuleReqDTO activityRuleApplyReqDTO;
    private ApplyLimitRuleReqDTO limitRuleReqDTO;
    private ApplyPreferentialReqDTO preferentialApplyReqDTO;
    private ApplyActivityShowReqDTO activityShowShopApplyReqDTO;
    private ApplyAttachmentReqDTO applyAttachmentReqDTO;

    public ApplyActivityBasicInfoReqDTO getActivityBasicInfoApplyReqDTO() {
        return activityBasicInfoApplyReqDTO;
    }

    public void setActivityBasicInfoApplyReqDTO(ApplyActivityBasicInfoReqDTO activityBasicInfoApplyReqDTO) {
        this.activityBasicInfoApplyReqDTO = activityBasicInfoApplyReqDTO;
    }

    public ApplyActivityRuleReqDTO getActivityRuleApplyReqDTO() {
        return activityRuleApplyReqDTO;
    }

    public void setActivityRuleApplyReqDTO(ApplyActivityRuleReqDTO activityRuleApplyReqDTO) {
        this.activityRuleApplyReqDTO = activityRuleApplyReqDTO;
    }

    public ApplyLimitRuleReqDTO getLimitRuleReqDTO() {
        return limitRuleReqDTO;
    }

    public void setLimitRuleReqDTO(ApplyLimitRuleReqDTO limitRuleReqDTO) {
        this.limitRuleReqDTO = limitRuleReqDTO;
    }

    public ApplyPreferentialReqDTO getPreferentialApplyReqDTO() {
        return preferentialApplyReqDTO;
    }

    public void setPreferentialApplyReqDTO(ApplyPreferentialReqDTO preferentialApplyReqDTO) {
        this.preferentialApplyReqDTO = preferentialApplyReqDTO;
    }

    public ApplyActivityShowReqDTO getActivityShowShopApplyReqDTO() {
        return activityShowShopApplyReqDTO;
    }

    public void setActivityShowShopApplyReqDTO(ApplyActivityShowReqDTO activityShowShopApplyReqDTO) {
        this.activityShowShopApplyReqDTO = activityShowShopApplyReqDTO;
    }

    public ApplyAttachmentReqDTO getApplyAttachmentReqDTO() {
        return applyAttachmentReqDTO;
    }

    public void setApplyAttachmentReqDTO(ApplyAttachmentReqDTO applyAttachmentReqDTO) {
        this.applyAttachmentReqDTO = applyAttachmentReqDTO;
    }
}
