//var datagrid;
//	$(function(){
//		$('#datagrid').datagrid({    
//		    url : '/ssc/queryVersion', 
//		    title : '版本管理列表',
//		    pagination : true,
//		    pageSize : 10,
//		    pageList : [10,15,20],
//		    fitColumns : true, //展示每一列自适应宽度,去掉滚动条
//		    //fit : true,
//		    checkOnSelect:false,
////		    idField : 'systemId',   //记住你选中的id,无论怎么翻页
//		    scrollbar:false,
//		    columns : [[    
////				{field:'ck', checkbox:true},
//		        {field:'vsystemId',title:'系统',width:100,align:'center'},    
//		        {field:'environment',title:'环境',width:100,align:'center'},    
//		        {field:'vbatch',title:'批次',width:100,align:'center'},
//		        {field:'vfilePath',title:'文件路径',width:100,align:'center',formatter: function(value,row,index){if(value == "0"){return "启用";}else if(value == "1"){ return "停用";}}},
////		        {field:'opBtn',title:'操作',width:140,align:'center',formatter: function(value,row,index){return '<a href="#" id="edit'+index+'" name="editBtn" onclick="editQrSystemId('+index+')"></a><a href="#" name="detailBtn" onclick="detailQrSystemId('+index+')"></a>';}}
//			    ]]
////			    onLoadSuccess:function(data){
////			        $("a[name='editBtn']").linkbutton({text:'修改',plain:true,iconCls:'icon-edit'});  
////			        $("a[name='detailBtn']").linkbutton({text:'详情',plain:true,iconCls:'icon-tip'});
////				}
//			}); 

//	})
	

	
	function queryEnvironment(){
		var esystem = $("#esystem").val();
		var environment = $("#environment").combobox('getValue');
		var ebatch = $("#ebatch").combobox('getValue');
		if(esystem==""||environment==""||ebatch==""){
			$.messager.alert("提示","所有条件必填");
			return;
		}
		$.ajax({
			type:"post",
			url:"/ssc/queryEnvironment",
			data:{"esystem":esystem,"environment":environment,"ebatch":ebatch},
//			async:false,
			success:function(data){
				if(data==""){
					$.messager.alert("提示","不存在该文件");
					return;
				}
				$("#datagrid").empty();
				var tbody = '<tr><td style="border:1px #E5F1FF solid;width:80px;"><label for="esystem">系统:</label></td><td style="border:1px #E5F1FF solid;width:120px;">'+esystem+'</td>'
					+'<td style="border:1px #E5F1FF solid;width:80px;"><label for="environment">环境:</label></td><td style="border:1px #E5F1FF solid;width:80px;">'+environment+'</td>'
					+'<td style="border:1px #E5F1FF solid;width:80px;"><label for="ebatch">批次:</label></td><td style="border:1px #E5F1FF solid;width:80px;">'+ebatch+'</td>'
					+'<td style="border:1px #E5F1FF solid;width:80px;"><label for="file">环境清单路径:</label></td><td style="border:1px #E5F1FF solid">'+data.detailedList+'&nbsp;&nbsp;&nbsp;<a href="'+data.detailedList+'" target="pdfFrame"><font color="red">show</font></a></td></tr>'
					+'<tr><td id="detailedListShow" colspan="8" style="border:1px #E5F1FF solid;height:500px;"><iframe name="pdfFrame" style="height:100%;width:100%" scrolling="auto"></iframe></td></tr>';
//				alert(data.detailedList);
//				new PDFObject({
//					url:"http://10.10.83.113:8080/home/crs_shared/envfile/实物管理_CSPJ_V1.5.pdf",
//					pdfOpenParams:{
//						view:'Fit',
//						scrollbars:'0',
//						toolbar:'0',
//						statusbar:'0',
//						navpanes:'0'
//					}
//				}).embed("pdfDiv");
				$("#datagrid").append(tbody);
			}
		});
		
	}

	function resetQuery(){
		$("#esystem").val("");
		$("#environment").combobox('setValue', '');
		$("#ebatch").combobox('setValue', '');
	}
	
	function openAddEnvironment(){
		$('#environmentWin').show().window({ 
			title:"环境清单上传",
		    width:600,    
		    height:250,    
		    modal:true,
		    content:'<iframe scrolling="auto" frameborder="0" src="/ssc/toAddEnvironment" style="width:100%;height:95%"></iframe>'
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
//    function editQrSystemId(index){
//    	$('#datagrid').datagrid("clearSelections");
//    	$('#datagrid').datagrid('selectRow',index);
//    	var row = $('#datagrid').datagrid('getSelected');
//    	if (row){
//    		$('#qrSystemIdWin').show().window({ 
//    			title:"修改",
//    		    width:600,    
//    		    height:250,    
//    		    modal:true,
//    		    content:'<iframe scrolling="auto" frameborder="0" src="/qrSystemId/toEditQrSystemId?systemId='+row.systemId+'" style="width:100%;height:99%"></iframe>'
//    		  });
//    	}
//    }
//    
//   
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

    
//    function reloadPage(){
//    	$("#datagrid").datagrid("reload");
//    }
    
	function closeWinDiv(){
		$('#environmentWin').dialog('close');
	}