<div class="container mt-4">
    <h2>User List</h2>
    <a href="/user/create" class="btn btn-primary mb-3">Create New User</a>

    <table class="table table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Email</th>
            <th>Username</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user}</td>
                <td>${user.email}</td>
                <td>${user.username}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>
                    <a href="/user/edit/${user.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="/user/delete/${user.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('Are you sure you want to delete this user?');">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>