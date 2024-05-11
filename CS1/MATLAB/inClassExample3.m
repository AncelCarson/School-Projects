clear all;
clc;
close all;

data = xlsread('Example.xlsx','Sheet2');
[rows,cols] = size(data);
syms x1;
for n = 1:rows
    x = data(:,n)';   % ' flips rows for colomns
    x = sort(x);
    y = data(n,:);
    y = sort(y);
    figure;
    hold on;
    set(gcf,'Position',[n*10,326-n*10,500,500]);
    plot (x,y);
    coef = polyfit(x,y,4);
    theGraph = coef(1)*x1^4+coef(2)*x1^3+coef(3)*x1^2+coef(4)*x1+coef(5);
    fplot(theGraph);
    hold off;
end
%saveas(gcf,'examplePlot.jpg');
