$(function(){
		initEditVersion();
	})
	
	
	function initEditVersion(){
		return;
		$("#editVersionBtn").bind("click",function(){
			$("#editVersionForm").form("submit",{
					url:"/ssc/editVersion",
					success:function(data){
						var result = eval('('+data+')');
						$.messager.alert("提示",result.result);
						$("#datagrid").datagrid("reload");
					}
			});
			$(this).unbind("click");
			
		});
//		$('#datagrid').datagrid("clearSelections");
	}
	


    

 
 function closeWin(){
	window.parent.reloadPage();
 	window.parent.closeWinDiv();
 }