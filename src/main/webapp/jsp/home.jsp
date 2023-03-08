<html>
    <head>
        <title>WIAMbook</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&amp;display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.0.0/css/all.css">
        <link href="/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
            <!-- Favicons -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
        <%
            String id = (String) request.getAttribute("id");
        %>
        <%@ page import="model.PostInstagram"%>
        <%@ page import="model.User"%>
        <%@ page import="service.Service"%>
        <%@page import="java.util.ArrayList"%>
        <%
                ArrayList<PostInstagram> datos = (ArrayList<PostInstagram>) request.getAttribute("posts");
          %>

    </head>
<body>
 <div class = "container text-center">
    <form action="comment" method="post" enctype='multipart/form-data'>
            <div class= "col">
                <!-- guardo como hidden el id del usuario -->
                <input hidden class="form-control" type="text" name="id" value="<%=id%>">
                <input hidden class="form-control" type="text" name="accion" value="3">
                <input class="form-control" type="text" name="titol" placeholder="Titulo del post">
                <br/>
                <input class="form-control" type="text" name="missatge" placeholder="Redacta el mensaje...">
                <br/>
                <input class="form-control form-control-sm" type="file" name="image">
                <br/>
                <input type="submit" class="btn btn-success btn-lg btn-block">
            </div>
    </form>
    </div>
    <div>
    <%for  (int i = 0; i < datos.size(); i++) {%>
        <div class="col p-3 mb-3 bg-black text-white container">
        <%if (id.equals(datos.get(i).getId_usuari()+"")) {%>
                        <div class="row clearfix">
                             <form action="comment" method="post">
                                    <input hidden class="form-control" type="text" name="id" value="<%=id%>">
                                    <input hidden class="form-control" type="text" name="post" value="<%=datos.get(i).getId()%>">
                                    <input hidden class="form-control" type="text" name="accion" value="1">
                                    <button type="submit" class="btn btn-link pull-right">
                                        <span id="boot-icon" class="bi bi-trash" style="font-size: 20px;"></span>
                                    </button>
                              </form>
                          </div>
                            <%}%>


            <div class = "row p-3 mb-3 text-white container">
                 <div class="row">
                                <p class="text-center col"><%=datos.get(i).getTitle()%></p>
                          </div>
                <div class = "text-center col">
                    <img class="cover center" src="data:image/png;base64,<%=datos.get(i).getImageString()%>"  height="400" width="500">
                </div>
                <div class = "row p-3 mb-3 text-white container text-center">
                    <p class="text-center col"><%=datos.get(i).getMessage()%></p>
                </div>
                <div class= "row border m-1">
                    <div class="col">
                    Created by <%=datos.get(i).getUsuari().getUsuari()%> <%=datos.get(i).getDat()%>
                    <a href="mailto:<%=datos.get(i).getUsuari().getEmail()%>">
                        <span id="boot-icon" class="bi bi-envelope" style="font-size: 30px;"></span>
                    </a>
                    <a href="https://www.github.com/<%=datos.get(i).getUsuari().getGitlab()%>">
                        <span id="boot-icon" class="bi bi-github" style="font-size: 30px;"></span>
                    </a>
                    <a href="https://www.linkedin.com/in/<%=datos.get(i).getUsuari().getLinkedin()%>">
                        <span id="boot-icon" class="bi bi-linkedin" style="font-size: 30px;"></span>
                    </a>
                    </div>
                    <div class="col text-white" style="width: 100px; height: 50px;">
                            <p class = "pull-right text-center"><%=datos.get(i).getLikes()%></p>
                            <form action="comment" method="post" class="pull-right">
                                <input hidden class="form-control" type="text" name="id" value="<%=id%>">
                                <input hidden class="form-control" type="text" name="post" value="<%=datos.get(i).getId()%>">
                                <input hidden class="form-control" type="text" name="accion" value="2">
                                <button type="submit" class="btn btn-link">
                                   <span id="boot-icon" class="bi bi-heart-fill" style="font-size: 20px;"></span>
                                </button>
                                </form>
                </div>
            </div>
        </div>
        </div>
    <%}%>
    </div>
</body>
</html>