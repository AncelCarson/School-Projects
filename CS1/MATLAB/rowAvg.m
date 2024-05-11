function result = rowAvg(value)
[cols,num] = size(value);
rowTot = 0;
for n = 1:num
    rowTot = value(n)+rowTot;
end
result = [rowTot/num];