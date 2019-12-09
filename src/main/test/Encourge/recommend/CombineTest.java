package Encourge.recommend;

import Customize.DataGenerate;
import Customize.UserList;
import Portal.CustomizedService;
import Portal.Preset;
import Portal.ToolDTO;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.activity.operation.api.ActivityQueryService;
import com.bestpay.marketing.activity.operation.api.models.request.CheckActivityQuotaReqDTO;
import com.bestpay.marketing.activity.operation.api.models.request.CheckActivitySoftRuleReqDTO;
import com.bestpay.marketing.activity.operation.api.models.request.QueryCompatibleActivityListReqDTO;
import com.bestpay.marketing.activity.operation.api.models.request.QueryValidActivityReqDTO;
import com.bestpay.marketing.activity.operation.api.models.response.ApplicableActivityResDTO;
import com.bestpay.marketing.activity.operation.api.models.response.CheckActivityResDTO;
import com.bestpay.marketing.config.api.enums.*;
import com.bestpay.marketing.config.api.tools.ToolRecommendService;
import com.bestpay.marketing.config.api.tools.request.ApplyToolRecommendReqDTO;
import com.bestpay.marketing.config.api.tools.response.ApplyToolRecommendResDTO;
import com.bestpay.marketing.recommend.api.RecBusinessService;
import com.bestpay.marketing.recommend.api.RecConfigService;
import com.bestpay.marketing.recommend.api.RecQueryService;
import com.bestpay.marketing.recommend.api.enums.RecJumpTypeEnum;
import com.bestpay.marketing.recommend.api.enums.RecSubThemeTypeEnum;
import com.bestpay.marketing.recommend.api.models.request.*;
import com.bestpay.marketing.recommend.api.models.response.*;
import com.bestpay.tradeproduct.service.acquiring.api.TradeProductRefundService;
import com.bestpay.tradeproduct.service.acquiring.api.TradeProductSeniorOrderService;
import com.bestpay.tradeproduct.service.acquiring.api.model.TradeProductCreateAndPayOrderReqDTO;
import com.bestpay.tradeproduct.service.acquiring.api.model.TradeProductRefundReqDTO;
import com.bestpay.tradeproduct.service.acquiring.api.model.result.TradeProductBaseResDTO;
import com.bestpay.tradeproduct.service.acquiring.api.model.result.TradeProductResDTO;
import com.google.gson.annotations.Until;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.*;


/**
 * Created by zengyouzu on 2019/9/11.
 */
public class CombineTest extends DataGenerate {
    public static RecommendService recommendService = new RecommendService();
    public static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    public static ToolRecommendService toolRecommendService = (ToolRecommendService) ac.getBean("toolRecommendService");
    public static RecConfigService recConfigService = (RecConfigService) ac.getBean("recConfigService");
    public static RecBusinessService recBusinessService = (RecBusinessService) ac.getBean("recBusinessService");
    public static RecQueryService recQueryService = (RecQueryService) ac.getBean("recQueryService");
    public static ActivityQueryService activityQueryService = (ActivityQueryService) ac.getBean("activityQueryService");
    public static TradeProductSeniorOrderService tradeProductSeniorOrderService = (TradeProductSeniorOrderService) ac.getBean("tradeProductSeniorOrderService");
    public static TradeProductRefundService tradeProductRefundService = (TradeProductRefundService) ac.getBean("tradeProductRefundService");


    //配置中心新建推荐人工具
    public static void addApplyToolRecommend() {
        CustomizedService customizedService = Preset.PresetTool();
        List<ToolDTO> toolDTOList = customizedService.getToolDTOList();
        ToolDTO toolDTO = new ToolDTO();
        for (int i = 0; i < toolDTOList.size(); i++) {
            toolDTO = toolDTOList.get(i);
        }

        ApplyToolRecommendReqDTO applyToolRecommendReqDTO = new ApplyToolRecommendReqDTO();
//        applyToolRecommendReqDTO.setApplyId("AI2770190916085832000001");//申请号
        applyToolRecommendReqDTO.setActionType(ActionTypeEnum.SUBMIT.getCode());//提交
//        applyToolRecommendReqDTO.setActionType(ActionTypeEnum.SAVE.getCode());//保存
        applyToolRecommendReqDTO.setApplyUser("DZHB_apply1");
        applyToolRecommendReqDTO.setApplyProvince("999900");
        applyToolRecommendReqDTO.setApplyCity("999901");
        applyToolRecommendReqDTO.setToolType(ToolTypeEnum.RECOMMEND.getCode());//推荐人工具
        applyToolRecommendReqDTO.setApplyChannel(ApplyChannelEnum.OMP.getCode());
//        applyToolRecommendReqDTO.setToolId("T30990190916085832000001");//工具号
        applyToolRecommendReqDTO.setApplyToolRecommendBasicInfoReqDTO(toolDTO.getApplyToolRecommendBasicInfoReqDTO());
        applyToolRecommendReqDTO.setApplyRecommendRuleReqDTO(toolDTO.getApplyRecommendRuleReqDTO());
        applyToolRecommendReqDTO.setApplyRecommendPreferentialReqDTO(toolDTO.getApplyRecommendPreferentialReqDTO());
        applyToolRecommendReqDTO.setApplyRecommendedRuleReqDTO(toolDTO.getApplyRecommendedRuleReqDTO());
//        applyToolRecommendReqDTO.setApplyAttachmentReqDTO(toolDTO.getApplyAttachmentReqDTO());
        applyToolRecommendReqDTO.setRequestNo("Req" + RandomStringNo());
        applyToolRecommendReqDTO.setRequestSystem("test");
        applyToolRecommendReqDTO.setRequestDate(new Date());
        applyToolRecommendReqDTO.setTraceLogId(TraceLogId());

        Result<ApplyToolRecommendResDTO> result = toolRecommendService.addApplyToolRecommend(applyToolRecommendReqDTO);
        System.out.println("********************推荐人工具申请********************");
        System.out.println("日志号:" + applyToolRecommendReqDTO.getTraceLogId());
        System.out.println("申请号:" + result.getResult().getApplyId());
        System.out.println("工具号:" + result.getResult().getToolId());
        System.out.println("活动号:" + result.getResult().getActivityId());
        System.out.println("请求流水:" + applyToolRecommendReqDTO.getRequestNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());

        recommendService.setToolId(result.getResult().getToolId());
        recommendService.setApplyId(result.getResult().getApplyId());
        recommendService.setActvityId(result.getResult().getActivityId());
    }

    //推荐人工具生效
    public static void recEffect() {
        String str = sdf + "推荐人工具";
        RecEffectReqDTO recEffectReqDTO = new RecEffectReqDTO();
        recEffectReqDTO.setToolId(recommendService.getToolId());
        recEffectReqDTO.setToolName(str);
        recEffectReqDTO.setToolDesc(str);
        recEffectReqDTO.setTitle(str);
        recEffectReqDTO.setTitleDesc(str);
        recEffectReqDTO.setThemeType(RecThemeTypeEnum.DEFAULT.getCode());
        recEffectReqDTO.setSubThemeType(RecSubThemeTypeEnum.GENERAL.getCode());
        recEffectReqDTO.setBackgroundPictureAddress("");
        recEffectReqDTO.setButtonPictureAddress("");
        recEffectReqDTO.setButtonName("");
        recEffectReqDTO.setJumpType(RecJumpTypeEnum.CHAINING.getCode());
        recEffectReqDTO.setJumpUrl("http://www.baidu.com");
        recEffectReqDTO.setActivityId("A" + RandomStringNo());
        recEffectReqDTO.setActivityType(ActivityTypeEnum.BUSINESS_REBATE.getCode());
        recEffectReqDTO.setActivityName(str);
        recEffectReqDTO.setToolRuleGroupId("TRG" + RandomStringNo());
        recEffectReqDTO.setStartTime(Start);
        recEffectReqDTO.setEndTime(End);
        recEffectReqDTO.setAdaptProvince("999900");

        Set CitySet = new HashSet<>();
        CitySet.add("999901");
        recEffectReqDTO.setAdaptCity(CitySet);

        Set PurposeSet = new HashSet<>();
        PurposeSet.add("");
        recEffectReqDTO.setPurpose(PurposeSet);

        recEffectReqDTO.setApplyEmail("123@qq.com");
        recEffectReqDTO.setApplyPhone(UserList.ContralNo());
        recEffectReqDTO.setApplyDepartment(ApplyDepartmentEnum.O2O.getCode());
        recEffectReqDTO.setRemarks("");
        recEffectReqDTO.setTraceLogId(TraceLogId());
        recEffectReqDTO.setRequestNo("Req" + RandomStringNo());
        recEffectReqDTO.setRequestSystem("test");
        recEffectReqDTO.setRequestDate(new Date());

        recommendService.setToolName(recEffectReqDTO.getToolName());
        recommendService.setProvince(recEffectReqDTO.getAdaptProvince());

        Result<Boolean> result = recConfigService.recEffect(recEffectReqDTO);
        System.out.println("********************推荐人工具生效********************");
        System.out.println("日志号:" + recEffectReqDTO.getTraceLogId());
        System.out.println("工具号:" + recEffectReqDTO.getToolId());
        System.out.println("活动号:" + recEffectReqDTO.getActivityId());
        System.out.println("请求流水:" + recEffectReqDTO.getRequestNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //推荐人工具变更
    public static void recModifyEffect() {
        RecModifyEffectReqDTO recModifyEffectReqDTO = new RecModifyEffectReqDTO();
        recModifyEffectReqDTO.setToolId(recommendService.getToolId());
        recModifyEffectReqDTO.setToolDesc("");
        recModifyEffectReqDTO.setTitle("");
        recModifyEffectReqDTO.setTitleDesc("");
        recModifyEffectReqDTO.setSubThemeType(RecSubThemeTypeEnum.GENERAL.getCode());
        recModifyEffectReqDTO.setBackgroundPictureAddress("");
        recModifyEffectReqDTO.setButtonPictureAddress("");
        recModifyEffectReqDTO.setButtonName("");
        recModifyEffectReqDTO.setJumpType("");
        recModifyEffectReqDTO.setJumpUrl("");
        recModifyEffectReqDTO.setEndTime(End);

        Set CitySet = new HashSet<>();
        CitySet.add("");
        recModifyEffectReqDTO.setAdaptCity(CitySet);

        recModifyEffectReqDTO.setRequestNo("Req" + RandomStringNo());
        recModifyEffectReqDTO.setRequestSystem("test");
        recModifyEffectReqDTO.setRequestDate(new Date());
        recModifyEffectReqDTO.setTraceLogId(TraceLogId());

        Result<Boolean> result = recConfigService.recModifyEffect(recModifyEffectReqDTO);
        System.out.println("********************推荐人工具变更********************");
        System.out.println("日志号:" + recModifyEffectReqDTO.getTraceLogId());
        System.out.println("工具号:" + recModifyEffectReqDTO.getToolId());
        System.out.println("请求流水:" + recModifyEffectReqDTO.getRequestNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //推荐人工具作废
    public static void recCancelEffect() {
        RecCancelEffectReqDTO recCancelEffectReqDTO = new RecCancelEffectReqDTO();
        recCancelEffectReqDTO.setToolId(recommendService.getToolId());
        recCancelEffectReqDTO.setTraceLogId(TraceLogId());

        Result<Boolean> result = recConfigService.recCancelEffect(recCancelEffectReqDTO);
        System.out.println("********************推荐人工具作废********************");
        System.out.println("日志号:" + recCancelEffectReqDTO.getTraceLogId());
        System.out.println("工具号:" + recCancelEffectReqDTO.getToolId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //推荐人立即邀请
    public static void recInviation() {
        RecInvitationReqDTO invitationReqDTO = new RecInvitationReqDTO();
        invitationReqDTO.setToolId(recommendService.getToolId());//工具ID
//        invitationReqDTO.setToolId("T30990190929163157000092");
        invitationReqDTO.setProductNo(UserList.ContralNo());//推荐人手机号
        invitationReqDTO.setTraceLogId(TraceLogId());

        recommendService.setProductNo(invitationReqDTO.getProductNo());

        Result<RecInvitationResDTO> result = recBusinessService.recInvitation(invitationReqDTO);
        System.out.println("********************立即邀请********************");
        System.out.println("日志号:" + invitationReqDTO.getTraceLogId());
        System.out.println("工具号:" + invitationReqDTO.getToolId());
        System.out.println("推荐人手机号:" + invitationReqDTO.getProductNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());

        recommendService.setRecommendUrl(result.getResult().getRecommendUrl());
    }

    //推荐人绑定
    public static void recBinding() {
        RecBindingReqDTO recBindingReqDTO = new RecBindingReqDTO();
        recBindingReqDTO.setRecommendUrl(recommendService.getRecommendUrl());//邀请链接
        recBindingReqDTO.setRecommendedProductNo(UserList.ContralNo());//被推荐人手机号
        recBindingReqDTO.setTraceLogId(TraceLogId());

        recommendService.setRecommendUrl(recBindingReqDTO.getRecommendUrl());
        recommendService.setRecommendProductNo(recBindingReqDTO.getRecommendedProductNo());

        Result<RecBindingResDTO> result = recBusinessService.recBinding(recBindingReqDTO);
        System.out.println("********************推荐人工具关系绑定********************");
        System.out.println("日志号:" + recBindingReqDTO.getTraceLogId());
        System.out.println("被推荐人手机号:" + recBindingReqDTO.getRecommendedProductNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //推荐人解绑
    public static void recUnBinding() {
        RecUnBindingReqDTO recUnBindingReqDTO = new RecUnBindingReqDTO();
        recUnBindingReqDTO.setProductNo(recommendService.getRecommendProductNo());//被推荐人手机号
        recUnBindingReqDTO.setTraceLogId(TraceLogId());

        Result<Boolean> result = recBusinessService.recUnBinding(recUnBindingReqDTO);
        System.out.println("********************推荐人工具关系解除绑定********************");
        System.out.println("日志号:" + recUnBindingReqDTO.getTraceLogId());
        System.out.println("被推荐人手机号:" + recUnBindingReqDTO.getProductNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //推荐人活动规则查询（活动详情）
    public static void queryRecActivityRuleDetail() {
        RecRuleDetailReqDTO recRuleDetailReqDTO = new RecRuleDetailReqDTO();
        recRuleDetailReqDTO.setToolId(recommendService.getToolId());//工具ID
        recRuleDetailReqDTO.setTraceLogId(TraceLogId());

        Result<RecToolRuleDetailResDTO> result = recQueryService.queryRecActivityRuleDetail(recRuleDetailReqDTO);
        System.out.println("********************推荐人活动详情规则查询********************");
        System.out.println("日志号:" + recRuleDetailReqDTO.getTraceLogId());
        System.out.println("工具号:" + recRuleDetailReqDTO.getToolId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //推荐人活动规则查询
    public static void queryRecRuleDetail() {
        RecRuleDetailReqDTO recRuleDetailReqDTO = new RecRuleDetailReqDTO();
        recRuleDetailReqDTO.setToolId(recommendService.getToolId());
        recRuleDetailReqDTO.setTraceLogId(TraceLogId());

        Result<RecRuleDetailResDTO> result = recQueryService.queryRecRuleDetail(recRuleDetailReqDTO);
        System.out.println("********************推荐人活动规则查询********************");
        System.out.println("日志号:" + recRuleDetailReqDTO.getTraceLogId());
        System.out.println("工具号:" + recRuleDetailReqDTO.getToolId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //被推荐人规则查询
    public static void queryRecToolRuleDetail() {
        RecToolRuleDetailReqDTO recToolRuleDetailReqDTO = new RecToolRuleDetailReqDTO();
        recToolRuleDetailReqDTO.setRecommendUrl(recommendService.getRecommendUrl());//邀请链接
        recToolRuleDetailReqDTO.setTraceLogId(TraceLogId());

        Result<RecToolRuleDetailResDTO> result = recQueryService.queryRecToolRuleDetail(recToolRuleDetailReqDTO);
        System.out.println("********************被推荐人规则查询********************");
        System.out.println("日志号:" + recToolRuleDetailReqDTO.getTraceLogId());
        System.out.println("邀请链接:" + recToolRuleDetailReqDTO.getRecommendUrl());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //推荐人工具详情页查询
    public static void queryRecToolsDetail() {
        RecToolDetailReqDTO recToolDetailReqDTO = new RecToolDetailReqDTO();
        recToolDetailReqDTO.setToolId(recommendService.getToolId());//工具ID
        recToolDetailReqDTO.setTraceLogId(TraceLogId());

        Result<RecToolDetailResDTO> result = recQueryService.queryRecToolsDetail(recToolDetailReqDTO);
        System.out.println("********************推荐人工具详情页查询********************");
        System.out.println("日志号:" + recToolDetailReqDTO.getTraceLogId());
        System.out.println("工具号:" + recToolDetailReqDTO.getToolId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //工具列表分页查询
    public static void queryRecToolsList() {
        RecToolsReqDTO recToolsReqDTO = new RecToolsReqDTO();
        recToolsReqDTO.setToolId(recommendService.getToolId());
        recToolsReqDTO.setToolName("");
        recToolsReqDTO.setAdaptProvince("");//适用省份
        recToolsReqDTO.setToolType("");//工具类型
        recToolsReqDTO.setStartStartTime(Start);//开始时间的开始时间
        recToolsReqDTO.setStartEndTime(StartEnd);//开始时间的结束时间
        recToolsReqDTO.setEndStartTime(EndStart);//结束时间的开始时间
        recToolsReqDTO.setEndEndTime(End);//结束时间的结束时间
//        recToolsReqDTO.setActivityState("");//活动状态
        recToolsReqDTO.setApplyDepartment("");//所属部门
        recToolsReqDTO.setPageSize(0);//每页显示条数
        recToolsReqDTO.setPageNo(0);//页码
        recToolsReqDTO.setTraceLogId(TraceLogId());

        Result<RecToolsResDTO> result = recQueryService.queryRecToolsList(recToolsReqDTO);
        System.out.println("********************工具列表分页查询********************");
        System.out.println("日志号:" + recToolsReqDTO.getTraceLogId());
        System.out.println("工具号:" + recToolsReqDTO.getToolId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //推荐人好友列表分页查询
    public static void recFriendsListQuery() {
        RecFriendsListQueryReqDTO recFriendsListQueryReqDTO = new RecFriendsListQueryReqDTO();
        recFriendsListQueryReqDTO.setToolId(recommendService.getToolId());
        recFriendsListQueryReqDTO.setProductNo(recommendService.getProductNo());
        recFriendsListQueryReqDTO.setPageSize(0);
        recFriendsListQueryReqDTO.setPageNo(0);
        recFriendsListQueryReqDTO.setTraceLogId(TraceLogId());

        Result<RecFriendsListQueryResDTO> result = recQueryService.recFriendsListQuery(recFriendsListQueryReqDTO);
        System.out.println("********************推荐人好友列表分页查询********************");
        System.out.println("日志号:" + recFriendsListQueryReqDTO.getTraceLogId());
        System.out.println("工具号:" + recFriendsListQueryReqDTO.getToolId());
        System.out.println("推荐人手机号:" + recFriendsListQueryReqDTO.getProductNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //推荐人已用工具列表分页查询
    public static void recUsedListQuery() {
        RecUsedListQueryReqDTO recUsedListQueryReqDTO = new RecUsedListQueryReqDTO();
        recUsedListQueryReqDTO.setProductNo(recommendService.getProductNo());
        recUsedListQueryReqDTO.setPageSize(0);
        recUsedListQueryReqDTO.setPageNo(0);
        recUsedListQueryReqDTO.setTraceLogId(TraceLogId());

        Result<RecListQueryResDTO> result = recQueryService.recUsedListQuery(recUsedListQueryReqDTO);
        System.out.println("********************推荐人已用工具列表分页查询********************");
        System.out.println("日志号:" + recUsedListQueryReqDTO.getTraceLogId());
        System.out.println("推荐人手机号:" + recUsedListQueryReqDTO.getProductNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //推荐人可用工具列表查询
    public static void recValidListQuery() {
        RecValidListQueryReqDTO recValidListQueryReqDTO = new RecValidListQueryReqDTO();
        recValidListQueryReqDTO.setProductNo(recommendService.getProductNo());
        recValidListQueryReqDTO.setTraceLogId(TraceLogId());

        Result<RecValidToolResDTO> result = recQueryService.recValidListQuery(recValidListQueryReqDTO);
        System.out.println("********************推荐人可用工具列表查询********************");
        System.out.println("日志号:" + recValidListQueryReqDTO.getTraceLogId());
        System.out.println("推荐人手机号:" + recValidListQueryReqDTO.getProductNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //活动号手机号校验
    public static void queryValidActivity() {
        QueryValidActivityReqDTO queryValidActivityReqDTO = new QueryValidActivityReqDTO();
        queryValidActivityReqDTO.setMerchantId("");
        queryValidActivityReqDTO.setStoreId("");
        queryValidActivityReqDTO.setProductNo(recommendService.getProductNo());
        queryValidActivityReqDTO.setActivityId(recommendService.getActvityId());
        queryValidActivityReqDTO.setRebateDimension("");
        queryValidActivityReqDTO.setTraceLogId(TraceLogId());

        Result<ApplicableActivityResDTO> result = activityQueryService.queryValidActivity(queryValidActivityReqDTO);
        System.out.println("********************活动号手机号校验********************");
        System.out.println("日志号:" + queryValidActivityReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //活动硬规则校验
    public static void queryCompatibleActivityList() {
        QueryCompatibleActivityListReqDTO queryCompatibleActivityListReqDTO = new QueryCompatibleActivityListReqDTO();
        queryCompatibleActivityListReqDTO.setProductNo("");
        queryCompatibleActivityListReqDTO.setToolType("");
        queryCompatibleActivityListReqDTO.setTraceLogId(TraceLogId());

        Result<List<ApplicableActivityResDTO>> result = activityQueryService.queryCompatibleActivityList(queryCompatibleActivityListReqDTO);
        System.out.println("********************活动硬规则校验********************");
        System.out.println("日志号:" + queryCompatibleActivityListReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //活动软规则校验
    public static void checkActivitySoftRule() {
        CheckActivitySoftRuleReqDTO checkActivitySoftRuleReqDTO = new CheckActivitySoftRuleReqDTO();
        checkActivitySoftRuleReqDTO.setProductNo(recommendService.getProductNo());

        List<String> activityIdList = new ArrayList<>();
        activityIdList.add(recommendService.getActvityId());
        checkActivitySoftRuleReqDTO.setActivityIdList(activityIdList);

        checkActivitySoftRuleReqDTO.setTraceLogId(TraceLogId());

        Result<List<CheckActivityResDTO>> result = activityQueryService.checkActivitySoftRule(checkActivitySoftRuleReqDTO);
        System.out.println("********************活动软规则校验********************");
        System.out.println("日志号:" + checkActivitySoftRuleReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //活动权益剩余笔数金额校验
    public static void checkActivityQuota() {
        CheckActivityQuotaReqDTO checkActivityQuotaReqDTO = new CheckActivityQuotaReqDTO();
        List<String> activityIdList = new ArrayList<>();
        activityIdList.add(recommendService.getActvityId());
        checkActivityQuotaReqDTO.setActivityIdList(activityIdList);

        checkActivityQuotaReqDTO.setTraceLogId(TraceLogId());

        Result<List<CheckActivityResDTO>> result = activityQueryService.checkActivityQuota(checkActivityQuotaReqDTO);
        System.out.println("********************活动权益剩余笔数金额校验********************");
        System.out.println("日志号:" + checkActivityQuotaReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }

    //3.0产品层下单消费
    public static void createAndPay() {
        Map BindingInfoMap = recommendService.getBindingInfoMap();
        Map TradeProductMap = new HashMap<>();
        String traceLogId = TraceLogId();

        TradeProductCreateAndPayOrderReqDTO tradeProductCreateAndPayOrderReqDTO = new TradeProductCreateAndPayOrderReqDTO();
        tradeProductCreateAndPayOrderReqDTO.setPlatformMerchantNo("999999999");//平台商户号
        tradeProductCreateAndPayOrderReqDTO.setRequestOrderNo("Req" + RandomStringNo());//请求系统单号
        tradeProductCreateAndPayOrderReqDTO.setRequestSystem("TRADE_ACQUIRING");//请求系统
        tradeProductCreateAndPayOrderReqDTO.setRequestDate(now);//请求时间
        tradeProductCreateAndPayOrderReqDTO.setProductCode("71100080237");//46产品码
//        tradeProductCreateAndPayOrderReqDTO.setProductCode("68800020211");//沙箱产品码
        tradeProductCreateAndPayOrderReqDTO.setTradeChannel("POS");//交易渠道
        tradeProductCreateAndPayOrderReqDTO.setCustomerOperatorNo(BindingInfoMap.get("RecommendedOperatorNo").toString());//
        tradeProductCreateAndPayOrderReqDTO.setAmount(2000L);//金额
        tradeProductCreateAndPayOrderReqDTO.setCcy("156");//币种
        tradeProductCreateAndPayOrderReqDTO.setRate(0l);//汇率
        tradeProductCreateAndPayOrderReqDTO.setForeignCcy("");//外币币种
        tradeProductCreateAndPayOrderReqDTO.setForeignAmount(0L);//外币金额
        tradeProductCreateAndPayOrderReqDTO.setStoreCode("ST00003");//门店号
        tradeProductCreateAndPayOrderReqDTO.setMerchantTradeNo("Mer" + RandomStringNo());
        tradeProductCreateAndPayOrderReqDTO.setGoodsInfo("高级即时下单并支付");//商品信息摘要
        tradeProductCreateAndPayOrderReqDTO.setTimeOut(100000L);//超时时间
        tradeProductCreateAndPayOrderReqDTO.setSecurity("DOUBLEFACTOR");//安全等级
        tradeProductCreateAndPayOrderReqDTO.setOperator("WY");//操作人
        tradeProductCreateAndPayOrderReqDTO.setMemo("高级即时下单并支付");//备注

        TradeProductMap.put("TradeAmount", tradeProductCreateAndPayOrderReqDTO.getAmount());
        TradeProductMap.put("TradeChannel", tradeProductCreateAndPayOrderReqDTO.getTradeChannel());

        int TradeType = 1;//1 业务返现金; 2 业务返红包金; 3 业务返代金券
        switch (TradeType) {
            case 1:
                tradeProductCreateAndPayOrderReqDTO.setMerchantNo("3178002076404718");//46
//                tradeProductCreateAndPayOrderReqDTO.setMerchantNo("3178002070296117");//沙箱
                Result<TradeProductResDTO> result1 = tradeProductSeniorOrderService.createSeniorOrderAndPay(tradeProductCreateAndPayOrderReqDTO, traceLogId);
                System.out.println("********************被推荐人消费********************");
                System.out.println("日志号:" + traceLogId);
                System.out.println("是否成功：" + result1.isSuccess());
                System.out.println("错误信息:" + result1.getErrorMsg());
                System.out.println("返回信息:" + result1.getResult());

                TradeProductMap.put("MerchantNo", tradeProductCreateAndPayOrderReqDTO.getMerchantNo());
                if (result1.getResult() != null) {
                    TradeProductMap.put("TradeNo", result1.getResult().getTradeNo());
                } else {
//                    new Until(result1.getResult().getTradeNo());
                }

                break;

            case 2:
                tradeProductCreateAndPayOrderReqDTO.setMerchantNo("3178002076404848");//46
//                tradeProductCreateAndPayOrderReqDTO.setMerchantNo("3178002070610263");//沙箱
                Result<TradeProductResDTO> result2 = tradeProductSeniorOrderService.createSeniorOrderAndPay(tradeProductCreateAndPayOrderReqDTO, traceLogId);
                System.out.println("********************被推荐人消费********************");
                System.out.println("日志号:" + traceLogId);
                System.out.println("是否成功：" + result2.isSuccess());
                System.out.println("错误信息:" + result2.getErrorMsg());
                System.out.println("返回信息:" + result2.getResult());

                TradeProductMap.put("MerchantNo", tradeProductCreateAndPayOrderReqDTO.getMerchantNo());
                TradeProductMap.put("TradeNo", result2.getResult().getTradeNo());
                break;

            case 3:
                tradeProductCreateAndPayOrderReqDTO.setMerchantNo("3178002076404969");//46
//                tradeProductCreateAndPayOrderReqDTO.setMerchantNo("3178002070610254");//沙箱
                Result<TradeProductResDTO> result3 = tradeProductSeniorOrderService.createSeniorOrderAndPay(tradeProductCreateAndPayOrderReqDTO, traceLogId);
                System.out.println("********************被推荐人消费********************");
                System.out.println("日志号:" + traceLogId);
                System.out.println("是否成功：" + result3.isSuccess());
                System.out.println("错误信息:" + result3.getErrorMsg());
                System.out.println("返回信息:" + result3.getResult());

                TradeProductMap.put("MerchantNo", tradeProductCreateAndPayOrderReqDTO.getMerchantNo());
                TradeProductMap.put("TradeNo", result3.getResult().getTradeNo());
                break;
        }
        recommendService.setTradeProductMap(TradeProductMap);
    }

    public static void refund() {
        Map TradeProductMap = recommendService.getTradeProductMap();
        String traceLogId = TraceLogId();

        TradeProductRefundReqDTO tradeProductRefundReqDTO = new TradeProductRefundReqDTO();
        tradeProductRefundReqDTO.setMerchantNo(TradeProductMap.get("MerchantNo").toString());//商户号
        tradeProductRefundReqDTO.setRequestOrderNo("Req" + RandomStringNo());//请求系统单号
        tradeProductRefundReqDTO.setRequestSystem("TRADE_ACQUIRING");//请求系统
        tradeProductRefundReqDTO.setRequestDate(now);//请求时间
        tradeProductRefundReqDTO.setRefundTradeChannel(TradeProductMap.get("TradeChannel").toString());//退款渠道
        tradeProductRefundReqDTO.setOriginalTradeNo(TradeProductMap.get("TradeNo").toString());//原交易号
        tradeProductRefundReqDTO.setRefundAmount(Long.valueOf(TradeProductMap.get("TradeAmount").toString()));//退款金额
        tradeProductRefundReqDTO.setRefundCcy("156");//退款币种
        tradeProductRefundReqDTO.setRefundReason("测试退款");//退款原因
        tradeProductRefundReqDTO.setProductCode("71100080237");//46产品码
//        tradeProductCreateAndPayOrderReqDTO.setProductCode("71100060194");//沙箱产品码
        tradeProductRefundReqDTO.setMemo("退款POS");//备注 O
        tradeProductRefundReqDTO.setOperator("WY");//操作人

        Result<TradeProductBaseResDTO> result = tradeProductRefundService.refund(tradeProductRefundReqDTO, traceLogId);
        System.out.println("********************被推荐人退款********************");
        System.out.println("日志号:" + traceLogId);
        System.out.println("是否成功：" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }
}
