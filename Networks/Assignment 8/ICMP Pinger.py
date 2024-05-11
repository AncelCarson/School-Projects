#######
# Student Name: Ancel Carson
# Course: COSC 3603-01 Networks & Data Communications
# Assignment: SMTP
# Filename: ICMP Pinger.py
# Date Modified: 11/15/2019
#
# Purpose: To create an understanding of how ICMP Pingers work
#
# Input: No input given
#
# Output: Messages returned as response to ping
#
# Assumptions: That the program will be alowed to connect and ping
#
# Limitations: This is a very rudamentary pinger so its abilitiys are severely limited
#       Letnet limits connections
#
# Developement Computer: Razer Blade 16 14"
# Operating System: Windows 10
# Compiler: Python 3.7.2
# IDE: Visual Studio Code
# Operational Status: NON-Functional
#######

# Libraries
import socket
import os 
import sys 
import struct 
import time 
import select 
import binascii   
 
ICMP_ECHO_REQUEST = 8
timeRTT = []
packageSent =0
packageRev = 0
 
def checksum(str):         
    csum = 0    
    countTo = int(len(str) / 2) * 2          
    count = 0    
    while count < countTo:     
        thisVal = ord(str[count+1]) * 256 + ord(str[count])                 
        csum = csum + thisVal               
        csum = csum & 0xffffffff
        count = count + 2 
 
    if countTo < len(str):         
        csum = csum + ord(str[len(str) - 1])         
        csum = csum & 0xffffffff
        csum = (csum >> 16) + (csum & 0xffff)     
        csum = csum + (csum >> 16)     
        answer = ~csum     
        answer = answer & 0xffff        
        answer = answer >> 8 | (answer << 8 & 0xff00)         
        return int(answer)
 
def receiveOnePing(mySocket, ID, timeout, destAddr): 
    global packageRev,timeRTT 
    timeLeft = timeout 
 
    while 1:                 
        startedSelect = time.time()         
        whatReady = select.select([mySocket], [], [], timeLeft)         
        howLongInSelect = (time.time() - startedSelect) 
        if whatReady[0] == []: # Timeout             
            return "Request timed out."   

        timeReceived = time.time()                 
        recPacket, addr = mySocket.recvfrom(1024)                 
        #Fill in start                  
        #Fetch the ICMP header from the IP packet
        icmpHeader = recPacket[20:28]
        requestType, code, revChecksum, revId, revSequence = struct.unpack('bbHHh',icmpHeader)
        if ID == revId:
            bytesInDouble = struct.calcsize('d')
            timeData = struct.unpack('d',recPacket[28:28 + bytesInDouble])[0]
            timeRTT.append(timeReceived - timeData)
            packageRev += 1
            return timeReceived - timeData
        else:
            return "ID is not the same!"
        #Fill in end                  
        
        timeLeft = timeLeft - howLongInSelect         
        if timeLeft <= 0:             
            return "Request timed out."         
 
def sendOnePing(mySocket, destAddr, ID):     
    # Header is type (8), code (8), checksum (16), id (16), sequence (16)          
    
    myChecksum = 0     
    # Make a dummy header with a 0 checksum.     
    # struct -- Interpret strings as packed binary data     
    header = struct.pack("bbHHh", ICMP_ECHO_REQUEST, 0, myChecksum, ID, 1)         
    data = struct.pack("d", time.time())         
    # Calculate the checksum on the data and the dummy header.     
    myChecksum = checksum(str(header + data))          
    
    # Get the right checksum, and put in the header     
    if sys.platform == 'darwin':         
        myChecksum = socket.htons(int(myChecksum)) & 0xffff   
        #Convert 16-bit integers from host to network byte order.     
    else:         
        myChecksum = socket.htons(int(myChecksum))    
        
    header = struct.pack("bbHHh", ICMP_ECHO_REQUEST, 0, myChecksum, ID, 1)     
    packet = header + data 
 
    mySocket.sendto(packet, (destAddr, 1)) # AF_INET address must be tuple, not str     
    #Both LISTS and TUPLES consist of a number of objects  
    #which can be referenced by their position number within the object 
 
def doOnePing(destAddr, timeout):         
    icmp = socket.getprotobyname("icmp") 
    #SOCK_RAW is a powerful socket type. For more details see: 
    # http://sock-raw.org/papers/sock_raw 
 
    #Fill in start 
    #Create Socket here 
    mySocket = socket.socket(socket.AF_INET, socket.SOCK_RAW, icmp)
    #Fill in end 
 
    myID = os.getpid() & 0xFFFF  #Return the current process i     
    sendOnePing(mySocket, destAddr, myID) 
    delay = receiveOnePing(mySocket, myID, timeout, destAddr)          
    
    mySocket.close()         
    return delay 
 
def ping(host, timeout=1):     
    #timeout=1 means: If one second goes by without a reply from the server,     
    #the client assumes that either the client’s ping or the server’s pong is lost     
    dest = socket.gethostbyname(host)     
    print("Pinging " + dest + " using Python:")  
    print("")    
    #Send ping requests to a server separated by approximately one second     
    while 1 :         
        delay = doOnePing(dest, timeout)         
        print(delay)        
        time.sleep(1)# one second     
    return delay 
 
ping("www.poly.edu") 