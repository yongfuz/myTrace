$(function(){
		$("#addVersionBtn").bind("click",function(){
//			var file = $("#fileImport").files[0];
//			if(file==null){
//				$.messager.alert("提示","错误，请选择文件");
//				return;
//			}
			$("#addVersionForm").form("submit",{
					url:"/ssc/addVersion",
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
    	window.parent.reloadPage();
    	window.parent.closeWinDiv();
    }