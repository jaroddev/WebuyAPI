
class LockTimeout {
    constructor(timeoutName = "locktimeout") {
        this.timeoutName = timeoutName;
        this.c = 0;
        this.interval;
    }
    
    inc() {
        ++this.c;
    }
    
    dec() {
        --this.c;
    }
    
    start() {
        const lockTimeout = this;
        
        clearInterval(this.interval);
        this.interval = setInterval(function() {
            if(lockTimeout.c === 0) {
                window.dispatchEvent(new Event(lockTimeout.timeoutName));
                clearInterval(lockTimeout.interval);
            }
        }, 1);
    }
}

const entityNames = [
    "shops",
    "shop-groups",
    "products",
    "offers",
];

const entityName = (function() {
    for(let i = 0; i < entityNames.length; ++i) {
        if(document.URL.match(new RegExp("/admin/" + entityNames[i], "i"))) {
            return entityNames[i];
        }
    }
    
    return null;
})();

const serviceType = (function() {
    if(document.URL.match(/\/admin\/login\/?$/i)) {
        return "login";
    }
    
    if(document.URL.match(new RegExp("/admin/(" + entityNames.join("|") + ")/?$", "i"))) {
        return "list";
    }
    
    if(document.URL.match(new RegExp("/admin/(" + entityNames.join("|") + ")/create/?$", "i"))) {
        return "create";
    }
    
    if(document.URL.match(new RegExp("/admin/(" + entityNames.join("|") + ")/edit/\\d+", "i"))) {
        return "edit";
    }
    
    return null;
})();

const entityId = (function() {
    const matches = document.URL.match(/\/(\d+)\/?$/);
    
    if(matches) {
        return Number(matches[1]);
    }
    
    return null;
})();
