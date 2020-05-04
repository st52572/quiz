var UserProfile = (function() {
    var id = localStorage.getItem('id');
    var login = localStorage.getItem('login');


    var getId = function() {
        return id;    // Or pull this from cookie/localStorage
    };

    var setId = function(newId) {
        id = newId;
        localStorage.setItem('id',newId);
        // Also set this in cookie/localStorage
    };

    var getLogin = function() {
        return login;    // Or pull this from cookie/localStorage
    };

    var setLogin = function(newLogin) {
        login = newLogin;
        localStorage.setItem('login',newLogin);
        // Also set this in cookie/localStorage
    };

    return {
        getId: getId,
        setId: setId,
        getLogin: getLogin,
        setLogin: setLogin
    }

})();

export default UserProfile;