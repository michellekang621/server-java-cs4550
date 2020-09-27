// declaring all inside function makes all variables automatically local variables
// best practice! to encapsulate it in an ify(??) expression
// a function that self invokes itself
(function () {

let users = [

    {
    username: "alice",
    fName: "Alice",
    lName: "Wonderland",
    role: "STUDENT"
    },
    {
    username: "bob",
    fName: "Bob",
    lName: "Marley",
    role: "STUDENT"
    },
    {
    username: "charlie",
    fName: "Charlie",
    lName: "Garcia",
    role: "FACULTY"
    }

]

// $ is an alias for jQuery
// put $ in front of variable name whenever the variable is something
// you grabbed through jQuery


const onclickEventHandler = () => {
    alert("heading clicked")
}

const deleteUser = (event) => {
    const deleteBtn = event.currentTarget
    // turns dom object into jQuery object
    const $deleteBtn = $(deleteBtn)
//    const parent = $deleteBtn.parent().parent().parent()
    const parent = $deleteBtn.parent("tr")
    parent.remove()

//    alert("delete user")
}

// instead of manipulating the dom, im gonna manipulate the data model
// in this case the array
const deleteUser2 = (index) => {
    const user = users[index]
    const userId = user._id
    userService.deleteUser(userId)
        .then(status => {
            console.log(status)
            users.splice(index, 1)
            renderUsers(users)
        })
    console.log(index)
    users.splice(index, 1)
    console.log(users)
    renderUsers(users)
}

let selectedUserIndex == -1

const selectUser = (index) => {
    selectedUserIndex = index
    $("#usernameFld").val(users[index.username])
    $("#firstnameFld").val(users[index.first])
    $("#lastnameFld").val(users[index.last])

}

let $template
let $tbody

function renderUsers(users) {
    $tbody.empty()

        for (let i = 0; i < users.length; i++) {
            const user = users[i]
            const username = user.username
            const fName = user.first
            const lName = user.last
            const role = user.role

            const $clone = $template.clone()

            $clone.removeClass("wbdv-hidden")

            const $username = $clone.find(".wbdv-username")
            $username.html(username)
            const $fName = $clone.find(".wbdv-first-name")
            $fName.html(fName)
            const $lName = $clone.find(".wbdv-last-name")
            $lName.html(lName)
            const $role = $clone.find(".wbdv-role")
            $role.html(role)

            const $removeBtn = $clone.find(".wbdv-remove")
            // ability to remembr what the state was (including index) at this time
            // () => deleteUser2(i) declares the function rather than calling it
            // at time of loop
            $removeBtn.click(() => deleteUser2(i))

            $clone
                .find(".wbdv-select")
                .click(() => selectUser(i))

            $tbody.append($clone)
            }

}

const createUser = () => {
    const username = $("#usernameFld").val()
    const first = $("#firstNameFld").val()
    const last = $("#lastNameFld").val()
    // implied that name of property and name of var is called the same (shortcut instead of doing ie  username = username
    const newUser = {
        username,
        first,
        last
    }

    userService.createUser(newUser)
        .then(actualInsertedUser => {
            users.push(actualInsertedUser)
            renderUsers(users)
        })
}

const updateUser = () => {
    const updatedFields = {
        username: $("#usernameFld").val(),
        first: $("#firstnameFld").val(),
        last: $("#lastnameFld").val()
    }

    const userId = users[selectedUserIndex]._id
    userService.updateUser(userId, updatedFields)
        .then(status => {
            users[selectedUserIndex] = updatedFields
            renderUsers(users)
        })
}


function init() {
    const heading1 = jQuery("h1")
//    heading1.remove()
//    heading1.css("backgroundColor", "yellow");
//    heading1.html("User Administration")
//    heading1.append(" - for Administrators only")

    heading1
        .css("backgroundColor", "yellow")
        .html("User Administration")
        .append(" - for Administrators only")
        .click(onclickEventHandler)

    $tbody = $("tbody.wbdv-tbody")
    $template = jQuery(".wbdv-template")
    $(".wbdv-create").click(createUser)
    $(".wbdv-update").click(updateUser)


    userService.findAllUsers()
        .then(_users => {
            console.log(_users)
            users = _users
            renderUsers(users)

        })


}


jQuery(init)
}


// all embedded inside immediately invoked function expression
//(function () {
//    var $usernameFld, $passwordFld;
//    var $removeBtn, $editBtn, $createBtn;
//    var $firstNameFld, $lastNameFld, $roleFld;
//    var $userRowTemplate, $tbody;
//    var userService = new AdminUserServiceClient();
//    $(main);
//
//    function main() { … }
//    function createUser() { … }
//    function findAllUsers() { … }
//    function findUserById() { … }
//    function deleteUser() { … }
//    function selectUser() { … }
//    function updateUser() { … }
//    function renderUser(user) { … }
//    function renderUsers(users) { … }
//})();
