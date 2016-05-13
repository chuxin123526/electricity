<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<HTML>
<HEAD>
<LINK href="${pageContext.request.contextPath }/css/jquery.treeview.css"
	type="text/css" rel="stylesheet">
<script language="javascript"
	src="${pageContext.request.contextPath }/script/jquery.treeview.js"></script>
<script language="javascript">
	$().ready(function() {
		$("#privilegeTree").treeview();

		$("[name=privilegeIDS]").click(function() {
			
			//当该复选框被选中的时候，所有该复选框下的复选框都被选中
			$(this).siblings("ul").find("input").attr("checked", this.checked);
			
			//当一个复选框被选中的时候，父元素复选框被选中
			if(this.checked)
			{
				$(this).parents("li").children("input").attr("checked" , "checked") ; 
			}
			else
			{
				//当取消当前复选框，检查兄弟元素，如所有兄弟元素未选中，则取消父复选框
				if($(this).parent().siblings("li").children("input:checked").size() == 0)
					{
						$(this).parent().parent().siblings("input").attr("checked" , false) ;
						
						//再检查父复选框的兄弟元素，如都没选中，则取消父父复选框
						if($(this).parent().parent().parent().siblings("li").children("input:checked").size() == 0)
							{
								$(this).parent().parent().parent().parent().siblings("input").attr("checked" , false) ;
							}
						
					}
			}
			
		}

		);

	}

	);
	
	function changeRole()
	{
		//通过ajax加载数据
		var url = "${pageContext.request.contextPath }/system/roleAction_changeRole.action" ; 
		var roleID = $("#roleSelect").val() ;

		$("#Form2").load(url , {"role.id":roleID}) ;
	}

	
</script>
</HEAD>

<input type="hidden" name="role.id" value="${role.id}" />

<table cellSpacing="1" cellPadding="0" width="90%" align="center"
	bgColor="#f5fafe" border="0">
	<tr>
		<td>
			<fieldset
				style="width: 100%; border: 1px solid #73C8F9; text-align: left; COLOR: #023726; FONT-SIZE: 12px;">
				<legend align="left">权限分配</legend>

				<ul id="privilegeTree" class="filetree">
					<s:iterator value="topPrivilegeList">
						<li><input type="checkbox" name="privilegeIDS" value="${id}" />${name}
							<ul>
								<s:iterator value="privileges">
									<li><input type="checkbox" name="privilegeIDS"
										value="${id}" />${name}
										<ul>
											<s:iterator value="privileges">
												<li><input type="checkbox" name="privilegeIDS"
													value="${id}" />${name}</li>
											</s:iterator>
										</ul></li>
								</s:iterator>
							</ul></li>



					</s:iterator>


				</ul>
			</fieldset>


			<fieldset
				style="width: 100%; border: 1px solid #73C8F9; text-align: left; COLOR: #023726; FONT-SIZE: 12px;">
				<legend align="left">用户</legend>

				<table>
					<thead>
						<tr>
							<td width="180px"><input type="checkbox"
								onchange="$(this).parent().parent().parent().siblings('tbody').children('tr').find('input').attr('checked' , this.checked) " /></td>
							<td width="180px">登录名</td>
							<td width="180px">姓名</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="userList">
							<tr>
								<input type="hidden" name="userIDS" value="${id}" />
								<td width="180px"><input type="checkbox" /></td>
								<td width="180px">${loginName}</td>
								<td width="180px">${name}</td>
							</tr>
						</s:iterator>
					</tbody>

				</table>

			</fieldset>
			<button type="button" style="margin-left: 50%; margin-top: 20px"
				onclick="$('#Form2').submit()">提交</button>


		</td>
	</tr>
</table>
</body>
</HTML>
