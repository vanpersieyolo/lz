<%--
  Created by IntelliJ IDEA.
  User: DANG ANH VAN
  Date: 9/23/2020
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<nav  class="navbar navbar-expand-lg navbar-light bg-light">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
            <img src="../img.jpg" width="50" height="50" class="d-inline-block align-top">
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="#"><h1>V & T SHOWROOM</h1></a>
        </li>
    </ul>

    <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</nav>
<div  style=" border: black solid 1px" >
    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" >
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="../img.jpg" alt="First slide" style="width: 100% ; height: 500px">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="../img.jpg" alt="Second slide" style="width: 100% ; height: 500px">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="../img.jpg" alt="Third slide" style="width: 100% ; height: 500px">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <div class="container">
        <a href="#">Trở về trang trước</a>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
            Thêm mới 1 sản phẩm
        </button>
        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="container">
                            <form>
                                <div class="form-group">
                                    <label>nhập tên xe</label>
                                    <input type="text" class="form-control"  placeholder="Tên xe">
                                </div>
                                <div class="form-group">
                                    <label>Nhập link ảnh</label>
                                    <input type="text" class="form-control" placeholder="File ảnh xe">
                                </div>
                                <div class="form-group">
                                    <label>Nhập giá bán</label>
                                    <input type="text" class="form-control"  placeholder="Giá bán xe">
                                </div>
                                <div class="form-group">
                                    <label >Chi tiết xe</label>
                                    <input type="text" class="form-control"  placeholder="Nhập chi tiết xe">
                                </div>
                                <button type="submit" class="btn btn-primary">ADD</button>
                            </form>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                    </div>
                </div>
            </div>
        </div>
        <h1 style="text-align: center">Bảng giá các loại xe</h1>    
        <div class="row">
            <c:forEach var = "car" items="${carlist}">
                <div class="col-md-6 col-lg-4">
                    <div class="single_service">
                        <div class="thumb">
                            <span><img src="<c:out value="${car.carImg}"/>" style="width: 100%"></span>
                        </div>
                        <div class="service_infor">
                            <h3><c:out value="${car.carName}"/></h3>
                            <h3><c:out value="${car.carPrice}"/></h3>
                            <div class="row">
                                <div class="col-md-6 col-lg-4"><a href="#">DELETE</a></div>
                                <div class="col-md-6 col-lg-4"><a href="#">UPDATE</a></div>
                                <div class="col-md-6 col-lg-4"><a href="#">DESCRIPTION</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<footer>
    <div class="footer-copyright text-center py-3">© 2020 Copyright:
        <a href="#"> T&V Car</a>
        HOTLINE:<a href="$">0999.686.868</a>
    </div>
</footer>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>
