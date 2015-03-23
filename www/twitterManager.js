var exec = require('cordova/exec');

var TwitterManager = function() {
};

TwitterManager.logout = function(hide) {
	console.log('plugin logout')
    exec(null, null, "TwitterManager", "logout", []);
};

module.exports = TwitterManager;



