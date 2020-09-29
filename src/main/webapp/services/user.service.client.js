function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    var url = 'https://wbdv-generic-server.herokuapp.com/api/001418910/users';
    var self = this;

    function createUser(user) {
        return fetch(url, {
            method: "POST",
            body: JSON.stringify(user),
            headers: {
                "content-type": "application/json"
            }
        })
            .then(response => response.json())
    }

    function findAllUsers() {
        return fetch(url)
            .then(response => response.json())
    }

    function findUserById(id) {
        return fetch(`${url}/${id}`)
            .then(response => response.json())
    }

    function updateUser(id, user) {
        return fetch(`${url}/${id}`, {
            method: "PUT",
            body: JSON.stringify(user),
            headers: {
                "content-type": "application/json"
            }
        })
            .then(response => response.json())
    }

    function deleteUser(id) {
        return fetch(`${url}/${id}`, {
            method: "DELETE",
        })
            .then(response => response.json())
    }
}
