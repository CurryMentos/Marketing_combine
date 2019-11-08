package Rule.Redis;

import lombok.Getter;

/**
 * 时间枚举
 *
 * @author cuiguangchun
 * @version Id: TimeEnum.java, v 0.1 2017/11/24 9:45 cuiguangchun Exp $$
 */
@Getter
public enum TimeEnum {

    //30分钟
    THIRTY_MINUTES(1800, "有效时间为30分钟，单位:秒"),

    TEN_MINUTES(600, "有效时间10分钟，单位秒"),

    HOUR(3600, "有效时间为1小时，单位:秒"),

    SIX_HOUR(21600, "有效时间为6小时，单位:秒"),

    TEN_HOUR(36000, "有效时间为10小时，单位:秒"),

    DAY(86400, "有效时间为24小时，单位:秒"),

    WEEK(604800, "有效时间为一周（7天），单位:秒"),

    TEN_DAY(864000, "有效时间为10天，单位:秒"),

    MONTH(2678400, "有效时间为1个月（31天），单位:秒"),

    FIVE_MINUTE(300, "有效时间为5分钟，单位:秒"),

    FIVE_SECOND(5, "有效时间为5秒，单位:秒"),

    TWO_MINUTE(120, "有效时间为2分钟，单位:秒");

    private Integer code;
    private String desc;

    TimeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
