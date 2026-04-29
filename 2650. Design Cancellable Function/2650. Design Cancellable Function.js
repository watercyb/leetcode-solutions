/*
 * Problem: 2650. Design Cancellable Function
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/design-cancellable-function/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Generator} generator
 * @return {[Function, Promise]}
 */
var cancellable = function (generator) {
    var isCancelled = false;
    var promise = new Promise(async (resolve, reject) => {
        async function run(re, e) {
            try {
                if (isCancelled) {
                    var res = generator.throw('Cancelled');
                    console.log(res);
                    resolve(res.value);
                }
                var res = e === null ? generator.next(re) : generator.throw(e);
                if (res.done) {
                    resolve(res.value);
                } else {
                    val = res.value.then((re) => run(re, null)).catch((e) => run(null, e));
                }
            } catch (e) {
                reject(e);
            }
        }
        run(null, null);
    });
    function cancel() {
        isCancelled = true;
    }
    return [cancel, promise];
};

/**
 * function* tasks() {
 *   const val = yield new Promise(resolve => resolve(2 + 2));
 *   yield new Promise(resolve => setTimeout(resolve, 100));
 *   return val + 1;
 * }
 * const [cancel, promise] = cancellable(tasks());
 * setTimeout(cancel, 50);
 * promise.catch(console.log); // logs "Cancelled" at t=50ms
 */
