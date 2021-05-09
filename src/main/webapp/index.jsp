<!doctype html>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="com.sahan.c3appone.config.API_URLs"%>
<%@page import="java.net.URL"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
	
	<div class="container">
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<center><h2>Welcome to Cohort 3 Official Website</h2></center>
				
				<table class="table">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Brand</th>
							<th scope="col">Model</th>
							<th scope="col">Year</th>
							<th scope="col">Owner</th>
						</tr>
					</thead>
					<tbody>
						
						<% 
						
							try{
								URL url = new URL(API_URLs.CAR_API);
								HttpURLConnection connection = (HttpURLConnection)url.openConnection();
								connection.setRequestMethod("GET");
								connection.setDoInput(true); // if downloads
								connection.setDoOutput(false); // if uploads
								
								InputStream inputStream = connection.getInputStream();
								InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
								BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
								
								if(connection.getResponseCode() == 200) {
									
									String line = "";
									StringBuilder sb = new StringBuilder();
									
									while((line = bufferedReader.readLine()) != null){
										sb.append(line);
									}
									
									String jsonString = sb.toString();
									
									JsonArray jsonArray = JsonParser.parseString(jsonString).getAsJsonArray();
									
									
									for(int i = 0; i < jsonArray.size(); i++){
										
										JsonObject obj = jsonArray.get(i).getAsJsonObject();
										
										%>
										<tr>
											<td><% out.print(obj.get("id").getAsString()); %></td>
											<td><% out.print(obj.get("brand").getAsString()); %></td>
											<td><% out.print(obj.get("model").getAsString()); %></td>
											<td><% out.print(obj.get("year").getAsString()); %></td>
											<td><% out.print(obj.get("user_id").getAsString()); %></td>
										</tr>
										<%
										
										
									}
									
									
									
								}
								
							}
							catch(Exception e){
								e.printStackTrace();
							}
													
						%>
						
					</tbody>
				</table>
				
			</div>
		</div>
	</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script> 
  </body>
</html>

