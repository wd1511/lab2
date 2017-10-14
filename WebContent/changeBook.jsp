<%@ page language="java" import="wdhit.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>修改图书信息</title>

    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Fonts -->
    <link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="/css/animate.css" rel="stylesheet" />
    <!-- Squad theme CSS -->
    <link href="/css/style.css" rel="stylesheet">
	<link href="/color/default.css" rel="stylesheet">

</head>

<body>
	
	 <section id="intro" class="intro">
		<div class="slogan">
			<%  book newbook = (book)request.getAttribute("newbook");
				%>
				原图书信息
				</br>
				图书名:<%= newbook.getTitle() %>
				</br>
				出版日期:<%= newbook.getPublishDate() %>
				</br>
				出版社：<%= newbook.getPublisher() %>
				</br>
				作者编号: <%= newbook.getAuthorID() %>
				</br>
				ISBN:<%= newbook.getISBN() %>
				</br>
				价格:	<%= newbook.getPrice() %>
				</br>
				输入新的信息
				<form action = "changeb.action?oldisbn=<%= newbook.getISBN()%>" method = "post">
					图书名称<%=" " %>:<input type = "text" name = "title">
					</br>
					出版日期<%=" " %>:<input type = "text" name = "publishDate">
					</br>
					出版社名<%=" " %>:<input type = "text" name = "publisher">
					</br>
					
					作者编号<%=" " %>:<input type = "text" name = "authorID">
					</br>
					
					ISBN编号:<input type = "text" name = "ISBN">
					</br>
					图书价格<%=" " %>:<input type = "text" name = "price">
					</br>
					<input type = "submit" value = "修改">
					<input type="button" value="返回" onclick="javascript:location.href='login.jsp'"> 
				</form>
			</div>
    </section>
	
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<div class="wow shake" data-wow-delay="0.4s">
					<div class="page-scroll marginbot-30">
						<a href="#intro" id="totop" class="btn btn-circle">
							<i class="fa fa-angle-double-up animated"></i>
						</a>
					</div>
					</div>
					<p>&copy;by wd</p>
                    <!-- 
                        All links in the footer should remain intact. 
                        Licenseing information is available at: http://bootstraptaste.com/license/
                        You can buy this theme without footer links online at: http://bootstraptaste.com/buy/?theme=Squadfree
                    -->
				</div>
			</div>	
		</div>
	</footer>
	
	<!-- Core JavaScript Files -->
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/jquery.easing.min.js"></script>	
	<script src="/js/jquery.scrollTo.js"></script>
	<script src="/js/wow.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="/js/custom.js"></script>
</body>
</html>
