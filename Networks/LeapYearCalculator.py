### Ancel Carson
### 8/28/2019
### Windows 10
### VIsual Studio Code
### Python 3

# Main Function
def main():
    year = int(input('Please enter a 4 digit year\n'))
    divide4 = (year % 4 == 0)
    divide100 = (year % 100 == 0)
    divide400 = (year % 400 == 0)

    if(divide4 and divide100 and divide400):
        print('%s is a leap year' % year)
    else:
        print('%s is not a leap year' % year)

# Self Program Call
if __name__ == '__main__':
    main()