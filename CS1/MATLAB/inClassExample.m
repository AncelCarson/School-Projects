clear all;
clc;

data = xlsread('Example.xlsx');
[rows,cols] = size(data);
for r = 1:rows
    sumOfRows(r) = sum(data(r,:));
end
sumOfRows