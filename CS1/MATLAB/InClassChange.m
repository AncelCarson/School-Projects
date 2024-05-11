clear all;
clc;
count = input('How many people would you like to enter?\n');
for i = 1:count
name = input('Please enter your name: \n','s');
age = input('Please enter your age: \n');
category = findGroup(age);
disp([name, ' is ', num2str(age), ' and in the ', category, ' group ']);
end