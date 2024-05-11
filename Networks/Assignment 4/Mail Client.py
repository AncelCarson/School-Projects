#######
# Student Name: Ancel Carson
# Course: COSC 3603-01 Networks & Data Communications
# Assignment: SMTP
# Filename: Mail Client.py
# Date Modified: 10/24/2019
#
# Purpose: To create an understanding of how SMTP mail servers work
#
# Input: No input given
#
# Output: Status of the email being sent at each step
#
# Assumptions: That the email address given stays the same and the host stays active
#
# Limitations: This is a very rudamentary email client so its abilitiys are severely limited
#
# Developement Computer: Razer Blade 16 14"
# Operating System: Windows 10
# Compiler: Python 3.7.2
# IDE: Visual Studio Code
# Operational Status: Functional
#######

# Libraries
from socket import *
import base64

msg = '\r\n I love computer networks!'
endmsg = '\r\n.\r\n'
# Choose a mail server (e.g. Google mail server) and call it mailserver 
mailserver = ("mailstore.uetimer.com", 25) #Fill in start   #Fill in end
# Create socket called clientSocket and establish a TCP connection with mailserver 
clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect(mailserver)

recv = clientSocket.recv(1024) 
print(recv)
if recv[:3] != '220': 
    print('220 reply not received from server.')

# Send HELO command and print server response. 
heloCommand = 'HELO mailstore.uetimer.com\r\n' 
clientSocket.send(bytes(heloCommand,'UTF-8')) 
recv1 = clientSocket.recv(1024) 
print(recv1)
if recv1[:3] != '250': 
    print('250 reply not received from server.')

# Send authentication information and print server response. 
username =  "dalaney@uetimer.com"                     #the username for your server
password = "pswd"                                    #the password for your server, changed here
base64_str = ("\x00"+username+"\x00"+password).encode()
base64_str = base64.b64encode(base64_str)
authMsg = "AUTH PLAIN ".encode()+base64_str+"\r\n".encode()
clientSocket.send(authMsg)
recv_auth = clientSocket.recv(1024)
print(recv_auth.decode())
if recv1[:3] != '250':
    print('250 reply not received from server.')

# Send MAIL FROM command and print server response. 
mailFrom = "MAIL FROM: <Random.Networks.address@41.org> \r\n"
clientSocket.send(mailFrom.encode())
recv2 = clientSocket.recv(1024)
print("After MAIL FROM command: "+str(recv2))
if recv1[:3] != '250':
    print('250 reply not received from server.')

# Send RCPT TO command and print server response.  
rcptTo = "RCPT TO: <dalaney@uetimer.com> \r\n"
clientSocket.send(rcptTo.encode())
recv3 = clientSocket.recv(1024)
print("After RCPT TO command: "+str(recv3))
if recv1[:3] != '250':
    print('250 reply not received from server.')

# Send DATA command and print server response. 
data = "DATA\r\n"
clientSocket.send(data.encode())
recv4 = clientSocket.recv(1024)
print("After DATA command: "+str(recv4))
if recv1[:3] != '250':
    print('250 reply not received from server.')

# Send message data. 
subject = "Subject: SMTP mail client testing \r\n\r\n" 
clientSocket.send(subject.encode())
clientSocket.send(msg.encode())
clientSocket.send(endmsg.encode())
recv_msg = clientSocket.recv(1024)
print("Response after sending message body:"+recv_msg.decode())
if recv1[:3] != '250':
    print('250 reply not received from server.')

# Send QUIT command and get server response. 
clientSocket.send("QUIT\r\n".encode())
message=clientSocket.recv(1024)
print (message)
clientSocket.close()
