package Portal.common.UploadService;
import com.xx.marketing.config.api.enums.FileTypeEnum;
import com.xx.marketing.roster.api.enums.RelationTypeEnum;
import com.xx.tradeproduct.service.common.api.enums.BizTypeEnum;
import com.google.common.collect.Lists;

import Customize.DataGenerate;
import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.common.UploadService;
import com.xx.marketing.config.api.common.models.request.RosterDetailReqDTO;
import com.xx.marketing.config.api.common.models.request.RosterReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by Administrator on 2019/10/31.
 * 添加商户名单
 */
public class AddRoster extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static UploadService uploadService = (UploadService) ac.getBean("uploadService");

    //商户信息新增/启用、停用接口
    @Test
    public static void addRoster() throws Exception {
        RosterReqDTO rosterReqDTO = new RosterReqDTO();
        rosterReqDTO.setBizType("ENABLE");//业务类型;  新增/启用：ENABLE；停用：DISENABLE
        rosterReqDTO.setApplyUser("ZYZ");//申请人
        rosterReqDTO.setFileType(FileTypeEnum.MERCHANT_FILE.getCode());//文件类型
        rosterReqDTO.setRosterSource("H5");//名单来源H5、OMP
        rosterReqDTO.setTraceLogId(TraceLogId());
        List<RosterDetailReqDTO> rosterDetailReqDTOList = new ArrayList<RosterDetailReqDTO>();
        RosterDetailReqDTO rosterDetailReqDTO = new RosterDetailReqDTO();
        rosterDetailReqDTO.setRelationId("T30990191111101306000023");//工具号 活动号 权益号
//        rosterDetailReqDTO.setRelationType(RelationTypeEnum.ACTIVITY.getCode());//活动
//        rosterDetailReqDTO.setRelationType(RelationTypeEnum.COUPON.getCode());//红包金
//        rosterDetailReqDTO.setRelationType(RelationTypeEnum.VOUCHER.getCode());//代金券
//        rosterDetailReqDTO.setRelationType(RelationTypeEnum.MERCHANT_REDBAG.getCode());//商户红包金
//        rosterDetailReqDTO.setRelationType(RelationTypeEnum.ENCOURAGE.getCode());//双向激励
        rosterDetailReqDTO.setRelationType(RelationTypeEnum.RECOMMEND.getCode());//推荐人
        rosterDetailReqDTO.setFileId(0L);
        rosterDetailReqDTOList.add(rosterDetailReqDTO);//名单信息请求
        rosterReqDTO.setRosterDetailReqDTOList(rosterDetailReqDTOList);

        Result<Boolean> result = uploadService.addRoster(rosterReqDTO);
        System.out.println("日志:" + rosterReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }
}
