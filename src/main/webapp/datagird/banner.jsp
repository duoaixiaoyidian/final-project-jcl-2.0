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
                $('#dg').dialog({
                    title:'添加轮播图片',
                    iconCls:'icon-add',
                    width:600,
                    height:300,
                    buttons:[{
                        text:'提交',
                        iconCls:'icon-ok',
                        handler:function () {
                            $('#fom').submit();

                        }
                    }]
                });
                $('#fom').form({
                    url:"${pageContext.request.contextPath}/banner/add",
                    onSubmit:function () {
                        var b =$('#fom').form('validate');
                        if(b){
                            return true;
                        }else{
                            return false;
                        }
                    },
                    success: function() {
                        $("#dg").dialog("close");
                        $("#tb").datagrid("load");
                    }
                });
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-control_remove_blue',
            handler: function () {
                var row = $("#tb").edatagrid("getSelected");
                if(row){
                    var id =row.id;
                    $.ajax({
                        type:"post",
                        url:"${pageContext.request.contextPath}/banner/delete",
                        data:"id="+id,
                        dataType:"text",
                        success:function(){
                            $("#tb").datagrid("load");
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
                var row = $("#tb").edatagrid("getSelected");
                if (row != null) {

                    var index = $("#tb").edatagrid("getRowIndex", row);
                    //当前行可编辑
                    $("#tb").edatagrid("editRow", index)

                } else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-script_save',
            handler: function () {
                $("#tb").edatagrid("saveRow")
            }
        }]
        
        $("#tb").edatagrid({
           url: '${pageContext.request.contextPath}/banner/queryAll',
           method: 'post',
           updateUrl:"${pageContext.request.contextPath}/banner/add",//通过URL更新数据到服务器并返回更新的行
           columns:[[
               {field:'id',title:'编号',width:100},
               {field:'title',title:'名称',width:100},
               {field:'imgPath',title:'图片',width:100},
               {field:'status',title:'状态',width:100,editor:{
                type:"text",
                   options:{
                       required:true
                   }
               }},
               {field:'description',title:'描述',width:100 },
               {field:'createDate',title:'上传时间',width:100}
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

</script>

<table id="tb"></table>


<div id="dg" style="padding:20px;">
    <form id="fom">
        <input id="dd" name="id" type="hidden" />
        <div class="in">
             Title<input id="title" name="title" class="easyui-textbox" data-options="required:true"/>
        </div>
        <div class="in">
            ImgPath<input id="img" name="imgPath" class="easyui-textbox" data-options="required:true"/>
        </div>
        <div class="in">
            Description<input id="description" name="description" class="easyui-textbox" data-options="required:true"/>
        </div>
        <div class="in">
            Status<input id="status" name="status" class="easyui-textbox" data-options="required:true"/>
        </div>
        <%--<div class="in">
           CreateDate<input id="create" name="createDate" class="easyui-datetimebox" data-options="required:true"/>
        </div>--%>
    </form>
</div>