<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Private School Application</title>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container">
                    <a class="navbar-brand">Private School Application</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item disabled">
                                <a class="nav-link">Courses</a>
                            </li>
                            <li class="nav-item disabled">
                                <a class="nav-link">Students</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link">Trainers<span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled">Assignments</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <main>
            <div class="container mt-4">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First name</th>
                            <th scope="col">Last name</th>
                            <th scope="col">Subject</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${trainers}" var="trainer">
                            <tr>
                                <th>${trainer.id}</th>
                                <td>${trainer.firstName}</td>
                                <td>${trainer.lastName}</td>
                                <td>${trainer.subject}</td>
                                <td>
                                    <a href="<c:url value='${editurl}/${trainer.id}'/>" class="btn btn-secondary btn-sm" role="button" aria-pressed="true">Edit</a>
                                </td>
                                <td>
                                    <a href="<c:url value='${deleteurl}/${trainer.id}'/>" class="btn btn-secondary btn-sm" role="button" aria-pressed="true">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="container my-3">
                    <td>
                        <a href="<c:url value='${newurl}'/>" class="btn btn-secondary btn-sm" role="button" aria-pressed="true">Add trainer</a>
                    </td>
                </div>
                <% String alert = (String) request.getAttribute("alert");
                    String success = (String) request.getAttribute("success");
                %>
                <div class="alert alert-warning alert-dismissible fade hidden" role="alert">
                    ${alert}
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="alert alert-success alert-dismissible fade hidden" role="alert">                    
                    ${success}
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </div>
        </main>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.slim.min.js"
        integrity="sha256-pasqAKBDmFT4eHoN2ndd6lN370kFiGUFyTiUHWhU7k8=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
                integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
    </body>
</html>
