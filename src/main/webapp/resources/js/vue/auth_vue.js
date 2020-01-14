var auth_vue = auth_vue || {}
auth_vue = {

  join: () => {
    return `<body class="bg-light">
    <div class="container">
  <div class="py-5 text-center">
   
    <h2>회원가입 form</h2>
 
  </div>

  <div class="row">
   
    <div class="col-md-8 order-md-1">
      
      <form class="needs-validation" novalidate="">
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="firstName">아이디</label>
            <input type="text" class="form-control" id="join_uid" placeholder="" value="" required="">
            <div class="invalid-feedback">
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="lastName">비밀번호</label>
            <input type="text" class="form-control" id="join_upw" placeholder="" value="" required="">
            <div class="invalid-feedback">
            </div>
          </div>
        </div>
        </div>
        <hr class="mb-4">
        <button id="btn_join" class="btn btn-primary btn-lg btn-block" type="submit">회원가입</button>
      </form>
    </div>
  </div>
</body>
    `
  },

  login: ()=> {
    return `<body class="text-center">
    <ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" href="#">Active</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Link</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Link</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
  </li>
</ul>
    <form class="form-signin">
  <img class="mb-4" src="" alt="" width="72" height="72">
  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
  <label for="inputEmail" class="sr-only">User Id</label>
  <input type="text" id="login_uid" class="form-control" placeholder="ID" required="" autofocus="" value="kim">
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" id="login_upw" class="form-control" placeholder="Password" required="" value="1234">
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  <button id="btn_login" class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
   
      <div class="checkbox mb-3">
		      <label>
		       <a id="a_join" href="#">회원가입</a>        
		     </label>
		    </div>
  <p class="mt-5 mb-3 text-muted"> 2017-2019</p>
</form>
</body>`
  },
}