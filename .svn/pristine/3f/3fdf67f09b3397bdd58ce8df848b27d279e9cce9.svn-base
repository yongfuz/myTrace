$(function(){
		$("#addEnvironmentBtn").bind("click",function(){
			$("#addEnvironmentForm").form("submit",{
					url:"/ssc/addEnvironment",
					success:function(data){
// 						$.messager.alert("提示",data.result);
						var result = eval('('+data+')');
						$.messager.alert("提示",result.result);
					}
			});
			$(this).unbind("click");
			
		});
		
//		$("#closeWinBtn").bind("click",function(){
//			alert(14)
//			window.parent.window.$("#uerWin").window("close");
//			$(this).unbind("click");
//		});
	})
	
	
    
 
    
    function closeWin(){
    	window.parent.closeWinDiv();
    }