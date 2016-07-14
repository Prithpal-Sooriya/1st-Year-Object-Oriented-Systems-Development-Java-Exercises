A Client/Server example

    --> The client sends data to a server.
    --> The server reads the data from client
    --> The server performs some computation with data retrieved
    --> The server sends new data to the client

The client:
    --> sends radius (double)
        --> data sent is through DataOutputStream from socket.getOutputStream
    --> client retrieves from server the area (double)
        --> data retrieved is through DataInputStream from socket.getInputStream

--> the JVM automatically creates/sets the port to create a socket for the client

The server:
    --> retrieves the radius from the client (double)
        --> data retrieved is through DataInputStream from socket.getInputStream
    --> server performs calculations to produce radius
    --> server sends the area (double)
        --> data sent is through DataOututStream from socket.getOutputStream

--> You have to specify a port in which the client to connect to