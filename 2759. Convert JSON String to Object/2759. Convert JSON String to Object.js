/*
 * Problem: 2759. Convert JSON String to Object
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/convert-json-string-to-object/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {string} str
 * @return {null|boolean|number|string|Array|Object}
 */
var jsonParse = function (str) {
    var idx = 0;
    function run() {
        if (str[idx] == '{') {
            var res = {};
            idx++;
            while (str[idx] != '}') {
                var k = run();
                idx++;
                var v = run();
                res[k] = v;
                if (str[idx] == ',') idx++;
            }
            idx++;
            return res;
        } else if (str[idx] == '[') {
            var res = [];
            idx++;
            while (str[idx] != ']') {
                res.push(run());
                if (str[idx] == ',') idx++;
            }
            idx++;
            return res;
        } else if (str[idx] == '"') {
            var res = '';
            idx++;
            while (str[idx] != '"') {
                res += str[idx];
                idx++;
            }
            idx++;
            return res;
        } else if (str[idx] == 't') {
            idx += 4;
            return true;
        } else if (str[idx] == 'f') {
            idx += 5;
            return false;
        } else if (str[idx] == 'n') {
            idx += 4;
            return null;
        } else {
            var res = '';
            while (str[idx] != ',' && str[idx] != '}' && str[idx] != ']' && idx < str.length) {
                res += str[idx];
                idx++;
            }
            return parseFloat(res);
        }
    }
    return run();
};
