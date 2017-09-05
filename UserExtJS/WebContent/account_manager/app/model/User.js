Ext.define('AM.model.User', {
    extend: 'Ext.data.Model',
    fields: ['id', 'name', 'email',{name:'orgId',mapping:'organization.id'},{name:'orgName',mapping:'organization.name'}],
    belongsTo: 'AM.model.Organization',
    validations: [
                  {type: 'presence', name: 'name'},
                  {type: 'length',   name: 'name', min: 5},
                  {type: 'format',   name: 'email', matcher: /^\s*\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*(\;\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)*(\;)*\s*$/},
                  {type: 'exclusion', name: 'name', list: ['administrator']}
              ],    
});