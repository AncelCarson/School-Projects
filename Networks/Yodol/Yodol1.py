#import socket module
from socket import *
import os
serverSocket = socket(AF_INET, SOCK_STREAM)

serverPort = 80
#web_dir = os.path.join(os.path.dirname(file), 'web')
#os.chdir(web_dir)

#Prepare a sever socket
    #Fill in start
serverSocket.bind(('', serverPort))
serverSocket.listen(1)
print('server is up on port #: ' + str(serverPort))

#print(serverSocket)
    #Fill in end

while True:
 #Establish the connection
    print('Ready to serve...')
    connectionSocket, addr = serverSocket.accept()
    try:
        message = connectionSocket.recv(1024)
        #print(message, '::', message.split()[0], ':', message.split()[1])
        print(str(message, 'UTF-8'))
        filename = message.split()[1]
        print(filename, "||", filename[1:])
        f = open(filename[1:])
        outputdata = f.read()

        #print(outputdata)
        #Send one HTTP header line into socket
        connectionSocket.send(bytes('\nHTTP/1.1 200 OK\n\n','UTF-8'))
 #Send the content of the requested file to the client
        for i in range(0, len(outputdata)):
            connectionSocket.send(bytes(outputdata[i],'UTF-8'))
        connectionSocket.close()
    except IOError:
    #Send response message for file not found
        connectionSocket.send(bytes('\nHTTP/1.1 404 Not Found','UTF-8'))
        connectionSocket.close()
    except OSError:
        connectionSocket.send(bytes('\nHTTP/1.1 404 File Not Found', 'UTF-8'))
        connectionSocket.close()

 #Close client socket

serverSocket.close()