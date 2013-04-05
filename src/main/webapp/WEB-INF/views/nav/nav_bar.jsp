<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="containter">
			<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Spitter Test</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="<s:url value='/'/>">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="<s:url value='spitters?new'/>">Sign Up</a></li>
            </ul>
          </div>
		</div>
	</div>
</div>