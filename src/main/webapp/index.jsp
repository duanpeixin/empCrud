<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("Path", request.getContextPath());
%>
<!-- 引入jquery -->
<script type="text/javascript" src="${Path }/static/js/jquery-3.3.1.min.js"></script>
<!-- 引入bootstrap jq -->
<script src="${Path }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<!-- 引入样式 -->
<link href="${Path }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

<!-- 增加模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName_add_input" class="col-sm-2 control-label">姓 名:</label>
                        <div class="col-sm-10">
                            <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="输入姓名">
                            <span  class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">邮 箱:</label>
                        <div class="col-sm-10">
                            <input type="text" name="empMail" class="form-control" id="email_add_input" placeholder="请输入邮箱">
                            <span  class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">绩 效:</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="empGrade" id="grade1_add_input" value="A" checked> A
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="empGrade" id="grade2_add_input" value="B"> B
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="empGrade" id="grade3_add_input" value="C"> C
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="empGrade" id="grade4_add_input" value="D"> D
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">部门名:</label>
                        <div class="col-sm-3">
                            <!-- 部门动态添加 -->
                            <select class="form-control" name="dId" id="dept_add_select">
                            </select>
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save_btn">提交</button>
            </div>
        </div>
    </div>
</div>

<!-- 编辑模态框 -->
<div class="modal fade" id="empEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myEditModalLabel">员工编辑</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName_add_input" class="col-sm-2 control-label">姓 名:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="empName_edit_input"></p>
                            <span  class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">邮 箱:</label>
                        <div class="col-sm-10">
                            <input type="text" name="empMail" class="form-control" id="email_edit_input" placeholder="请输入邮箱">
                            <span  class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">绩 效:</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="empGrade" id="grade1_edit_input" value="A" checked> A
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="empGrade" id="grade2_edit_input" value="B"> B
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="empGrade" id="grade3_edit_input" value="C"> C
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="empGrade" id="grade4_edit_input" value="D"> D
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_edit_input" class="col-sm-2 control-label">部门名:</label>
                        <div class="col-sm-3">
                            <!-- 部门动态添加 -->
                            <select class="form-control" name="dId" id="dept_edit_select">
                            </select>
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>



	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>员工后台管理</h1>
			</div>
		</div>

		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-8 col-md-offset-8">
				<button type="button" class="btn btn-success" id="emp_add_modal_btn">新增</button>
				<!--  <button type="button" class="btn btn-danger">删除</button>-->
			</div>

		</div>
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped" id="emp_table">	
				<thead>			
					<tr>
					    <th><input type="checkbox" id="checkAll"></th>
						<th>#</th>
						<th>姓名</th>
						<th>绩效</th>
						<th>邮箱</th>
						<th>部门</th>
						<th>操作</th>
					</tr>
					</thead>
					
			<tbody>
				
			</tbody>
			</table>

			</div>

		</div>
		<!-- 分页 -->
		<div class="row">
			<!-- 分页记录 -->
			<div class="col-md-6" id="pageInfo_area"></div>
			<!-- 分页条 -->
          <div class="col-md-6" id="pageNav_area"></div> 
		</div>

	</div>
	
	<script type="text/javascript">
	var PageTotal,currentPage;
	  $(function(){
		  toPage(1);	  
	  });
	  //跳转页码
	  function toPage(pn){
		  $.ajax({
			  url:"${Path }/emps",
			  data:"pn="+pn,
			  type:"get",
			  success:function(result){
				  //1.员工信息
				  getEmps(result);
				  //2.分页信息
				  getPageInfo(result);
				  //3.分页条
				  getPageNav(result);
			  }
			  
		  });
	  }
	  //员工信息
	  function getEmps(result){
		  $("#emp_table tbody").empty();
		  var emps = result.map.pageInfo.list;
		  $.each(emps,function(index,items){
			  var checkBox = $("<td><input type='checkbox' calss='check_items'></td>")
			  var empid = $("<td></td>").append(items.empId);
			  var empname = $("<td></td>").append(items.empName);
			  var empmail = $("<td></td>").append(items.empMail);
			  var empgrade = $("<td></td>").append(items.empGrade);
			  var empdepname = $("<td></td>").append(items.department.depName);
			  /*
			     编辑按钮
			  <button type="button" class="btn btn-info btn-sm">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
			</button>
			  */
			  var editButton = $("<buttod></button>").addClass("btn btn-info btn-sm edit_btn")
			  .append($("<span></span>")).addClass("glyphicon glyphicon-pencil")
			  .append("编辑");
			  //为按钮自定义属性 员工ID
			  editButton.attr("edit-empID",items.empId);
			  /*
			  删除按钮
			  button type="button" class="btn btn-danger btn-sm">
				<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
			</button>
			  */
			  var deleteButton = $("<buttod></button>").addClass("btn btn-danger btn-sm delete_btn")
			  .append($("<span></span>")).addClass("glyphicon glyphicon-trash")
			  .append("删除");
			  deleteButton.attr("delete-empID",items.empId);
			  var ButtonTd = $("<td></td>").append(editButton).append(" ").append(deleteButton);
			  
			  $("<tr></tr>").append(checkBox).append(empid)
			  .append(empname)
			  .append(empgrade)
			  .append(empmail)
			  .append(empdepname)
			  .append(ButtonTd)
			  .appendTo("#emp_table tbody")
		  });
	  }
	  //分页信息
	  function getPageInfo(result){
		  $("#pageInfo_area").empty();
		  $("#pageInfo_area").append("当前第"+result.map.pageInfo.pageNum+"页,总共"
				  +result.map.pageInfo.pages+"页，共"
				  +result.map.pageInfo.total+"条记录");		
		  PageTotal = result.map.pageInfo.total;
		  currentPage = result.map.pageInfo.pageNum
	  }
	  
	  //分页条
	  function getPageNav(result){
		  $("#pageNav_area").empty();
		  var ul = $("<ul></ul>").addClass("pagination");
		  var firstPage = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
		  var inPage = $("<li></li>").append($("<a></a>").append($("<span></span>")).append("&laquo;"));
		  if(result.map.pageInfo.hasPreviousPage==false){
			  firstPage.addClass("disabled");
			  inPage.addClass("disabled");
		  }else{
			  firstPage.click(function(){
				  toPage(1);
			  });
			  inPage.click(function(){
				  toPage(result.map.pageInfo.pageNum - 1);
			  });
		  }
		  var outPage = $("<li></li>").append($("<a></a>").append($("<span></span>")).append("&raquo;"));
		  var LastPage = $("<li></li>").append($("<a></a>").append("尾页").attr("href","#"));
		  if(result.map.pageInfo.hasNextPage==false){
			  outPage.addClass("disabled");
			  LastPage.addClass("disabled");
		  }else{
			  outPage.click(function(){
				  toPage(result.map.pageInfo.pageNum + 1);
			  });
			  LastPage.click(function(){
				  toPage(result.map.pageInfo.pages);
			  });
		  }
		  ul.append(firstPage).append(inPage);
		  var navigatepagenums = result.map.pageInfo.navigatepageNums;
		  $.each(navigatepagenums,function(index,items){
			  var num = $("<li></li>").append($("<a></a>").append(items));
			  if(result.map.pageInfo.pageNum==items){
				  num.addClass("active");
			  }
			  num.click(function(){
				  toPage(items);
			  });
			  ul.append(num);
		  });
		  ul.append(outPage).append(LastPage);
		  
		  var navEl = $("<nav></nav>").append(ul);
		  navEl.appendTo("#pageNav_area");
	  }
	//点击新增按钮调用模态框
	    $("#emp_add_modal_btn").click(function(){
	        //表单重置
            $("#empAddModal form")[0].reset();
            $("#empAddModal form").find("*").removeClass("has-error has-success");
            $("#empAddModal form").find(".help-block").text("");
	        //发送ajax请求，查出部门信息
	        getDepts("#empAddModal select");
	        //弹出模态框
	        $("#empAddModal").modal({
	            backdrop:"static"
	        });
	    });
	//查出所有部门信息
	function getDepts(ele){
        $(ele).empty();
        $.ajax({
            url:"${Path }/deps",
            type:"GET",
            success:function(result) {           	
                $.each(result.map.Deps, function () {
                    var optionEle = $("<option></option>").append(this.depName).attr("value", this.depId);
                    optionEle.appendTo(ele);
                });
            }
        })
    }
	//模态框数据校验
	function validate_add_form(){
		//1.校验姓名格式
        var empName = $("#empName_add_input").val();
        var regName =  /^[\u2E80-\u9FFF]+$/;
        $("#empName_add_input").parent().removeClass("has-error  has-success" );
        $("#empName_add_input").next("span").text(" ");
        if(!regName.test(empName)){
        	//错误信息显示         
          $("#empName_add_input").parent().addClass("has-error");
          $("#empName_add_input").next("span").text("请输入2-5个中文字符！");
            return false;       
        }else{
        	$("#empName_add_input").parent().addClass("has-success");
        	$("#empName_add_input").next("span").text("输入正确");
        }
        //2.校验邮箱格式
        var email = $("#email_add_input").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        $("#email_add_input").parent().removeClass("has-error  has-success" );
        $("#email_add_input").next("span").text(" ");
        if(!regEmail.test(email)){
        	$("#email_add_input").empty();
        	$("#email_add_input").parent().addClass("has-error");
        	$("#email_add_input").next("span").text("输入邮箱格式错误！");
            return false;
        }else{
        	$("#email_add_input").parent().addClass("has-success");
        	$("#email_add_input").next("span").text("输入正确");
        }
        return true;
    }
	//检验姓名是否可用
	$("#empName_add_input").change(function(){		
		var empName = this.value;
		$.ajax({
			url:"${Path }/checkEmps",
			data:"empName="+empName,
			type:"Post",
			success:function(result){
				$("#empName_add_input").parent().removeClass("has-error  has-success" );
			     $("#empName_add_input").next("span").text(" ");
				if(result.code==100){
					$("#empName_add_input").parent().addClass("has-success");
					$("#empName_add_input").next("span").text("用户名可用");
					$("#emp_save_btn").attr("ajax-val","success");
				}else{
					$("#empName_add_input").parent().addClass("has-error");
					$("#empName_add_input").next("span").text("用户名重复");
					$("#emp_save_btn").attr("ajax-val","error");
				}
			}
		})
		
	});
	
	//提交新增员工信息
	$("#emp_save_btn").click(function(){
		//校验格式
		if(!validate_add_form()){
            return false;
        }
		//校验名字
		if($(this).attr("ajax-val")=="erreo"){
			return false;
		}
        
		$.ajax({
			url:"${Path }/emps",
			type:"POST",
			data:$("#empAddModal form").serialize(),
			success:function(result){
				//员工保存成功  1.关闭模态框  2.跳到最后页显示新增数据
				//1.关闭
				if(result.code==100){
				$("#empAddModal").modal('hide');
				//2.到最后一页
				toPage(PageTotal);					
				}else{
					//显示失败信息
					if(undefined!=result.map.errorMap.empMail){
						//显示邮箱错误信息
						$("#email_add_input").parent().addClass("has-error");
			        	$("#email_add_input").next("span").text(result.map.errorMap.empMail);
					}
					if(undefined!=result.map.errorMap.empName){
						 $("#empName_add_input").parent().addClass("has-error");
				          $("#empName_add_input").next("span").text(result.map.errorMap.empName);
					}
				}
			}
		})
	})
	
	//为编辑按钮绑定事件
	$(document).on("click",".edit_btn",function(){
		 $("#email_edit_input").parent().removeClass("has-error  has-success" );
	     $("#email_edit_input").next("span").text(" ");
		//发请求，查员工信息
		getEmp($(this).attr("edit-empID"));
		//把员工id穿给更新按钮
		$("#emp_update_btn").attr("edit-empID",$(this).attr("edit-empID"));
		//发送ajax请求  查出部门信息
		getDepts("#empEditModal select")
		//弹出模态框
		$("#empEditModal").modal({
            backdrop:"static"
        });
	});
	//查询员工信息
	function getEmp(id){
        $.ajax({
            url:"${Path}/emps/"+id,
            type:"GET",
            success:function(result){
                var empDate = result.map.emp;
                $("#empName_edit_input").text(empDate.empName);
                $("#email_edit_input").val(empDate.empMail);
                //放在[]的选中
                $("#empEditModal input[name=empGrade]").val([empDate.empGrade]);
                $("#empEditModal select").val([empDate.dId]);
            }
        })
    }
	
	//更新员工信息
	$("#emp_update_btn").click(function(){
		//验证邮箱
		var email = $("#email_edit_input").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;       
        if(!regEmail.test(email)){
        	$("#email_edit_input").parent().addClass("has-error");
        	$("#email_edit_input").next("span").text("输入邮箱格式错误！");
            return false;
        }else{
        	$("#email_edit_input").parent().addClass("has-success");
        	$("#email_edit_input").next("span").text("输入正确");
        }
        
            //发送ajax请求更新数据
            $.ajax({
            	url:"${Path}/emps/"+$(this).attr("edit-empID"),
            	type:"PUT",
            	data:$("#empEditModal form").serialize(),
            	success:function(result){
            		$("#empEditModal").modal('hide');
            		toPage(currentPage);
            	}          	
            })            
	})
	//为删除按钮绑定事件
	$(document).on("click",".delete_btn",function(){
		//获得员工姓名
		var empName = $(this).parents("tr").find("td:eq(1)").text();
		var empID = $(this).attr("delete-empID");
		//判断是否删除
		if(confirm("是否要删除【"+empName+"】？")){
			//确定删除后发送ajax请求
			$.ajax({
				url:"${Path}/emps/"+empID,
				type:"DELETE",
				success:function(result){
					alert(result.msg);
					toPage(currentPage);
				}
			})
		}
	})
	//选择框全选
	$("#checkAll").click(function(){
		$(".check_items").prop("checked",$(this).prop("checked"));
	})
	$(document).on("click",".check_items",function(){
		var flag = ($(".check_items:checked").length == $(".check_items").length);
        $("#checkAll").prop("checked",flag);
	})
	
	
	</script>

</body>
</html>