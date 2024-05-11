clear all;
clc;

incomeTaxRate = .075;
ssTaxRate = .0325;
[fileData,text] = xlsread ('employeeInfo.xlsx');
employee = menu('Select employee, if done exit window.',text);
while (employee ~= 0)
    cont = isnan(fileData(employee,1));
    if cont == 1
        disp([text{employee}, ' did not work this week'])
    else
        name = text{employee};
        nameBreak = find(name==' ');
        nameLength = find(name,1,'last');
        for n = 1:nameLength-nameBreak
            lastName(n) = name(n+nameBreak);
        end
        if fileData(employee,1) > 40
            overTime = fileData(employee,1)-40;
            pay = 40*fileData(employee,2);
            overPay = overTime*(fileData(employee,2)*1.5);
        else
            pay = fileData(employee,1)*fileData(employee,2);
            overPay = 0;
        end
        gross = pay+overPay;
        incomeTax = taxCalc(gross,incomeTaxRate);
        ssTax = taxCalc(gross,ssTaxRate);
        netPay = gross-(incomeTax+ssTax);
        fprintf('Pay information for %s is:\n', lastName)
        fprintf('------------------------------\n')
        fprintf('Regular pay is: $%.2f\n', pay)
        fprintf('Overtime pay is: $%.2f\n', overPay)
        fprintf('Gross pay is: $%.2f\n', gross)
        fprintf('------------------------------\n')
        fprintf('Income tax is: $%.2f\n', incomeTax)
        fprintf('SS tax is: $%.2f\n', ssTax)
        fprintf('------------------------------\n')
        fprintf('Net pay is: $%.2f\n', netPay)
    end
    employee = menu('Select employee, if done exit window.',text);
    clear lastName;
    clc;
end
disp('Thank you for using the program.')