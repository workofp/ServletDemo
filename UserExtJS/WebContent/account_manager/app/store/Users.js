Ext.define('AM.store.Users', {
    extend: 'Ext.data.Store',
//    fields: ['name', 'email'],
    model: 'AM.model.User',
//    data: [
//        {name: 'Ed',    email: 'ed@sencha.com'},
//        {name: 'Tommy', email: 'tommy@sencha.com'}
//    ]
    autoLoad: true,

    proxy: {
        type: 'ajax',
//        url: 'data/users.json',
        api: {
//            read: 'data/users.json',
        	read: '/UserSSH/listUser',
        	create: '/UserSSH/editUser', 
            update: '/UserSSH/editUser',
//        	update: '/UserSSH/saveUsersExt',
        	destroy:'/UserSSH/destroyUser'
        },
        reader: {
            type: 'json',
//            root: 'users',
            root: 'object',
            successProperty: 'success'
        }
    }
});