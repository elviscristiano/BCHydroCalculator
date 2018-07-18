var exec = require('cordova/exec');

// module.exports.coolMethod = function (arg0, success, error) {
//     exec(success, error, 'BCHydroCalculator', 'coolMethod', [arg0]);
// };

module.exports.calculate = function (arg0, success, error) {
    exec(success, error, 'BCHydroCalculator', 'calculate', [arg0]);
};
