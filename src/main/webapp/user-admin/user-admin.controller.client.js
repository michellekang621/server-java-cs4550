(function () {
    var $usernameFld, $passwordFld;
    var $searchBtn, $createBtn, $updateBtn;
    var $removeBtn, $selectBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $template, $tbody;
    var users = [];
    let selectedUserIndex = -1;
    var userService = new AdminUserServiceClient();

    function createUser() {
        const username = $("#usernameFld").val()
        const password = $("#passwordFld").val()
        const first = $("#firstNameFld").val()
        const last = $("#lastNameFld").val()
        const role = $("#roleFld").val()
        const newUser = {
            username,
            password,
            first,
            last,
            role
        }

        userService.createUser(newUser)
            .then(actualInsertedUser => {
                users.push(actualInsertedUser)
                $("#usernameFld").val("")
                $("#passwordFld").val("")
                $("#firstNameFld").val("")
                $("#lastNameFld").val("")
                $("#roleFld").val()
                renderUsers(users)
            })

    }
    function findAllUsers() {
        userService.findAllUsers()
            .then(_users => {
                users = _users
                renderUsers(users)
            })
    }

//    function findUserById() {}

    function deleteUser(index) {
    console.log(index)
     const user = users[index]
     const userId = user._id
     userService.deleteUser(userId)
        .then(status => {
            users.splice(index, 1)
            renderUsers(users)
        })
    }


    function selectUser(index) {
        selectedUserIndex = index
        $("#usernameFld").val(users[index].username)
        $("#passwordFld").val(users[index].password)
        $("#firstNameFld").val(users[index].first)
        $("#lastNameFld").val(users[index].last)
        $("#roleFld").val(users[index].role)
    }
    function updateUser() {
        const updatedUser = {
            username: $("#usernameFld").val(),
            password: $("#passwordFld").val(),
            first: $("#firstNameFld").val(),
            last: $("#lastNameFld").val(),
            role: $("#roleFld").val()
        }

        const userId = users[selectedUserIndex]._id
        userService.updateUser(userId, updatedUser)
            .then(status => {
                users[selectedUserIndex].username = updatedUser.username
                users[selectedUserIndex].password = updatedUser.password
                users[selectedUserIndex].first = updatedUser.first
                users[selectedUserIndex].last = updatedUser.last
                users[selectedUserIndex].role = updatedUser.role
                $("#usernameFld").val("")
                $("#passwordFld").val("")
                $("#firstNameFld").val("")
                $("#lastNameFld").val("")
                $("#roleFld").val()
                renderUsers(users)
            })

    }
    function renderUser(user) {
        const username = user.username
        const password = user.password
        const first = user.first
        const last = user.last
        const role = user.role

        const $clone = $template.clone()
        $clone.removeClass("wbdv-hidden")

        const $username = $clone.find(".wbdv-username")
        $username.html(username)
        const $password = $clone.find(".wbdv-password")
        $password.html(password)
        const $first = $clone.find(".wbdv-first-name")
        $first.html(first)
        const $last = $clone.find(".wbdv-last-name")
        $last.html(last)
        const $role = $clone.find(".wbdv-role")
        $role.html(role)

        $removeBtn = $clone.find(".wbdv-remove")
        $selectBtn = $clone.find(".wbdv-select")

        return $clone
    }

    function renderUsers(users) {
        $tbody.empty()
        for (let i = 0; i < users.length; i++) {
            user = users[i]
            clone = renderUser(user)
            $removeBtn.click(() => deleteUser(i))
            $selectBtn.click(() => selectUser(i))
            $tbody.append(clone)
        }
    }


    function main() {
        $template = $(".wbdv-template")
        $tbody = $("tbody.wbdv-tbody")

        $(".wbdv-create").click(createUser)
        $(".wbdv-update").click(updateUser)
        findAllUsers()
    }

    $(main);

})();
