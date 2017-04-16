<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" type="image/x-icon" href="${requestScope.pageContext}/static/images/favicon.ico">

    <title>Play Sudoku</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="${requestScope.pageContext}/static/css/jumbotron-narrow.css" rel="stylesheet">
    <link href="${requestScope.pageContext}/static/css/sudoku.css" rel="stylesheet">
	  <link href="${requestScope.pageContext}/static/css/sudoku2.css" rel="stylesheet"> 

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">
    <div class="header">
	
        <nav>
            <ul class="nav nav-pills pull-right"> 
                <li role="presentation" class="active"><a href="#" type="button" value="play" onclick="start_timer()">Play</a></li>
                <li role="presentation"><a href="/submit.html">Submit a Game</a></li>
                <li role="presentation"><a href="/about.html">About project</a></li>
				
            </ul>
        </nav>
        <div class ="block"><h3 class="text-muted">Open Sudoku  </h3></div>
		
	
    </div>

     

       

<div class="content">

<div class="row">

<div class="span6">.<h1>Play Free Sudoku Now!</h1>..</div>
  <div class="span6"><p>Sudoku is one of the most popular puzzle games of all time. The goal of Sudoku is to fill a 9×9 grid with numbers so that each row, column and 3×3 section contain all of the digits between 1 and 9. As a logic puzzle, Sudoku is also an excellent brain game. If you play Sudoku daily, you will soon start to see improvements in your concentration and overall brain power. Start a game now. Within no time Sudoku will be your favorite free online game.

  </p>..</div>

<div class="span6">.<h1>About Sudoku</h1>..</div>
  <div class="span6"><p>The popular Japanese puzzle game Sudoku is based on the logical placement of numbers. An online game of logic, Sudoku doesn’t require any calculation nor special math skills; all that is needed are brains and concentration.

  </p>..</div>


  <div class="content">

<div class="row">
<div class="span6">
<h1>Registration</h1>
<form action="/echo" method="post">
<label for="login-field">Login (email):</label>
<input type="text" name="login" id="login-field"><br>

<label for="password-field">Password:</label><br>
<input type="password" name="password" id="password-field">
Information about yourself:
<textarea name="comment" id="comment-field" rows=3>
</textarea><br>
<input type="checkbox" name="subcribe" id="subscribe-field" checked>
<label for="checkbox"> Subscribe to newsletter</label>
<input type="submit" value="Sign Up">

</form></div>
</div>

</div>
 



<!--
		<nav>
            <ul class="nav nav-pills pull-right"> 
                <li role="presentation" class="active"><a href="#" ><div class ="block" id="sample_timer">00:00:00</div> </a></li>
                
                <li role="presentation"><a href="/about.html"><div>  Moves: 1</div></a></li>
				
            </ul>
        </nav>
            -->
			
        </div>
    </div>

    <footer class="footer">
        <div class="row">
            <div class="col-lg-6">
                <p>This training project is mentored by <a href="http://iunetworks.am">iunetworks.am</a></p>
            </div>
            <div class="col-lg-6">
                <p>Free hosting provided by <a href="http://www.ucom.am">ucom.am</a></p>
            </div>
        </div>


    </footer>

</div>

<div>  <a href="#" type="button" value="play" onclick="start_game()">NEW GAME</a></li>
</div>

<!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${requestScope.pageContext}/static/js/ie10-viewport-bug-workaround.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="${requestScope.pageContext}/static/js/sudoku-game.js"></script>

	





<!-- / <input type="button" value="play" onclick="start_timer()">*/ -->

</body>
</html>
