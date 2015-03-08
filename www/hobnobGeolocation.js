module.exports = {
    start: function(success, failure, config) {
        cordova.exec(success || function() {},
             failure || function() {},
             'Twitter',
             'start',
             []);
    }
};