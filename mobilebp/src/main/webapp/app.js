/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Mobilebp',

    extend: 'Mobilebp.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Mobilebp.view.mainleftmenutree.MainPanel':'Mobilebp.view.mobileview.main.MainPanel',
	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Mobilebp.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
