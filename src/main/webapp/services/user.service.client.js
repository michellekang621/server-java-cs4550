function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    var url = 'http://wbdv-generic-server.herokuapp.com/api/michellekang/users';
    var self = this;

    function createUser(user) {
        fetch(url, {
            method: "POST",
            body: json.stringify(user),
            headers: {
                "content-type": "application/json"
            }
        })
            .then(response => response.json())
    }

    function findAllUsers() {
        fetch(url)
            .then(response => response.json())
    }

    function findUserById(id) {
        fetch(`${url}/${id}`)
            .then(response => response.json())
    }

    function updateUser(id, user) {
        fetch(`${url}/${id}`, {
            method: "PUT",
            body: json.stringify(user),
            headers: {
                "content-type": "application/json"
            }
        })
            .then(response => response.json())
    }

    function deleteUser(id) {
        fetch(`${url}/${id}`, {
            method: "DELETE",
        })
            .then(response => response.json())
    }
}
