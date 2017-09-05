Ext.define('AM.controller.Users', {
    extend: 'Ext.app.Controller',

    stores: [
             'Users',
             'Organizations'
         ],
    models: ['User','Organization'],         
    
    views: [
            'user.List',
            'organization.Combo',
            'user.Edit'
        ],
    
        init: function() {
            this.control({
                'userlist': {
                    itemdblclick: this.editUser
                },
             "#add-user-btn": {
                    click: this.newUser
                }, 
             "#delete-user-btn": {
                    click: this.deleteUser
                },   
             "#save-user-btn": {
                    click: this.saveUser
                },                 
            'useredit button[action=save]': {
                click: this.updateUser
            }            
            });
        },

        updateUser: function(button) {
            console.log('clicked the Save button');
            
            var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();
            
        if(record != null){
        	record.set(values);
        }else{
            var newrecord = new Ext.create('AM.model.User',values);
            this.getUsersStore().add(newrecord);
            record = newrecord;
        }
        
        // run some validation on the new user we just created
        var errors = record.validate();
        
        if(!errors.isValid()){
            console.log('Is User valid?', errors.isValid()); //returns 'false' as there were validation errors
            console.log('All Errors:', errors.items); //returns the array of all errors found on this model instance
            Ext.Msg.alert('Wait!', errors.items[0].field + ' ' + errors.items[0].message, Ext.emptyFn);
//            console.log('Name Errors:', errors.getByField('name')); //returns the errors for the age field  
            
//            Ext.Msg.alert('Wait!', errors.getByField('name')[0].field + ' ' + errors.getByField('name')[0].message, Ext.emptyFn);
            return;
        }

        win.close();  
        this.getUsersStore().sync({
            success : function ( batch ,option ){
            	console.log( 'success' ) ;  
            	this.getUsersStore().reload();
            	     } ,
            	     failure : function (){
            	console.log( 'failure...' ) ;	
            	this.getUsersStore().rejectChnages() ; // rollback...	
            	     } ,
            	     scope : this
            	});
        },
        
        deleteUser: function(button) {
            console.log('clicked the Delete button');
            
            Ext.Msg.confirm('删除确认','确定要删除?', function(btn) {
                if (btn == 'yes') {
                	var record=button.up('grid').getSelectionModel().getSelection();
                	Ext.getStore("Users").remove(record);
                	Ext.getStore("Users").sync();
                }
            });
            
        },
        
        saveUser: function(button) {
            console.log('clicked the Save button');
            
            this.getUsersStore().sync({
                success : function ( batch ,option ){
                	console.log( 'success' ) ;  
                	this.getUsersStore().reload();
                	     } ,
                	     failure : function (){
                	console.log( 'failure...' ) ;	
                	this.getUsersStore().rejectChnages() ; // rollback...	
                	     } ,
                	     scope : this
                	});
            
        },
        
        newUser: function(button) {
            console.log('Clicked on New');
            
            var view = Ext.widget('useredit');

            view.show();
        }, 
        
        editUser: function(grid, record) {
            console.log('Double clicked on ' + record.get('name'));
            
            var view = Ext.widget('useredit');

            view.down('form').loadRecord(record);
        }        

});