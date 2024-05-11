function result = myMax(maxArray,rows,cols)
result = [0,0,0];
for r = 1:rows
    for c = 1:cols
        if result(r)<maxArray(r,c)
            result(r) = maxArray(r,c);
        end
    end
end
