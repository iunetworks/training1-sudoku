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
                <li role="presentation" class="active"><a href="#">Play</a></li>
                <li role="presentation"><a href="/submit.html">Submit a Game</a></li>
                <li role="presentation"><a href="/about.html">About project</a></li>
            </ul>
        </nav>
        <h3 class="text-muted">Open Sudoku</h3>
		
		
		<script type="text/javascript">
var c=0;
var t;
var timer_is_on=0;

function timedCount()
{
document.getElementById('txt').value=c;
c=c+1;
t=setTimeout("timedCount()",1000);
}

function doTimer()
{
if (!timer_is_on)
  {
  timer_is_on=1;
  timedCount();
  }
}



 


function simple_timer(sec, block, direction) {
    var time    = sec;
    direction   = direction || false;
             
    var hour    = parseInt(time / 3600);
    if ( hour < 1 ) hour = 0;
    time = parseInt(time - hour * 3600);
    if ( hour < 10 ) hour = '0'+hour;
 
    var minutes = parseInt(time / 60);
    if ( minutes < 1 ) minutes = 0;
    time = parseInt(time - minutes * 60);
    if ( minutes < 10 ) minutes = '0'+minutes;
 
    var seconds = time;
    if ( seconds < 10 ) seconds = '0'+seconds;
 
    block.innerHTML = hour+':'+minutes+':'+seconds;
 
    if ( direction ) {
        sec++;
 
        setTimeout(function(){ simple_timer(sec, block, direction); }, 1000);
    } else {
        sec--;
 
        if ( sec > 0 ) {
            setTimeout(function(){ simple_timer(sec, block, direction); }, 1000);
        } else {
            alert('Время вышло!');
        }
    }
}
</script>

<form>

<script type="text/javascript">
function start_timer() {
    var block = document.getElementById('sample_timer');
    simple_timer(0, block, true);
}
 </script
<div id="sample_timer">00:00:00</div>
<input type="button" value="Начать отсчёт" onclick="start_timer()" />
<input type="button" value="Начать отсчет!" onClick="doTimer()">
<input type="text" id="txt">
</form>
 
<div id="sample_timer">00:00:00</div>
<input type="button" value="Начать отсчёт" onclick="start_timer()">

    </div>

    <div class="row">
        <div id="sudoku-table" class="sudoku-table col-lg-12">
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            &nbsp;
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
<!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${requestScope.pageContext}/static/js/ie10-viewport-bug-workaround.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="${requestScope.pageContext}/static/js/sudoku-game.js"></script>
</body>
</html>
