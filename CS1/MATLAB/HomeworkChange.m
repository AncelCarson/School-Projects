clear all;
clc;

cols = 8;
rows = 3;
myArray = [0,0];
for r1 = 1:rows
    for  c = 1:cols
        myArray(r1,c) = input (['Please ender the value for day ', num2str(r1), ' Truck ', num2str(c), '\n']);
    end
end
dayMax = myMax(myArray, rows, cols);
dayMaxAvg = myAvg(dayMax, rows);
for  r = 1:rows
     disp([num2str(dayMax(r))]);
end
disp(' ');
disp([num2str(dayMaxAvg)]);
disp('The program is finished. Thank you for using our program');
