Ext.define('AM.view.organization.Combo' ,{
    extend: 'Ext.form.field.ComboBox',
    alias : 'widget.organizationCombo',

    title : 'All Organizations',
    
    //we no longer define the Users store in the `initComponent` method
    store: 'Organizations',
    
    fieldLabel: 'ѡ����֯',
    queryMode: 'local',
    displayField: 'name',
    valueField: 'id',
    triggerAction : 'all',  
    queryMode: 'local',//���������Լ���ʵ�ֹ���
    fieldLabel: 'Choose Organization',
    forceSelection: true,
    lazyRender : true 
    
});