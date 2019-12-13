$(function(){
	var url = window.location.href;
	if(top.location.href != url){
		top.location.href = url;
	}
	
	$("#loginBtn").bind("click",function(){
		var userId = $("#userId").val();
		$.ajax({
			type:"post",
			url:"login",
			data:$("#loginForm").serialize(),
			success:function(result){
				if(result.status == "200"){
					location.href = "/ssc/toIndex?userId="+userId;
				}else{
					$.messager.alert("提示",result.message);
					return;
				}
			},
			error:function(){
				$.messager.alert("提示","登录请求失败,请联系管理员!");
			}
		});
		
//		$(this).unbind("click");
	});
})




/**
 * 按enter键登录
 */
$(document).keydown(function(event){
	if(event.keyCode == 13){
		login();
	}
})	
