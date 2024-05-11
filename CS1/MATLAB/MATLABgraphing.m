clear all;
clc;

[data,text] = xlsread('graphData.xlsx');
[rows,cols] = size(data);
screensize = get(groot,'Screensize');
for n = 1:cols
    y = data(:,n);
    figure;
    set(gcf,'Position',[n*10,(screensize(4)-574)-n*10,500,500]);
    plot (y);
    grid on;
    title(text{n});
    xlabel('Potatoes');
    ylabel('Fries');
end
for r = 1:rows
    tempArray = data(r,:);
    rowAvg(r) = myAvg(tempArray, cols);
    xVal(r) = ((rows-2)+r)/(rows-1);
end
figure;
hold on;
plot(xVal,rowAvg);
grid on;
plot(xVal,rowAvg,'mo');
syms x;
coef = polyfit(xVal,rowAvg,4);
theGraph = coef(1)*x^4+coef(2)*x^3+coef(3)*x^2+coef(4)*x+coef(5);
fplot(theGraph,[1,2],'g');
fplot(7*sin(x)-3*x^2+11*cos(x^3)+47*x-25,[1,2],'r');
legend('Raw Data','Data Points','Line of Best Fit','Inordinate Function','Location','bestoutside');
title('Acorn Consumption');
xlabel('Squirrels');
ylabel('Acorns');