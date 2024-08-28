 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" id="home" href="${contextRoot}/home">shoppingSite</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                	<li id="home"><a href="${contextRoot}/home">Home</a>
                    </li>
                    <li id="about"><a href="${contextRoot}/about">About</a>
                    </li>
                    <li id="listProduct"><a href="${contextRoot}/show/all/products">View Products</a>
                    </li>
                     <li id="manageProduct"><a href="${contextRoot}/manage/products">Manage Products</a>
                    </li>
                    
                    <li id=contact><a href="${contextRoot}/contact">Contact</a>
                    </li>
                </ul>
                
                <ul class="nav navbar-nav navbar-right">
                	 <li id="register"><a href="${contextRoot}/register">Sign Up</a>
                    </li>
                     <li id="login"><a href="${contextRoot}/login">Login</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>