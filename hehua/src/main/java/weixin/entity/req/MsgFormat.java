package weixin.entity.req;

/**
 * Created by Administrator on 2017/5/2.
 * IntelliJ IDEA 2017 of gzcss
 */
public class MsgFormat {
    public static String eventOrderPassMsgFormat(String orderNo,String orderTitle,String orderDesc,String orderDetailUrl,String waitQuequUrl) {

        StringBuilder sb = new StringBuilder();
        sb.append("格式：交互消息格式");
        sb.append("\n");
        sb.append("内容：\"您好！您有一项待处理事件即将超时，请尽快处理。\"");
        sb.append("\n");

        sb.append("单号："+orderNo);
        sb.append("\n");
        sb.append("标题："+orderTitle);
        sb.append("\n");
        sb.append("描述："+orderDesc);
        sb.append("\n");

        sb.append("<a href=\"http://www.gzwise.top/wxtest/loginweixinAction.action?meurl=caseinfo.caseinfo%3A%7B%22number%22%3A%22"+orderNo+"%22%2C%22cssAcceptFlag%22%3A%22false%22%7D\">[查看工单]</a>");
        sb.append("\n");

        sb.append("<a href=\"http://www.gzwise.top/wxtest/loginweixinAction.action?meurl=doingcase.doingcase\">[查看待办队列]</a>");
        sb.append("\n");
        return sb.toString();
    }

    public static String eventFlowNodeMsgFormat(String orderNo,String usernameId,String status) {
        StringBuilder sb = new StringBuilder();
        sb.append("XXX您好！您收到了新的事件工单，现待办队列还有n张待办未处理！");
        sb.append("\n");


        sb.append("单号："+orderNo);
        sb.append("\n");
        sb.append("事件标题：XXXXX");
        sb.append("\n");
        sb.append("事件描述：XXXXX");
        sb.append("\n");

        sb.append("<a href=\"https://www.baidu.com\">[查看工单]</a>");
        sb.append("\n");

        sb.append("<a href=\"http://www.gzwise.top/wxtest/loginweixinAction.action?getType=0&meurl=recicase.recicase%3A%7B%22number%22%3A%22"+orderNo+"%22%2C%22cssAcceptFlag%22%3A%22true%22%7D&number="+orderNo+"&usernameId="+usernameId+"&status="+status+"\">[接受]</a>");
        sb.append("\n");

        //sb.append("<a href=\"http://www.gzwise.top/wxtest/loginweixinAction.action?meurl=\">[拒绝]</a>");
        //sb.append("\n");

        sb.append("<a href=\"http://www.gzwise.top/wxtest/loginweixinAction.action?meurl=caseinfo.turntosend%3A%7B%22number%22%3A%22"+orderNo+"%22%7D\">[转派]</a>");
        sb.append("\n");

        sb.append("<hr>");
        sb.append("<a href=\"http://172.16.1.18/ydyw/main.html?sid=a3d3#doingcase.doingcase\">[查看待办队列]</a>");
        sb.append("\n");

        return sb.toString();

    }

    public static String textCardMsg(String orderNo,String usernameId,String status) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"normal\">");
        sb.append("您好！您收到了新的事件工单，现待办队列还有n张待办未处理！");
        sb.append("\n");


        sb.append("单号："+orderNo);
        sb.append("\n");
        sb.append("事件标题：XXXXX");
        sb.append("\n");
        sb.append("事件描述：XXXXX");
        sb.append("\n");

        sb.append("<a href=\"https://www.baidu.com\">[查看工单]</a>");
        sb.append("\n</div>");

        sb.append("<div class=\"highlight\">");
        sb.append("<a href=\"http://172.16.1.18/ydyw/main.html?sid=a3d3#doingcase.doingcase\">[查看待办队列]</a>");
        sb.append("\n</div>");

        return sb.toString();

    }

    public String pleaseOrderFlowNodeMsgFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("XXX您好！您收到了新的事件工单，现待办队列还有n张待办未处理！");
        sb.append("\n");

        sb.append("工单标题：XXXXX");
        sb.append("\n");
        sb.append("工单内容：XXXXX");
        sb.append("优先级为：XXXXX");
        sb.append("，请到ITSM客户端进行操作。");

        sb.append("\n");
        return sb.toString();
        //工单内容：【申请人】 + 【申请理由及用途字段】 + “优先级为“ + 【优先级】，请到ITSM客户端进行操作。

    }

    public String doorToDoorServiceMsgFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("XXX您好！");
        sb.append("\n");
        sb.append("您的事件单（PM-031200-001234）已被xxx接受，将于2017年4月10日星期一 10：00：00上门服务，如有疑问请联系工程师。");

        //【服务对象】您好！
        //您的事件单（PM-031200-001234）已被xxx接受，将于2017年4月10日星期一 10：00：00上门服务，如有疑问请联系工程师。
        return sb.toString();
    }

}
