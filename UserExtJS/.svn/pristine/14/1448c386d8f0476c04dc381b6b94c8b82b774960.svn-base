Ext.define('AM.view.user.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlist',

    title : 'All Users',
    
    //we no longer define the Users store in the `initComponent` method
    store: 'Users',
    renderTo: Ext.getBody(),

    enableColumnHide : false,
    autoScroll : true,
    containerScroll : true,
   // selModel: Ext.create('Ext.selection.CheckboxModel', {singleSelect : true }),//��Ӷ�ѡ��
    selType:'checkboxmodel',
    dockedItems: [{
 	   id:'toolbarid',
        xtype: 'toolbar',
        dock: 'top',
        width: 360,
        items: [
            {
                xtype: 'button',
                id: 'add-user-btn',
                icon: '../image/add.png',
                text: '新增用户'
            },"-",
            {
                xtype: 'button',
                id: 'delete-user-btn',
                icon   : '../image/delete.png',
                text: '删除用户'
            },"-",
            {
                xtype: 'button',
                id: 'save-user-btn',
                icon   : '../image/save.png',
                text: '保存'
            },"-"
            ]
    }],
    
//    selType: 'cellmodel',
//    plugins: [
//        Ext.create('Ext.grid.plugin.CellEditing', {
//            clicksToEdit: 1
//        })
//    ],
    
    initComponent: function() {
        this.columns = [
            {header: '用户名',  dataIndex: 'name',  
//                editor: {
//                    xtype: 'textfield',
//                    allowBlank: false
//                },
            	flex: 1},
            {header: 'email', dataIndex: 'email',
//                    editor: {
//                        xtype: 'textfield',
//                        allowBlank: false
//                    },
            		flex: 1},    
            {header: '组织', dataIndex: 'orgName'},
//            {header: '��֯ID', dataIndex: 'orgId',
//                        editor: {
//                            xtype: 'organizationCombo',
//                            displayField:'name',
//                            valueField:'id',
//                            name : 'orgId'
//                        },  
//                        flex: 1}
        ];

        this.callParent(arguments);
    }
});