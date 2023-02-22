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

            <!-- Favicons -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
        <%
            String id = (String) request.getAttribute("id");
        %>
    </head>
<body>
 <div class = "container text-center">
    <form action="comment" method="post">

            <div class= "col">
                <!-- guardo como hidden el id del usuario -->
                <input hidden class="form-control" type="text" name="id" value="<%=id%>">
                <input class="form-control" type="text" name="titol" placeholder="Titulo del post">
                <br/>
                <input class="form-control" type="text" name="missatge" placeholder="Redacta el mensaje...">
                <br/>
                <input class="form-control" type="text" name="url" placeholder="Pega la url de la imagen">
                <br/>
                <input type="submit" class="btn btn-success btn-lg btn-block">
            </div>

    </form>
    </div>
    <div class="col p-3 mb-3 bg-dark text-white">
        <p class="text-center">Titulo prueba.</p>
        <div class = "container d-flex align-items-center justify-content-center">

            <div class = "center">
                <img src="https://picsum.photos/500/600.jpg" alt="alternatetext" width="500" height="600">
            </div>
        </div>
    </div>

   <div class="col p-3 mb-3 bg-dark text-white">
           <p class="text-center">Titulo prueba.</p>
           <div class = "container d-flex align-items-center justify-content-center">

               <div class = "center">
                   <img src="https://picsum.photos/500/600.jpg" alt="alternatetext" width="500" height="600">
               </div>
           </div>
       </div>
</body>
</html>