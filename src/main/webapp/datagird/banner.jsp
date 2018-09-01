<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style type="text/css">
    .in{
        margin-top:30px;
        margin-left:30px;
    }
</style>
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-edit',
            text: "添加",
            handler: function () {
                $('#banner_div').dialog("open");
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-control_remove_blue',
            handler: function () {
                var row = $("#banner_table").edatagrid("getSelected");
                if(row){
                    var id =row.id;
                    $.ajax({
                        type:"post",
                        url:"${pageContext.request.contextPath}/banner/delete",
                        data:"id="+id,
                        dataType:"text",
                        success:function(){
                            $("#banner_table").edatagrid("load");
                        }
                    });
                }else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-bullet_edit',
            handler: function () {
                /*
                 *使当前选中行可编辑模式
                 * */
                var row = $("#banner_table").edatagrid("getSelected");
                if (row != null) {

                    var index = $("#banner_table").edatagrid("getRowIndex", row);
                    //当前行可编辑
                    $("#banner_table").edatagrid("editRow", index);
                }else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-script_save',
            handler: function () {
                $("#banner_table").edatagrid('saveRow');
                $("#banner_table").edatagrid("load");
            }
        }]
        
        $("#banner_table").edatagrid({
           url: '${pageContext.request.contextPath}/banner/queryAll',
           method: "post",
           updateUrl: "${pageContext.request.contextPath}/banner/update",
           columns:[[
               {field:'id',title:'编号',width:100,editor:{
                   type:"text",
                   options:{
                       required:true
                   }
               }},
               {field:'title',title:'名称',width:100,editor:{
                   type:"text",
                   options:{
                       required:true
                   }
               }},
               {field:'imgPath',title:'图片路径',width:100,editor:{
                   type:"text",
                   options:{
                       required:true
                   }
               }},
               {field:'status',title:'状态',width:100,editor:{
                type:"text",
                   options:{
                       required:true
                   }
               }},
               {field:'description',title:'图片描述',width:100,editor:{
                   type:"text",
                   options:{
                       required:true
                   }
               }},
               {field:'createDate',title:'上传日期',width:100,editor:{
                   type:"text",
                   options:{
                       required:true
                   }
               }}
           ]],
            fitColumns:true,
            fit:true,
            pagination:true,
            pageSize:5,
            pageList:[5,10,15,20],
            toolbar:toolbar,
            view:detailview,
            detailFormatter: function (rowIndex,rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}'+rowData.imgPath+'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.createDate + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    });
    function submit() {
        $("#banner_form").form("submit", {
            url: "${pageContext.request.contextPath}/banner/add",
            onSubmit:function(){
                return true;
            },
        })
    }
</script>

<table id="banner_table"></table>
<div id="banner_div" class="easyui-dialog" title="添加轮播图" style="width:400px;height:350px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,width:600,height:500,buttons:[{
				text:'保存',
				handler:function(){
                     submit();
                      $('#banner_div').dialog('close');
                      $('#banner_table').edatagrid('reload')
				}
			},{
				text:'关闭',
				handler:function(){
                     $('#banner_div').dialog('close');
				}
			}]">
    <form id="banner_form" enctype="multipart/form-data" method="post">
        <input name="id" type="hidden"/>
        <div class="in">
             名称:<input name="title" class="easyui-validatebox" data-options="required:true"/>
        </div>
        <div class="in">
            图片路径:<input  name="img" class="easyui-filebox" data-options="required:true"/>
        </div>
        <div class="in">
            图片描述:<input name="description" class="easyui-textbox" data-options="required:true"/>
        </div>
        <div class="in">
            状态:<select  class="easyui-combobox" name="status" style="width:200px;">
                    <option value="Y">展示</option>
                    <option value="N">不展示</option>
                  </select>
        </div>
        <div class="in">
           上传日期:<input  name="createDate" class="easyui-datetimebox" data-options="required:true"/>
        </div>
    </form>
</div>