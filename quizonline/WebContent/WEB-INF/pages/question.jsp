<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
   
 <head>
    
    <title>Quiz questions</title>
  
  </head>
  
  <div id="result"></div> 
  <script>
  var count=0;
  function ShowHideDiv(correct_answer){
	  var x=document.getElementsByName('option');
	  alert(x);
	  for(i = 0; i < x.length; i++) { 
          if(x[i].equals(list.correct_answer)) 
          document.getElementById("result").innerHTML
                  = +x[i].value; 
      } 
	  
  }
  </script>
    
<body background="images/quizpage.jpg">
     
<center><h1>The Quiz</h1></center>
    
 
 <form  action="submitTest" id="quiz" name="quiz">
 
  
 <c:forEach items="${list}"  var="list" varStatus="status">     
     
 
    
<p>Q. ${status.index+1} ${list.question}</p>
 
  <input type="radio"  name="option${status.index+1}" value="${list.option1}" >${list.option1}<br>

    <input type="radio"  name="option${status.index+1}" value="${list.option2}" >${list.option2}<br>
  
   <input type="radio"  name="option${status.index+1}" value="${list.option3}" >${list.option3}<br>
  
   <input type="radio"  name="option${status.index+1}" value="${list.option4}" >${list.option4}<br>
     
   </c:forEach>
	<br><br><input  type="submit" value="submit" >
     
     </form>
    

 
     
     

 </body>

</html>

