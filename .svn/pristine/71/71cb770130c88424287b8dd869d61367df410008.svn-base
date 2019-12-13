$(function(){
//	alert(123);
//	 $("#mainMenu").accordion({ // 初始化accordion
//	        title : '导航菜单',
//	        fit : true,
//	        border : true,
//	        animate : true
//	    });
	getTreeMenuDiv();
	getTreeMenu();
	
})





	function getTreeMenuDiv(){
//		$("#mainMenu").empty();
		$.ajax({
			type:"post",
			url:"/ssc/getTreeMenuDiv",
			data:{functionId:0},
			async:false,
			success:function(data){
				//导航菜单绑定初始化
//				$("#mainMenu").accordion();
				
				for (var i = 0; i < data.length; i++) {
					$("#mainMenu").accordion('add', {
			            title : data[i].functionName,
			            content : '<ul class="easyui-tree wu-side-tree" id="menu'+data[i].functionId+'" >',
			            iconCls : 'icon-application-cascade',
			            selected : true,
			            collapsible : true
			        });
				}
				$.parser.parse();
				
			}
			
		});
	}

function getTreeMenu(){
	$.ajax({
		type:"post",
		dataType:'json',
		url:"/ssc/getTreeMenu",
		data:{functionId:0},
		async:false,
		success:function(data){
			console.log(data);
			$.each(data,function(i){
				$.parser.onComplete = function(){
					$("#menu"+data[i].id).tree({
						data:data[i].children,
						onClick : function(node) {  
		                    var url = node.attributes.url;
		                    var urlstr = "/"+url+"?m="+Math.random();
		                    var contentStr = '<iframe id="tadFrame" scrolling="auto" frameborder="0" src="'+urlstr+'" style="width:100%;height:99%"></iframe> ';
		                    if(url==null || url == "#"){
		    					return false;
		    				}else{
		    					var tabObj = $("#wu-tabs");
		    					if(!tabObj.tabs('exists', node.text)){
		    						$("#wu-tabs").tabs("add",{title:node.text,content:contentStr,cache:false,closable:true});
		    					}else{
		    						$("#wu-tabs").tabs('select',node.text);
		    						var tab = $('#wu-tabs').tabs('getSelected');  // 获取选择的面板
		    						tab.panel('refresh');
		    				}
		    			}
		               } 
					});
				}
//					$("#wu-tabs").tabs({
//						onSelect:function(title,index){
//							if(index!=0){
//								$("#tadFrame").attr('src',$("#tadFrame").attr('src'));
//							}
//						}
//					});
					$.parser.parse();
				})
				
			}
		})
			
//	});
}

function changePwd(){
	$("#changePwdWin").show().window({ 
		title:"修改密码",
	    width:600,    
	    height:250,    
	    modal:true,
	    content:'<iframe scrolling="auto" frameborder="0" src="/toChangePwd" style="width:100%;height:95%"></iframe>'
	});
}


