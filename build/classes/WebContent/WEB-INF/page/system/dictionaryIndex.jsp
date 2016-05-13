<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<HTML>
	<HEAD>
		<title>系统设置</title>		
		<LINK href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet">
		<script language="javascript" src="${pageContext.request.contextPath }/script/function.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/script/pub.js"></script>
		<script type="text/javascript"  src="${pageContext.request.contextPath }/script/jquery-1.4.2.js"></script>
		<script language="javascript">
		
			
			
		function changetype(){
	
			
			//通过jquery的ajax组件想后台发送类型id
			var url = "${pageContext.request.contextPath }/system/dataDictionaryAction_edit.action" ; 
			var id = $("#dataDictionaryType").val() ; 

				$("#Form2").load(url , {"dataDictionaryType.id":id}) ; 		
			
	   }
	   
     function saveDict(){
	      

	    
	      document.Form2.action="dataDictionaryAction_save.action";
	      document.Form2.submit();     
	}    
  
     
     
     
/**       
 function insertRows(){ 

  var tempRow=0; 
  var tbl=document.getElementById("dictTbl");
  tempRow=tbl.rows.length; 
  var Rows=tbl.rows;//类似数组的Rows 
  var newRow=tbl.insertRow(tbl.rows.length);//插入新的一行 
  var Cells=newRow.cells;//类似数组的Cells 
  for (i=0;i<3;i++)//每行的3列数据 
  { 
     var newCell=Rows[newRow.rowIndex].insertCell(Cells.length); 
     newCell.align="center"; 
     switch (i) 
    { 
      case 0 : newCell.innerHTML=""+tempRow+"";break; 
      case 1 : newCell.innerHTML="<input name=\"itemname\" type=\"text\" id=\""+tempRow+"\" size=\"45\" maxlength=25>";break; 
      case 2 : newCell.innerHTML="<a href='javascript:delTableRow(\""+tempRow+"\")'><img src=${pageContext.request.contextPath }/images/delete.gif width=15 height=14 border=0 style=CURSOR:hand></a>";break;

    } 
    //alert(newCell.innerHTML);
  } 
 } 
function delTableRow(rowNum){ 

   var tbl=document.getElementById("dictTbl");
    
    if (tbl.rows.length >rowNum){ 
      
       tbl.deleteRow(rowNum); 
     
      for (i=rowNum;i<tbl.rows.length;i++)
       {
         tbl.rows[i].cells[0].innerHTML=i;
         tbl.rows[i].cells[2].innerHTML="<a href='javascript:delTableRow(\""+i+"\")'><img src=${pageContext.request.contextPath }/images/delete.gif width=15 height=14 border=0 style=CURSOR:hand></a>";      
         tbl.rows[i].cells[1].childNodes[0].id=i;
      }
   }
}
*/

function insertRows(){ 
	//获取表格对象
	var tb1 = $("#dictTbl");
	var tempRow = $("#dictTbl tr").size();//获取表格的行数
	var $tdNum = $("<td align='center'></td>");
	$tdNum.html(tempRow);
	
	var $tdName = $("<td align='center'></td>");
	$tdName.html("<input name=\"dataDictionaryPropertyNames\" type=\"text\" id=\""+tempRow+"\" size=\"45\" maxlength=25>");
	
	var $tdDel = $("<td align='center'></td>");
	$tdDel.html("<a href='javascript:delTableRow(\""+tempRow+"\")'><img src=${pageContext.request.contextPath }/images/delete.gif width=15 height=14 border=0 style=CURSOR:hand></a>");
	
	
	// 创建tr，将3个td放置到tr中
	var $tr = $("<tr></tr>");
	$tr.append($tdName);
	$tr.append($tdDel);
	//在表格的最后追加新增的tr
	tb1.append($tr);
} 

function delTableRow(rowNum){ 
   //改变行号和删除的行号
   var tb1 = $("#dictTbl");
   var tempRow = $("#dictTbl tr").size();//获取表格的行数
   if (tempRow >rowNum){     
	  //获取删除行的id指定的对象，例如：<input name=\"itemname\" type=\"text\" id=\""+tempRow+"\" size=\"45\" maxlength=25>
	  $("#"+rowNum).parent().parent().remove();
	  //加1表示寻找下一个id，目的是将后面tr的格式向上移动
      for (i=(parseInt(rowNum)+1);i<tempRow;i++){
    	  //将i-1的值赋值给编号
    	  $("#"+i).parent().prev().html(i-1);
    	  //将i-1的值赋值给超链接的删除
    	  $("#"+i).parent().next().html("<a href='javascript:delTableRow(\""+(i-1)+"\")'><img src=${pageContext.request.contextPath }/images/delete.gif width=15 height=14 border=0 style=CURSOR:hand></a>");//
    	  //将i-1的值赋值给文本框的id，用于删除
    	  $("#"+i).attr("id",(i-1));//将id设置成i-1
      }
   }
} 


	function returnMethod(){
		return saveDict();
	}
	 </script>
 </HEAD>
		
	<body>
	 <Form name="Form1" id="Form1"  method="post" style="margin:0px;">
		<table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" colspan=3 align="center" background="${pageContext.request.contextPath }/images/b-info.gif">
						<font face="宋体" size="2"><strong>数据字典维护</strong></font>
					</td>
				</tr>
				<TR height=10><td colspan=3></td></TR>		
				<tr>
					<td class="ta_01" align="right" width="35%" >类型列表：</td>
					<td class="ta_01" align="left"  width="30%" >
					
					<s:select list="#dataDictionaryTypeList" cssClass="bg" headerKey="" headerValue="请选择"
					 cssStyle="width:180px" id="dataDictionaryType" name="dataDictionaryType.id"
					  listKey="id" listValue="name" onchange="changetype()">
					
					
					</s:select>
						
					</td>
						
					 <td class="ta_01"  align="right" width="35%" >					 	    
				    </td>	  		
				</tr>
				
				
				
				
				<TR height=10><td colspan=3 align="right">
				   <input type="button" name="saveitem" value="添加选项" style="font-size:12px; color:black; height=20;width=80" onClick="insertRows()">
				 </td></TR>   
			</TBODY>
		</table>
		</Form>
		
 <Form name="Form2" id="Form2"  method="post" style="margin:0px;">
    <table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0" >
    <tr>
     <td >
	   <table cellspacing="0"   cellpadding="1" rules="all" bordercolor="gray" border="1" id="dictTbl"
		    style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WIDTH:100%; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#f5fafe; WORD-WRAP:break-word">
			
		
						
				<tr style="FONT-WEIGHT:bold;FONT-SIZE:12pt;HEIGHT:25px;BACKGROUND-COLOR:#afd1f3">
					<td class="ta_01" align="center"  width="60%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">名称</td>
					<td class="ta_01" align="center"  width="20%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">删除</td>					
				</tr>
			    
			   
	            
			
	     </table>
	   </td>
	 </tr>
  <tr>
     <td >   
	 </td>
 </tr>
 <TR height=10><td colspan=3></td></TR>
  <tr>
     <td align="center" colspan=3>
       <input type="button" name="saveitem" value="保存" style="font-size:12px; color:black; height=20;width=50" onClick="returnMethod()">
	 </td>
 </tr>
	 
  </table>
   
    
   
  </Form>
  </body>
</HTML>


