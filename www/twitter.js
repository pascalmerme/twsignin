module.exports = {
    logout: function(success, failure, config) {
        cordova.exec(success || function() {},
             failure || function() {},
             'TwitterManager',
             'logout',
             []);
    }
};