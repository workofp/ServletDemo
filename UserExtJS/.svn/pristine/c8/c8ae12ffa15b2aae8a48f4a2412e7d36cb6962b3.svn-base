Ext.define('AM.store.Organizations', {
    extend: 'Ext.data.Store',
    model: 'AM.model.Organization',
    autoLoad: true,

    proxy: {
        type: 'ajax',
        api: {
        	read: '/UserSSH/listOrg',
        	create: '/UserSSH/editUser', 
        	update: '/UserSSH/editUser',
        	destroy:'/UserSSH/destroyUser'
        },
        reader: {
            type: 'json',
            root: 'object',
            successProperty: 'success'
        }
    }
});