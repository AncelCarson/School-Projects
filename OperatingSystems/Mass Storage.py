### Ancel Carson
### 4/29/2020
### Windows 10
### Python command line, Notepad, IDLE

# Libraries
import numpy as np

#Variables
requests = 1000
cylinders = 5000
direction = True

requestList = []
sortedList = []

# Main Function
def main():
    global direction
    print("Selects a request to start at.")
    start = int(input("Your selection must be an integer between 0 & %d.\n" % (cylinders - 1)))
    if (start < 0) or (start >= cylinders):
        input("Invalid input. Press enter to end the program.")
        exit()
    for num in range(requests):
        location = np.random.randint(cylinders - 1)
        requestList.append(location)
        sortedList.append(location)

    sortedList.sort()
    reqArray = np.asarray(sortedList)
    index = (np.abs(reqArray - start)).argmin()
    if (sortedList[index] > start):
        direction = False
    
    print("Using %d requests and starting at cylinder %d:\n" % (requests, start))
    print("\tHeadmovement for FCFS:", FCFS(start))
    print("\tHeadmovement for SSTF:", SSTF(start, index))
    print("\tHeadmovement for SCAN:", SCAN(start, index, direction))
    print("\tHeadmovement for CSCAN:", CSCAN(start, index, direction))
    print("\tHeadmovement for LOOK:", LOOK(start, index, direction))
    print("\tHeadmovement for CLOOK:", CLOOK(start, index, direction))
    input("\nCalculation finished. Press enter to close the program.")

def FCFS(start):
    distance = 0
    current = start
    for step in requestList:
        distance += abs(current - step)
        current = step

    return distance

def SSTF(start, index):
    distance = 0
    current = start
    upIndex = index - 1
    downIndex = index + 1
    for num in range(requests - 1):
        if(upIndex >= 0):
            upValue = sortedList[upIndex]
        else:
            upValue = requests + 1
        if(downIndex < requests):
            downValue = sortedList[downIndex]
        else:
            downValue = -1

        upDist = abs(current - upValue)
        downDist = abs(current - downValue)
        if(upIndex >= 0) and (upDist < downDist):
            distance += upDist
            current = upValue
            upIndex -= 1
        elif(downIndex < requests):
            distance += downDist
            current = downValue
            downIndex += 1

    return distance

def SCAN(start, index, direction):
    distance = 0
    startIndex = index
    current = start
    newDir = direction
    for num in range(requests):
        nextPt = sortedList[index]
        step = abs(current - nextPt)
        distance += step
        current = nextPt
        if(direction):
            index -= 1
            if(index == -1):
                index = startIndex + 1
                distance += current
                direction = False
        else:
            index += 1
            if(index >= requests):
                index = startIndex - 1
                distance += (cylinders - current)
                direction = True
    return distance

def CSCAN(start, index, direction):
    distance = 0
    startIndex = index
    current = start
    newDir = direction
    for num in range(requests):
        nextPt = sortedList[index]
        step = abs(current - nextPt)
        distance += step
        current = nextPt
        if(direction):
            index -= 1
            if(index == -1):
                index = requests - 1
                distance += current + cylinders
        else:
            index += 1
            if(index >= requests):
                index = 0
                distance += ((cylinders - current) + cylinders)
    return distance

def LOOK(start, index, direction):
    distance = 0
    startIndex = index
    current = start
    newDir = direction
    for num in range(requests):
        nextPt = sortedList[index]
        step = abs(current - nextPt)
        distance += step
        current = nextPt
        if(direction):
            index -= 1
            if(index == -1):
                index = startIndex + 1
                direction = False
        else:
            index += 1
            if(index >= requests):
                index = startIndex - 1
                direction = True
    return distance

def CLOOK(start, index, direction):
    distance = 0
    startIndex = index
    current = start
    newDir = direction
    for num in range(requests):
        nextPt = sortedList[index]
        step = abs(current - nextPt)
        distance += step
        current = nextPt
        if(direction):
            index -= 1
            if(index == -1):
                index = requests - 1
        else:
            index += 1
            if(index >= requests):
                index = 0
    return distance

# Self Program Call
if __name__ == '__main__':
    main()