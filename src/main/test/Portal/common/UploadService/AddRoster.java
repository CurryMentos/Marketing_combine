package Portal.common.UploadService;

import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.common.UploadService;
import com.xx.marketing.config.api.common.models.request.RosterDetailReqDTO;
import com.xx.marketing.config.api.common.models.request.RosterReqDTO;
import org.testng.annotations.Test;
import java.util.*;

/**
 * Created by Administrator on 2019/10/31.
 */
public class AddRoster {
    UploadService uploadService = BeanUtil.getBean("uploadService");

    //商户信息新增/启用、停用接口
    @Test
    public void addRoster() throws Exception {
        String traceLogId = UUID.randomUUID().toString();
        RosterReqDTO rosterReqDTO = new RosterReqDTO();
        rosterReqDTO.setBizType("");//业务类型;  新增/启用：ENABLE；停用：DISENABLE
        rosterReqDTO.setApplyUser("");//申请人
        rosterReqDTO.setFileType("MERCHANT_FILE");//文件类型
        rosterReqDTO.setRosterSource("");//名单来源H5、OMP
        rosterReqDTO.setTraceLogId(traceLogId);
        List<RosterDetailReqDTO> rosterDetailReqDTOList = new ArrayList<RosterDetailReqDTO>();
        rosterDetailReqDTOList.add(rosterDetailReqDTO());//名单信息请求

        Result<Boolean> result = uploadService.addRoster(rosterReqDTO);
        System.out.println("是否成功：" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
        System.out.println("日志:" + traceLogId);
    }
    //名单信息请求LIST
    public RosterDetailReqDTO rosterDetailReqDTO() {
        RosterDetailReqDTO rosterDetailReqDTO = new RosterDetailReqDTO();
        rosterDetailReqDTO.setRelationId("E20990190828151308000028");//关联编号
        rosterDetailReqDTO.setRelationType("VOUCHER");//关联类型
        // 推荐人工具：RECOMMEND，双向激励工具：ENCOURAGE，商户红包工具：MERCHANT_REDBAG；
        //活动：ACTIVITY；代金券权益：VOUCHER，红包金权益：COUPON
        return rosterDetailReqDTO;
    }


}
