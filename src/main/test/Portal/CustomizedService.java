package Portal;

import java.util.List;

/**
 * Created by zengyouzu on 2019/8/20.
 */
public class CustomizedService {
    private List<ActivityDTO> activityDTOList;
    private List<ToolDTO> toolDTOList;

    public List<ActivityDTO> getActivityDTOList() {
        return activityDTOList;
    }

    public void setActivityDTOList(List<ActivityDTO> activityDTOList) {
        this.activityDTOList = activityDTOList;
    }

    public List<ToolDTO> getToolDTOList() {
        return toolDTOList;
    }

    public void setToolDTOList(List<ToolDTO> toolDTOList) {
        this.toolDTOList = toolDTOList;
    }
}
