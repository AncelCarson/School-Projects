clear all;
clc;

[miles,names] = xlsread('theDriversM.xlsx');
[rows,cols] = size(miles);
companyName = input('What is the company name?\n','s');
clc;
for n = 1:cols
    indivdualMiles = sum(miles(:,n));
    pay = truckerPay(indivdualMiles);
    fprintf('%s drove %d miles $%.2f\n',names{n},indivdualMiles,pay);
end
disp(' ');
fprintf('The above is pay information for %s company.\n',companyName);