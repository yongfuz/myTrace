var datagrid;
	$(function(){
		$('#datagrid').datagrid({    
		    url : '/ssc/queryVersion', 
		    title : '版本管理列表',
		    pagination : true,
		    pageSize : 10,
		    pageList : [10,15,20],
		    fitColumns : true, //展示每一列自适应宽度,去掉滚动条
		    //fit : true,
		    checkOnSelect:false,
//		    idField : 'systemId',   //记住你选中的id,无论怎么翻页
		    scrollbar:false,
		    columns : [[    
//				{field:'ck', checkbox:true},
		        {field:'vsystem',title:'系统',width:80,align:'center'},    
		        {field:'environment',title:'环境',width:80,align:'center'},    
		        {field:'vbatch',title:'批次',width:80,align:'center'},
		        {field:'vfilePath',title:'文件路径',width:200,align:'center'},
		        {field:'opBtn',title:'操作',width:140,align:'center',formatter: function(value,row,index){return '<a href="#" id="edit'+index+'" name="editBtn" onclick="editVersion('+index+')"></a><a href="#" id="del'+index+'" name="delBtn" onclick="delVersion('+index+')"></a>';}}
			    ]],
			    onLoadSuccess:function(data){
			        $("a[name='editBtn']").linkbutton({text:'修改',plain:true,iconCls:'icon-edit'});  
			        $("a[name='delBtn']").linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
				}
			}); 

	})
	

	
	function queryVersion(){
		var vsystem = $("#vsystem").val();
		var environment = $("#environment").combobox('getValue');
		var vbatch = $("#vbatch").combobox('getValue');
		$('#datagrid').datagrid('load', {    
			vsystem : vsystem,    
			environment : environment,
			vbatch :vbatch
		});
		
	}

	function resetQuery(){
		$("#vsystem").val("");
		$("#environment").combobox('setValue', '');
		$("#vbatch").combobox('setValue', '');
	}
	
	function openAddVersion(){
		$('#versionWin').show().window({ 
			title:"版本上传",
		    width:600,    
		    height:250,    
		    modal:true,
		    content:'<iframe scrolling="auto" frameborder="0" src="/ssc/toAddVersion" style="width:100%;height:95%"></iframe>'
		});
	}
	
//	function delQrSystemId(){
//		var row = $('#datagrid').datagrid('getChecked');
//		 if (row.length==0){ 
//             $.messager.alert("提示", "请选择要删除的行！", "info"); 
//             return; 
//         }else{     
//               var temID=""; 
//             //批量获取选中行的评估模板ID 
//        	   $.messager.confirm('提示', '是否删除选中数据?', function (r){                          
//                  if (!r) { 
//                         return; 
//                     }
//　　			//将id字符串连在一起
//               $.each(row,function(i){
//            	   if(temID==""){
//            		   temID = row[i].systemId;
//            	   }else{
//            		   temID = row[i].systemId+","+temID;
//            	   }
//			});
//　　			$.post("/qrSystemId/delQrSystemId",{systemIdStr:temID},function(data){
//				$.messager.alert("提示",data.result);
//				$("#datagrid").datagrid("reload");
//				$("#datagrid").datagrid("clearSelections");
//　　			},"json");
//         });
//	   }	
//	}
//
//	
	
	function editVersion(index){
    	$('#datagrid').datagrid("clearSelections");
    	$('#datagrid').datagrid('selectRow',index);
    	var row = $('#datagrid').datagrid('getSelected');
    	if (row){
    		$('#versionWin').show().window({ 
    			title:"修改",
    		    width:600,    
    		    height:250,    
    		    modal:true,
    		    content:'<iframe scrolling="auto" frameborder="0" src="/ssc/toEditVersion?vsystem='+row.vsystem+'&environment='+row.environment+'&vbatch='+row.vbatch+'" style="width:100%;height:99%"></iframe>'
    		  });
    	}
    } 
	
    function delVersion(index){
    	$('#datagrid').datagrid("clearSelections");
    	$('#datagrid').datagrid('selectRow',index);
    	var row = $('#datagrid').datagrid('getSelected');
 	    $.messager.confirm('提示', '是否删除选中数据?', function (r){                          
 		   if (!r) { 
             return; 
 		   }else{
 			  $.post("/ssc/delVersion",
 		 			  {"vsystem":row.vsystem,"environment":row.environment,"vbatch":row.vbatch},
 		 			  function(data){
 							$.messager.alert("提示",data.result);
 							$("#datagrid").datagrid("reload");
 							$("#datagrid").datagrid("clearSelections");
 						},"json");
 		   }
 	    });
 	   
 	    
       }
   
//    function detailQrSystemId(index){
//    	$('#datagrid').datagrid("clearSelections");
//    	$('#datagrid').datagrid('selectRow',index);
//    	var row = $('#datagrid').datagrid('getSelected');
//    	if (row){
//    		$('#qrSystemIdWin').show().window({ 
//    			title:"详情",
//    		    width:600,    
//    		    height:250,    
//    		    modal:true,
//    		    content:'<iframe scrolling="auto" frameborder="0" src="/qrSystemId/toDetailQrSystemId?systemId='+row.systemId+'" style="width:100%;height:95%"></iframe>'
//    		});
//    	}
//    	
//    }
//    

    
    function reloadPage(){
    	$("#datagrid").datagrid("reload");
    }
    
	function closeWinDiv(){
		$('#versionWin').dialog('close');
	}