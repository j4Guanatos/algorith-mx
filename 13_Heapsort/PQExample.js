
var PQ = function(maxSize, compare){

    if(!maxSize)
        maxSize = 10;
    if(!isFunction(compare)) {
        compare = function (a, b) {
            return a - b;
        }
    }

    var heap = new Array(maxSize + 1),
        N = 0;

    function isFunction(functionToCheck) {
        var getType = {};
        return functionToCheck && getType.toString.call(functionToCheck) === '[object Function]';
    }

    function parent (i){
        return i >> 1;      // 0.5i
    }

    function left (i){
        return i << 1;      // 2i
    }

    function right (i){
        return i << 1 | 1;  // 2i + 1
    }

    var swap = function (i, j) {
        var t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    var heapifySink = function (i) {
        while (2 * i <= N){
            var l = left(i),
                r = right(i),
                most = i;
            if (l <= N && heap[l] && compare(heap[i], heap[l]) > 0) most = l;
            if (r <= N && heap[r] && compare(heap[most], heap[r]) > 0) most = r;
            if (most == i) break;
            swap(i , most);
            i = most;
        }
    }

    var heapifySwim = function (i) {
        while (i > 1 && compare(heap[parent(i)], heap[i]) > 0) {
            var paren = parent(i);
            swap(paren, i);
            i = paren;
        }
    }

    // Exposed API

    return {
        insert: function (el) {
            heap[++N] = el;
            heapifySwim(N);
        },
        most: function() {
            if(1 in heap && heap[1] != undefined)
                return heap[1];
            else
                return null;
        },
        removeMost: function() {
            var self = this,
                mos = self.most();
            if(mos){
                swap(1, N--);
                heap[N + 1] = null;
                heapifySink(1);
            }
            return mos;
        },
        size: function () {
            return N;
        }
    };
}

var myPQ = PQ(10, function(a, b){return b - a;});
myPQ.insert(5);
myPQ.insert(3);
myPQ.insert(2);
myPQ.insert(9);
myPQ.insert(7);
myPQ.insert(4);
myPQ.insert(6);
myPQ.insert(8);
myPQ.insert(1);

console.log("Removed: "+myPQ.removeMost());
console.log("Removed: "+myPQ.removeMost());
console.log("Removed: "+myPQ.removeMost());
console.log("Removed: "+myPQ.removeMost());
console.log("Removed: "+myPQ.removeMost());
console.log("Removed: "+myPQ.removeMost());
console.log("Removed: "+myPQ.removeMost());
console.log("Removed: "+myPQ.removeMost());
console.log("Removed: "+myPQ.removeMost());