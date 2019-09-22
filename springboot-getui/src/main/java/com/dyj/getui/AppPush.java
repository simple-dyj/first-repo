package com.dyj.getui;

/**
 * @author dyj
 * @date 2019/7/19 10:30
 */
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AppPush {

//    应用名称：个推Demo-dingyajunzl
//    appId：sjwgMwqv3G8VaoNbsPkVF2
//    appSecret：batPMjPUdx7haIGJGImm26
//    appKey：UKZ2LC0VcY7DB9waJRex54
//    应用包名：com.getui.demo
//    masterSecret：【个推】bTrkvhQl8z7YsOyhikFBV

    private static String appId = "sjwgMwqv3G8VaoNbsPkVF2";
    private static String appKey = "UKZ2LC0VcY7DB9waJRex54";
    private static String masterSecret = "bTrkvhQl8z7YsOyhikFBV";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";
    private static String clientId = "b9515b952bc28f352e7e60cff70fb353";

    public static void main(String[] args) throws IOException {

        IGtPush push = new IGtPush(url, appKey, masterSecret);

        // 定义"点击链接打开通知模板"，并设置标题、内容、链接
        LinkTemplate template = new LinkTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTitle("dyj测试");
        template.setText("测试内容");
        template.setUrl("http://getui.com");

        List<String> appIds = new ArrayList<String>();
        appIds.add(appId);

        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
        AppMessage message = new AppMessage();
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);
        //批量推送
//        IPushResult ret = push.pushMessageToApp(message);
//        System.out.println(ret.getResponse().toString());


        Target target = new Target();
        target.setClientId("b9515b952bc28f352e7e60cff70fb353");
        target.setAppId(appId);
        SingleMessage msg = new SingleMessage();
        msg.setData(template);
        msg.setOffline(true);
        msg.setOfflineExpireTime(1000 * 600);

        //单条推送
        IPushResult singleResult = push.pushMessageToSingle(msg, target);
        System.out.println(singleResult.getResponse().toString());
    }
}
