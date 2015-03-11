





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

function start_timer() {
    var block = document.getElementById('sample_timer');
    simple_timer(0, block, true);
}