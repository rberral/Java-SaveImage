<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery-2.1.4.js"></script>
<script src="js/jquery.Jcrop.js"></script>
<script src="js/main.js"></script>
<!--  <link rel="stylesheet" href="demo_files/main.css" type="text/css" />
<link rel="stylesheet" href="demo_files/demos.css" type="text/css" />  -->
<link rel="stylesheet" href="css/jquery.Jcrop.min.css" type="text/css" />
<style type="text/css">
  .optdual { position: relative; }
  .optdual .offset { position: absolute; left: 18em; }
  .optlist label { width: 16em; display: block; }
  #dl_links { margin-top: .5em; }
</style>

</head>
<body>

<div class="container">
<div class="row">
<div class="span12">
<div class="box">
    <img id="target"/>
  <div style="margin: .8em 0 .5em;">
        <input id="botonFile" type="file" accept="image/jpeg, image/png, image/jpg">
    <span class="requires">
      <button id="enable" class="btn btn-mini">Recortar</button>
    </span>

  </div>
	<form name="myForm" action="SaveImageServlet" method="post" onsubmit="return checkCoordinates();">
		<input type="hidden" name="x" value=""/>
		<input type="hidden" name="y" value=""/>
		<input type="hidden" name="w" value=""/>
		<input type="hidden" name="h" value=""/>
		<input type="hidden" name="imgSRC" id="idImgSRC" value=""/>
		<input type="submit" value="Guardar Imagen"/>
	</form>
</div>
</div>
</div>
</div>
</body>
</html>

