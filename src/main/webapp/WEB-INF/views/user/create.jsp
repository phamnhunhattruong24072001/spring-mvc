<form action="/user/store" method="post">
    <div class="row">
        <div class="form-group col-lg-6">
            <label>Email address</label>
            <input type="text" class="form-control" name="email">
        </div>
        <div class="form-group col-lg-6">
            <label>Username</label>
            <input type="text" name="username" class="form-control">
        </div>
        <div class="form-group col-lg-6">
            <label>First name</label>
            <input type="text" class="form-control" name="firstName">
        </div>
        <div class="form-group col-lg-6">
            <label>Last name</label>
            <input type="text" class="form-control" name="lastName">
        </div>
        <div class="form-group col-lg-6">
            <label>Password</label>
            <input type="password" class="form-control" name="password">
        </div>
        <div class="col-lg-12">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>
</form>