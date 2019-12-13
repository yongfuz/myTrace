package com.pactera.bg.budsc.bank.yongfu.jdpush;

import com.pactera.bg.budsc.bank.yongfu.po.JpushClient;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class JpushClientUtil {

	private final static String appKey = "6750cbf2cb732fa95e6ac709";
	private final static String masterSecret = "3acb8d8548fca94da5bee206";
	private static JPushClient jPushClient = new JPushClient(masterSecret, appKey);

	public static void main(String[] args) {
		JpushClient jpushClient = new JpushClient();
		jpushClient.setRegistrationId("1a0018970afae35532f");
		jpushClient.setMsgContent("这个是消息内容");
		jpushClient.setMsgTitle("这个是标题");
		jpushClient.setNotificationTitle("这个是通知标题");
		jpushClient.setExtrasParam("这个是其他参数内容");
		int result = JpushClientUtil.sendToRegistrationId(jpushClient);
		System.out.println("推送结果:" + result);
	}

	/**
	 * 0推送失败，1推送成功
	 * 
	 * @param jpushClient
	 * @return
	 */
	public static int sendToRegistrationId(JpushClient jpushClient) {
		int result = 0;
		try {
			PushPayload pushPayload = JpushClientUtil.buildPushObject_all_registrationId_alertWithTitle(jpushClient);
			System.out.println(pushPayload);
			PushResult pushResult = jPushClient.sendPush(pushPayload);
			System.out.println(pushResult);
			if (pushResult.getResponseCode() == 200) {
				result = 1;
			}
		} catch (APIConnectionException e) {
			e.printStackTrace();

		} catch (APIRequestException e) {
			e.printStackTrace();
		}

		return result;
	}

	private static PushPayload buildPushObject_all_registrationId_alertWithTitle(JpushClient jpushClient) {
		String registrationId = jpushClient.getRegistrationId();
		String notification_title = jpushClient.getNotificationTitle();
		String msg_title = jpushClient.getMsgTitle();
		String msg_content = jpushClient.getMsgContent();
		String extrasparam = jpushClient.getExtrasParam();
		System.out.println("----------buildPushObject_all_all_alert");
		// 创建一个IosAlert对象，可指定APNs的alert、title等字段
		// IosAlert iosAlert = IosAlert.newBuilder().setTitleAndBody("title",
		// "alert body").build();
		return PushPayload.newBuilder()
				// 指定要推送的平台，all代表当前应用配置了的所有平台，也可以传android等具体平台
				.setPlatform(Platform.all())
				// 指定推送的接收对象，all代表所有人，也可以指定已经设置成功的tag或alias或该应应用客户端调用接口获取到的registration
				// id
				.setAudience(Audience.registrationId(registrationId))
				// jpush的通知，android的由jpush直接下发，iOS的由apns服务器下发，Winphone的由mpns下发
				.setNotification(Notification.newBuilder()
						// 指定当前推送的android通知
						.addPlatformNotification(AndroidNotification.newBuilder().setAlert(notification_title)
								.setTitle(notification_title)
								// 此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
								.addExtra("sss", extrasparam).build())
						// 指定当前推送的iOS通知
						.addPlatformNotification(IosNotification.newBuilder()
								// 传一个IosAlert对象，指定apns title、title、subtitle等
								.setAlert(notification_title)
								// 直接传alert
								// 此项是指定此推送的badge自动加1
								.incrBadge(1)
								// 此字段的值default表示系统默认声音；传sound.caf表示此推送以项目里面打包的sound.caf声音来提醒，
								// 如果系统没有此音频则以系统默认声音提醒；此字段如果传空字符串，iOS9及以上的系统是无声音提醒，以下的系统是默认声音
								.setSound("sound.caf")
								// 此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
								.addExtra("content", extrasparam).build())
						// 此项说明此推送是一个background推送，想了解background看：http://docs.jpush.io/client/ios_tutorials/#ios-7-background-remote-notification
						// 取消此注释，消息推送时ios将无法在锁屏情况接收
						// .setContentAvailable(true)
						.build())
				// Platform指定了哪些平台就会像指定平台中符合推送条件的设备进行推送。 jpush的自定义消息，
				// sdk默认不做任何处理，不会有通知提示。建议看文档http://docs.jpush.io/guideline/faq/的
				// [通知与自定义消息有什么区别？]了解通知和自定义消息的区别
				.setMessage(Message.newBuilder()

						.setMsgContent(msg_content)

						.setTitle(msg_title)

						.addExtra("message extras key", extrasparam)

						.build())

				.setOptions(Options.newBuilder()
						// 此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
						.setApnsProduction(false)
						// 此字段是给开发者自己给推送编号，方便推送者分辨推送记录
						.setSendno(1)
						// 此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天；
						.setTimeToLive(86400)

						.build())

				.build();

	}

}