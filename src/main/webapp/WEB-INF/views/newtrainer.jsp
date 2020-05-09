<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>New Trainer</title>
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
                <div id="form-container" class="card">
                    <div id="form-title" class="card-header">Add a new trainer</div>
                    <div class="card-body">
                        <form:form method="POST" action="new" modelAttribute="trainer">
                            <form:input type="hidden" path="id" id="id"/>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="firstName">First name</label>
                                    <form:input type="text" class="form-control" maxlength="45" id="firstName" path="firstName" required="required"/>
                                </div>

                                <div class="form-group col-md-6">
                                    <label for="lastName">Last name</label>
                                    <form:input type="text" class="form-control" maxlength="45" id="lastName" path="lastName" required="required"/>

                                </div>
                            </div>
                            <div class="form-group">
                                <label for="subject">Subject</label>
                                <form:input type="text" class="form-control" maxlength="45" id="subject" path="subject" required="required"/>

                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <a href="<c:url value='${listurl}'/>" class="btn btn-primary" type="reset" role="button" aria-pressed="true">Cancel</a>
                        </form:form>
                    </div>

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
