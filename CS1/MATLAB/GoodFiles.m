clear all;
clc;

fileData = xlsread('fieldData.xlsx');
[rows,cols] = size(fileData);
if (rows == cols)
    for n = 1:rows
        avgArray(n) = fileData(n,n);
        goodFile(n) = 0;
    end
    baseAvg = rowAvg(avgArray);
    for c = 1:cols
        for r = 1:rows
            if fileData(r,c)<=0
                goodFile(c)=1;
            end
            avgArray(r) = fileData(r,c);
        end
        tempAvg = rowAvg(avgArray);
        if goodFile(c)==0
            if [tempAvg<baseAvg]
                disp(['column ', num2str(c), ' is good and it''s value is ', num2str(tempAvg), '.'])
            end
        end
    end
else
    disp('The table is not good and data needs to be recollected.');
    disp('A good table has the same number of rows and columns.');
end