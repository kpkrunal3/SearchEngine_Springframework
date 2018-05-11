<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

@import "compass/css3";

@import url(https://fonts.googleapis.com/css?family=Roboto:700);
@import url(http://weloveiconfonts.com/api/?family=entypo);
@import url(https://fonts.googleapis.com/css?family=Holtwood+One+SC);
@import url(https://fonts.googleapis.com/css?family=Voces);


/* zocial */
[class*="entypo-"]:before {
  font-family: 'entypo', sans-serif;
}

*{
  box-sizing: border-box;
}

body {
  margin: 0;
  border: 0;
  padding: 0;
}

.header{
  background: #16a085;
  height: 200px;
  padding: 20px;
}

h1 { 
  font-family: 'Holtwood One SC', serif;
  color:white;
  font-size:50px;
  text-shadow: 0px 3px 0px #7f8c8d;
}

.cont {
  position: relative;
  margin:20px auto;
  width: 500px;
}

.srchFld {
  border: 0;
  border-radius:7px;
  padding: 0 17px;
  padding-right:55px;
  display:inline-block;
  float:left;
  width:380px;
  border-bottom:5px solid #bdc3c7;
  height: 60px;
  font-family: 'Roboto', sans-serif;
  color: #7f8c8d;
  font-size:19px;
  
}

.srchFld:focus {
  outline-color: rgba(white,0);
}

.srchBtn {
  border: 0;
  border-radius:7px;
  padding: 0 17px;
  background: #e74c3c;
  display:inline-block;
  float:right;
  width:99px;
  border-bottom:5px solid #c0392b;
  color:white;
  height: 60px;
  font-family: 'Roboto', sans-serif;
  color: white;
  font-size:18px;
  cursor: pointer;
}

.srchBtn:active {
  border-bottom:0px solid #c0392b;
}

.ico {
  position: absolute;
  right:135px;
  top: 13px;
  font-size:35px;
  color:#7f8c8d;
}

.contact {
  border-bottom:2px solid rgb(200,200,200);
  border-bottom-style:dashed;
  padding: 15px;
  height: 180px;
  
}

.wrapr {
  width: 600px;
  margin: 0 auto;
}

.imgWrpr {
  float:left;
  height: 150px;
  width: 150px;
  border-radius:80px;
  overflow:hidden;
  border:10px solid #eee;
}

.contact img {
  height: 150px;
  width: auto;
}

.contactInfo {
  display:inline-block;
  float:left;
  padding: 30px;
  font-size:25px;
  color:rgb(80,80,80);
  font-family: 'Voces', cursive;
  
}

.name {
  font-size:35px;
}


.animate-enter, 
.animate-leave
{ 
 @include transition (400ms cubic-bezier(0.250, 0.250, 0.750, 0.750) all);
  position: relative;
  display: block;
} 

.animate-enter.animate-enter-active, 
.animate-leave {
  opacity: 1;
  
}

.animate-leave.animate-leave-active,
.animate-enter {
  opacity: 0;
  
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function contactsCtrl($scope) {

	  $scope.contacts = [
	    {
	      name:"Sintel",
	      code:"Durian",
	      year:"2010",
	      img:"http://www.sintel.org/wp-content/uploads/2010/03/sintel_ab_original_dark_facial.png",
	    },{
	      name:"Big Buck Bunny",
	      code:"Peach",
	      year:"2008",
	      img:"https://www.crearonline.com.ar/wp-content/uploads/2010/05/big_buck_bunny.png",
	    },{
	      name:"Tears of steel",
	      code:"Mango",
	      year:"2012",
	      img:"http://cf.broadsheet.ie/wp-content/uploads/2012/09/roboeye.jpg",
	    },{
	      name:"Elephants Dream",
	      code:"Orange",
	      year:"2006",
	      img:"http://orange.blender.org/wp-content/themes/orange/images/media/gallery/s5_proog.jpg",
	    }
	  ]

	}
</script>
<body>

<!-- <form action="/Advance_Computing/mainpage/" method="get">
<div style="height: 44px;width: 177px;border: 1px solid black;margin:300px;margin-left: 500px"">
<input type="text" name="iname">
<input type="submit" value="submit">
</div>
</form> -->

 <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.1.5/angular.min.js"></script>

<div ng-app>
  <div ng-controller="contactsCtrl">
    <section class="header">
      <center><h1>Search Bar</h1></center>
      <form action="/Advance_Computing/mainpage/" class="cont" method="get">
        <input type="text" class="srchFld" name= "iname" placeholder="" ng-model="search"/>
        <button type="submit" class="srchBtn">Search</button>
        <div class="entypo-search ico"></div>
      </form>
    </section>
    <section class="content">
        <div class="wrapr">
         
        </div>
    </section>
  </div>
</div> 


</body>
</html>