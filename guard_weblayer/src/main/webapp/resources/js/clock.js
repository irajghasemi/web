function flip_clock()
 {
 var date=new Date();
 var hours=date.getHours();
 var minutes=date.getMinutes();
 var seconds=date.getSeconds();
 
 /* Call for the function "addZero" which adds a zero infront of a single digit. eg "3" becomes "03" */
 minutes=addZero(minutes);
 seconds=addZero(seconds);
 
 /* Split the 2 digit numbers into single numbers eg "12" will become "1" and "2" individually */
 
 hours1=Math.floor(hours/10);
 hours2=hours-(hours1*10);
 minutes1=Math.floor(minutes/10);
 minutes2=minutes-(minutes1*10);
 seconds1=Math.floor(seconds/10);
 seconds2=seconds-(seconds1*10);
 
 /* Define the background position of the image, pulling the data from our "clock" array */
  
document.getElementById('img_s1').style.backgroundPosition = "0px -"+clock[seconds1]+"px";
document.getElementById('img_s2').style.backgroundPosition = "0px -"+clock[seconds2]+"px";
document.getElementById('img_m1').style.backgroundPosition = "0px -"+clock[minutes1]+"px";
document.getElementById('img_m2').style.backgroundPosition = "0px -"+clock[minutes2]+"px";
document.getElementById('img_h1').style.backgroundPosition = "0px -"+clock[hours1]+"px";
document.getElementById('img_h2').style.backgroundPosition = "0px -"+clock[hours2]+"px";

 /* Repeat the function "flip_clock" every 0.5 seconds to keep the images refreshed */
 setTimeout('flip_clock()', 500);
 }
 /* Function "addZero" which adds a zero infront of a single digit. eg "3" becomes "03" */
 function addZero(min_or_sec)
 {
 if (min_or_sec < 10)
 { min_or_sec="0" ;+ min_or_sec; };
 return min_or_sec;
 }
 /* The array to define image positioning dependant on which number needs to be shown */
 var clock = new Array();
    clock[0] = "801"; //number 0 
    clock[1] = "0"; //number 1
    clock[2] = "89"; //number 2
    clock[3] = "178"; //number 3
    clock[4] = "267"; //number 4
    clock[5] = "356"; //number 5
    clock[6] = "445"; //number 6
    clock[7] = "534"; //number 7
    clock[8] = "623"; //number 8
    clock[9] = "712"; //number 9