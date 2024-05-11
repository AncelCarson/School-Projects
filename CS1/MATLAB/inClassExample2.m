clear all;
clc;

[data,days] = xlsread('Example.xlsx')
maxDataFile = fopen('maxOutput.txt','w');
newData = data'; % (') lets you flip the data rows for columns and columns for rows
[rows,cols] = size(newData);
for r = 1:rows
    theMax = max(newData(r,:)); % (:) says to look at the whole row
    fprintf(maxDataFile,'The max for %s is $%.2f.\n\n',days{r},theMax);
end
fprintf('Program is finished output is in "maxOutput.txt"\n')
fclose(maxDataFile);