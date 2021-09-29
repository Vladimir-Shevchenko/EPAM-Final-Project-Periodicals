<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18.09.2021
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
      <link rel="stylesheet" href="CSS/wel.css">

  </head>
  <body>
  <!-- TIPS:
  1. The carousel shouldn't be in any other div, like for example div with class container.
  2. You can align image position in classes bg1, bg2, bg3 using css background-position.
  http://arturssmirnovs.com/blog/bootstrap-carousel-100-height-and-width/
  -->

  <!-- Carousel 100% Fullscreen -->
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner">
          <div class="item bg bg1 active">
              <div class="container">
                  <div class="carousel-caption">
                      <h1>Example headline.</h1>
                      <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
                      <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
                  </div>
              </div>
          </div>
          <div class="item bg bg2">
              <div class="container">
                  <div class="carousel-caption">
                      <h1>Another example headline.</h1>
                      <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                      <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                  </div>
              </div>
          </div>
          <div class="item bg bg1">
              <div class="container">
                  <div class="carousel-caption">
                      <h1>One more for good measure.</h1>
                      <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                      <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
                  </div>
              </div>
          </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
  </div>
  <!-- /end Carousel 100% Fullscreen -->

  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  </body>
</html>
