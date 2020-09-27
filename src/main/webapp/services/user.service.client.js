//function AdminUserServiceClient() {
//    this.createUser = createUser;
//    this.findAllUsers = findAllUsers;
//    this.findUserById = findUserById;
//    this.deleteUser = deleteUser;
//    this.updateUser = updateUser;
//    this.url = 'https://wbdv-generic-server.herokuapp.com/api/jannunzi/users';
//    var self = this;
//    function createUser(user) { … }
//    function findAllUsers() { … }
//    function findUserById(userId) { … }
//    function updateUser(userId, user) { … }
//    function deleteUser(userId) { … }
//}

const url = 'https://wbdv-generic-server.herokuapp.com/api/michellekang/users'

const streamIsDone = (jsonData) => {
    console.log(jsonData)
}

const userService = {
    findAllUsers: () =>
        fetch(url)
            .then(response => response.json()),
    deleteUser: (userId) =>
        fetch(`${url}/${userId}`, {         //same as concatenating
            method: "DELETE"
        })
            .then(response => response.json()),
    createUser: (user) =>
        fetch(url, {
            method: "POST",
            body: JSON.stringify(user),
            headers: {
                "content-type": "application/json"
            }
        })
            .then(response => response.json()),
    updateUser: (userId, updatedUser) =>
        fetch(`${url}/${userId}`, {
            method: "PUT",
            body: JSON.stringify(updatedUser),
            headers: {
                "content-type": "application/json"
            }
        })
            .then(response => response.json())
}