var HTTP_STATUS_CODES = {
    '0'   : 'Connection Error',
    '200' : 'OK',
    '201' : 'Created',
    '202' : 'Accepted',
    '203' : 'Non-Authoritative Information',
    '204' : 'No Content',
    '205' : 'Reset Content',
    '206' : 'Partial Content',
    '300' : 'Multiple Choices',
    '301' : 'Moved Permanently',
    '302' : 'Found',
    '303' : 'See Other',
    '304' : 'Not Modified',
    '305' : 'Use Proxy',
    '307' : 'Temporary Redirect',
    '400' : 'Bad Request',
    '401' : 'Unauthorized',
    '402' : 'Payment Required',
    '403' : 'Forbidden',
    '404' : 'Not Found',
    '405' : 'Method Not Allowed',
    '406' : 'Not Acceptable',
    '407' : 'Proxy Authentication Required',
    '408' : 'Request Timeout',
    '409' : 'Conflict',
    '410' : 'Gone',
    '411' : 'Length Required',
    '412' : 'Precondition Failed',
    '413' : 'Request Entity Too Large',
    '414' : 'Request-URI Too Long',
    '415' : 'Unsupported Media Type',
    '416' : 'Requested Range Not Satisfiable',
    '417' : 'Expectation Failed',
    '500' : 'Internal Server Error',
    '501' : 'Not Implemented',
    '502' : 'Bad Gateway',
    '503' : 'Service Unavailable',
    '504' : 'Gateway Timeout',
    '505' : 'HTTP Version Not Supported'
};

var fadeDelay = 500;

$(document.body).prop("tabindex","-1");

$.ajaxSetup({
    contentType: "application/json; charset=utf-8"
});

function sendGet(sendUrl, sfunc) {
    $.ajax({
        url: sendUrl,
        type: "GET",
        error: function (data, status) {
        },
        success: function (data, status) {
            if(sfunc) {
                sfunc();
            }
        }
    });
}

function sendPost(sendUrl, data, sfunc) {
    $.ajax({
        url: sendUrl,
        type: "POST",
        error: function (data, status) {
        },
        success: function (data, status) {
            if(sfunc) {
                sfunc();
            }
        },
        data: data
    });
}

function getNotificationPermission() {
    if (Notification.permission !== "granted") {
        Notification.requestPermission(function(result) {
            if (result === 'granted') {
                console.log("Notifications granted!");
            }
        });
    }
}

function humanFileSize(bytes, si=true, dp=1) {
    const thresh = si ? 1000 : 1024;
    if (Math.abs(bytes) < thresh) {
        return bytes + '\xa0';
    }
    const units = ['KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
    let u = -1;
    const r = 10**dp;
    do {
        bytes /= thresh;
        ++u;
    } while (Math.round(Math.abs(bytes) * r) / r >= thresh && u < units.length - 1);
    return bytes.toFixed(dp) + '\xa0' + units[u];
}

function load(addr) {
    if(hasParent()) {
        window.parent.loadInParent(addr);
    } else {
        window.location.href = "/";
    }
}

function returnPage(addr) {
    if(hasParent()) {
        window.parent.returnPageInParent();
    } else {
        window.location.href = "/";
    }
}

function notify(status, msg, time) {
    if(hasParent()) {
        window.parent.notifyInParent(status, msg, time);
    } else {
        UIkit.notification({message: msg, status: status, pos: 'bottom-center', timeout: time})
    }
}

function getRelativeDate(milis) {
    var timeDate = new Date(milis);
    var timeStr = timeDate.toLocaleDateString();
    if(timeStr === new Date().toLocaleDateString()) {
        return "Today";
    } else if(timeStr === new Date((new Date().getTime()) - 86400000).toLocaleDateString()) {
        return "Yesterday";
    } else if(milis < ((new Date().getTime()) - 31536000000)) { // more than 1 year
        return timeStr;
    } else if(milis > ((new Date().getTime() - 604800000))) { // less than 1 week
        const dayNames = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
        return dayNames[timeDate.getDay()];
    } else {
        const monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
        return monthNames[timeDate.getMonth()] + "/" + timeDate.getDate();
    }
}

function clearCache() {
    $.ajax({
        url: "/api/clearCache",
        type: "GET",
        success: function (data, status) {
            //location.reload();
        }
    });
}

function copyClipboard(data, msg) {
    navigator.clipboard.writeText(data)
        .then(() => { notify("primary", msg, 2000); })
        .catch((error) => { notify("warning", "Unsuccessful copy to clipboard!", 2000); });
}

var isRTL = function(s){
    var ltrChars    = 'A-Za-z\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u02B8\u0300-\u0590\u0800-\u1FFF'+'\u2C00-\uFB1C\uFDFE-\uFE6F\uFEFD-\uFFFF',
        rtlChars    = '\u0591-\u07FF\uFB1D-\uFDFD\uFE70-\uFEFC',
        rtlDirCheck = new RegExp('^[^'+ltrChars+']*['+rtlChars+']');
    return rtlDirCheck.test(s);
}

function getTime(milis) {
    var timeDate = new Date(milis);
    var hour = "" + timeDate.getHours();
    var min = "" + timeDate.getMinutes();
    hour = (hour.length === 1) ? "0" + hour : hour;
    min = (min.length === 1) ? "0" + min : min;
    return hour + ":" + min;
}

function onerror(data) {
    var text = HTTP_STATUS_CODES[data.status];
    UIkit.notification({message: text, status: 'warning', pos: 'bottom-center', timeout: 1000})
}

function hasParent() {
    return window.parent.loadInParent;
}

function fromHex(hex) {
    var str = '';
    for (var i = 0; i < hex.length; i += 2) {
        str += String.fromCharCode(parseInt(hex.substr(i, 2), 16));
    }
    return str;
}

function toHex(str) {
    var hex = '';
    for(var i=0;i<str.length;i++) {
        var p = str.charCodeAt(i).toString(16);
        hex += (p.length === 1) ? ('0' + p) : p;
    }
    return hex;
}

function deleteCookie(key) {
    key = toHex(key);
    document.cookie = key + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
}

function setCookie(key, value) {
    key = toHex(key);
    value = toHex(value);
    let date = new Date();
    let days = 365;
    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
    let expires = "expires=" + date.toUTCString();
    document.cookie = key + "=" + value + ";" + expires + ";path=/";
}

function hasCookie(key) {
    key = toHex(key);
    return (document.cookie.indexOf(key + "=") >= 0);
}

function getCookie(key) {
    key = toHex(key);
    let name = key + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i].trim();
        if (c.indexOf(name) === 0) {
            return fromHex(c.substring(name.length, c.length));
        }
    }
    return "";
}

function createLoadingSpinner() {
    var spinnerHolder = document.createElement('div');
    spinnerHolder.setAttribute("id", "LoadingSpinner");
    spinnerHolder.classList.add("Centered");
    spinnerHolder.style.textAlign = "center";
    spinnerHolder.style.position = "fixed";
    spinnerHolder.style.top = "120px";
    spinnerHolder.style.zIndex = "10";
    var spinner = document.createElement('div');
    spinner.setAttribute("uk-spinner", "ratio: 2");
    spinnerHolder.append(spinner);
    document.body.append(spinnerHolder);
}