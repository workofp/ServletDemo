Ext.define('AM.view.organization.Combo' ,{
    extend: 'Ext.form.field.ComboBox',
    alias : 'widget.organizationCombo',

    title : 'All Organizations',
    
    //we no longer define the Users store in the `initComponent` method
    store: 'Organizations',
    
    fieldLabel: '选择组织',
    queryMode: 'local',
    displayField: 'name',
    valueField: 'id',
    triggerAction : 'all',  
    queryMode: 'local',//申明本属性即可实现过滤
    fieldLabel: 'Choose Organization',
    forceSelection: true,
    lazyRender : true 
    
});